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
import ru.sbt.diploma.nodes.TLLTypesGen;

@GeneratedBy(TLLReadLocalVariableNode.class)
public final class TLLReadLocalVariableNodeGen extends TLLReadLocalVariableNode {

    private final FrameSlot slot;
    @CompilationFinal private int state_;
    @CompilationFinal private int exclude_;

    private TLLReadLocalVariableNodeGen(FrameSlot slot) {
        this.slot = slot;
    }

    @Override
    protected FrameSlot getSlot() {
        return this.slot;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state = state_;
        if ((state & 0b1) != 0 /* is-active readLong(VirtualFrame) */) {
            if ((isLong(frameValue))) {
                return readLong(frameValue);
            }
        }
        if ((state & 0b10) != 0 /* is-active readBoolean(VirtualFrame) */) {
            if ((isBoolean(frameValue))) {
                return readBoolean(frameValue);
            }
        }
        if ((state & 0b100) != 0 /* is-active readObject(VirtualFrame) */) {
            return readObject(frameValue);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(frameValue);
    }

    @Override
    public boolean executeBoolean(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100) != 0 /* is-active readObject(VirtualFrame) */) {
            return TLLTypesGen.expectBoolean(executeGeneric(frameValue));
        }
        if ((state & 0b10) != 0 /* is-active readBoolean(VirtualFrame) */) {
            if ((isBoolean(frameValue))) {
                return readBoolean(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return TLLTypesGen.expectBoolean(executeAndSpecialize(frameValue));
    }

    @Override
    public long executeLong(VirtualFrame frameValue) throws UnexpectedResultException {
        int state = state_;
        if ((state & 0b100) != 0 /* is-active readObject(VirtualFrame) */) {
            return TLLTypesGen.expectLong(executeGeneric(frameValue));
        }
        if ((state & 0b1) != 0 /* is-active readLong(VirtualFrame) */) {
            if ((isLong(frameValue))) {
                return readLong(frameValue);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return TLLTypesGen.expectLong(executeAndSpecialize(frameValue));
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        int state = state_;
        try {
            if ((state & 0b110) == 0 /* only-active readLong(VirtualFrame) */ && state != 0  /* is-not readLong(VirtualFrame) && readBoolean(VirtualFrame) && readObject(VirtualFrame) */) {
                executeLong(frameValue);
                return;
            } else if ((state & 0b101) == 0 /* only-active readBoolean(VirtualFrame) */ && state != 0  /* is-not readLong(VirtualFrame) && readBoolean(VirtualFrame) && readObject(VirtualFrame) */) {
                executeBoolean(frameValue);
                return;
            }
            executeGeneric(frameValue);
            return;
        } catch (UnexpectedResultException ex) {
            return;
        }
    }

    private Object executeAndSpecialize(VirtualFrame frameValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        int oldState = state;
        int oldExclude = exclude;
        try {
            if (((exclude & 0b1)) == 0 /* is-not-excluded readLong(VirtualFrame) */) {
                if ((isLong(frameValue))) {
                    this.state_ = state = state | 0b1 /* add-active readLong(VirtualFrame) */;
                    lock.unlock();
                    hasLock = false;
                    return readLong(frameValue);
                }
            }
            if (((exclude & 0b10)) == 0 /* is-not-excluded readBoolean(VirtualFrame) */) {
                if ((isBoolean(frameValue))) {
                    this.state_ = state = state | 0b10 /* add-active readBoolean(VirtualFrame) */;
                    lock.unlock();
                    hasLock = false;
                    return readBoolean(frameValue);
                }
            }
            this.exclude_ = exclude = exclude | 0b11 /* add-excluded readLong(VirtualFrame), readBoolean(VirtualFrame) */;
            state = state & 0xfffffffc /* remove-active readLong(VirtualFrame), readBoolean(VirtualFrame) */;
            this.state_ = state = state | 0b100 /* add-active readObject(VirtualFrame) */;
            lock.unlock();
            hasLock = false;
            return readObject(frameValue);
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

    public static TLLReadLocalVariableNode create(FrameSlot slot) {
        return new TLLReadLocalVariableNodeGen(slot);
    }

}
