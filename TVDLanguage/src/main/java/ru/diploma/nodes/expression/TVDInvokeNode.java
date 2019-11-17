package ru.diploma.nodes.expression;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.Node.*;
import com.oracle.truffle.api.nodes.NodeInfo;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.runtime.TVDUndefinedNameException;

/**
 * The node for function invocation in TVD. Since TVD has first class functions, the {@link TVDFunction
 * target function} can be computed by an arbitrary expression. This node is responsible for
 * evaluating this expression, as well as evaluating the {@link #argumentNodes arguments}. The
 * actual dispatch is then delegated to a chain of {@link TVDDispatchNode} that form a polymorphic
 * inline cache.
 */
@NodeInfo(shortName = "invoke")
public final class TVDInvokeNode extends TVDExpressionNode {

    @Child
    private TVDExpressionNode functionNode;
    @Children
    private final TVDExpressionNode[] argumentNodes;
    @Child
    private InteropLibrary library;

    public TVDInvokeNode(TVDExpressionNode functionNode, TVDExpressionNode[] argumentNodes) {
        this.functionNode = functionNode;
        this.argumentNodes = argumentNodes;
        this.library = InteropLibrary.getFactory().createDispatched(3);
    }

    @ExplodeLoop
    @Override
    public Object executeGeneric(VirtualFrame frame) {
        Object function = functionNode.executeGeneric(frame);

        /*
         * The number of arguments is constant for one invoke node. During compilation, the loop is
         * unrolled and the execute methods of all arguments are inlined. This is triggered by the
         * ExplodeLoop annotation on the method. The compiler assertion below illustrates that the
         * array length is really constant.
         */
        CompilerAsserts.compilationConstant(argumentNodes.length);

        Object[] argumentValues = new Object[argumentNodes.length];
        for (int i = 0; i < argumentNodes.length; i++) {
            argumentValues[i] = argumentNodes[i].executeGeneric(frame);
        }

        try {
            return library.execute(function, argumentValues);
        } catch (ArityException | UnsupportedTypeException | UnsupportedMessageException e) {
            /* Execute was not successful. */
            throw TVDUndefinedNameException.undefinedFunction(this, function);
        }
    }

    @Override
    public boolean hasTag(Class<? extends Tag> tag) {
        if (tag == StandardTags.CallTag.class) {
            return true;
        }
        return super.hasTag(tag);
    }

}

