package ru.diploma.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.nodes.Node;

public class TLLUndefinedNameException extends TLLException {
    private static final long serialVersionUID = 1L;

    @CompilerDirectives.TruffleBoundary
    public static TLLUndefinedNameException undefinedFunction(Node location, Object name) {
        throw new TLLUndefinedNameException("Undefined function: " + name, location);
    }

    @CompilerDirectives.TruffleBoundary
    public static TLLUndefinedNameException undefinedProperty(Node location, Object name) {
        throw new TLLUndefinedNameException("Undefined property: " + name, location);
    }

    private TLLUndefinedNameException(String message, Node node) {
        super(message, node);
    }
}
