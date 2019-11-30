package ru.sbt.diploma.util;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLTypes;

/**
 * The node to normalize any value to an TLL value. This is useful to reduce the number of values
 * expression nodes need to expect.
 */
@TypeSystemReference(TLLTypes.class)
@NodeChild
@Log4j
public abstract class TLLUnboxNode extends TLLExpressionNode {
    @Specialization
    protected static long fromLong(long value) {
        log.info("Unbox Long");
        return value;
    }
}
