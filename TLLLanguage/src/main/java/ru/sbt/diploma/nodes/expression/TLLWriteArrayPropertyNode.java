package ru.sbt.diploma.nodes.expression;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.*;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.BufferArray;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.util.TLLToMemberNode;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

import java.util.List;

@Log4j
@NodeInfo(shortName = ".[]=")
@NodeChild("receiverNode")
@NodeChild("nameNode")
@NodeChild("valueNode")
@NodeChild("index")
public abstract class TLLWriteArrayPropertyNode extends TLLExpressionNode {

    static final int LIBRARY_LIMIT = 3;

    @Specialization(limit = "LIBRARY_LIMIT")
    protected Object write(Object receiver, Object name, Object value, long index,
                           @CachedLibrary("receiver") InteropLibrary objectLibrary,
                           @Cached TLLToMemberNode asMember) {
        try {
            BufferArray list = null;
            if (!objectLibrary.isMemberReadable(receiver, asMember.execute(name))) {
                list = new BufferArray();
            } else {
                list = (BufferArray) objectLibrary.readMember(receiver, asMember.execute(name));
            }
            list.buffer.add((int) index - 1, value);
            String execute = asMember.execute(name);
            log.info("writeObject in Write Property Array Node");
            objectLibrary.writeMember(receiver, execute, list);
        } catch (UnsupportedMessageException | UnknownIdentifierException | UnsupportedTypeException e) {
            // write was not successful. In SL we only have basic support for errors.
            throw TLLUndefinedNameException.undefinedProperty(this, name);
        }
        return value;
    }
}
