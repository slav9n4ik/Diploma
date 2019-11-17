package ru.diploma.nodes.controlflow;

import com.oracle.truffle.api.nodes.ControlFlowException;

/**
 * Exception thrown by the {@link TVDReturnNode return statement} and caught by the
 * {@link TVDFunctionBodyNode function body}. The exception transports the return value in its
 * {@link #result} field.
 */
public final class TVDReturnException extends ControlFlowException {

    private static final long serialVersionUID = 4073191346281369231L;

    private final Object result;

    public TVDReturnException(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
