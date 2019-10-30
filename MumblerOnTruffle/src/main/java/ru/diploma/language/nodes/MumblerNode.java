package ru.diploma.language.nodes;

import com.oracle.truffle.api.dsl.TypeSystemReference;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.UnexpectedResultException;
import ru.diploma.language.types.MumblerFunction;
import ru.diploma.language.types.MumblerList;
import ru.diploma.language.types.MumblerSymbol;
import ru.diploma.language.types.MumblerTypes;

@TypeSystemReference(MumblerTypes.class)
@NodeInfo(language = "Mumbler Language", description = "The abstract base node for all expressions")
public abstract class MumblerNode extends Node {
    public abstract Object execute(VirtualFrame virtualFrame);

    public long executeLong(VirtualFrame virtualFrame)
            throws UnexpectedResultException {
        return MumblerTypesGen.MUMBLERTYPES.expectLong(
                this.execute(virtualFrame));
    }

    public boolean executeBoolean(VirtualFrame virtualFrame)
            throws UnexpectedResultException {
        return MumblerTypesGen.MUMBLERTYPES.expectBoolean(
                this.execute(virtualFrame));
    }

    public MumblerSymbol executeMumblerSymbol(VirtualFrame virtualFrame)
            throws UnexpectedResultException {
        return MumblerTypesGen.MUMBLERTYPES.expectMumblerSymbol(
                this.execute(virtualFrame));
    }

    public MumblerFunction executeMumblerFunction(VirtualFrame virtualFrame)
            throws UnexpectedResultException {
        return MumblerTypesGen.MUMBLERTYPES.expectMumblerFunction(
                this.execute(virtualFrame));
    }

    public MumblerList<?> executeMumblerList(VirtualFrame virtualFrame)
            throws UnexpectedResultException {
        return MumblerTypesGen.MUMBLERTYPES.expectMumblerList(
                this.execute(virtualFrame));
    }
}
