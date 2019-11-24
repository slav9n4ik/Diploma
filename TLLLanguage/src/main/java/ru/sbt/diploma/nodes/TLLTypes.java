package ru.sbt.diploma.nodes;

import com.oracle.truffle.api.dsl.TypeCast;
import com.oracle.truffle.api.dsl.TypeCheck;
import com.oracle.truffle.api.dsl.TypeSystem;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLNull;

/**
 * The type system of TLL, as explained in {@link TLLLanguage}. Based on the {@link TypeSystem}
 * annotation, the Truffle DTLL generates the subclass {@link TLLTypesGen} with type test and type
 * conversion methods for some types. In this class, we only cover types where the automatically
 * generated ones would not be sufficient.
 */
@TypeSystem({long.class, boolean.class})
@Log4j
public abstract class TLLTypes {
    /**
     * Example of a manually specified type check that replaces the automatically generated type
     * check that the Truffle DTLL would generate. For {@link TLLNull}, we do not need an
     * {@code instanceof} check, because we know that there is only a {@link TLLNull#SINGLETON
     * singleton} instance.
     */
    @TypeCheck(TLLNull.class)
    public static boolean isTLLNull(Object value) {
        log.info("isTLLNull invoke");
        return value == TLLNull.SINGLETON;
    }

    /**
     * Example of a manually specified type cast that replaces the automatically generated type cast
     * that the Truffle DTLL would generate. For {@link TLLNull}, we do not need an actual cast,
     * because we know that there is only a {@link TLLNull#SINGLETON singleton} instance.
     */
    @TypeCast(TLLNull.class)
    public static TLLNull asTLLNull(Object value) {
        log.info("asTLLNull invoke");
        assert isTLLNull(value);
        return TLLNull.SINGLETON;
    }
}
