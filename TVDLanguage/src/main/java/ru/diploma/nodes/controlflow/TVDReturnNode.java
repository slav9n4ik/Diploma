package ru.diploma.nodes.controlflow;


import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDStatementNode;
import ru.diploma.runtime.TVDNull;

/**
 * Implementation of the TVD return statement. We need to unwind an unknown number of interpreter
 * frames that are between this {@link TVDReturnNode} and the {@link TVDFunctionBodyNode} of the
 * method we are exiting. This is done by throwing an {@link TVDReturnException exception} that is
 * caught by the {@link TVDFunctionBodyNode#executeGeneric function body}. The exception transports
 * the return value.
 */
@NodeInfo(shortName = "return", description = "The node implementing a return statement")
public final class TVDReturnNode extends TVDStatementNode {

    @Node.Child
    private TVDExpressionNode valueNode;

    public TVDReturnNode(TVDExpressionNode valueNode) {
        this.valueNode = valueNode;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        Object result;
        if (valueNode != null) {
            result = valueNode.executeGeneric(frame);
        } else {
            /*
             * Return statement that was not followed by an expression, so return the TVD null value.
             */
            result = TVDNull.SINGLETON;
        }
        throw new TVDReturnException(result);
    }
}
