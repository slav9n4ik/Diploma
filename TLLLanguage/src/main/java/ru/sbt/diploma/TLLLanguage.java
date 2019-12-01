package ru.sbt.diploma;

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
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.builtin.TLLBuiltinNode;
import ru.sbt.diploma.nodes.TLLEvalRootNode;
import ru.sbt.diploma.nodes.local.TLLLexicalScope;
import ru.sbt.diploma.parser.TLLLanguageParser;
import ru.sbt.diploma.runtime.TLLContext;
import ru.sbt.diploma.runtime.TLLFunction;
import ru.sbt.diploma.runtime.TLLNull;

import java.util.*;

@TruffleLanguage.Registration(id = TLLLanguage.ID,
        name = "TLL", defaultMimeType = TLLLanguage.MIME_TYPE,
        characterMimeTypes = TLLLanguage.MIME_TYPE, contextPolicy = TruffleLanguage.ContextPolicy.SHARED)
@ProvidedTags({StandardTags.CallTag.class,
        StandardTags.StatementTag.class,
        StandardTags.RootTag.class,
        StandardTags.RootBodyTag.class,
        StandardTags.ExpressionTag.class,
        DebuggerTags.AlwaysHalt.class})
@Log4j
public class TLLLanguage extends TruffleLanguage<TLLContext> {

    public static volatile int counter;

    public static final String ID = "tll";
    public static final String MIME_TYPE = "application/x-tll";

    public TLLLanguage() {
        counter++;
    }

    @Override
    protected TLLContext createContext(Env env) {
        TLLContext TLLContext = new TLLContext(this, env, new ArrayList<>(EXTERNAL_BUILTINS));
        log.info("Create TLL context. Env: " + env.getFileNameSeparator());
        return TLLContext;
    }

    @Override
    public CallTarget parse(ParsingRequest request) throws Exception {
        log.info("Start parsing");
        Source source = request.getSource();
        Map<String, RootCallTarget> blocks = TLLLanguageParser.parseTLL(this, source);
        //RootCallTarget main = blocks.get("START");
        RootNode evalMain = new TLLEvalRootNode(this, blocks);
        log.info("TLLLanguage - End parsing. Create call target!");
        return Truffle.getRuntime().createCallTarget(evalMain.getRootNode());
    }

    @Override
    protected boolean isVisible(TLLContext context, Object value) {
        log.info("IsVisible invoke");
        return !InteropLibrary.getFactory().getUncached(value).isNull(value);
    }

    @Override
    protected String toString(TLLContext context, Object value) {
        return toString(value);
    }

    public static String toString(Object value) {
        log.info("toString Invoke");
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
    protected Object findMetaObject(TLLContext context, Object value) {
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
    public Iterable<Scope> findLocalScopes(TLLContext context, Node node, Frame frame) {
        log.info("FindLocalScopes invoke");
        final TLLLexicalScope scope = TLLLexicalScope.createScope(node);
        return new Iterable<Scope>() {
            @Override
            public Iterator<Scope> iterator() {
                return new Iterator<Scope>() {
                    private TLLLexicalScope previousScope;
                    private TLLLexicalScope nextScope = scope;

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
                        Scope vscope = Scope.newBuilder(nextScope.getName(),
                                nextScope.getVariables(frame))
                                         .node(nextScope.getNode())
                                         .arguments(nextScope.getArguments(frame))
                                         .build();
                        previousScope = nextScope;
                        nextScope = null;
                        return vscope;
                    }
                };
            }
        };
    }

    @Override
    protected SourceSection findSourceLocation(TLLContext context, Object value) {
        log.info("FindSourceLocation invoke");
        if (value instanceof TLLFunction) {
            return ((TLLFunction) value).getDeclaredLocation();
        }
        return null;
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        log.info("IsObjectOfLanguage invoke");
        if (!(object instanceof TruffleObject)) {
            return false;
        } else if (object instanceof TLLFunction || object instanceof TLLNull) {
            return true;
        } else if (TLLContext.isTLLObject(object)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected Iterable<Scope> findTopScopes(TLLContext context) {
        log.info("FindTopScopes invoke");
        return context.getTopScopes();
    }

    public static TLLContext getCurrentContext() {
        log.info("DetCurrentContext invoke");
        return getCurrentContext(TLLLanguage.class);
    }

    private static final List<NodeFactory<? extends TLLBuiltinNode>> EXTERNAL_BUILTINS = Collections.synchronizedList(new ArrayList<>());

    public static void installBuiltin(NodeFactory<? extends TLLBuiltinNode> builtin) {
        EXTERNAL_BUILTINS.add(builtin);
    }
}
