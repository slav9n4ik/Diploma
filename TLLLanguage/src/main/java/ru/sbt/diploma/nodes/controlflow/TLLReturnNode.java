package ru.sbt.diploma.nodes.controlflow;


import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLStatementNode;
import ru.sbt.diploma.runtime.TLLNull;

/**
 * Implementation of the TLL return statement. We need to unwind an unknown number of interpreter
 * frames that are between this {@link TLLReturnNode} and the {@link TLLFunctionBodyNode} of the
 * method we are exiting. This is done by throwing an {@link TLLReturnException exception} that is
 * caught by the {@link TLLFunctionBodyNode#executeGeneric function body}. The exception transports
 * the return value.
 */
@NodeInfo(shortName = "return", description = "The node implementing a return statement")
@Log4j
public final class TLLReturnNode extends TLLStatementNode {

    @Node.Child
    private TLLExpressionNode valueNode;

    public TLLReturnNode(TLLExpressionNode valueNode) {
        this.valueNode = valueNode;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        log.info("Execute Void Return Node");
        Object result;
        if (valueNode != null) {
            result = valueNode.executeGeneric(frame);
        } else {
            /*
             * Return statement that was not followed by an expression, so return the TLL null value.
             */
            result = TLLNull.SINGLETON;
        }
        throw new TLLReturnException(result);
    }
}
