package ru.diploma.builtin;

import com.oracle.truffle.api.ExactMath;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

import java.math.BigInteger;

@NodeInfo(shortName = "+")
@GenerateNodeFactory
public abstract class AddBuiltinNode extends BuiltinNode {
    @Specialization(rewriteOn = ArithmeticException.class)
    public long add(long value0, long value1) {
        return value0 + value1;
    }

    @Specialization
    protected BigInteger add(BigInteger value0, BigInteger value1) {
        return value0.add(value1);
    }
}
