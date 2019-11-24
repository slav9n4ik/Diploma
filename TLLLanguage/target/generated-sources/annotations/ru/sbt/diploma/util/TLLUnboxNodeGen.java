// CheckStyle: start generated
package ru.sbt.diploma.util;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.CompilationFinal;
import com.oracle.truffle.api.dsl.GeneratedBy;
import com.oracle.truffle.api.dsl.UnsupportedSpecializationException;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeCost;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import ru.sbt.diploma.nodes.TLLExpressionNode;

@GeneratedBy(TLLUnboxNode.class)
public final class TLLUnboxNodeGen extends TLLUnboxNode {

    @Child private TLLExpressionNode child0_;
    @CompilationFinal private int state_;

    private TLLUnboxNodeGen(TLLExpressionNode child0) {
        this.child0_ = child0;
    }

    @Override
    public Object executeGeneric(VirtualFrame frameValue) {
        int state = state_;
        long child0Value_;
        try {
            child0Value_ = this.child0_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        if (state != 0 /* is-active fromLong(long) */) {
            return fromLong(child0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(child0Value_);
    }

    @Override
    public long executeLong(VirtualFrame frameValue) {
        int state = state_;
        long child0Value_;
        try {
            child0Value_ = this.child0_.executeLong(frameValue);
        } catch (UnexpectedResultException ex) {
            return executeAndSpecialize(ex.getResult());
        }
        if (state != 0 /* is-active fromLong(long) */) {
            return fromLong(child0Value_);
        }
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(child0Value_);
    }

    @Override
    public void executeVoid(VirtualFrame frameValue) {
        executeLong(frameValue);
        return;
    }

    private long executeAndSpecialize(Object child0Value) {
        int state = state_;
        if (child0Value instanceof Long) {
            long child0Value_ = (long) child0Value;
            this.state_ = state = state | 0b1 /* add-active fromLong(long) */;
            return fromLong(child0Value_);
        }
        throw new UnsupportedSpecializationException(this, new Node[] {this.child0_}, child0Value);
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

    public static TLLUnboxNode create(TLLExpressionNode child0) {
        return new TLLUnboxNodeGen(child0);
    }

}
