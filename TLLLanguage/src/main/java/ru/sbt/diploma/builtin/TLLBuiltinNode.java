package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.runtime.TLLContext;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.runtime.TLLException;
import ru.sbt.diploma.runtime.TLLFunctionRegistry;

/**
 * Base class for all builtin functions. It contains the Truffle DSL annotation {@link NodeChild}
 * that defines the function arguments.<br>
 * The builtin functions are registered in {@link TLLContext#installBuiltins}. Every builtin node
 * subclass is instantiated there, wrapped into a function, and added to the
 * {@link TLLFunctionRegistry}. This ensures that builtin functions can be called like user-defined
 * functions; there is no special function lookup or call node for builtin functions.
 */
@NodeChild(value = "arguments", type = TLLExpressionNode[].class)
@GenerateNodeFactory
@Log4j
public abstract class TLLBuiltinNode extends TLLExpressionNode {

    @Override
    public final Object executeGeneric(VirtualFrame frame) {
        log.info("Execute Generic");
        try {
            return execute(frame);
        } catch (UnsupportedSpecializationException e) {
            throw TLLException.typeError(e.getNode(), e.getSuppliedValues());
        }
    }

    @Override
    public final boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
        log.info("Execute Boolean");
        return super.executeBoolean(frame);
    }

    @Override
    public final long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        log.info("Execute Long");
        return super.executeLong(frame);
    }

    @Override
    public final void executeVoid(VirtualFrame frame) {
        log.info("Execute Void");
        super.executeVoid(frame);
    }

    protected abstract Object execute(VirtualFrame frame);
}
