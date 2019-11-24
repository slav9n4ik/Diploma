package ru.sbt.diploma.nodes.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.TLLExpressionNode;

/**
 * Constant literal for a primitive {@code long} value. The unboxed value can be returned when the
 * parent expects a long value and calls {@link TLLLongLiteralNode#executeLong}. In the generic case,
 * the primitive value is automatically boxed by Java.
 */
@NodeInfo(shortName = "const")
@Log4j
public final class TLLLongLiteralNode extends TLLExpressionNode {

    private final long value;

    public TLLLongLiteralNode(long value) {
        this.value = value;
    }

    @Override
    public long executeLong(VirtualFrame frame) throws UnexpectedResultException {
        log.info("Execute long in LongLiteralNode");
        return value;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        log.info("Execute Generic in LongLiteralNode");
        return value;
    }
}
