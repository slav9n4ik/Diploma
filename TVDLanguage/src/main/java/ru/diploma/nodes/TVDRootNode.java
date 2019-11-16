package ru.diploma.nodes;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import ru.diploma.TVDLanguage;
import ru.diploma.builtin.ReadArgumentNode;

@NodeInfo(language = "TVD", description = "The root of all TVD execution trees")
public class TVDRootNode extends RootNode {

    @Children private final TVDExpressionNode[] bodyNodes;
    @CompilationFinal
    public String name;

    public TVDRootNode(TVDExpressionNode[] bodyNodes, FrameDescriptor frameDescriptor) {
        //TODO Убрать null
        super(null, frameDescriptor);
        this.bodyNodes = bodyNodes;
    }

    @Override
    @ExplodeLoop
    public Object execute(VirtualFrame virtualFrame) {
        int last = this.bodyNodes.length - 1;
        CompilerAsserts.compilationConstant(last);
        for (int i=0; i<last; i++) {
            this.bodyNodes[i].execute(virtualFrame);
        }
        return this.bodyNodes[last].execute(virtualFrame);
    }

    public static TVDRootNode create(FrameSlot[] argumentNames,
                                         TVDExpressionNode[] bodyNodes,
                                         FrameDescriptor frameDescriptor) {
        TVDExpressionNode[] allNodes = new TVDExpressionNode[argumentNames.length + bodyNodes.length];
        for (int i=0; i<argumentNames.length; i++) {
            allNodes[i] = DefineNodeGen.create(
                    new ReadArgumentNode(i), argumentNames[i]);
        }
        System.arraycopy(bodyNodes, 0, allNodes,
                argumentNames.length, bodyNodes.length);
        return new TVDRootNode(allNodes, frameDescriptor);
    }

}
