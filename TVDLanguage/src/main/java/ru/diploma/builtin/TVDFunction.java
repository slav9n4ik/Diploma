package ru.diploma.builtin;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.MaterializedFrame;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDRootNode;

public class TVDFunction {
    public final RootCallTarget callTarget;
    private MaterializedFrame lexicalScope;

    public TVDFunction(RootCallTarget callTarget) {
        this.callTarget = callTarget;
    }

    public MaterializedFrame getLexicalScope() {
        return lexicalScope;
    }

    public void setLexicalScope(MaterializedFrame lexicalScope) {
        this.lexicalScope = lexicalScope;
    }

    public static TVDFunction create(FrameSlot[] arguments,
                                     TVDExpressionNode[] bodyNodes, FrameDescriptor frameDescriptor) {
        return new TVDFunction(
                Truffle.getRuntime().createCallTarget(
                        TVDRootNode.create(arguments, bodyNodes, frameDescriptor)));
    }
}
