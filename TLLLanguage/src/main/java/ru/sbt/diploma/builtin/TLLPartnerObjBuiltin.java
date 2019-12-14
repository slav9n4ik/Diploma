package ru.sbt.diploma.builtin;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.instrumentation.AllocationReporter;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.profiles.BranchProfile;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLContext;
import ru.sbt.diploma.runtime.TLLNull;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

/**
 * Built-in function to create a new object Partner Object
 */
@NodeInfo(shortName = "Partner")
@Log4j
public abstract class TLLPartnerObjBuiltin extends TLLBuiltinNode {

    @Specialization
    @SuppressWarnings("unused")
    public Object newPartnerObject(TLLNull o, @CachedContext(TLLLanguage.class) TLLContext context,
                            @Cached("context.getAllocationReporter()") AllocationReporter reporter) {
        //TODO проверь это @SuppressWarnings("unused")
        log.info("NewPartnerObject invoke");
        return context.createPartnerObject(reporter);
    }
}
