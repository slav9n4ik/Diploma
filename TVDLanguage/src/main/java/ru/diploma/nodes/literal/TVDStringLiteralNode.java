package ru.diploma.nodes.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.diploma.nodes.TVDExpressionNode;

/**
 * Constant literal for a String value.
 */
@NodeInfo(shortName = "const")
public final class TVDStringLiteralNode extends TVDExpressionNode {
    private final String value;

    public TVDStringLiteralNode(String value) {
        this.value = value;
    }

    @Override
    public String executeGeneric(VirtualFrame frame) {
        return value;
    }
}
