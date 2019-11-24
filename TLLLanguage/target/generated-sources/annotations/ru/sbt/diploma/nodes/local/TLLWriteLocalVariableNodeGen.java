// CheckStyle: start generated
package ru.sbt.diploma.nodes.local;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import java.util.concurrent.locks.Lock;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLTypesGen;

@GeneratedBy(TLLWriteLocalVariableNode.class)
public final class TLLWriteLocalVariableNodeGen extends TLLWriteLocalVariableNode {

    private final FrameSlot slot;
    @Child private TLLExpressionNode valueNode_;
    @CompilationFinal private int state_;
    @CompilationFinal private int exclude_;

    private TLLWriteLocalVariableNodeGen(TLLExpressionNode valueNode, FrameSlot slot) {
        this.slot = slot;
        this.valueNode_ = valueNode;
    }

    @Override
    protected FrameSlot getSlot() {
        return this.slot;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b110) == 0 /* only-active writeLong(VirtualFrame, long) */ && state != 0  /* is-not writeLong(VirtualFrame, long) && writeBoolean(VirtualFrame, boolean) && write(VirtualFrame, Object) */) {
            return executeGeneric_long0(frameValue, state);
        } else if ((state & 0b101) == 0 /* only-active writeBoolean(VirtualFrame, boolean) */ && state != 0  /* is-not writeLong(VirtualFrame, long) && writeBoolean(VirtualFrame, boolean) && write(VirtualFrame, Object) */) {
            return executeGeneric_boolean1(frameValue, state);
        } else {
            return executeGeneric_generic2(frameValue, state);
        }
    }

    private Object executeGeneric_long0(VirtualFrame frameValue, int state) {
        long valueNodeValue_;
        try {
            valueNodeValue_ = this.valueNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state & 0b1) != 0 /* is-active writeLong(VirtualFrame, long) */;
        if ((isLongOrIllegal(frameValue))) {
            return writeLong(frameValue, valueNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, valueNodeValue_);
    }

    private Object executeGeneric_boolean1(VirtualFrame frameValue, int state) {
        boolean valueNodeValue_;
        try {
            valueNodeValue_ = this.valueNode_.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(frameValue, ex.getResult());
        }
        assert (state & 0b10) != 0 /* is-active writeBoolean(VirtualFrame, boolean) */;
        if ((isBooleanOrIllegal(frameValue))) {
            return writeBoolean(frameValue, valueNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, valueNodeValue_);
    }

    private Object executeGeneric_generic2(VirtualFrame frameValue, int state) {
        Object valueNodeValue_ = this.valueNode_.executeGeneric(frameValue);
        if ((state & 0b1) != 0 /* is-active writeLong(VirtualFrame, long) */ && valueNodeValue_ instanceof Long) {
            long valueNodeValue__ = (long) valueNodeValue_;
            if ((isLongOrIllegal(frameValue))) {
                return writeLong(frameValue, valueNodeValue__);
            }
        }
        if ((state & 0b10) != 0 /* is-active writeBoolean(VirtualFrame, boolean) */ && valueNodeValue_ instanceof Boolean) {
            boolean valueNodeValue__ = (boolean) valueNodeValue_;
            if ((isBooleanOrIllegal(frameValue))) {
                return writeBoolean(frameValue, valueNodeValue__);
            }
        }
        if ((state & 0b100) != 0 /* is-active write(VirtualFrame, Object) */) {
            return write(frameValue, valueNodeValue_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue, valueNodeValue_);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100) != 0 /* is-active write(VirtualFrame, Object) */) {
            return TLLTypesGen.expectBoolean(executeGeneric(frameValue));
        }
        boolean valueNodeValue_;
        try {
            valueNodeValue_ = this.valueNode_.executeBoolean(frameValue);
        } catch (UnexpectedResultException ex) {
            return TLLTypesGen.expectBoolean(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state & 0b10) != 0 /* is-active writeBoolean(VirtualFrame, boolean) */) {
            if ((isBooleanOrIllegal(frameValue))) {
                return writeBoolean(frameValue, valueNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return TLLTypesGen.expectBoolean(executeAndSpecialize(frameValue, valueNodeValue_));
    }

    @Override
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100) != 0 /* is-active write(VirtualFrame, Object) */) {
            return TLLTypesGen.expectLong(executeGeneric(frameValue));
        }
        long valueNodeValue_;
        try {
            valueNodeValue_ = this.valueNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return TLLTypesGen.expectLong(executeAndSpecialize(frameValue, ex.getResult()));
        }
        if ((state & 0b1) != 0 /* is-active writeLong(VirtualFrame, long) */) {
            if ((isLongOrIllegal(frameValue))) {
                return writeLong(frameValue, valueNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return TLLTypesGen.expectLong(executeAndSpecialize(frameValue, valueNodeValue_));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b110) == 0 /* only-active writeLong(VirtualFrame, long) */ && state != 0  /* is-not writeLong(VirtualFrame, long) && writeBoolean(VirtualFrame, boolean) && write(VirtualFrame, Object) */) {
                executeLong(frameValue);
                return;
            } else if ((state & 0b101) == 0 /* only-active writeBoolean(VirtualFrame, boolean) */ && state != 0  /* is-not writeLong(VirtualFrame, long) && writeBoolean(VirtualFrame, boolean) && write(VirtualFrame, Object) */) {
                executeBoolean(frameValue);
                return;
            }
            executeGeneric(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(VirtualFrame frameValue, Object valueNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        int oldState = state;
        int oldExclude = exclude;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded writeLong(VirtualFrame, long) */ && valueNodeValue instanceof Long) {
                long valueNodeValue_ = (long) valueNodeValue;
                if ((isLongOrIllegal(frameValue))) {
                    this.state_ = state = state | 0b1 /* add-active writeLong(VirtualFrame, long) */;
                    lock.unlock();
                    hasLock = false;
                    return writeLong(frameValue, valueNodeValue_);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded writeBoolean(VirtualFrame, boolean) */ && valueNodeValue instanceof Boolean) {
                boolean valueNodeValue_ = (boolean) valueNodeValue;
                if ((isBooleanOrIllegal(frameValue))) {
                    this.state_ = state = state | 0b10 /* add-active writeBoolean(VirtualFrame, boolean) */;
                    lock.unlock();
                    hasLock = false;
                    return writeBoolean(frameValue, valueNodeValue_);
                }
            }
            this.exclude_ = exclude = exclude | 0b11 /* add-excluded writeLong(VirtualFrame, long), writeBoolean(VirtualFrame, boolean) */;
            state = state & 0xfffffffc /* remove-active writeLong(VirtualFrame, long), writeBoolean(VirtualFrame, boolean) */;
            this.state_ = state = state | 0b100 /* add-active write(VirtualFrame, Object) */;
            lock.unlock();
            hasLock = false;
            return write(frameValue, valueNodeValue);
        } finally {
            if (oldState != 0 || oldExclude != 0) {
                checkForPolymorphicSpecialize(oldState, oldExclude);
            }
            if (hasLock) {
                lock.unlock();
            }
        }
    }

    private void checkForPolymorphicSpecialize(int oldState, int oldExclude) {
        int newState = this.state_;
        int newExclude = this.exclude_;
        if ((oldState ^ newState) != 0 || (oldExclude ^ newExclude) != 0) {
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

    public static TLLWriteLocalVariableNode create(TLLExpressionNode valueNode, FrameSlot slot) {
        return new TLLWriteLocalVariableNodeGen(valueNode, slot);
    }

}
