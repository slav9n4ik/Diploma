package ru.sbt.diploma.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.frame.FrameSlotKind;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import lombok.extern.log4j.Log4j;
import org.antlr.v4.runtime.Token;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLStatementNode;
import ru.sbt.diploma.nodes.expression.*;
import ru.sbt.diploma.nodes.TLLRootNode;
import ru.sbt.diploma.nodes.controlflow.TLLBlockNode;
import ru.sbt.diploma.nodes.controlflow.TLLFunctionBodyNode;
import ru.sbt.diploma.nodes.controlflow.TLLReturnNode;
import ru.sbt.diploma.nodes.literal.TLLFunctionLiteralNode;
import ru.sbt.diploma.nodes.literal.TLLLongLiteralNode;
import ru.sbt.diploma.nodes.literal.TLLStringLiteralNode;
import ru.sbt.diploma.nodes.local.*;
import ru.sbt.diploma.util.TLLUnboxNodeGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j
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
    private int parameterCount;
    private int blockStartPos;
    private String blockName;
    private FrameDescriptor frameDescriptor;
    private List<TLLStatementNode> allNodes;

    private LexicalScope lexicalScope;

    public TLLNodeFactory(TLLLanguage language, Source source) {
        this.language = language;
        this.source = source;
        this.allBlocks = new HashMap<>();
    }

    public void startBlock(Token nameToken, Token blockStartToken) {
        log.info("Start Block name: " + nameToken.getText());
        blockStartPos = blockStartToken.getStartIndex();
        blockName = nameToken.getText();
        frameDescriptor = new FrameDescriptor();
        lexicalScope = new LexicalScope(lexicalScope);
        allNodes = new ArrayList<>();
    }

    public void finishBlock(List<TLLStatementNode> blockNodes, int startPos, int length) {
        log.info("Finish Block");
        TLLBlockNode blockNode = executeBlock(blockNodes, startPos, length);

        allNodes.add(blockNode);
        final int bodyEndPos = blockNode.getSourceEndIndex();
        final SourceSection blockSrc = source.createSection(blockStartPos, bodyEndPos - blockStartPos);
        final TLLStatementNode methodBlock = executeBlock(allNodes, blockStartPos, bodyEndPos - blockStartPos);
        lexicalScope = lexicalScope.outer;
        assert lexicalScope == null : "Wrong scoping of blocks in parser";

        //TODO убрать TLLFunctionBodyNode и переделать TLLBlock
        final TLLFunctionBodyNode functionBodyNode = new TLLFunctionBodyNode(methodBlock);
        functionBodyNode.setSourceSection(blockSrc.getCharIndex(), blockSrc.getCharLength());

        final TLLRootNode rootNode = new TLLRootNode(language, frameDescriptor, functionBodyNode, blockSrc, blockName);
        allBlocks.put(blockName, Truffle.getRuntime().createCallTarget(rootNode));

        blockStartPos = 0;
        blockName = null;
        frameDescriptor = null;
        lexicalScope = null;
        parameterCount = 0;
    }

    private TLLBlockNode executeBlock(List<TLLStatementNode> blockNodes, int startPos, int length) {

        if (containsNull(blockNodes)) {
            return null;
        }

        List<TLLStatementNode> flattenedNodes = new ArrayList<>(blockNodes.size());
        flattenBlocks(blockNodes, flattenedNodes);
        for (TLLStatementNode statement : flattenedNodes) {
            if (statement.hasSource()) {
                statement.addStatementTag();
            }
        }
        TLLBlockNode blockNode = new TLLBlockNode(flattenedNodes.toArray(new TLLStatementNode[flattenedNodes.size()]));
        blockNode.setSourceSection(startPos, length);
        return blockNode;
    }

    public TLLExpressionNode createBinary(Token opToken, TLLExpressionNode leftNode, TLLExpressionNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return null;
        }
        log.info("Create Binary Left: " + leftNode.toString() + " Right: "
                + rightNode.toString() + " Expression: " + opToken.getText());

        final TLLExpressionNode leftUnboxed = TLLUnboxNodeGen.create(leftNode);
        final TLLExpressionNode rightUnboxed = TLLUnboxNodeGen.create(rightNode);

        final TLLExpressionNode result;
        switch (opToken.getText()) {
            case "+":
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
        log.info("CreateNumericLiteral: " + literalToken.getText());
        TLLExpressionNode result = new TLLLongLiteralNode(Long.parseLong(literalToken.getText()));
        srcFromToken(result, literalToken);
        result.addExpressionTag();
        return result;
    }

    /**
     * Returns an {@link TLLReturnNode} for the given parameters.
     *
     * @param t         The token containing the return node's info
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
     * Returns an {@link TLLReadPropertyNode} for the given parameters.
     *
     * @param receiverNode The receiver of the property access
     * @param nameNode The name of the property being accessed
     * @return An SLExpressionNode for the given parameters. null if receiverNode or nameNode is
     *         null.
     */
    public TLLExpressionNode createReadProperty(TLLExpressionNode receiverNode, TLLExpressionNode nameNode) {
        if (receiverNode == null || nameNode == null) {
            return null;
        }

        final TLLExpressionNode result = TLLReadPropertyNodeGen.create(receiverNode, nameNode);

        final int startPos = receiverNode.getSourceCharIndex();
        final int endPos = nameNode.getSourceEndIndex();
        result.setSourceSection(startPos, endPos - startPos);
        result.addExpressionTag();

        log.info("createReadProperty: " + nameNode.toString());
        return result;
    }

    public TLLExpressionNode createReadArrayProperty(TLLExpressionNode receiverNode,
                                                     TLLExpressionNode nameNode,
                                                     Token literalToken) {
        if (receiverNode == null || nameNode == null || literalToken == null) {
            return null;
        }

        TLLExpressionNode index = new TLLLongLiteralNode(Long.parseLong(literalToken.getText()));
        final TLLExpressionNode result = TLLReadArrayPropertyNodeGen.create(receiverNode, nameNode, index);
        //final TLLExpressionNode result = TLLReadArrayPropertyNodeGen.create(receiverNode, index);

        final int startPos = receiverNode.getSourceCharIndex();
        final int endPos = nameNode.getSourceEndIndex();
        result.setSourceSection(startPos, endPos - startPos);
        result.addExpressionTag();

        log.info("createReadArrayProperty" + nameNode.toString() + " index: " + index);
        return result;
    }

    /**
     * Returns an {@link TLLWritePropertyNode} for the given parameters.
     *
     * @param receiverNode The receiver object of the property assignment
     * @param nameNode The name of the property being assigned
     * @param valueNode The value to be assigned
     * @return An SLExpressionNode for the given parameters. null if receiverNode, nameNode or
     *         valueNode is null.
     */
    public TLLExpressionNode createWriteProperty(TLLExpressionNode receiverNode,
                                                 TLLExpressionNode nameNode,
                                                 TLLExpressionNode valueNode) {
        if (receiverNode == null || nameNode == null || valueNode == null) {
            return null;
        }

        final TLLExpressionNode result = TLLWritePropertyNodeGen.create(receiverNode, nameNode, valueNode);

        final int start = receiverNode.getSourceCharIndex();
        final int length = valueNode.getSourceEndIndex() - start;
        result.setSourceSection(start, length);
        result.addExpressionTag();

        return result;
    }

    public TLLExpressionNode createWriteArrayProperty(TLLExpressionNode receiverNode,
                                                      TLLExpressionNode nameNode,
                                                      TLLExpressionNode valueNode,
                                                      TLLExpressionNode index) {
        if (receiverNode == null || nameNode == null
                || valueNode == null || index == null) {
            return null;
        }

        final TLLExpressionNode result = TLLWriteArrayPropertyNodeGen.create(receiverNode, nameNode, valueNode, index);
        //final TLLExpressionNode result = TLLWriteArrayPropertyNodeGen.create(receiverNode, nameNode, valueNode);

        final int start = receiverNode.getSourceCharIndex();
        final int length = valueNode.getSourceEndIndex() - start;
        result.setSourceSection(start, length);
        result.addExpressionTag();

        log.info("createReadArrayProperty" + nameNode.toString() + " index: " + index);
        return result;
    }

    /**
     * Returns a {@link TLLReadLocalVariableNode} if this read is a local variable or a
     * {@link TLLFunctionLiteralNode} if this read is global. In TLL, the only global names are
     * functions.
     *
     * @param nameNode The name of the variable/function being read
     * @return either:
     * <ul>
     * <li>A TLLReadLocalVariableNode representing the local variable being read.</li>
     * <li>A TLLFunctionLiteralNode representing the function definition.</li>
     * <li>null if nameNode is null.</li>
     * </ul>
     */
    public TLLExpressionNode createRead(TLLExpressionNode nameNode) {
        if (nameNode == null) {
            return null;
        }

        String name = ((TLLStringLiteralNode) nameNode).executeGeneric(null);
        log.info("CreateRead: " + name);
        final TLLExpressionNode result;
        final FrameSlot frameSlot = lexicalScope.locals.get(name);
        if (frameSlot != null) {
            /* Read of a local variable. */
            result = TLLReadLocalVariableNodeGen.create(frameSlot);
        } else {
            /* Read of a global name. In our language, the only global names are functions. */
            result = new TLLFunctionLiteralNode(language, name);
        }
        result.setSourceSection(nameNode.getSourceCharIndex(), nameNode.getSourceLength());
        result.addExpressionTag();
        return result;
    }

    public TLLExpressionNode createReadArrayValue(TLLExpressionNode nameArray, Token literalToken) {
        if (nameArray == null) {
            return null;
        }

        String name = ((TLLStringLiteralNode) nameArray).executeGeneric(null);
        TLLExpressionNode index = new TLLLongLiteralNode(Long.parseLong(literalToken.getText()));

        log.info("CreateReadArrayValue: " + name);
        final FrameSlot frameSlot = lexicalScope.locals.get(name);
        if (frameSlot == null) {
            throw new RuntimeException("Frame slot is null in CreateReadArrayValue");
        }
        final TLLExpressionNode result = TLLReadArrayLocalNodeGen.create(index, frameSlot);
        result.setSourceSection(nameArray.getSourceCharIndex(), nameArray.getSourceLength());
        result.addExpressionTag();
        return result;
    }

    /**
     * Returns an {@link TLLInvokeNode} for the given parameters.
     *
     * @param parameterNodes The parameters of the function call
     * @param finalToken     A token used to determine the end of the sourceSelection for this call
     * @return An TLLInvokeNode for the given parameters. null if functionNode or any of the
     * parameterNodes are null.
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

    /**
     * Returns an {@link TLLWriteLocalVariableNode} for the given parameters.
     *
     * @param nameNode  The name of the variable being assigned
     * @param valueNode The value to be assigned
     * @return An TLLExpressionNode for the given parameters. null if nameNode or valueNode is null.
     */
    public TLLExpressionNode createAssignment(TLLExpressionNode nameNode, TLLExpressionNode valueNode) {
        return createAssignment(nameNode, valueNode, null);
    }

    /**
     * Returns an {@link TLLWriteLocalVariableNode} for the given parameters.
     *
     * @param nameNode      The name of the variable being assigned
     * @param valueNode     The value to be assigned
     * @param argumentIndex null or index of the argument the assignment is assigning
     * @return An TLLExpressionNode for the given parameters. null if nameNode or valueNode is null.
     */
    public TLLExpressionNode createAssignment(TLLExpressionNode nameNode, TLLExpressionNode valueNode, Integer argumentIndex) {
        if (nameNode == null || valueNode == null) {
            return null;
        }

        String name = ((TLLStringLiteralNode) nameNode).executeGeneric(null);
        FrameSlot frameSlot = frameDescriptor.findOrAddFrameSlot(
                name,
                argumentIndex,
                FrameSlotKind.Illegal);
        lexicalScope.locals.put(name, frameSlot);
        final TLLExpressionNode result = TLLWriteLocalVariableNodeGen.create(valueNode, frameSlot);

        if (valueNode.hasSource()) {
            final int start = nameNode.getSourceCharIndex();
            final int length = valueNode.getSourceEndIndex() - start;
            result.setSourceSection(start, length);
        }
        result.addExpressionTag();

        return result;
    }

    public TLLExpressionNode createWriteArrayValue(TLLExpressionNode name, TLLExpressionNode valueNode, TLLExpressionNode index) {
        if (name == null || valueNode == null) {
            return null;
        }

        String nameArray = ((TLLStringLiteralNode) name).executeGeneric(null);
        FrameSlot frameSlot = frameDescriptor.findOrAddFrameSlot(
                nameArray, null, FrameSlotKind.Object);
        lexicalScope.locals.put(nameArray, frameSlot);
        final TLLExpressionNode result = TLLWriteArrayLocalNodeGen.create(index, valueNode, frameSlot);

        if (valueNode.hasSource()) {
            final int start = name.getSourceCharIndex();
            final int length = valueNode.getSourceEndIndex() - start;
            result.setSourceSection(start, length);
        }
        result.addExpressionTag();

        return result;
    }

    public void addFormalParameter(Token nameToken) {
        /*
         * Method parameters are assigned to local variables at the beginning of the method. This
         * ensures that accesses to parameters are specialized the same way as local variables are
         * specialized.
         */
        final TLLReadArgumentNode readArg = new TLLReadArgumentNode(parameterCount);
        TLLExpressionNode assignment = createAssignment(createStringLiteral(nameToken, false), readArg, parameterCount);
        allNodes.add(assignment);
        parameterCount++;
    }

    public Map<String, RootCallTarget> getAllBlocks() {
        return allBlocks;
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
