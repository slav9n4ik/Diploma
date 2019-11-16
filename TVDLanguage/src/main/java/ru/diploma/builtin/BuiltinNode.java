package ru.diploma.builtin;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDRootNode;

@NodeChild(value = "arguments", type = TVDExpressionNode[].class)
public abstract class BuiltinNode extends TVDExpressionNode {
    public static TVDFunction createBuiltinFunction(
                    NodeFactory<? extends BuiltinNode> factory,
                    VirtualFrame outerFrame) {
        int argumentCount = factory.getExecutionSignature().size();
        TVDExpressionNode[] argumentNodes = new TVDExpressionNode[argumentCount];
        for (int i=0; i<argumentCount; i++) {
            argumentNodes[i] = new ReadArgumentNode(i);
        }
        BuiltinNode node = factory.createNode((Object) argumentNodes);
        return new TVDFunction(Truffle.getRuntime().createCallTarget(
                new TVDRootNode(new TVDExpressionNode[] {node},
                        new FrameDescriptor())));
    }
}
