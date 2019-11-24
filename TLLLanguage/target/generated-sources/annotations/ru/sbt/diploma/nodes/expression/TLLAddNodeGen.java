// CheckStyle: start generated
package ru.sbt.diploma.nodes.expression;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import java.util.concurrent.locks.Lock;
import ru.sbt.diploma.nodes.TLLExpressionNode;

@GeneratedBy(TLLAddNode.class)
public final class TLLAddNodeGen extends TLLAddNode {

    @Child private TLLExpressionNode leftNode_;
    @Child private TLLExpressionNode rightNode_;
    @CompilationFinal private int state_;
    @CompilationFinal private int exclude_;

    private TLLAddNodeGen(TLLExpressionNode leftNode, TLLExpressionNode rightNode) {
        this.leftNode_ = leftNode;
        this.rightNode_ = rightNode;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state = state_;
        long leftNodeValue_;
        try {
            leftNodeValue_ = this.leftNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = this.rightNode_.executeGeneric(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        long rightNodeValue_;
        try {
            rightNodeValue_ = this.rightNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if (state != 0 /* is-active add(long, long) */) {
            try {
                return add(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded add(long, long) */;
                    this.state_ = this.state_ & 0xfffffffe /* remove-active add(long, long) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public long executeLong(VirtualFrame frameValue) {
        int state = state_;
        long leftNodeValue_;
        try {
            leftNodeValue_ = this.leftNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            Object rightNodeValue = this.rightNode_.executeGeneric(frameValue);
            return executeAndSpecialize(ex.getResult(), rightNodeValue);
        }
        long rightNodeValue_;
        try {
            rightNodeValue_ = this.rightNode_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(leftNodeValue_, ex.getResult());
        }
        if (state != 0 /* is-active add(long, long) */) {
            try {
                return add(leftNodeValue_, rightNodeValue_);
            } catch (ArithmeticException ex) {
                // implicit transferToInterpreterAndInvalidate()
                Lock lock = getLock();
                lock.lock();
                try {
                    this.exclude_ = this.exclude_ | 0b1 /* add-excluded add(long, long) */;
                    this.state_ = this.state_ & 0xfffffffe /* remove-active add(long, long) */;
                } finally {
                    lock.unlock();
                }
                return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
            }
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeLong(frameValue);
        return;
    }

    private long executeAndSpecialize(Object leftNodeValue, Object rightNodeValue) {
        Lock lock = getLock();
        boolean hasLock = true;
        lock.lock();
        int state = state_;
        int exclude = exclude_;
        try {
            if ((exclude) == 0 /* is-not-excluded add(long, long) */ && leftNodeValue instanceof Long) {
                long leftNodeValue_ = (long) leftNodeValue;
                if (rightNodeValue instanceof Long) {
                    long rightNodeValue_ = (long) rightNodeValue;
                    this.state_ = state = state | 0b1 /* add-active add(long, long) */;
                    try {
                        lock.unlock();
                        hasLock = false;
                        return add(leftNodeValue_, rightNodeValue_);
                    } catch (ArithmeticException ex) {
                        // implicit transferToInterpreterAndInvalidate()
                        lock.lock();
                        try {
                            this.exclude_ = this.exclude_ | 0b1 /* add-excluded add(long, long) */;
                            this.state_ = this.state_ & 0xfffffffe /* remove-active add(long, long) */;
                        } finally {
                            lock.unlock();
                        }
                        return executeAndSpecialize(leftNodeValue_, rightNodeValue_);
                    }
                }
            }
            throw new UnsupportedSpecializationException(this, new Node[] {this.leftNode_, this.rightNode_}, leftNodeValue, rightNodeValue);
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

    public static TLLAddNode create(TLLExpressionNode leftNode, TLLExpressionNode rightNode) {
        return new TLLAddNodeGen(leftNode, rightNode);
    }

}
