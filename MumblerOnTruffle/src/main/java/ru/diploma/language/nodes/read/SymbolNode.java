package ru.diploma.language.nodes.read;

import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.VirtualFrame;
import ru.diploma.language.nodes.MumblerNode;

public class SymbolNode extends MumblerNode {

    private final FrameSlot slot;

    public SymbolNode(FrameSlot slot) {
        this.slot = slot;
    }

    public Object execute(VirtualFrame virtualFrame) {
        Frame frame = virtualFrame;
        Object value = frame.getValue(this.slot);
        while (value == null) {
            frame = this.getLexicalScope(frame);
            if (frame == null) {
                throw new RuntimeException("Unknown variable: " +
                        this.slot.getIdentifier());
            }
            value = frame.getValue(this.slot);
        }
        return value;
    }

    private Frame getLexicalScope(Frame frame) {
        return (Frame) frame.getArguments()[0];
    }
}
