package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.nodes.BufferArray;
import ru.sbt.diploma.runtime.TLLContext;

import java.io.PrintWriter;

@NodeInfo(shortName = "sum")
@Log4j
public abstract class TLLCollectionSumBuiltin extends TLLBuiltinNode {

    @Specialization(guards = "isBufferArray(value)")
    public long sum(Object value, @CachedContext(TLLLanguage.class) TLLContext context) {
        log.info("Sum buffer items invoke");
        long sum = 0L;
        for (Object item : ((BufferArray) value).buffer) {
            sum += (long) item;
        }
        doPrint(context.getOutput(),"Sum is " + sum);
        return sum;
    }

    public boolean isBufferArray(Object value) {
        return value instanceof BufferArray;
    }

    @TruffleBoundary
    private static void doPrint(PrintWriter out, String value) {
        out.println(value);
    }
}
