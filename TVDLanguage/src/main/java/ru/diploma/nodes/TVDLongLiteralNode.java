package ru.diploma.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.UnexpectedResultException;

public class TVDLongLiteralNode extends TVDExpressionNode {
    private final long value;

    public TVDLongLiteralNode(long value) {
        this.value = value;
    }

    @Override
    public long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        return value;
    }

    @Override
    public Object execute(VirtualFrame frame) {
        return value;
    }
}
