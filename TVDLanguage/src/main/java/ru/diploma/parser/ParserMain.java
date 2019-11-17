package ru.diploma.parser;

import com.oracle.truffle.api.source.Source;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import ru.diploma.TVDLanguage;

public class ParserMain {
    public static void main(String[] args) throws Exception {
        //testParsingSumInAntlr();
        //testAntlrTree();
        testParsingPrintInAntlr();
    }

    private static void testAntlrTree() {
        CharStream inputStream = CharStreams.fromString("43 + 57");
        TVDLanguageLexer lexer = new TVDLanguageLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        TVDLanguageParser parser = new TVDLanguageParser(commonTokenStream);

        ParseTree tree = parser.sum();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TVDWalker(), tree);
    }

    private static void testParsingSumInAntlr() throws Exception {
        Source source = Source.newBuilder("tvd",
                "43 + 57",
                "sum.tvd").build();

        //new TVDLanguage().parseCustom(source);
    }

    private static void testParsingPrintInAntlr() throws Exception {
        Source source = Source.newBuilder("tvd",
                "print()",
                "print.tvd").build();

        //new TVDLanguage().parseCustom(source);
    }
}
