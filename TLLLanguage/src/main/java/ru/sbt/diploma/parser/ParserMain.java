package ru.sbt.diploma.parser;

import com.oracle.truffle.api.source.Source;

public class ParserMain {
    public static void main(String[] args) throws Exception {
        //testParsingSumInAntlr();
        //testAntlrTree();
        testParsingPrintInAntlr();
    }

    private static void testAntlrTree() {
//        CharStream inputStream = CharStreams.fromString("43 + 57");
//        TLLLanguageLexer lexer = new TLLLanguageLexer(inputStream);
//        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
//        TLLLanguageParser parser = new TLLLanguageParser(commonTokenStream);
//
//        ParseTree tree = parser.sum();
//        ParseTreeWalker walker = new ParseTreeWalker();
//        walker.walk(new TLLWalker(), tree);
    }

    private static void testParsingSumInAntlr() throws Exception {
        Source source = Source.newBuilder("tvd",
                "43 + 57",
                "sum.tvd").build();

        //new TLLLanguage().parseCustom(source);
    }

    private static void testParsingPrintInAntlr() throws Exception {
        Source source = Source.newBuilder("tvd",
                "print()",
                "print.tvd").build();

        //new TLLLanguage().parseCustom(source);
    }
}
