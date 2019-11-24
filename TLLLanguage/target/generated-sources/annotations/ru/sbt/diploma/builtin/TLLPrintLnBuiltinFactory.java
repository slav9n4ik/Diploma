// CheckStyle: start generated
package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.TruffleLanguage.ContextReference;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.builtin.TLLPrintLnBuiltin;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.runtime.TLLContext;

@GeneratedBy(TLLPrintLnBuiltin.class)
public final class TLLPrintLnBuiltinFactory implements NodeFactory<TLLPrintLnBuiltin> {

    private static TLLPrintLnBuiltinFactory instance;

    private TLLPrintLnBuiltinFactory() {
    }

    @Override
    public Class<TLLPrintLnBuiltin> getNodeClass() {
        return TLLPrintLnBuiltin.class;
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
    public TLLPrintLnBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof TLLExpressionNode[])) {
            return create((TLLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<TLLPrintLnBuiltin> getInstance() {
        if (instance == null) {
            instance = new TLLPrintLnBuiltinFactory();
        }
        return instance;
    }

    public static TLLPrintLnBuiltin create(TLLExpressionNode[] arguments) {
        return new TLLPrintLnBuiltinNodeGen(arguments);
    }

    @GeneratedBy(TLLPrintLnBuiltin.class)
    public static final class TLLPrintLnBuiltinNodeGen extends TLLPrintLnBuiltin {

        @Child private TLLExpressionNode arguments0_;
        @CompilationFinal private int state_;
        @CompilationFinal private ContextReference<TLLContext> tLLLanguageContextReference_;

        private TLLPrintLnBuiltinNodeGen(TLLExpressionNode[] arguments) {
            this.arguments0_ = arguments != null && 0 < arguments.length ? arguments[0] : null;
        }

        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state = state_;
            if ((state & 0b1110) == 0 /* only-active println(long, TLLContext) */ && state != 0  /* is-not println(long, TLLContext) && println(boolean, TLLContext) && println(String, TLLContext) && println(Object, TLLContext) */) {
                return execute_long0(frameValue, state);
            } else if ((state & 0b1101) == 0 /* only-active println(boolean, TLLContext) */ && state != 0  /* is-not println(long, TLLContext) && println(boolean, TLLContext) && println(String, TLLContext) && println(Object, TLLContext) */) {
                return execute_boolean1(frameValue, state);
            } else {
                return execute_generic2(frameValue, state);
            }
        }

        private Object execute_long0(VirtualFrame frameValue, int state) {
            long arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeLong(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b1) != 0 /* is-active println(long, TLLContext) */;
            return println(arguments0Value_, this.tLLLanguageContextReference_.get());
        }

        private Object execute_boolean1(VirtualFrame frameValue, int state) {
            boolean arguments0Value_;
            try {
                arguments0Value_ = this.arguments0_.executeBoolean(frameValue);
            } catch (UnexpectedResultException ex) {
                return executeAndSpecialize(ex.getResult());
            }
            assert (state & 0b10) != 0 /* is-active println(boolean, TLLContext) */;
            return println(arguments0Value_, this.tLLLanguageContextReference_.get());
        }

        private Object execute_generic2(VirtualFrame frameValue, int state) {
            Object arguments0Value_ = this.arguments0_.executeGeneric(frameValue);
            if ((state & 0b1) != 0 /* is-active println(long, TLLContext) */ && arguments0Value_ instanceof Long) {
                long arguments0Value__ = (long) arguments0Value_;
                return println(arguments0Value__, this.tLLLanguageContextReference_.get());
            }
            if ((state & 0b10) != 0 /* is-active println(boolean, TLLContext) */ && arguments0Value_ instanceof Boolean) {
                boolean arguments0Value__ = (boolean) arguments0Value_;
                return println(arguments0Value__, this.tLLLanguageContextReference_.get());
            }
            if ((state & 0b100) != 0 /* is-active println(String, TLLContext) */ && arguments0Value_ instanceof String) {
                String arguments0Value__ = (String) arguments0Value_;
                return println(arguments0Value__, this.tLLLanguageContextReference_.get());
            }
            if ((state & 0b1000) != 0 /* is-active println(Object, TLLContext) */) {
                return println(arguments0Value_, this.tLLLanguageContextReference_.get());
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize(arguments0Value_);
        }

        private Object executeAndSpecialize(Object arguments0Value) {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            int oldState = state;
            try {
                if (arguments0Value instanceof Long) {
                    long arguments0Value_ = (long) arguments0Value;
                    ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                    if (tLLLanguageContextReference__ == null) {
                        this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                    }
                    this.state_ = state = state | 0b1 /* add-active println(long, TLLContext) */;
                    lock.unlock();
                    hasLock = false;
                    return println(arguments0Value_, tLLLanguageContextReference__.get());
                }
                if (arguments0Value instanceof Boolean) {
                    boolean arguments0Value_ = (boolean) arguments0Value;
                    ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                    if (tLLLanguageContextReference__ == null) {
                        this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                    }
                    this.state_ = state = state | 0b10 /* add-active println(boolean, TLLContext) */;
                    lock.unlock();
                    hasLock = false;
                    return println(arguments0Value_, tLLLanguageContextReference__.get());
                }
                if (arguments0Value instanceof String) {
                    String arguments0Value_ = (String) arguments0Value;
                    ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                    if (tLLLanguageContextReference__ == null) {
                        this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                    }
                    this.state_ = state = state | 0b100 /* add-active println(String, TLLContext) */;
                    lock.unlock();
                    hasLock = false;
                    return println(arguments0Value_, tLLLanguageContextReference__.get());
                }
                ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                if (tLLLanguageContextReference__ == null) {
                    this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                }
                this.state_ = state = state | 0b1000 /* add-active println(Object, TLLContext) */;
                lock.unlock();
                hasLock = false;
                return println(arguments0Value, tLLLanguageContextReference__.get());
            } finally {
                if (oldState != 0) {
                    checkForPolymorphicSpecialize(oldState);
                }
                if (hasLock) {
                    lock.unlock();
                }
            }
        }

        private void checkForPolymorphicSpecialize(int oldState) {
            int newState = this.state_;
            if ((oldState ^ newState) != 0) {
                this.reportPolymorphicSpecialize();
            }
        }

        @Override
        public NodeCost getCost() {
            int state = state_;
            if (state == 0b0) {
                return NodeCost.UNINITIALIZED;
            } else if ((state & (state - 1)) == 0 /* is-single-active  */) {
                return NodeCost.MONOMORPHIC;
            }
            return NodeCost.POLYMORPHIC;
        }

    }
}
