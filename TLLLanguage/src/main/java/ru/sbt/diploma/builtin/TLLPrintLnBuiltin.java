package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLContext;

import java.io.PrintWriter;

/**
 * Builtin function to write a value to the {@link TLLContext#getOutput() standard output}. The
 * different specialization leverage the typed {@code println} methods available in Java, i.e.,
 * primitive values are printed without converting them to a {@link String} first.
 * <p>
 * Printing involves a lot of Java code, so we need to tell the optimizing system that it should not
 * unconditionally inline everything reachable from the println() method. This is done via the
 * {@link TruffleBoundary} annotations.
 */
@NodeInfo(shortName = "println")
@Log4j
public abstract class TLLPrintLnBuiltin extends TLLBuiltinNode {
    @Specialization
    public long println(long value, @CachedContext(TLLLanguage.class) TLLContext context) {
        log.info("Println long invoke");
        doPrint(context.getOutput(), value);
        return value;
    }

    @TruffleBoundary
    private static void doPrint(PrintWriter out, long value) {
        out.println(value);
    }

    @Specialization
    public boolean println(boolean value, @CachedContext(TLLLanguage.class) TLLContext context) {
        log.info("Println boolean invoke");
        doPrint(context.getOutput(), value);
        return value;
    }

    @TruffleBoundary
    private static void doPrint(PrintWriter out, boolean value) {
        out.println(value);
    }

    @Specialization
    public String println(String value, @CachedContext(TLLLanguage.class) TLLContext context) {
        log.info("Println string invoke");
        doPrint(context.getOutput(), value);
        return value;
    }

    @TruffleBoundary
    private static void doPrint(PrintWriter out, String value) {
        out.println(value);
    }

    @Specialization
    public Object println(Object value, @CachedContext(TLLLanguage.class) TLLContext context) {
        log.info("Println object invoke");
        doPrint(context.getOutput(), value);
        return value;
    }

    @TruffleBoundary
    private static void doPrint(PrintWriter out, Object value) {
        out.println(value);
    }
}
