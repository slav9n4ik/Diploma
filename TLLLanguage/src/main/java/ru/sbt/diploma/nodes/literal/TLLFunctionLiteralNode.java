package ru.sbt.diploma.nodes.literal;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.TruffleLanguage.*;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.runtime.TLLContext;
import ru.sbt.diploma.runtime.TLLFunction;
import ru.sbt.diploma.runtime.TLLFunctionRegistry;

import static com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate;

/**
 * Constant literal for a {@link TLLFunction function} value, created when a function name occurs as
 * a literal in TLL source code. Note that function redefinition can change the {@link CallTarget
 * call target} that is executed when calling the function, but the {@link TLLFunction} for a name
 * never changes. This is guaranteed by the {@link TLLFunctionRegistry}.
 */
@NodeInfo(shortName = "func")
@Log4j
public final class TLLFunctionLiteralNode extends TLLExpressionNode {
    /** The name of the function. */
    private final String functionName;

    /**
     * The resolved function. During parsing (in the constructor of this node), we do not have the
     * {@link TLLContext} available yet, so the lookup can only be done at {@link #executeGeneric
     * first execution}. The {@link CompilationFinal} annotation ensures that the function can still
     * be constant folded during compilation.
     */
    @CompilationFinal
    private TLLFunction cachedFunction;

    private final ContextReference<TLLContext> reference;

    public TLLFunctionLiteralNode(TLLLanguage language, String functionName) {
        this.functionName = functionName;
        this.reference = language.getContextReference();
    }

    @Override
    public TLLFunction executeGeneric(VirtualFrame frame) {
        log.info("Execute Generic Function Literal Node");
        if (cachedFunction == null) {
            /* We are about to change a @CompilationFinal field. */
            transferToInterpreterAndInvalidate();
            /* First execution of the node: lookup the function in the function registry. */
            cachedFunction = reference.get().getFunctionRegistry().lookup(functionName, true);
        }
        return cachedFunction;
    }
}
