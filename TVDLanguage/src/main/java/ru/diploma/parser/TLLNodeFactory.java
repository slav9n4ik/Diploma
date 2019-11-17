package ru.diploma.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import org.antlr.v4.runtime.Token;
import ru.diploma.TLLLanguage;
import ru.diploma.nodes.TLLExpressionNode;
import ru.diploma.nodes.TLLStatementNode;
import ru.diploma.nodes.expression.TLLAddNodeGen;
import ru.diploma.nodes.TLLRootNode;
import ru.diploma.nodes.controlflow.TLLBlockNode;
import ru.diploma.nodes.controlflow.TLLFunctionBodyNode;
import ru.diploma.nodes.controlflow.TLLReturnNode;
import ru.diploma.nodes.expression.TLLInvokeNode;
import ru.diploma.nodes.literal.TLLFunctionLiteralNode;
import ru.diploma.nodes.literal.TLLLongLiteralNode;
import ru.diploma.nodes.literal.TLLStringLiteralNode;
import ru.diploma.util.TLLUnboxNodeGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TLLNodeFactory {

    /**
     * Local variable names that are visible in the current block. Variables are not visible outside
     * of their defining block, to prevent the usage of undefined variables. Because of that, we can
     * decide during parsing if a name references a local variable or is a function name.
     */
    static class LexicalScope {


        protected final LexicalScope outer;
        protected final Map<String, FrameSlot> locals;
        LexicalScope(LexicalScope outer) {
            this.outer = outer;
            this.locals = new HashMap<>();
            if (outer != null) {
                locals.putAll(outer.locals);
            }
        }

    }

    /* State while parsing a source unit. */

    private final Map<String, RootCallTarget> allBlocks;
    private final Source source;
    //private final Map<String, RootCallTarget> allFunctions;
    private TLLExpressionNode[] nodes;

    /* State while parsing a block. */
    private final TLLLanguage language;
    private int blockStartPos;
    private String blockName;
    private FrameDescriptor frameDescriptor;
    private int blockBodyStartPos;
    private ArrayList<Object> blockNodes;

    private LexicalScope lexicalScope;

    public TLLNodeFactory(TLLLanguage language, Source source) {
        this.language = language;
        this.source = source;
        this.allBlocks = new HashMap<>();
    }

    public void startBlock(Token nameToken, Token blockStartToken) {
        System.out.println("******* Start Block *******");
        blockStartPos = nameToken.getStartIndex();
        blockName = nameToken.getText();
        blockBodyStartPos = blockStartToken.getStartIndex();
        frameDescriptor = new FrameDescriptor();
        blockNodes = new ArrayList<>();
        lexicalScope = new LexicalScope(lexicalScope);
    }

    public void finishBlock(List<TLLStatementNode> blockNodes, int startPos, int length) {
        System.out.println("******* Finish Block *******");
        lexicalScope = lexicalScope.outer;

        List<TLLStatementNode> flattenedNodes = new ArrayList<>(blockNodes.size());
        flattenBlocks(blockNodes, flattenedNodes);
        for (TLLStatementNode statement : flattenedNodes) {
            if (statement.hasSource()) {
                statement.addStatementTag();
            }
        }
        TLLBlockNode blockNode = new TLLBlockNode(flattenedNodes.toArray(new TLLStatementNode[flattenedNodes.size()]));
        blockNode.setSourceSection(startPos, length);

        if (blockNode == null) {
            // a state update that would otherwise be performed by finishBlock
            lexicalScope = lexicalScope.outer;
        } else {
            blockNodes.add(blockNode);
            final int bodyEndPos = blockNode.getSourceEndIndex();
            final SourceSection blockSrc = source.createSection(blockStartPos, bodyEndPos - blockStartPos);
            assert lexicalScope == null : "Wrong scoping of blocks in parser";

            //TODO убрать TLLFunctionBodyNode и переделать TLLBlock
            final TLLFunctionBodyNode functionBodyNode = new TLLFunctionBodyNode(blockNode);
            functionBodyNode.setSourceSection(blockSrc.getCharIndex(), blockSrc.getCharLength());
            
            final TLLRootNode rootNode = new TLLRootNode(language, frameDescriptor, functionBodyNode, blockSrc, blockName);
            allBlocks.put(blockName, Truffle.getRuntime().createCallTarget(rootNode));
        }

        blockStartPos = 0;
        blockName = null;
        blockBodyStartPos = 0;
        //parameterCount = 0;
        frameDescriptor = null;
        lexicalScope = null;
    }

    public TLLExpressionNode createBinary(Token opToken, TLLExpressionNode leftNode, TLLExpressionNode rightNode) {
        System.out.println("******* CreateBinary Function *******");
        if (leftNode == null || rightNode == null) {
            return null;
        }
        final TLLExpressionNode leftUnboxed = TLLUnboxNodeGen.create(leftNode);
        final TLLExpressionNode rightUnboxed = TLLUnboxNodeGen.create(rightNode);

        final TLLExpressionNode result;
        switch (opToken.getText()) {
            case "+":
                System.out.println("CreateBinary Function Plus Operation");
                result = TLLAddNodeGen.create(leftUnboxed, rightUnboxed);
                break;
            default:
                throw new RuntimeException("unexpected operation: " + opToken.getText());
        }
        int start = leftNode.getSourceCharIndex();
        int length = rightNode.getSourceEndIndex() - start;
        result.setSourceSection(start, length);
        result.addExpressionTag();

        return result;
    }

    public TLLExpressionNode createNumericLiteral(Token literalToken) {
        TLLExpressionNode result = new TLLLongLiteralNode(Long.parseLong(literalToken.getText()));
        //TODO
//        try {
//            /* Try if the literal is small enough to fit into a long value. */
//            result = new TLLLongLiteralNode(Long.parseLong(literalToken.getText()));
//        } catch (NumberFormatException ex) {
//            /* Overflow of long value, so fall back to BigInteger. */
//            //result = new TLLBigIntegerLiteralNode(new BigInteger(literalToken.getText()));
//        }
        srcFromToken(result, literalToken);
        result.addExpressionTag();

        return result;
    }

    /**
     * Returns an {@link TLLReturnNode} for the given parameters.
     *
     * @param t The token containing the return node's info
     * @param valueNode The value of the return (null if not returning a value)
     * @return An TLLReturnNode for the given parameters.
     */
    public TLLStatementNode createReturn(Token t, TLLExpressionNode valueNode) {
        final int start = t.getStartIndex();
        final int length = valueNode == null ? t.getText().length() : valueNode.getSourceEndIndex() - start;
        final TLLReturnNode returnNode = new TLLReturnNode(valueNode);
        returnNode.setSourceSection(start, length);
        return returnNode;
    }

    /**
     * Returns a {@link TLLReadLocalVariableNode} if this read is a local variable or a
     * {@link TLLFunctionLiteralNode} if this read is global. In TLL, the only global names are
     * functions.
     *
     * @param nameNode The name of the variable/function being read
     * @return either:
     *         <ul>
     *         <li>A TLLReadLocalVariableNode representing the local variable being read.</li>
     *         <li>A TLLFunctionLiteralNode representing the function definition.</li>
     *         <li>null if nameNode is null.</li>
     *         </ul>
     */
    public TLLExpressionNode createRead(TLLExpressionNode nameNode) {
        if (nameNode == null) {
            return null;
        }

        String name = ((TLLStringLiteralNode) nameNode).executeGeneric(null);
        final TLLExpressionNode result = new TLLFunctionLiteralNode(language, name);
        final FrameSlot frameSlot = lexicalScope.locals.get(name);
//        if (frameSlot != null) {
//            /* Read of a local variable. */
//            //TODO
//            //result = TLLReadLocalVariableNodeGen.create(frameSlot);
//        } else {
//            /* Read of a global name. In our language, the only global names are functions. */
//            result = new TLLFunctionLiteralNode(language, name);
//        }
        result.setSourceSection(nameNode.getSourceCharIndex(), nameNode.getSourceLength());
        result.addExpressionTag();
        return result;
    }

    /**
     * Returns an {@link TLLInvokeNode} for the given parameters.
     *
     * @param parameterNodes The parameters of the function call
     * @param finalToken A token used to determine the end of the sourceSelection for this call
     * @return An TLLInvokeNode for the given parameters. null if functionNode or any of the
     *         parameterNodes are null.
     */
    public TLLExpressionNode createCall(TLLExpressionNode functionNode, List<TLLExpressionNode> parameterNodes, Token finalToken) {
        if (functionNode == null || containsNull(parameterNodes)) {
            return null;
        }

        final TLLExpressionNode result = new TLLInvokeNode(functionNode, parameterNodes.toArray(new TLLExpressionNode[parameterNodes.size()]));

        final int startPos = functionNode.getSourceCharIndex();
        final int endPos = finalToken.getStartIndex() + finalToken.getText().length();
        result.setSourceSection(startPos, endPos - startPos);
        result.addExpressionTag();

        return result;
    }

    public TLLExpressionNode createStringLiteral(Token literalToken, boolean removeQuotes) {
        /* Remove the trailing and ending " */
        String literal = literalToken.getText();
        if (removeQuotes) {
            assert literal.length() >= 2 && literal.startsWith("\"") && literal.endsWith("\"");
            literal = literal.substring(1, literal.length() - 1);
        }

        final TLLStringLiteralNode result = new TLLStringLiteralNode(literal.intern());
        srcFromToken(result, literalToken);
        result.addExpressionTag();
        return result;
    }

    public Map<String, RootCallTarget> getAllBlocks() {
        return allBlocks;
    }

    //To check parser
    public void showOperation(Token bodyStartToken) {
        System.out.println("Node Factory showOperation: " + bodyStartToken.getText());
    }

    //To check parser
    public void showNumber(Token bodyStartToken) {
        System.out.println("Node Factory showNumber: " + bodyStartToken.getText());
    }

    /**
     * Checks whether a list contains a null.
     */
    private static boolean containsNull(List<?> list) {
        for (Object e : list) {
            if (e == null) {
                return true;
            }
        }
        return false;
    }

    private void flattenBlocks(Iterable<? extends TLLStatementNode> bodyNodes, List<TLLStatementNode> flattenedNodes) {
        for (TLLStatementNode n : bodyNodes) {
            if (n instanceof TLLBlockNode) {
                flattenBlocks(((TLLBlockNode) n).getStatements(), flattenedNodes);
            } else {
                flattenedNodes.add(n);
            }
        }
    }

    /**
     * Creates source description of a single token.
     */
    private static void srcFromToken(TLLStatementNode node, Token token) {
        node.setSourceSection(token.getStartIndex(), token.getText().length());
    }
}
