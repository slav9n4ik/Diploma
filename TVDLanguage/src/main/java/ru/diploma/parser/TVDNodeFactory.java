package ru.diploma.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.source.Source;
import org.antlr.v4.runtime.Token;
import ru.diploma.TVDLanguage;
import ru.diploma.nodes.TVDAddNodeGen;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDLongLiteralNode;
import ru.diploma.nodes.TVDStatementNode;
import ru.diploma.util.TVDUnboxNodeGen;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class TVDNodeFactory {

    /* State while parsing a source unit. */
    private final Source source;
    private final Map<String, RootCallTarget> allFunctions;

    /* State while parsing a block. */
    private final TVDLanguage language;

    public TVDNodeFactory(TVDLanguage language, Source source) {
        this.language = language;
        this.source = source;
        this.allFunctions = new HashMap<>();
    }

    public void startFunction() {
        System.out.println("******* Start Function *******");
    }

    public void finishFunction(Token sumToken, TVDExpressionNode result) {
        System.out.println("******* Finish Function *******");

        //TODO Исправить заглушку имени
        allFunctions.put("main", Truffle.getRuntime().createCallTarget(rootNode));
    }

    public TVDExpressionNode createBinary(Token opToken, TVDExpressionNode leftNode, TVDExpressionNode rightNode) {
        System.out.println("******* CreateBinary Function *******");
        if (leftNode == null || rightNode == null) {
            return null;
        }
        final TVDExpressionNode leftUnboxed = TVDUnboxNodeGen.create(leftNode);
        final TVDExpressionNode rightUnboxed = TVDUnboxNodeGen.create(rightNode);

        final TVDExpressionNode result;
        switch (opToken.getText()) {
            case "+":
                System.out.println("CreateBinary Function Plus Operation");
                result = TVDAddNodeGen.create(leftUnboxed, rightUnboxed);
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

    public TVDExpressionNode createNumericLiteral(Token literalToken) {
        TVDExpressionNode result;
        try {
            /* Try if the literal is small enough to fit into a long value. */
            result = new TVDLongLiteralNode(Long.parseLong(literalToken.getText()));
        } catch (NumberFormatException ex) {
            /* Overflow of long value, so fall back to BigInteger. */
            result = null;//new TVDBigIntegerLiteralNode(new BigInteger(literalToken.getText()));
        }
        srcFromToken(result, literalToken);
        result.addExpressionTag();
        return result;
    }

    /**
     * Creates source description of a single token.
     */
    private static void srcFromToken(TVDStatementNode node, Token token) {
        node.setSourceSection(token.getStartIndex(), token.getText().length());
    }

    public Map<String, RootCallTarget> getAllFunctions() {
        return allFunctions;
    }

    //To check parser
    public void showOperation(Token bodyStartToken) {
        System.out.println("Node Factory showOperation: " + bodyStartToken.getText());
    }

    //To check parser
    public void showNumber(Token bodyStartToken) {
        System.out.println("Node Factory showNumber: " + bodyStartToken.getText());
    }

}
