package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLContext;

import java.io.PrintWriter;

@NodeInfo(shortName = "compare")
@Log4j
public abstract class TLLCompareBuiltin extends TLLBuiltinNode {

    @Specialization(guards = {"isLong(left)", "isLong(right)"} )
    public int compare(long left, long right, @CachedContext(TLLLanguage.class) TLLContext context) {
        log.info("Compare items invoke");
        int result = Long.compare(left, right);

        if(result == 0) {
            doPrint(context.getOutput(),"Значения равны");
        }

        if(result < 0) {
            doPrint(context.getOutput(),"Левое значение меньше");
        } else {
            doPrint(context.getOutput(),"Левое значение больше");
        }

        return result;
    }

    public boolean isLong(Object value) {
        return value instanceof Long;
    }

    @TruffleBoundary
    private static void doPrint(PrintWriter out, String value) {
        out.println(value);
    }
}
