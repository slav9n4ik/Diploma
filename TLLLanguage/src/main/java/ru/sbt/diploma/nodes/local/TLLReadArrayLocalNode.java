package ru.sbt.diploma.nodes.local;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.VirtualFrame;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.BufferArray;
import ru.sbt.diploma.nodes.TLLExpressionNode;

@NodeChild("index")
@NodeField(name = "slot", type = FrameSlot.class)
@Log4j
public abstract class TLLReadArrayLocalNode extends TLLExpressionNode {
    /**
     * Returns the descriptor of the accessed local variable. The implementation of this method is
     * created by the Truffle DSL based on the {@link NodeField} annotation on the class.
     */
    protected abstract FrameSlot getSlot();

    @Specialization(guards = "isObject(frame)")
    protected long readLong(VirtualFrame frame, long index) {
        log.info("readLong in Read Local Array Node");
        /*
         * The FrameSlotKind has been set to Object, so from now on all writes to the local
         * variable will be Object writes. However, now we are in a frame that still has an old
         * non-Object value. This is a slow-path operation: we read the non-Object value, and
         * write it immediately as an Object value so that we do not hit this path again
         * multiple times for the same variable of the same frame.
         */
        CompilerDirectives.transferToInterpreter();
        BufferArray bufferArray = (BufferArray) frame.getValue(getSlot());
        long result = (Long) bufferArray.buffer.get((int) index);
        frame.setObject(getSlot(), bufferArray);
        return result;
    }

    protected boolean isObject(VirtualFrame frame) {
        return frame.getFrameDescriptor().getFrameSlotKind(getSlot()) == FrameSlotKind.Object;
    }
}
