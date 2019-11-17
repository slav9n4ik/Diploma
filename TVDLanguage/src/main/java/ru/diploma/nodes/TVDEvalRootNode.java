package ru.diploma.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;
import ru.diploma.TVDLanguage;
import ru.diploma.runtime.TVDContext;
import ru.diploma.runtime.TVDNull;

import java.util.Map;

/**
 * This class performs two additional tasks:
 *
 * <ul>
 * <li>Lazily registration of functions on first execution. This fulfills the semantics of
 * "evaluating" source code in TVD.</li>
 * <li>Conversion of arguments to types understood by TVD. The TVD source code can be evaluated from a
 * different language, i.e., the caller can be a node from a different language that uses types not
 * understood by TVD.</li>
 * </ul>
 */
public final class TVDEvalRootNode extends RootNode {

    private final Map<String, RootCallTarget> functions;
    @CompilerDirectives.CompilationFinal
    private boolean registered;

    private final TruffleLanguage.ContextReference<TVDContext> reference;

    @Child private DirectCallNode mainCallNode;

    public TVDEvalRootNode(TVDLanguage language, RootCallTarget rootFunction, Map<String, RootCallTarget> functions) {
        super(null); // internal frame
        this.functions = functions;
        this.mainCallNode = rootFunction != null ? DirectCallNode.create(rootFunction) : null;
        this.reference = language.getContextReference();
    }

    @Override
    protected boolean isInstrumentable() {
        return false;
    }

    @Override
    public String getName() {
        return "root eval";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public Object execute(VirtualFrame frame) {
        /* Lazy registrations of functions on first execution. */
        if (!registered) {
            /* Function registration is a slow-path operation that must not be compiled. */
            CompilerDirectives.transferToInterpreterAndInvalidate();
            reference.get().getFunctionRegistry().register(functions);
            registered = true;
        }

        if (mainCallNode == null) {
            /* The source code did not have a "main" function, so nothing to execute. */
            return TVDNull.SINGLETON;
        } else {
            /* Conversion of arguments to types understood by TVD. */
            Object[] arguments = frame.getArguments();
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = TVDContext.fromForeignValue(arguments[i]);
            }
            return mainCallNode.call(arguments);
        }
    }
}
