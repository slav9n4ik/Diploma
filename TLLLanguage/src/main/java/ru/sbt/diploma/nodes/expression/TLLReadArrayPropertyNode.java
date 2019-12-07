package ru.sbt.diploma.nodes.expression;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.InvalidArrayIndexException;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.BufferArray;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.util.TLLToMemberNode;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

@Log4j
@NodeInfo(shortName = ".[]")
@NodeChild("receiverNode")
@NodeChild("nameNode")
@NodeChild("index")
public abstract class TLLReadArrayPropertyNode extends TLLExpressionNode {

    static final int LIBRARY_LIMIT = 3;

    @Specialization(guards = "objects.hasMembers(receiver)", limit = "LIBRARY_LIMIT")
    protected Object readLong(Object receiver, Object name, long index,
                                @CachedLibrary("receiver") InteropLibrary objects,
                                @Cached TLLToMemberNode asMember) {
        try {
            BufferArray list = (BufferArray) objects.readMember(receiver, asMember.execute(name));
            log.info("writeObject in Read Property Array Node");
            return list.buffer.get((int) index - 1);
        } catch (UnsupportedMessageException | UnknownIdentifierException e) {
            // read was not successful. In SL we only have basic support for errors.
            throw TLLUndefinedNameException.undefinedProperty(this, name);
        }
    }

//    @Specialization(guards = "arrays.hasArrayElements(receiver)", limit = "LIBRARY_LIMIT")
//    protected Object readArray(Object receiver, Object index,
//                               @CachedLibrary("receiver") InteropLibrary arrays,
//                               @CachedLibrary("index") InteropLibrary numbers) {
//        try {
//            return arrays.readArrayElement(receiver, numbers.asLong(index));
//        } catch (UnsupportedMessageException | InvalidArrayIndexException e) {
//            // read was not successful. In SL we only have basic support for errors.
//            throw TLLUndefinedNameException.undefinedProperty(this, index);
//        }
//    }
}
