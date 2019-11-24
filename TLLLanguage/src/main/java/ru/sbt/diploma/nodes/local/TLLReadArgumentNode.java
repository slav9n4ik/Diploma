package ru.sbt.diploma.nodes.local;

import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.profiles.BranchProfile;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.parser.TLLNodeFactory;
import ru.sbt.diploma.runtime.TLLNull;

/**
 * Reads a function argument. Arguments are passed in as an object array.
 * <p>
 * Arguments are not type-specialized. To ensure that repeated accesses within a method are
 * specialized and can, e.g., be accessed without unboxing, all arguments are loaded into local
 * variables {@link TLLNodeFactory#addFormalParameter in the method prologue}.
 */
@Log4j
public class TLLReadArgumentNode extends TLLExpressionNode {

    /** The argument number, i.e., the index into the array of arguments. */
    private final int index;

    /**
     * Profiling information, collected by the interpreter, capturing whether the function was
     * called with fewer actual arguments than formal arguments.
     */
    private final BranchProfile outOfBoundsTaken = BranchProfile.create();

    public TLLReadArgumentNode(int index) {
        this.index = index;
    }

    @Override
    public Object executeGeneric(VirtualFrame frame) {
        log.info("Execute Generic Read Args Node");
        Object[] args = frame.getArguments();
        if (index < args.length) {
            return args[index];
        } else {
            /* In the interpreter, record profiling information that the branch was used. */
            outOfBoundsTaken.enter();
            /* Use the default null value. */
            return TLLNull.SINGLETON;
        }
    }
}
