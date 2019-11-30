package ru.sbt.diploma.nodes.local;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.frame.FrameSlotTypeException;
import com.oracle.truffle.api.frame.VirtualFrame;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.BufferArray;
import ru.sbt.diploma.nodes.TLLExpressionNode;

@NodeChild("index")
@NodeChild("valueNode")
@NodeField(name = "slot", type = FrameSlot.class)
@Log4j
public abstract class TLLWriteArrayLocalNode extends TLLExpressionNode {

    /**
     * Returns the descriptor of the accessed local variable. The implementation of this method is
     * created by the Truffle DSL based on the {@link NodeField} annotation on the class.
     */
    protected abstract FrameSlot getSlot();

    @Specialization(guards = "isBufferObjectOrIllegal(frame)")
    protected long writeLongByIndex(VirtualFrame frame, long index, long value) {
        log.info("writeLong in Write Local Array Node");
        /* Initialize type on first write of the local variable. No-op if kind is already Long. */
        final FrameSlotKind kind = frame.getFrameDescriptor().getFrameSlotKind(getSlot());
        BufferArray bufferArray = null;
        if (kind == FrameSlotKind.Illegal) {
            bufferArray = createBufferArray(value);
        } else {
            try {
                bufferArray = (BufferArray) frame.getObject(getSlot());
                if (bufferArray == null) {
                    bufferArray = createBufferArray(value);
                } else {
                    bufferArray.buffer.add((int) index - 1, value);
                }
            } catch (FrameSlotTypeException e) {
                e.printStackTrace();
            }
        }
        frame.getFrameDescriptor().setFrameSlotKind(getSlot(), FrameSlotKind.Object);
        frame.setObject(getSlot(), bufferArray);
        return value;
    }

    private BufferArray createBufferArray(long value) {
        BufferArray bufferArray;
        bufferArray = new BufferArray();
        bufferArray.buffer.add(value);
        return bufferArray;
    }

    protected boolean isBufferObjectOrIllegal(VirtualFrame frame) {
        final FrameSlotKind kind = frame.getFrameDescriptor().getFrameSlotKind(getSlot());
        return kind == FrameSlotKind.Object || kind == FrameSlotKind.Illegal;
    }
}
