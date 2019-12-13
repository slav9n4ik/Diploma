package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.nodes.BufferArray;
import ru.sbt.diploma.runtime.TLLContext;

import java.io.PrintWriter;

@NodeInfo(shortName = "check")
@Log4j
public abstract class TLLCheckBuiltin extends TLLBuiltinNode {

    @Specialization(guards = "objects.hasMembers(receiver)", limit = "3")
    public boolean check(Object receiver,
                      @CachedLibrary("receiver") InteropLibrary objects,
                      @CachedContext(TLLLanguage.class) TLLContext context) {
        try {
            log.info("Check object invoke");
            BufferArray sublimits = (BufferArray) objects.readMember(receiver, "sublimit");
            long sublimitSum = 0L;
            for(Object item : sublimits.buffer) {
                sublimitSum += (long)item;
            }
            long limit = (long) objects.readMember(receiver, "limit");

            if (sublimitSum >= limit) {
                doPrint(context.getOutput(),"Сумма сублимитов больше лимита");
            } else {
                doPrint(context.getOutput(), "Лимит больше суммы сублимитов");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @TruffleBoundary
    private static void doPrint(PrintWriter out, String value) {
        out.println(value);
    }
}
