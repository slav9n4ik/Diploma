package ru.diploma.parser;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.source.Source;
import org.antlr.v4.runtime.Token;
import ru.diploma.TVDLanguage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TVDNodeFactory {

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
    private final Source source;
    private final Map<String, RootCallTarget> allFunctions;

    /* State while parsing a function. */
//    private int functionStartPos;
//    private String functionName;
//    private int functionBodyStartPos; // includes parameter list
//    private int parameterCount;
//    private FrameDescriptor frameDescriptor;
    //private List<SLStatementNode> methodNodes;

    /* State while parsing a block. */
    private LexicalScope lexicalScope;
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

    //    public void startBlock() {
//        lexicalScope = new LexicalScope(lexicalScope);
//    }
    public Map<String, RootCallTarget> getAllFunctions() {
        return allFunctions;
    }

}
