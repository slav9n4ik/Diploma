package ru.sbt.diploma.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.RootNode;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLContext;
import ru.sbt.diploma.runtime.TLLNull;

import java.util.Map;

/**
 * This class performs two additional tasks:
 *
 * <ul>
 * <li>Lazily registration of functions on first execution. This fulfills the semantics of
 * "evaluating" source code in TLL.</li>
 * <li>Conversion of arguments to types understood by TLL. The TLL source code can be evaluated from a
 * different language, i.e., the caller can be a node from a different language that uses types not
 * understood by TLL.</li>
 * </ul>
 */
@Log4j
public final class TLLEvalRootNode extends RootNode {

    private final Map<String, RootCallTarget> functions;
    @CompilerDirectives.CompilationFinal
    private boolean registered;

    private final TruffleLanguage.ContextReference<TLLContext> reference;

    @Child private DirectCallNode mainCallNode;

    public TLLEvalRootNode(TLLLanguage language, RootCallTarget rootFunction, Map<String, RootCallTarget> functions) {
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
        log.info("Execute in EvalRootNode");
        /* Lazy registrations of functions on first execution. */
        if (!registered) {
            /* Function registration is a slow-path operation that must not be compiled. */
            CompilerDirectives.transferToInterpreterAndInvalidate();
            reference.get().getFunctionRegistry().register(functions);
            registered = true;
        }
        if (mainCallNode == null) {
            /* The source code did not have a "main" function, so nothing to execute. */
            return TLLNull.SINGLETON;
        } else {
            /* Conversion of arguments to types understood by TLL. */
            Object[] arguments = frame.getArguments();
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = TLLContext.fromForeignValue(arguments[i]);
            }
            return mainCallNode.call(arguments);
        }
    }
}
