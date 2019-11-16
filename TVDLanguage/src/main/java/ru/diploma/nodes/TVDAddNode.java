package ru.diploma.nodes;

import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

/**
 * TVD node that performs the "+" operation, which performs addition on arbitrary precision numbers,
 * as well as String concatenation if one of the operands is a String.
 * <p>
 * Type specialization on the input values is essential for the performance. This is achieved via
 * node rewriting: specialized subclasses handle just a single type, so that the generic node that
 * can handle all types is used only in cases where different types were encountered. The subclasses
 * are automatically generated by the Truffle DTVD. In addition, a {@link TVDAddNodeGen factory class}
 * is generated that provides, e.g., {@link TVDAddNodeGen#create node creation}.
 */
@NodeInfo(shortName = "+")
public abstract class TVDAddNode extends TVDBinaryNode {
    /**
     * Specialization for primitive {@code long} values. This is the fast path of the
     * arbitrary-precision arithmetic. We need to check for overflows of the addition, and switch to
     * the {@link #add(TVDBigNumber, TVDBigNumber) slow path}. Therefore, we use an
     * {@link Math#addExact(long, long) addition method that throws an exception on overflow}. The
     * {@code rewriteOn} attribute on the {@link Specialization} annotation automatically triggers
     * the node rewriting on the exception.
     * <p>
     * In compiled code, {@link Math#addExact(long, long) addExact} is compiled to efficient machine
     * code that uses the processor's overflow flag. Therefore, this method is compiled to only two
     * machine code instructions on the fast path.
     * <p>
     * This specialization is automatically selected by the Truffle DTVD if both the left and right
     * operand are {@code long} values.
     */
    @Specialization(rewriteOn = ArithmeticException.class)
    protected long add(long left, long right) {
        return Math.addExact(left, right);
    }
}
