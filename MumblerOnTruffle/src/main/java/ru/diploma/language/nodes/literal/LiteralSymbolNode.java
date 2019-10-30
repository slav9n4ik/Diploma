package ru.diploma.language.nodes.literal;

import com.oracle.truffle.api.frame.VirtualFrame;
import ru.diploma.language.nodes.MumblerNode;
import ru.diploma.language.types.MumblerSymbol;

public class LiteralSymbolNode extends MumblerNode {

    public final MumblerSymbol symbol;

    public LiteralSymbolNode(MumblerSymbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public MumblerSymbol executeMumblerSymbol(VirtualFrame virtualFrame) {
        return this.symbol;
    }

    @Override
    public Object execute(VirtualFrame virtualFrame) {
        return this.symbol;
    }

    @Override
    public String toString() {
        return this.symbol.toString();
    }
}
