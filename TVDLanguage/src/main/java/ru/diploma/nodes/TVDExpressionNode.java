package ru.diploma.nodes;

import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import com.oracle.truffle.api.source.SourceSection;

@TypeSystemReference(TVDTypes.class)
@NodeInfo(description = "The abstract base node for all expressions")
public abstract class TVDExpressionNode extends Node {

    @CompilationFinal
    private SourceSection sourceSection;

    @CompilationFinal
    private boolean isTail = false;

    @Override
    public SourceSection getSourceSection() {
        return this.sourceSection;
    }

    public void setSourceSection(SourceSection sourceSection) {
        this.sourceSection = sourceSection;
    }

    public boolean isTail() {
        return this.isTail;
    }

    public void setIsTail() {
        this.isTail = true;
    }

    public abstract Object execute(VirtualFrame virtualFrame);

    public long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        return TVDTypesGen.expectLong(execute(frame));
    }

    protected boolean isArgumentIndexInRange(VirtualFrame virtualFrame,
                                             int index) {
        return (index + 1) < virtualFrame.getArguments().length;
    }

    protected Object getArgument(VirtualFrame virtualFrame, int index) {
        return virtualFrame.getArguments()[index + 1];
    }

}
