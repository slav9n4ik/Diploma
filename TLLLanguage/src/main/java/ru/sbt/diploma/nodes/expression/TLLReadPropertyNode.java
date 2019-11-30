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
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.util.TLLToMemberNode;
import ru.sbt.diploma.runtime.TLLUndefinedNameException;

/**
 * The node for reading a property of an object. When executed, this node:
 * <ol>
 * <li>evaluates the object expression on the left hand side of the object access operator</li>
 * <li>evaluated the property name</li>
 * <li>reads the named property</li>
 * </ol>
 */
@NodeInfo(shortName = ".")
@NodeChild("receiverNode")
@NodeChild("nameNode")
public abstract class TLLReadPropertyNode extends TLLExpressionNode {
    static final int LIBRARY_LIMIT = 3;

    @Specialization(guards = "arrays.hasArrayElements(receiver)", limit = "LIBRARY_LIMIT")
    protected Object readArray(Object receiver, Object index,
                                @CachedLibrary("receiver") InteropLibrary arrays,
                                @CachedLibrary("index") InteropLibrary numbers) {
        try {
            return arrays.readArrayElement(receiver, numbers.asLong(index));
        } catch (UnsupportedMessageException | InvalidArrayIndexException e) {
            // read was not successful. In SL we only have basic support for errors.
            throw TLLUndefinedNameException.undefinedProperty(this, index);
        }
    }

    @Specialization(guards = "objects.hasMembers(receiver)", limit = "LIBRARY_LIMIT")
    protected Object readObject(Object receiver, Object name,
                                 @CachedLibrary("receiver") InteropLibrary objects,
                                 @Cached TLLToMemberNode asMember) {
        try {
            return objects.readMember(receiver, asMember.execute(name));
        } catch (UnsupportedMessageException | UnknownIdentifierException e) {
            // read was not successful. In SL we only have basic support for errors.
            throw TLLUndefinedNameException.undefinedProperty(this, name);
        }
    }
}
