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
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import ru.sbt.diploma.TLLLanguage;
import ru.diploma.builtin.TLLReadLnBuiltin;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.runtime.TLLContext;

@GeneratedBy(TLLReadLnBuiltin.class)
@SuppressWarnings("unused")
public final class TLLReadLnBuiltinFactory implements NodeFactory<TLLReadLnBuiltin> {

    private static TLLReadLnBuiltinFactory instance;

    private TLLReadLnBuiltinFactory() {
    }

    @Override
    public Class<TLLReadLnBuiltin> getNodeClass() {
        return TLLReadLnBuiltin.class;
    }

    @Override
    public List<Class<? extends Node>> getExecutionSignature() {
        return Arrays.asList();
    }

    @Override
    public List<List<Class<?>>> getNodeSignatures() {
        return Arrays.asList(Arrays.asList(TLLExpressionNode[].class));
    }

    @Override
    public TLLReadLnBuiltin createNode(Object... arguments) {
        if (arguments.length == 1 && (arguments[0] == null || arguments[0] instanceof TLLExpressionNode[])) {
            return create((TLLExpressionNode[]) arguments[0]);
        } else {
            throw new IllegalArgumentException("Invalid create signature.");
        }
    }

    public static NodeFactory<TLLReadLnBuiltin> getInstance() {
        if (instance == null) {
            instance = new TLLReadLnBuiltinFactory();
        }
        return instance;
    }

    public static TLLReadLnBuiltin create(TLLExpressionNode[] arguments) {
        return new TLLReadLnBuiltinNodeGen(arguments);
    }

    @GeneratedBy(TLLReadLnBuiltin.class)
    public static final class TLLReadLnBuiltinNodeGen extends TLLReadLnBuiltin {

        @CompilationFinal private int state_;
        @CompilationFinal private ContextReference<TLLContext> tLLLanguageContextReference_;

        private TLLReadLnBuiltinNodeGen(TLLExpressionNode[] arguments) {
        }

        @Override
        protected Object execute(VirtualFrame frameValue) {
            int state = state_;
            if (state != 0 /* is-active readln(TLLContext) */) {
                return readln(this.tLLLanguageContextReference_.get());
            }
            CompilerDirectives.transferToInterpreterAndInvalidate();
            return executeAndSpecialize();
        }

        private String executeAndSpecialize() {
            Lock lock = getLock();
            boolean hasLock = true;
            lock.lock();
            int state = state_;
            try {
                ContextReference<TLLContext> tLLLanguageContextReference__ = this.tLLLanguageContextReference_;
                if (tLLLanguageContextReference__ == null) {
                    this.tLLLanguageContextReference_ = tLLLanguageContextReference__ = super.lookupContextReference(TLLLanguage.class);
                }
                this.state_ = state = state | 0b1 /* add-active readln(TLLContext) */;
                lock.unlock();
                hasLock = false;
                return readln(tLLLanguageContextReference__.get());
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
            } else {
                return NodeCost.MONOMORPHIC;
            }
        }

    }
}
