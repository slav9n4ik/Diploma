// CheckStyle: start generated
package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.ExplodeLoop.LoopExplosionKind;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.runtime.TLLContext;

@GeneratedBy(TLLEvalBuiltin.class)
public final class TLLEvalBuiltinFactory implements NodeFactory<TLLEvalBuiltin> {

    private static TLLEvalBuiltinFactory instance;

    private TLLEvalBuiltinFactory() {
    }

    @Override
    public Class<TLLEvalBuiltin> getNodeClass() {
        return TLLEvalBuiltin.class;
    }

    @Override
    public List<Class<? extends Node>> getExecutionSignature() {
        return Arrays.asList(TLLExpressionNode.class, TLLExpressionNode.class);
    }

    @Override
    public List<List<Class<?>>> getNodeSignatures() {
        return Arrays.asList(Arrays.asList(TLLExpressionNode[].class));
    }

    @Override
    public TLLEvalBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof TLLExpressionNode[])) {
            return create((TLLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<TLLEvalBuiltin> getInstance() {
        if (instance == null) {
            instance = new TLLEvalBuiltinFactory();
        }
        return instance;
    }

    public static TLLEvalBuiltin create(TLLExpressionNode[] arguments) {
        return new TLLEvalBuiltinNodeGen(arguments);
    }

    @GeneratedBy(TLLEvalBuiltin.class)
    public static final class TLLEvalBuiltinNodeGen extends TLLEvalBuiltin {

        @Child private TLLExpressionNode arguments0_;
        @Child private TLLExpressionNode arguments1_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;
        @CompilationFinal private ContextReference<TLLContext> tLLLanguageContextReference_;
        @Child private EvalCachedData evalCached_cache;

        private TLLEvalBuiltinNodeGen(TLLExpressionNode[] arguments) {
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
            this.arguments1_ = arguments != null && 1 < arguments.length ? arguments[1] : null;
        }

        @ExplodeLoop(kind = LoopExplosionKind.FULL_EXPLODE_UNTIL_RETURN)
        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.executeGeneric(frameValue);
            Object arguments1Value_ = this.arguments1_.executeGeneric(frameValue);
            if (state != 0 /* is-active evalCached(String, String, String, String, TLLContext, DirectCallNode) || evalUncached(String, String, TLLContext) */ && arguments0Value_ instanceof String) {
                String arguments0Value__ = (String) arguments0Value_;
                if (arguments1Value_ instanceof String) {
                    String arguments1Value__ = (String) arguments1Value_;
                    if ((state & 0b1) != 0 /* is-active evalCached(String, String, String, String, TLLContext, DirectCallNode) */) {
                        EvalCachedData s1_ = this.evalCached_cache;
                        while (s1_ != null) {
                            if ((stringsEqual(s1_.cachedId_, arguments0Value__)) && (stringsEqual(s1_.cachedCode_, arguments1Value__))) {
                                return evalCached(arguments0Value__, arguments1Value__, s1_.cachedId_, s1_.cachedCode_, this.tLLLanguageContextReference_.get(), s1_.callNode_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active evalUncached(String, String, TLLContext) */) {
                        return evalUncached(arguments0Value__, arguments1Value__, this.tLLLanguageContextReference_.get());
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_, arguments1Value_);
        }

        private Object executeAndSpecialize(Object arguments0Value, Object arguments1Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            int oldState = state;
            int oldExclude = exclude;
            int oldCacheCount = state == 0 ? 0 : countCaches();
            try {
                if (arguments0Value instanceof String) {
                    String arguments0Value_ = (String) arguments0Value;
                    if (arguments1Value instanceof String) {
                        String arguments1Value_ = (String) arguments1Value;
                        if ((exclude) == 0 /* is-not-excluded evalCached(String, String, String, String, TLLContext, DirectCallNode) */) {
                            int count1_ = 0;
                            EvalCachedData s1_ = this.evalCached_cache;
                            if ((state & 0b1) != 0 /* is-active evalCached(String, String, String, String, TLLContext, DirectCallNode) */) {
                                while (s1_ != null) {
                                    if ((stringsEqual(s1_.cachedId_, arguments0Value_)) && (stringsEqual(s1_.cachedCode_, arguments1Value_))) {
                                        break;
                                    }
                                    s1_ = s1_.next_;
                                    count1_++;
                                }
                            }
                            if (s1_ == null) {
                                {
                                    String cachedId__ = (arguments0Value_);
                                    if ((stringsEqual(cachedId__, arguments0Value_))) {
                                        String cachedCode__ = (arguments1Value_);
                                        if ((stringsEqual(cachedCode__, arguments1Value_)) && count1_ < (3)) {
                                            s1_ = super.insert(new EvalCachedData(evalCached_cache));
                                            s1_.cachedId_ = cachedId__;
                                            s1_.cachedCode_ = cachedCode__;
                                            ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                                            if (tLLLanguageContextReference__ == null) {
                                                this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                                            }
                                            s1_.callNode_ = s1_.insertAccessor((DirectCallNode.create(parse(arguments0Value_, arguments1Value_, tLLLanguageContextReference__.get()))));
                                            this.evalCached_cache = s1_;
                                            this.state_ = state = state | 0b1 /* add-active evalCached(String, String, String, String, TLLContext, DirectCallNode) */;
                                        }
                                    }
                                }
                            }
                            if (s1_ != null) {
                                lock.unlock();
                                hasLock = false;
                                return evalCached(arguments0Value_, arguments1Value_, s1_.cachedId_, s1_.cachedCode_, this.tLLLanguageContextReference_.get(), s1_.callNode_);
                            }
                        }
                        ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                        if (tLLLanguageContextReference__ == null) {
                            this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                        }
                        this.exclude_ = exclude = exclude | 0b1 /* add-excluded evalCached(String, String, String, String, TLLContext, DirectCallNode) */;
                        this.evalCached_cache = null;
                        state = state & 0xfffffffe /* remove-active evalCached(String, String, String, String, TLLContext, DirectCallNode) */;
                        this.state_ = state = state | 0b10 /* add-active evalUncached(String, String, TLLContext) */;
                        lock.unlock();
                        hasLock = false;
                        return evalUncached(arguments0Value_, arguments1Value_, tLLLanguageContextReference__.get());
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_, this.arguments1_}, arguments0Value, arguments1Value);
            } finally {
                if (oldState != 0 || oldExclude != 0) {
                    checkForPolymorphicSpecialize(oldState, oldExclude, oldCacheCount);
                }
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        private void checkForPolymorphicSpecialize(int oldState, int oldExclude, int oldCacheCount) {
            int newState = this.state_;
            int newExclude = this.exclude_;
            if ((oldState ^ newState) != 0 || (oldExclude ^ newExclude) != 0 || oldCacheCount < countCaches()) {
                this.reportPolymorphicSpecialize();
            }
        }

        private int countCaches() {
            int cacheCount = 0;
            EvalCachedData s1_ = this.evalCached_cache;
            while (s1_ != null) {
                cacheCount++;
                s1_= s1_.next_;
            }
            return cacheCount;
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                EvalCachedData s1_ = this.evalCached_cache;
                if ((s1_ == null || s1_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @GeneratedBy(TLLEvalBuiltin.class)
        private static final class EvalCachedData extends Node {

            @Child EvalCachedData next_;
            @CompilationFinal String cachedId_;
            @CompilationFinal String cachedCode_;
            @Child DirectCallNode callNode_;

            EvalCachedData(EvalCachedData next_) {
                this.next_ = next_;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.NONE;
            }

            <T extends Node> T insertAccessor(T node) {
                return super.insert(node);
            }

        }
    }
}
