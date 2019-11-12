package ru.diploma.parser;

public class TVDWalker extends TVDLanguageBaseListener {
    public void enterSum(TVDLanguageParser.SumContext ctx ) {
        System.out.println( "Entering R : " + ctx.NUMERIC_LITERAL());
    }

    public void exitSum(ru.diploma.parser.TVDLanguageParser.SumContext ctx ) {
        System.out.println( "Exiting R");
    }
}
