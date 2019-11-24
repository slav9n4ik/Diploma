package ru.sbt.diploma.util;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLTypes;

/**
 * The node to normalize any value to an SL value. This is useful to reduce the number of values
 * expression nodes need to expect.
 */
@TypeSystemReference(TLLTypes.class)
@NodeChild
public abstract class TLLUnboxNode extends TLLExpressionNode {
    @Specialization
    protected static long fromLong(long value) {
        return value;
    }
}
