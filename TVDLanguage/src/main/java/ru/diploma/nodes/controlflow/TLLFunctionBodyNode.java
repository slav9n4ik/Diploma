package ru.diploma.nodes.controlflow;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.profiles.BranchProfile;
import ru.diploma.nodes.TLLExpressionNode;
import ru.diploma.nodes.TLLRootNode;
import ru.diploma.nodes.TLLStatementNode;
import ru.diploma.runtime.TLLNull;

import static ru.diploma.runtime.TLLObjectType.SINGLETON;

/**
 * The body of a user-defined TLL function. This is the node referenced by a {@link TLLRootNode} for
 * user-defined functions. It handles the return value of a function: the {@link TLLReturnNode return
 * statement} throws an {@link TLLReturnException exception} with the return value. This node catches
 * the exception. If the method ends without an explicit {@code return}, return the
 * {@link TLLNull#SINGLETON default null value}.
 */
@NodeInfo(shortName = "body")
public final class TLLFunctionBodyNode extends TLLExpressionNode {

    /** The body of the function. */
    @Child
    private TLLStatementNode bodyNode;

    /**
     * Profiling information, collected by the interpreter, capturing whether the function had an
     * {@link TLLReturnNode explicit return statement}. This allows the compiler to generate better
     * code.
     */
    private final BranchProfile exceptionTaken = BranchProfile.create();
    private final BranchProfile nullTaken = BranchProfile.create();

    public TLLFunctionBodyNode(TLLStatementNode bodyNode) {
        this.bodyNode = bodyNode;
        addRootTag();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        try {
            /* Execute the function body. */
            bodyNode.executeVoid(frame);

        } catch (TLLReturnException ex) {
            /*
             * In the interpreter, record profiling information that the function has an explicit
             * return.
             */
            exceptionTaken.enter();
            /* The exception transports the actual return value. */
            return ex.getResult();
        }

        /*
         * In the interpreter, record profiling information that the function ends without an
         * explicit return.
         */
        nullTaken.enter();
        /* Return the default null value. */
        return SINGLETON;
    }
}

