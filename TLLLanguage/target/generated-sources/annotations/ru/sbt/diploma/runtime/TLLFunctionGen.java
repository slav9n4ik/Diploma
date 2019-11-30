// CheckStyle: start generated
package ru.sbt.diploma.runtime;

import com.oracle.truffle.api.Assumption;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.DynamicDispatchLibrary;
import com.oracle.truffle.api.library.LibraryExport;
import com.oracle.truffle.api.library.LibraryFactory;
import com.oracle.truffle.api.nodes.DirectCallNode;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.IndirectCallNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.ExplodeLoop.LoopExplosionKind;
import java.util.concurrent.locks.Lock;
import ru.sbt.diploma.runtime.TLLFunction;
import ru.sbt.diploma.runtime.TLLFunction.Execute;

@GeneratedBy(TLLFunction.class)
final class TLLFunctionGen {

    private static final LibraryFactory<DynamicDispatchLibrary> DYNAMIC_DISPATCH_LIBRARY_ = LibraryFactory.resolve(DynamicDispatchLibrary.class);

    static  {
        LibraryExport.register(TLLFunction.class, new InteropLibraryExports());
    }

    private TLLFunctionGen() {
    }

    @GeneratedBy(TLLFunction.class)
    private static final class InteropLibraryExports extends LibraryExport<InteropLibrary> {

        private InteropLibraryExports() {
            super(InteropLibrary.class, TLLFunction.class, false);
        }

        @Override
        protected InteropLibrary createUncached(Object receiver) {
            assert receiver instanceof TLLFunction;
            return new Uncached();
        }

        @Override
        protected InteropLibrary createCached(Object receiver) {
            assert receiver instanceof TLLFunction;
            return new Cached();
        }

        @GeneratedBy(TLLFunction.class)
        private static final class Cached extends InteropLibrary {

            @CompilationFinal private int state_;
            @CompilationFinal private int exclude_;
            @Child private DirectData direct_cache;
            @Child private IndirectCallNode indirect_callNode_;

            Cached() {
            }

            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof TLLFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.sbt.diploma.runtime.TLLFunction'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof TLLFunction;
            }

            @ExplodeLoop(kind = LoopExplosionKind.FULL_EXPLODE_UNTIL_RETURN)
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) throws UnsupportedTypeException, ArityException, UnsupportedMessageException {
                assert assertAdopted();
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TLLFunction arg0Value = (TLLFunction) arg0Value_;
                int state = state_;
                if (state != 0 /* is-active doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) || doIndirect(TLLFunction, Object[], IndirectCallNode) */) {
                    if ((state & 0b1) != 0 /* is-active doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) */) {
                        DirectData s1_ = this.direct_cache;
                        while (s1_ != null) {
                            if (!Assumption.isValidAssumption(s1_.assumption0_)) {
                                CompilerDirectives.transferToInterpreterAndInvalidate();
                                removeDirect_(s1_);
                                return executeAndSpecialize(arg0Value, arg1Value);
                            }
                            if ((arg0Value.getCallTarget() == s1_.cachedTarget_)) {
                                return Execute.doDirect(arg0Value, arg1Value, s1_.callTargetStable_, s1_.cachedTarget_, s1_.callNode_);
                            }
                            s1_ = s1_.next_;
                        }
                    }
                    if ((state & 0b10) != 0 /* is-active doIndirect(TLLFunction, Object[], IndirectCallNode) */) {
                        return Execute.doIndirect(arg0Value, arg1Value, this.indirect_callNode_);
                    }
                }
                CompilerDirectives.transferToInterpreterAndInvalidate();
                return executeAndSpecialize(arg0Value, arg1Value);
            }

            private Object executeAndSpecialize(TLLFunction arg0Value, Object[] arg1Value) {
                Lock lock = getLock();
                boolean hasLock = true;
                lock.lock();
                int state = state_;
                int exclude = exclude_;
                try {
                    if ((exclude) == 0 /* is-not-excluded doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) */) {
                        int count1_ = 0;
                        DirectData s1_ = this.direct_cache;
                        if ((state & 0b1) != 0 /* is-active doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) */) {
                            while (s1_ != null) {
                                if ((arg0Value.getCallTarget() == s1_.cachedTarget_) && (s1_.assumption0_ == null || Assumption.isValidAssumption(s1_.assumption0_))) {
                                    break;
                                }
                                s1_ = s1_.next_;
                                count1_++;
                            }
                        }
                        if (s1_ == null) {
                            {
                                RootCallTarget cachedTarget__ = (arg0Value.getCallTarget());
                                if ((arg0Value.getCallTarget() == cachedTarget__)) {
                                    Assumption callTargetStable__ = (arg0Value.getCallTargetStable());
                                    Assumption assumption0 = (callTargetStable__);
                                    if (Assumption.isValidAssumption(assumption0)) {
                                        if (count1_ < (TLLFunction.INLINE_CACHE_SIZE)) {
                                            s1_ = super.insert(new DirectData(direct_cache));
                                            s1_.callTargetStable_ = callTargetStable__;
                                            s1_.cachedTarget_ = cachedTarget__;
                                            s1_.callNode_ = s1_.insertAccessor((DirectCallNode.create(cachedTarget__)));
                                            s1_.assumption0_ = assumption0;
                                            this.direct_cache = s1_;
                                            this.state_ = state = state | 0b1 /* add-active doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) */;
                                        }
                                    }
                                }
                            }
                        }
                        if (s1_ != null) {
                            lock.unlock();
                            hasLock = false;
                            return Execute.doDirect(arg0Value, arg1Value, s1_.callTargetStable_, s1_.cachedTarget_, s1_.callNode_);
                        }
                    }
                    this.indirect_callNode_ = super.insert((IndirectCallNode.create()));
                    this.exclude_ = exclude = exclude | 0b1 /* add-excluded doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) */;
                    this.direct_cache = null;
                    state = state & 0xfffffffe /* remove-active doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) */;
                    this.state_ = state = state | 0b10 /* add-active doIndirect(TLLFunction, Object[], IndirectCallNode) */;
                    lock.unlock();
                    hasLock = false;
                    return Execute.doIndirect(arg0Value, arg1Value, this.indirect_callNode_);
                } finally {
                    if (hasLock) {
                        lock.unlock();
                    }
                }
            }

            @Override
            public NodeCost getCost() {
                int state = state_;
                if (state == 0b0) {
                    return NodeCost.UNINITIALIZED;
                } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                    DirectData s1_ = this.direct_cache;
                    if ((s1_ == null || s1_.next_ == null)) {
                        return NodeCost.MONOMORPHIC;
                    }
                }
                return NodeCost.POLYMORPHIC;
            }

            void removeDirect_(Object s1_) {
                Lock lock = getLock();
                lock.lock();
                try {
                    DirectData prev = null;
                    DirectData cur = this.direct_cache;
                    while (cur != null) {
                        if (cur == s1_) {
                            if (prev == null) {
                                this.direct_cache = cur.next_;
                                this.adoptChildren();
                            } else {
                                prev.next_ = cur.next_;
                                prev.adoptChildren();
                            }
                            break;
                        }
                        prev = cur;
                        cur = cur.next_;
                    }
                    if (this.direct_cache == null) {
                        this.state_ = this.state_ & 0xfffffffe /* remove-active doDirect(TLLFunction, Object[], Assumption, RootCallTarget, DirectCallNode) */;
                    }
                } finally {
                    lock.unlock();
                }
            }

            @Override
            public boolean isExecutable(Object receiver) {
                assert assertAdopted();
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TLLFunction) receiver).isExecutable();
            }

            @GeneratedBy(TLLFunction.class)
            private static final class DirectData extends Node {

                @Child DirectData next_;
                @CompilationFinal Assumption callTargetStable_;
                @CompilationFinal RootCallTarget cachedTarget_;
                @Child DirectCallNode callNode_;
                @CompilationFinal Assumption assumption0_;

                DirectData(DirectData next_) {
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
        @GeneratedBy(TLLFunction.class)
        private static final class Uncached extends InteropLibrary {

            Uncached() {
            }

            @TruffleBoundary
            @Override
            public boolean accepts(Object receiver) {
                assert !(receiver instanceof TLLFunction) || DYNAMIC_DISPATCH_LIBRARY_.getUncached().dispatch(receiver) == null : "Invalid library export 'ru.sbt.diploma.runtime.TLLFunction'. Exported receiver with dynamic dispatch found but not expected.";
                return receiver instanceof TLLFunction;
            }

            @Override
            public boolean isAdoptable() {
                return false;
            }

            @Override
            public NodeCost getCost() {
                return NodeCost.MEGAMORPHIC;
            }

            @TruffleBoundary
            @Override
            public Object execute(Object arg0Value_, Object... arg1Value) {
                assert this.accepts(arg0Value_) : "Invalid library usage. Library does not accept given receiver.";
                TLLFunction arg0Value = (TLLFunction) arg0Value_;
                return Execute.doIndirect(arg0Value, arg1Value, (IndirectCallNode.getUncached()));
            }

            @TruffleBoundary
            @Override
            public boolean isExecutable(Object receiver) {
                assert this.accepts(receiver) : "Invalid library usage. Library does not accept given receiver.";
                return ((TLLFunction) receiver) .isExecutable();
            }

        }
    }
}
