package ru.sbt.diploma.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

public class TLLUndefinedFunctionRootNode extends TLLRootNode {
    public TLLUndefinedFunctionRootNode(TLLLanguage language, String name) {
        super(language, null, null, null, name);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw TLLUndefinedNameException.undefinedFunction(null, getName());
    }
}
