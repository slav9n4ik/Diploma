package ru.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.diploma.TVDLanguage;
import ru.diploma.runtime.TVDContext;
import ru.diploma.runtime.TVDException;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Builtin function that reads a String from the {@link TVDContext#getInput() standard input}.
 */
@NodeInfo(shortName = "readln")
public abstract class TVDReadlnBuiltin extends TVDBuiltinNode {
    @Specialization
    public String readln(@CachedContext(TVDLanguage.class) TVDContext context) {
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
            throw new TVDException(ex.getMessage(), this);
        }
    }
}
