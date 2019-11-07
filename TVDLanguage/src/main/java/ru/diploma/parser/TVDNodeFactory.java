package ru.diploma.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import org.antlr.v4.runtime.Token;
import ru.diploma.TVDLanguage;

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

    public Map<String, RootCallTarget> getAllFunctions() {
        return allFunctions;
    }

}
