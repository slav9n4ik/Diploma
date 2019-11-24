package ru.sbt.diploma.nodes;

import com.oracle.truffle.api.frame.VirtualFrame;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

@Log4j
public class TLLUndefinedFunctionRootNode extends TLLRootNode {
    public TLLUndefinedFunctionRootNode(TLLLanguage language, String name) {
        super(language, null, null, null, name);
    }

    @Override
    public Object execute(VirtualFrame frame) {
        log.info("Throw Exception");
        throw TLLUndefinedNameException.undefinedFunction(null, getName());
    }
}
