// CheckStyle: start generated
package ru.sbt.diploma.nodes;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.InstrumentableNode.WrapperNode;
import com.oracle.truffle.api.nodes.NodeCost;

@GeneratedBy(TLLStatementNode.class)
final class TLLStatementNodeWrapper extends TLLStatementNode implements WrapperNode {

    @Child private TLLStatementNode delegateNode;
    @Child private ProbeNode probeNode;

    TLLStatementNodeWrapper(TLLStatementNode delegateNode, ProbeNode probeNode) {
        this.delegateNode = delegateNode;
        this.probeNode = probeNode;
    }

    @Override
    public TLLStatementNode getDelegateNode() {
        return delegateNode;
    }

    @Override
    public ProbeNode getProbeNode() {
        return probeNode;
    }

    @Override
    public NodeCost getCost() {
        return NodeCost.NONE;
    }

    @Override
    public void executeVoid(VirtualFrame frame) {
        for (;;) {
            boolean wasOnReturnExecuted = false;
            try {
                probeNode.onEnter(frame);
                delegateNode.executeVoid(frame);
                wasOnReturnExecuted = true;
                probeNode.onReturnValue(frame, null);
                break;
            } catch (Throwable t) {
                Object result = probeNode.onReturnExceptionalOrUnwind(frame, t, wasOnReturnExecuted);
                if (result == ProbeNode.UNWIND_ACTION_REENTER) {
                    continue;
                } else if (result != null) {
                    break;
                }
                throw t;
            }
        }
    }

}
