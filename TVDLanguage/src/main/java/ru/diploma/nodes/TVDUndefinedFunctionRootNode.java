package ru.diploma.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;
import ru.diploma.TVDLanguage;
import ru.diploma.runtime.TVDUndefinedNameException;

public class TVDUndefinedFunctionRootNode extends TVDRootNode {
    public TVDUndefinedFunctionRootNode(TVDLanguage language, String name) {
        super(language, null, null, null, name);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        throw TVDUndefinedNameException.undefinedFunction(null, getName());
    }
}
