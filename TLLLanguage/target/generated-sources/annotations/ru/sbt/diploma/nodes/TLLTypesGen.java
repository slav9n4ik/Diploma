// CheckStyle: start generated
package ru.sbt.diploma.nodes;

import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import ru.sbt.diploma.nodes.BufferArray;
import ru.sbt.diploma.nodes.TLLTypes;

@GeneratedBy(TLLTypes.class)
public final class TLLTypesGen extends TLLTypes {

    @Deprecated public static final TLLTypesGen T_L_L_TYPES = new TLLTypesGen();

    protected TLLTypesGen() {
    }

    public static boolean isLong(Object value) {
        return value instanceof Long;
    }

    public static long asLong(Object value) {
        assert value instanceof Long : "TLLTypesGen.asLong: long expected";
        return (long) value;
    }

    public static long expectLong(Object value) throws UnexpectedResultException {
        if (value instanceof Long) {
            return (long) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isBoolean(Object value) {
        return value instanceof Boolean;
    }

    public static boolean asBoolean(Object value) {
        assert value instanceof Boolean : "TLLTypesGen.asBoolean: boolean expected";
        return (boolean) value;
    }

    public static boolean expectBoolean(Object value) throws UnexpectedResultException {
        if (value instanceof Boolean) {
            return (boolean) value;
        }
        throw new UnexpectedResultException(value);
    }

    public static boolean isBufferArray(Object value) {
        return value instanceof BufferArray;
    }

    public static BufferArray asBufferArray(Object value) {
        assert value instanceof BufferArray : "TLLTypesGen.asBufferArray: BufferArray expected";
        return (BufferArray) value;
    }

    public static BufferArray expectBufferArray(Object value) throws UnexpectedResultException {
        if (value instanceof BufferArray) {
            return (BufferArray) value;
        }
        throw new UnexpectedResultException(value);
    }

}
