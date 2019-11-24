package ru.sbt.diploma.runtime;

import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;

/**
 * The TLL type for a {@code null} (i.e., undefined) value. In Truffle, it is generally discouraged
 * to use the Java {@code null} value to represent the guest language {@code null} value. It is not
 * possible to specialize on Java {@code null} (since you cannot ask it for the Java class), and
 * there is always the danger of a spurious {@link NullPointerException}. Representing the guest
 * language {@code null} as a singleton, as in {@link #SINGLETON this class}, is the recommended
 * practice.
 */
@ExportLibrary(InteropLibrary.class)
public class TLLNull implements TruffleObject {

    /**
     * The canonical value to represent {@code null} in SL.
     */
    public static final TLLNull SINGLETON = new TLLNull();

    /**
     * Disallow instantiation from outside to ensure that the {@link #SINGLETON} is the only
     * instance.
     */
    private TLLNull() {
    }

    /**
     * This method is, e.g., called when using the {@code null} value in a string concatenation. So
     * changing it has an effect on SL programs.
     */
    @Override
    public String toString() {
        return "NULL";
    }

    /**
     * {@link TLLNull} values are interpreted as null values by other languages.
     */
    @ExportMessage
    boolean isNull() {
        return true;
    }
}
