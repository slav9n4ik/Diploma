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
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.runtime.TLLContext;
import ru.sbt.diploma.runtime.TLLNull;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

/**
 * Built-in function to create a new object Partner Object
 */
@NodeInfo(shortName = "Partner")
public abstract class TLLPartnerObjBuildin extends TLLBuiltinNode {

    @Specialization
    @SuppressWarnings("unused")
    public Object newPartnerObject(TLLNull partnerObjNull, @CachedContext(TLLLanguage.class) TLLContext context,
                            @Cached("context.getAllocationReporter()") AllocationReporter reporter) {
        //TODO проверь это @SuppressWarnings("unused")
        return context.createObject(reporter);
    }

    @Specialization(guards = "!values.isNull(obj)", limit = "3")
    public Object newPartnerObject(Object obj, @CachedLibrary("obj") InteropLibrary values) {
        try {
            return values.instantiate(obj);
        } catch (UnsupportedTypeException | ArityException | UnsupportedMessageException e) {
            /* Foreign access was not successful. */
            throw TLLUndefinedNameException.undefinedFunction(this, obj);
        }
    }
}
