package ru.sbt.diploma.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import lombok.extern.log4j.Log4j;

/**
 * Base class for all TLL nodes that produce a value and therefore benefit from type specialization.
 * The annotation {@link TypeSystemReference} specifies the TLL types. Specifying it here defines the
 * type system for all subclasses.
 */
@TypeSystemReference(TLLTypes.class)
@NodeInfo(description = "The abstract base node for all expressions")
@GenerateWrapper
@Log4j
public abstract class TLLExpressionNode extends TLLStatementNode {

    private boolean hasExpressionTag;

    /**
     * The execute method when no specialization is possible. This is the most general case,
     * therefore it must be provided by all subclasses.
     */
    public abstract Object executeGeneric(VirtualFrame frame);

    /**
     * When we use an expression at places where a {@link TLLStatementNode statement} is already
     * sufficient, the return value is just discarded.
     */
    @Override
    public void executeVoid(VirtualFrame frame) {
        log.info("Execute void in ExpressionNode");
        executeGeneric(frame);
    }

    @Override
    public WrapperNode createWrapper(ProbeNode probe) {
        return new TLLExpressionNodeWrapper(this, probe);
    }

    @Override
    public boolean hasTag(Class<? extends Tag> tag) {
        if (tag == StandardTags.ExpressionTag.class) {
            return hasExpressionTag;
        }
        return super.hasTag(tag);
    }

    /**
     * Marks this node as being a {@link StandardTags.ExpressionTag} for instrumentation purposes.
     */
    public final void addExpressionTag() {
        hasExpressionTag = true;
    }

    /*
     * Execute methods for specialized types. They all follow the same pattern: they call the
     * generic execution method and then expect a result of their return type. Type-specialized
     * subclasses overwrite the appropriate methods.
     */

    public long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        log.info("Execute long in ExpressionNode");
        return TLLTypesGen.expectLong(executeGeneric(frame));
    }

    public boolean executeBoolean(VirtualFrame frame) throws UnexpectedResultException {
        log.info("Execute boolean in ExpressionNode");
        return TLLTypesGen.expectBoolean(executeGeneric(frame));
    }

}
