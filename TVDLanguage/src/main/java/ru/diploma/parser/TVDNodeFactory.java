package ru.diploma.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import org.antlr.v4.runtime.Token;
import ru.diploma.TVDLanguage;
import ru.diploma.nodes.TVDAddNodeGen;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.util.TVDUnboxNodeGen;

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

    public void showOperation(Token bodyStartToken) {
        System.out.println("Node Factory showOperation");
        System.out.println(bodyStartToken.getText());
    }

    public void showNumber(Token bodyStartToken) {
        System.out.println("Node Factory showNumber");
        System.out.println(bodyStartToken.getText());
    }

    public TVDExpressionNode createBinary(Token opToken, TVDExpressionNode leftNode, TVDExpressionNode rightNode) {
        if (leftNode == null || rightNode == null) {
            return null;
        }
        final TVDExpressionNode leftUnboxed = TVDUnboxNodeGen.create(leftNode);
        final TVDExpressionNode rightUnboxed = TVDUnboxNodeGen.create(rightNode);

        final TVDExpressionNode result;
        switch (opToken.getText()) {
            case "+":
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

    public Map<String, RootCallTarget> getAllFunctions() {
        return allFunctions;
    }

}
