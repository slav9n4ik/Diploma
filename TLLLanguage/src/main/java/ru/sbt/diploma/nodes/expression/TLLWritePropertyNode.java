package ru.sbt.diploma.nodes.expression;

import com.oracle.truffle.api.dsl.Cached;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.interop.*;
import com.oracle.truffle.api.library.CachedLibrary;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.util.TLLToMemberNode;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

/**
 * The node for writing a property of an object. When executed, this node:
 * <ol>
 * <li>evaluates the object expression on the left hand side of the object access operator</li>
 * <li>evaluates the property name</li>
 * <li>evaluates the value expression on the right hand side of the assignment operator</li>
 * <li>writes the named property</li>
 * <li>returns the written value</li>
 * </ol>
 */
@NodeInfo(shortName = ".=")
@NodeChild("receiverNode")
@NodeChild("nameNode")
@NodeChild("valueNode")
public abstract class TLLWritePropertyNode extends TLLExpressionNode {
    static final int LIBRARY_LIMIT = 3;

    @Specialization(limit = "LIBRARY_LIMIT")
    protected Object write(Object receiver, Object name, Object value,
                           @CachedLibrary("receiver") InteropLibrary objectLibrary,
                           @Cached TLLToMemberNode asMember) {
        try {
            objectLibrary.writeMember(receiver, asMember.execute(name), value);
        } catch (UnsupportedMessageException | UnknownIdentifierException | UnsupportedTypeException e) {
            // write was not successful. In SL we only have basic support for errors.
            throw TLLUndefinedNameException.undefinedProperty(this, name);
        }
        return value;
    }
}
