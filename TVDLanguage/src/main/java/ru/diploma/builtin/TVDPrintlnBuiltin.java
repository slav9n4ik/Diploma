package ru.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.diploma.TVDLanguage;
import ru.diploma.runtime.TVDContext;

import java.io.PrintWriter;

/**
 * Builtin function to write a value to the {@link TVDContext#getOutput() standard output}. The
 * different specialization leverage the typed {@code println} methods available in Java, i.e.,
 * primitive values are printed without converting them to a {@link String} first.
 * <p>
 * Printing involves a lot of Java code, so we need to tell the optimizing system that it should not
 * unconditionally inline everything reachable from the println() method. This is done via the
 * {@link CompilerDirectives.TruffleBoundary} annotations.
 */
@NodeInfo(shortName = "println")
public abstract class TVDPrintlnBuiltin extends TVDBuiltinNode {
    @Specialization
    public long println(long value, @CachedContext(TVDLanguage.class) TVDContext context) {
        doPrint(context.getOutput(), value);
        return value;
    }

    @CompilerDirectives.TruffleBoundary
    private static void doPrint(PrintWriter out, long value) {
        out.println(value);
    }

    @Specialization
    public boolean println(boolean value, @CachedContext(TVDLanguage.class) TVDContext context) {
        doPrint(context.getOutput(), value);
        return value;
    }

    @CompilerDirectives.TruffleBoundary
    private static void doPrint(PrintWriter out, boolean value) {
        out.println(value);
    }

    @Specialization
    public String println(String value, @CachedContext(TVDLanguage.class) TVDContext context) {
        doPrint(context.getOutput(), value);
        return value;
    }

    @CompilerDirectives.TruffleBoundary
    private static void doPrint(PrintWriter out, String value) {
        out.println(value);
    }

    @Specialization
    public Object println(Object value, @CachedContext(TVDLanguage.class) TVDContext context) {
        doPrint(context.getOutput(), value);
        return value;
    }

    @CompilerDirectives.TruffleBoundary
    private static void doPrint(PrintWriter out, Object value) {
        out.println(value);
    }
}
