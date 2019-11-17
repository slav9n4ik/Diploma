package ru.diploma.runtime;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives.*;
import com.oracle.truffle.api.Scope;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage.Env;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.object.Layout;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TLLLanguage;
import ru.diploma.builtin.*;
import ru.diploma.nodes.TLLExpressionNode;
import ru.diploma.nodes.TLLRootNode;
import ru.diploma.nodes.local.TLLReadArgumentNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import static com.oracle.truffle.api.CompilerDirectives.transferToInterpreter;

/**
 * The run-time state of TLL during execution. The context is created by the {@link TLLLanguage}. It
 * is used, for example, by {@link TLLBuiltinNode#getContext() builtin functions}.
 * <p>
 * It would be an error to have two different context instances during the execution of one script.
 * However, if two separate scripts run in one Java VM at the same time, they have a different
 * context. Therefore, the context is not a singleton.
 */
public class TLLContext {

    private static final Source BUILTIN_SOURCE = Source.newBuilder(TLLLanguage.ID, "", "TLL builtin").build();
    static final Layout LAYOUT = Layout.createLayout();

    private final Env env;
    private final BufferedReader input;
    private final PrintWriter output;
    private final TLLLanguage language;
    //TODO если появятся объекты #object
    //private final AllocationReporter allocationReporter;
    //private final Shape emptyShape;
    private final Iterable<Scope> topScopes; // Cache the top scopes
    private final TLLFunctionRegistry functionRegistry;

    public TLLContext(TLLLanguage language, Env env, List<NodeFactory<? extends TLLBuiltinNode>> externalBuiltins) {
        this.env = env;
        this.input = new BufferedReader(new InputStreamReader(env.in()));
        this.output = new PrintWriter(env.out(), true);
        this.language = language;
        //TODO если появятся объекты #object
        //this.allocationReporter = env.lookup(AllocationReporter.class);
        //this.emptyShape = LAYOUT.createShape(TLLObjectType.SINGLETON);
        this.functionRegistry = new TLLFunctionRegistry(language);
        this.topScopes = Collections.singleton(Scope.newBuilder("global", functionRegistry.getFunctionsObject()).build());
        installBuiltins();
        for (NodeFactory<? extends TLLBuiltinNode> builtin : externalBuiltins) {
            installBuiltin(builtin);
        }
    }

    /**
     * Return the current Truffle environment.
     */
    public Env getEnv() {
        return env;
    }

    /**
     * Returns the default input, i.e., the source for the {@link TLLReadLnBuiltin}. To allow unit
     * testing, we do not use {@link System#in} directly.
     */
    public BufferedReader getInput() {
        return input;
    }

    /**
     * The default default, i.e., the output for the {@link TLLPrintLnBuiltin}. To allow unit
     * testing, we do not use {@link System#out} directly.
     */
    public PrintWriter getOutput() {
        return output;
    }

    /**
     * Returns the registry of all functions that are currently defined.
     */
    public TLLFunctionRegistry getFunctionRegistry() {
        return functionRegistry;
    }
    public Iterable<Scope> getTopScopes() {
        return topScopes;
    }

    /**
     * Adds all builtin functions to the {@link TLLFunctionRegistry}. This method lists all
     * {@link TLLBuiltinNode builtin implementation classes}.
     */
    private void installBuiltins() {
        installBuiltin(TLLReadLnBuiltinFactory.getInstance());
        installBuiltin(TLLPrintLnBuiltinFactory.getInstance());

        //installBuiltin(TLLImportBuiltinFactory.getInstance());
        //installBuiltin(TLLEvalBuiltinFactory.getInstance());
        //installBuiltin(TLLWrapPrimitiveBuiltinFactory.getInstance());

        //installBuiltin(TLLIsNullBuiltinFactory.getInstance());
        //installBuiltin(TLLIsExecutableBuiltinFactory.getInstance());
        //installBuiltin(TLLHasSizeBuiltinFactory.getInstance());
        //installBuiltin(TLLGetSizeBuiltinFactory.getInstance());
        //installBuiltin(TLLNanoTimeBuiltinFactory.getInstance());
        //installBuiltin(TLLDefineFunctionBuiltinFactory.getInstance());
        //installBuiltin(TLLStackTraceBuiltinFactory.getInstance());
        //installBuiltin(TLLHelloEqualsWorldBuiltinFactory.getInstance());
        //installBuiltin(TLLNewObjectBuiltinFactory.getInstance());
    }

    public void installBuiltin(NodeFactory<? extends TLLBuiltinNode> factory) {
        /*
         * The builtin node factory is a class that is automatically generated by the Truffle DTLL.
         * The signature returned by the factory reflects the signature of the @Specialization
         *
         * methods in the builtin classes.
         */
        int argumentCount = factory.getExecutionSignature().size();
        TLLExpressionNode[] argumentNodes = new TLLExpressionNode[argumentCount];
        /*
         * Builtin functions are like normal functions, i.e., the arguments are passed in as an
         * Object[] array encapsulated in TLLArguments. A TLLReadArgumentNode extracts a parameter
         * from this array.
         */
        for (int i = 0; i < argumentCount; i++) {
            argumentNodes[i] = new TLLReadArgumentNode(i);
        }
        /* Instantiate the builtin node. This node performs the actual functionality. */
        TLLBuiltinNode builtinBodyNode = factory.createNode((Object) argumentNodes);
        builtinBodyNode.addRootTag();
        /* The name of the builtin function is specified via an annotation on the node class. */
        String name = lookupNodeInfo(builtinBodyNode.getClass()).shortName();
        builtinBodyNode.setUnavailableSourceSection();

        /* Wrap the builtin in a RootNode. Truffle requires all AST to start with a RootNode. */
        TLLRootNode rootNode = new TLLRootNode(language, new FrameDescriptor(), builtinBodyNode, BUILTIN_SOURCE.createUnavailableSection(), name);

        getFunctionRegistry().register(name, Truffle.getRuntime().createCallTarget(rootNode));
    }

    public static NodeInfo lookupNodeInfo(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        NodeInfo info = clazz.getAnnotation(NodeInfo.class);
        if (info != null) {
            return info;
        } else {
            return lookupNodeInfo(clazz.getSuperclass());
        }
    }

    //TODO если появятся объекты #object
    /*
     * Methods for object creation / object property access.
     */
//    public AllocationReporter getAllocationReporter() {
//        return allocationReporter;
//    }
//    /**
//     * Allocate an empty object. All new objects initially have no properties. Properties are added
//     * when they are first stored, i.e., the store triggers a shape change of the object.
//     */
//    public DynamicObject createObject(AllocationReporter reporter) {
//        DynamicObject object = null;
//        reporter.onEnter(null, 0, AllocationReporter.SIZE_UNKNOWN);
//        object = emptyShape.newInstance();
//        reporter.onReturnValue(object, 0, AllocationReporter.SIZE_UNKNOWN);
//        return object;
//    }
//
    public static boolean isTLLObject(Object value) {
        /*
         * LAYOUT.getType() returns a concrete implementation class, i.e., a class that is more
         * precise than the base class DynamicObject. This makes the type check faster.
         */
        return LAYOUT.getType().isInstance(value) && LAYOUT.getType().cast(value).getShape().getObjectType() == TLLObjectType.SINGLETON;
    }

    /*
     * Methods for language interoperability.
     */
    public static Object fromForeignValue(Object a) {
        if (a instanceof Long || a instanceof String || a instanceof Boolean) {
            return a;
        } else if (a instanceof Character) {
            return String.valueOf(a);
        } else if (a instanceof Number) {
            return fromForeignNumber(a);
        } else if (a instanceof TruffleObject) {
            return a;
        } else if (a instanceof TLLContext) {
            return a;
        }
        transferToInterpreter();
        throw new IllegalStateException(a + " is not a Truffle value");
    }

    @TruffleBoundary
    private static long fromForeignNumber(Object a) {
        return ((Number) a).longValue();
    }

    public CallTarget parse(Source source) {
        return env.parsePublic(source);
    }

    /**
     * Returns an object that contains bindings that were exported across all used languages. To
     * read or write from this object the {@link TruffleObject interop} API can be used.
     */
    public TruffleObject getPolyglotBindings() {
        return (TruffleObject) env.getPolyglotBindings();
    }

    public static TLLContext getCurrent() {
        return TLLLanguage.getCurrentContext();
    }
}
