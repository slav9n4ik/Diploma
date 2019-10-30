package ru.diploma.language.nodes.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import ru.diploma.language.nodes.MumblerNode;

public class BooleanNode extends MumblerNode {
    public final boolean value;

    public BooleanNode(Boolean bool) {
        this.value = bool;
    }

    @Override
    public boolean executeBoolean(VirtualFrame virtualFrame) {
        return this.value;
    }

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        return this.value;
    }

    @Override
    public String toString() {
        if (this.value) {
            return "#t";
        } else {
            return "#f";
        }
    }
}

