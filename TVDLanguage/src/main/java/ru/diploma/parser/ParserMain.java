package ru.diploma.parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ParserMain {
    public static void main(String[] args) {
        CharStream inputStream = CharStreams.fromString("43 + 57");
        TVDLanguageLexer lexer = new TVDLanguageLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        TVDLanguageParser parser = new TVDLanguageParser(commonTokenStream);

        ParseTree tree = parser.sum();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new TVDWalker(), tree);
    }
}
