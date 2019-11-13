package ru.diploma.parser;

public class TVDWalker extends TVDLanguageBaseListener {
    public void enterSum(TVDLanguageParser.TvdlanguageContext ctx ) {
        System.out.println( "Entering R : " + ctx.sum().leftnode.NUMERIC_LITERAL);
    }

    public void exitSum(ru.diploma.parser.TVDLanguageParser.TvdlanguageContext ctx ) {
        System.out.println( "Exiting R");
    }
}
