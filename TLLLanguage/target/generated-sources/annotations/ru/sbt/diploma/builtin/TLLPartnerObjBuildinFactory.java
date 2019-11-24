// CheckStyle: start generated
package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.AllocationReporter;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.NodeUtil;
import com.oracle.truffle.api.nodes.ExplodeLoop.LoopExplosionKind;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.builtin.TLLPartnerObjBuildin;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLTypes;
import ru.sbt.diploma.runtime.TLLContext;
import ru.sbt.diploma.runtime.TLLNull;

@GeneratedBy(TLLPartnerObjBuildin.class)
public final class TLLPartnerObjBuildinFactory implements NodeFactory<TLLPartnerObjBuildin> {

    private static TLLPartnerObjBuildinFactory instance;
    private static final LibraryFactory<InteropLibrary> INTEROP_LIBRARY_ = LibraryFactory.resolve(InteropLibrary.class);

    private TLLPartnerObjBuildinFactory() {
    }

    @Override
    public Class<TLLPartnerObjBuildin> getNodeClass() {
        return TLLPartnerObjBuildin.class;
    }

    @Override
    public List<Class<? extends Node>> getExecutionSignature() {
        return Arrays.asList(TLLExpressionNode.class);
    }

    @Override
    public List<List<Class<?>>> getNodeSignatures() {
        return Arrays.asList(Arrays.asList(TLLExpressionNode[].class));
    }

    @Override
    public TLLPartnerObjBuildin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof TLLExpressionNode[])) {
            return create((TLLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<TLLPartnerObjBuildin> getInstance() {
        if (instance == null) {
            instance = new TLLPartnerObjBuildinFactory();
        }
        return instance;
    }

    public static TLLPartnerObjBuildin create(TLLExpressionNode[] arguments) {
        return new TLLPartnerObjBuildinNodeGen(arguments);
    }

    @GeneratedBy(TLLPartnerObjBuildin.class)
    public static final class TLLPartnerObjBuildinNodeGen extends TLLPartnerObjBuildin {

        @Child private TLLExpressionNode arguments0_;
        @CompilationFinal private int state_;
        @CompilationFinal private int exclude_;
        @CompilationFinal private ContextReference<TLLContext> tLLLanguageContextReference_;
        @CompilationFinal private AllocationReporter newPartnerObject0_reporter_;
        @Child private NewPartnerObject1Data newPartnerObject1_cache;

        private TLLPartnerObjBuildinNodeGen(TLLExpressionNode[] arguments) {
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @ExplodeLoop(kind = LoopExplosionKind.FULL_EXPLODE_UNTIL_RETURN)
        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state = state_;
            Object arguments0Value_ = this.arguments0_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active newPartnerObject(TLLNull, TLLContext, AllocationReporter) */ && TLLTypes.isTLLNull(arguments0Value_)) {
                TLLNull arguments0Value__ = TLLTypes.asTLLNull(arguments0Value_);
                return newPartnerObject(arguments0Value__, this.tLLLanguageContextReference_.get(), this.newPartnerObject0_reporter_);
            }
            if ((state & 0b110) != 0 /* is-active newPartnerObject(Object, InteropLibrary) || newPartnerObject(Object, InteropLibrary) */) {
                if ((state & 0b10) != 0 /* is-active newPartnerObject(Object, InteropLibrary) */) {
                    NewPartnerObject1Data s2_ = this.newPartnerObject1_cache;
                    while (s2_ != null) {
                        if ((s2_.values_.accepts(arguments0Value_)) && (!(s2_.values_.isNull(arguments0Value_)))) {
                            return newPartnerObject(arguments0Value_, s2_.values_);
                        }
                        s2_ = s2_.next_;
                    }
                }
                if ((state & 0b100) != 0 /* is-active newPartnerObject(Object, InteropLibrary) */) {
                    Node prev_ = NodeUtil.pushEncapsulatingNode(this);
                    try {
                        if ((!((INTEROP_LIBRARY_.getUncached(arguments0Value_)).isNull(arguments0Value_)))) {
                            return newPartnerObject(arguments0Value_, (INTEROP_LIBRARY_.getUncached(arguments0Value_)));
                        }
                    } finally {
                        NodeUtil.popEncapsulatingNode(prev_);
                    }
                }
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int exclude = exclude_;
            int oldState = state;
            int oldExclude = exclude;
            int oldCacheCount = state == 0 ? 0 : countCaches();
            try {
                if (TLLTypes.isTLLNull(arguments0Value)) {
                    TLLNull arguments0Value_ = TLLTypes.asTLLNull(arguments0Value);
                    ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                    if (tLLLanguageContextReference__ == null) {
                        this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                    }
                    this.newPartnerObject0_reporter_ = (tLLLanguageContextReference__.get().getAllocationReporter());
                    this.state_ = state = state | 0b1 /* add-active newPartnerObject(TLLNull, TLLContext, AllocationReporter) */;
                    lock.unlock();
                    hasLock = false;
                    return newPartnerObject(arguments0Value_, tLLLanguageContextReference__.get(), this.newPartnerObject0_reporter_);
                }
                if ((exclude) == 0 /* is-not-excluded newPartnerObject(Object, InteropLibrary) */) {
                    int count2_ = 0;
                    NewPartnerObject1Data s2_ = this.newPartnerObject1_cache;
                    if ((state & 0b10) != 0 /* is-active newPartnerObject(Object, InteropLibrary) */) {
                        while (s2_ != null) {
                            if ((s2_.values_.accepts(arguments0Value)) && (!(s2_.values_.isNull(arguments0Value)))) {
                                break;
                            }
                            s2_ = s2_.next_;
                            count2_++;
                        }
                    }
                    if (s2_ == null) {
                        {
                            InteropLibrary values__ = super.insert((INTEROP_LIBRARY_.create(arguments0Value)));
                            // assert (s2_.values_.accepts(arguments0Value));
                            if ((!(values__.isNull(arguments0Value))) && count2_ < (3)) {
                                s2_ = super.insert(new NewPartnerObject1Data(newPartnerObject1_cache));
                                s2_.values_ = s2_.insertAccessor(values__);
                                this.newPartnerObject1_cache = s2_;
                                this.state_ = state = state | 0b10 /* add-active newPartnerObject(Object, InteropLibrary) */;
                            }
                        }
                    }
                    if (s2_ != null) {
                        lock.unlock();
                        hasLock = false;
                        return newPartnerObject(arguments0Value, s2_.values_);
                    }
                }
                {
                    Node prev_ = NodeUtil.pushEncapsulatingNode(this);
                    try {
                        {
                            InteropLibrary newPartnerObject2_values__ = (INTEROP_LIBRARY_.getUncached(arguments0Value));
                            if ((!(newPartnerObject2_values__.isNull(arguments0Value)))) {
                                this.exclude_ = exclude = exclude | 0b1 /* add-excluded newPartnerObject(Object, InteropLibrary) */;
                                this.newPartnerObject1_cache = null;
                                state = state & 0xfffffffd /* remove-active newPartnerObject(Object, InteropLibrary) */;
                                this.state_ = state = state | 0b100 /* add-active newPartnerObject(Object, InteropLibrary) */;
                                lock.unlock();
                                hasLock = false;
                                return newPartnerObject(arguments0Value, newPartnerObject2_values__);
                            }
                        }
                    } finally {
                        NodeUtil.popEncapsulatingNode(prev_);
                    }
                }
                throw new UnsupportedSpecializationException(this, new Node[] {this.arguments0_}, arguments0Value);
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
            NewPartnerObject1Data s2_ = this.newPartnerObject1_cache;
            while (s2_ != null) {
                cacheCount++;
                s2_= s2_.next_;
            }
            return cacheCount;
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                NewPartnerObject1Data s2_ = this.newPartnerObject1_cache;
                if ((s2_ == null || s2_.next_ == null)) {
                    return NodeCost.MONOMORPHIC;
                }
            }
            return NodeCost.POLYMORPHIC;
        }

        @GeneratedBy(TLLPartnerObjBuildin.class)
        private static final class NewPartnerObject1Data extends Node {

            @Child NewPartnerObject1Data next_;
            @Child InteropLibrary values_;

            NewPartnerObject1Data(NewPartnerObject1Data next_) {
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
