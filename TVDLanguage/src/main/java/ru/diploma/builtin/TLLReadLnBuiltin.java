package ru.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.diploma.TLLLanguage;
import ru.diploma.runtime.TLLContext;
import ru.diploma.runtime.TLLException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Builtin function that reads a String from the {@link TLLContext#getInput() standard input}.
 */
@NodeInfo(shortName = "readln")
public abstract class TLLReadLnBuiltin extends TLLBuiltinNode {
    @Specialization
    public String readln(@CachedContext(TLLLanguage.class) TLLContext context) {
        String result = doRead(context.getInput());
        if (result == null) {
            /*
             * We do not have a sophisticated end of file handling, so returning an empty string is
             * a reasonable alternative. Note that the Java null value should never be used, since
             * it can interfere with the specialization logic in generated source code.
             */
            result = "";
        }
        return result;
    }

    @CompilerDirectives.TruffleBoundary
    private String doRead(BufferedReader in) {
        try {
            return in.readLine();
        } catch (IOException ex) {
            throw new TLLException(ex.getMessage(), this);
        }
    }
}
