package ru.diploma.nodes.literal;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.TruffleLanguage.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.diploma.TVDLanguage;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.runtime.TVDContext;
import ru.diploma.runtime.TVDFunction;
import ru.diploma.runtime.TVDFunctionRegistry;

import static com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate;

/**
 * Constant literal for a {@link TVDFunction function} value, created when a function name occurs as
 * a literal in TVD source code. Note that function redefinition can change the {@link CallTarget
 * call target} that is executed when calling the function, but the {@link TVDFunction} for a name
 * never changes. This is guaranteed by the {@link TVDFunctionRegistry}.
 */
@NodeInfo(shortName = "func")
public final class TVDFunctionLiteralNode extends TVDExpressionNode {
    /** The name of the function. */
    private final String functionName;

    /**
     * The resolved function. During parsing (in the constructor of this node), we do not have the
     * {@link TVDContext} available yet, so the lookup can only be done at {@link #executeGeneric
     * first execution}. The {@link CompilationFinal} annotation ensures that the function can still
     * be constant folded during compilation.
     */
    @CompilationFinal
    private TVDFunction cachedFunction;

    private final ContextReference<TVDContext> reference;

    public TVDFunctionLiteralNode(TVDLanguage language, String functionName) {
        this.functionName = functionName;
        this.reference = language.getContextReference();
    }

    @Override
    public TVDFunction executeGeneric(VirtualFrame frame) {
        if (cachedFunction == null) {
            /* We are about to change a @CompilationFinal field. */
            transferToInterpreterAndInvalidate();
            /* First execution of the node: lookup the function in the function registry. */
            cachedFunction = reference.get().getFunctionRegistry().lookup(functionName, true);
        }
        return cachedFunction;
    }
}
