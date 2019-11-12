package ru.diploma.util;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.dsl.TypeSystemReference;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDTypes;

/**
 * The node to normalize any value to an SL value. This is useful to reduce the number of values
 * expression nodes need to expect.
 */
@TypeSystemReference(TVDTypes.class)
@NodeChild
public abstract class TVDUnboxNode extends TVDExpressionNode {
    @Specialization
    protected static long fromLong(long value) {
        return value;
    }
}
