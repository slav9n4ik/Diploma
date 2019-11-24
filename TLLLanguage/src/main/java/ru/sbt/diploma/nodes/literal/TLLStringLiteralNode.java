package ru.sbt.diploma.nodes.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.sbt.diploma.nodes.TLLExpressionNode;

/**
 * Constant literal for a String value.
 */
@NodeInfo(shortName = "const")
public final class TLLStringLiteralNode extends TLLExpressionNode {
    private final String value;

    public TLLStringLiteralNode(String value) {
        this.value = value;
    }

    @Override
    public String executeGeneric(VirtualFrame frame) {
        return value;
    }
}
