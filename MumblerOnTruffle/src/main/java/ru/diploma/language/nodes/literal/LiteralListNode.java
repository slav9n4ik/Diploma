package ru.diploma.language.nodes.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import ru.diploma.language.nodes.MumblerNode;
import ru.diploma.language.types.MumblerList;

public class LiteralListNode extends MumblerNode {
    public final MumblerList<?> list;

    public LiteralListNode(MumblerList<?> list) {
        this.list = list;
    }

    @Override
    public MumblerList<?> executeMumblerList(VirtualFrame virtualFrame) {
        return this.list;
    }

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        return this.list;
    }

    @Override
    public String toString() {
        return this.list.toString();
    }
}