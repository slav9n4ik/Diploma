package ru.diploma.runtime;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.nodes.Node;

public class TVDUndefinedNameException extends TVDException {
    private static final long serialVersionUID = 1L;

    @CompilerDirectives.TruffleBoundary
    public static TVDUndefinedNameException undefinedFunction(Node location, Object name) {
        throw new TVDUndefinedNameException("Undefined function: " + name, location);
    }

    @CompilerDirectives.TruffleBoundary
    public static TVDUndefinedNameException undefinedProperty(Node location, Object name) {
        throw new TVDUndefinedNameException("Undefined property: " + name, location);
    }

    private TVDUndefinedNameException(String message, Node node) {
        super(message, node);
    }
}
