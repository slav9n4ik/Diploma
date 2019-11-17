package ru.diploma.nodes.controlflow;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.profiles.BranchProfile;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDRootNode;
import ru.diploma.nodes.TVDStatementNode;
import ru.diploma.runtime.TVDNull;

/**
 * The body of a user-defined TVD function. This is the node referenced by a {@link TVDRootNode} for
 * user-defined functions. It handles the return value of a function: the {@link TVDReturnNode return
 * statement} throws an {@link TVDReturnException exception} with the return value. This node catches
 * the exception. If the method ends without an explicit {@code return}, return the
 * {@link TVDNull#SINGLETON default null value}.
 */
@NodeInfo(shortName = "body")
public final class TVDFunctionBodyNode extends TVDExpressionNode {

    /** The body of the function. */
    @Child
    private TVDStatementNode bodyNode;

    /**
     * Profiling information, collected by the interpreter, capturing whether the function had an
     * {@link TVDReturnNode explicit return statement}. This allows the compiler to generate better
     * code.
     */
    private final BranchProfile exceptionTaken = BranchProfile.create();
    private final BranchProfile nullTaken = BranchProfile.create();

    public TVDFunctionBodyNode(TVDStatementNode bodyNode) {
        this.bodyNode = bodyNode;
        addRootTag();
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        try {
            /* Execute the function body. */
            bodyNode.executeVoid(frame);

        } catch (TVDReturnException ex) {
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
        return TVDNull.SINGLETON;
    }
}

