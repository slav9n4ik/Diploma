package ru.diploma;

import com.oracle.truffle.api.*;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import ru.diploma.builtin.TVDBuiltinNode;
import ru.diploma.nodes.TVDEvalRootNode;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.local.TVDLexicalScope;
import ru.diploma.parser.TVDLanguageParser;
import ru.diploma.runtime.TVDContext;
import ru.diploma.runtime.TVDFunction;
import ru.diploma.runtime.TVDNull;

import java.util.*;

@TruffleLanguage.Registration(id = TVDLanguage.ID,
        name = "TVD", defaultMimeType = TVDLanguage.MIME_TYPE,
        characterMimeTypes = TVDLanguage.MIME_TYPE, contextPolicy = TruffleLanguage.ContextPolicy.SHARED)
@ProvidedTags({StandardTags.CallTag.class,
        StandardTags.StatementTag.class,
        StandardTags.RootTag.class,
        StandardTags.RootBodyTag.class,
        StandardTags.ExpressionTag.class,
        DebuggerTags.AlwaysHalt.class})
public class TVDLanguage extends TruffleLanguage<TVDContext> {

    public static volatile int counter;

    public static final String ID = "tvd";
    public static final String MIME_TYPE = "application/x-tvd";

    public TVDLanguage() {
        counter++;
    }

    @Override
    protected TVDContext createContext(Env env) {
        TVDContext tvdContext = new TVDContext(this, env, new ArrayList<>(EXTERNAL_BUILTINS));
        return tvdContext;
    }

    @Override
    public CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        Map<String, RootCallTarget> blocks = TVDLanguageParser.parseTVD(this, source);
        RootCallTarget main = blocks.get("START");
        RootNode evalMain = new TVDEvalRootNode(this, main, blocks);
        return Truffle.getRuntime().createCallTarget(evalMain);
    }

    @Override
    protected boolean isVisible(TVDContext context, Object value) {
        return !InteropLibrary.getFactory().getUncached(value).isNull(value);
    }

    @Override
    protected String toString(TVDContext context, Object value) {
        return toString(value);
    }

    public static String toString(Object value) {
        try {
            if (value == null) {
                return "ANY";
            }
            InteropLibrary interop = InteropLibrary.getFactory().getUncached(value);
            if (interop.fitsInLong(value)) {
                return Long.toString(interop.asLong(value));
            } else if (interop.isBoolean(value)) {
                return Boolean.toString(interop.asBoolean(value));
            } else if (interop.isString(value)) {
                return interop.asString(value);
            } else if (interop.isNull(value)) {
                return "NULL";
            } else if (interop.hasMembers(value)) {
                return "Object";
            } else {
                return "Unsupported";
            }
        } catch (UnsupportedMessageException e) {
            CompilerDirectives.transferToInterpreter();
            throw new AssertionError();
        }
    }

    @Override
    protected Object findMetaObject(TVDContext context, Object value) {
        return getMetaObject(value);
    }

    public static String getMetaObject(Object value) {
        if (value == null) {
            return "ANY";
        }
        InteropLibrary interop = InteropLibrary.getFactory().getUncached(value);
        if (interop.isNumber(value)) {
            return "Number";
        } else if (interop.isBoolean(value)) {
            return "Boolean";
        } else if (interop.isString(value)) {
            return "String";
        } else if (interop.isNull(value)) {
            return "NULL";
        } else if (interop.isExecutable(value)) {
            return "Function";
        } else if (interop.hasMembers(value)) {
            return "Object";
        } else {
            return "Unsupported";
        }
    }

    @Override
    public Iterable<Scope> findLocalScopes(TVDContext context, Node node, Frame frame) {
        final TVDLexicalScope scope = TVDLexicalScope.createScope(node);
        return new Iterable<Scope>() {
            @Override
            public Iterator<Scope> iterator() {
                return new Iterator<Scope>() {
                    private TVDLexicalScope previousScope;
                    private TVDLexicalScope nextScope = scope;

                    @Override
                    public boolean hasNext() {
                        if (nextScope == null) {
                            nextScope = previousScope.findParent();
                        }
                        return nextScope != null;
                    }

                    @Override
                    public Scope next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        Scope vscope = Scope.newBuilder(nextScope.getName(), nextScope.getVariables(frame)).node(nextScope.getNode()).arguments(nextScope.getArguments(frame)).build();
                        previousScope = nextScope;
                        nextScope = null;
                        return vscope;
                    }
                };
            }
        };
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        if (!(object instanceof TruffleObject)) {
            return false;
        } else if (object instanceof TVDFunction || object instanceof TVDNull) {
            return true;
        } else if (TVDContext.isTVDObject(object)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected Iterable<Scope> findTopScopes(TVDContext context) {
        return context.getTopScopes();
    }

    public static TVDContext getCurrentContext() {
        return getCurrentContext(TVDLanguage.class);
    }

    private static final List<NodeFactory<? extends TVDBuiltinNode>> EXTERNAL_BUILTINS = Collections.synchronizedList(new ArrayList<>());

    public static void installBuiltin(NodeFactory<? extends TVDBuiltinNode> builtin) {
        EXTERNAL_BUILTINS.add(builtin);
    }
}
