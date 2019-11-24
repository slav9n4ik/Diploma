package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.source.Source;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLContext;

/**
 * Builtin function to evaluate source code in any supported language.
 * <p>
 * The call target is cached against the mime type and the source code, so that if they are the same
 * each time then a direct call will be made to a cached AST, allowing it to be compiled and
 * possibly inlined.
 */
@NodeInfo(shortName = "eval")
@SuppressWarnings("unused")
public abstract class TLLEvalBuiltin extends TLLBuiltinNode {

    @Specialization(guards = {"stringsEqual(cachedId, id)", "stringsEqual(cachedCode, code)"})
    public Object evalCached(String id, String code,
                             @Cached("id") String cachedId,
                             @Cached("code") String cachedCode,
                             @CachedContext(TLLLanguage.class) TLLContext context,
                             @Cached("create(parse(id, code, context))") DirectCallNode callNode) {
        return callNode.call(new Object[]{});
    }

    @CompilerDirectives.TruffleBoundary
    @Specialization(replaces = "evalCached")
    public Object evalUncached(String id, String code, @CachedContext(TLLLanguage.class) TLLContext context) {
        return parse(id, code, context).call();
    }

    protected CallTarget parse(String id, String code, TLLContext context) {
        final Source source = Source.newBuilder(id, code, "(eval)").build();
        return context.parse(source);
    }

    /* Work around findbugs warning in generate code. */
    protected static boolean stringsEqual(String a, String b) {
        return a.equals(b);
    }
}
