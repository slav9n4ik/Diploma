package ru.sbt.diploma.nodes.controlflow;

import com.oracle.truffle.api.nodes.ControlFlowException;
import lombok.extern.log4j.Log4j;

/**
 * Exception thrown by the {@link TLLReturnNode return statement} and caught by the
 * {@link TLLFunctionBodyNode function body}. The exception transports the return value in its
 * {@link #result} field.
 */
@Log4j
public final class TLLReturnException extends ControlFlowException {

    private static final long serialVersionUID = 4073191346281369231L;

    private final Object result;

    public TLLReturnException(Object result) {
        this.result = result;
    }

    public Object getResult() {
        log.info("Get Result Return Exception");
        return result;
    }
}
