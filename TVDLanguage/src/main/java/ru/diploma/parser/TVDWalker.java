package ru.diploma.parser;

public class TVDWalker extends TVDLanguageBaseListener {
    public void enterSum(TVDLanguageParser.TvdlanguageContext ctx ) {
        //TODO переделать для теста Antrl в ParserMain
        System.out.println( "Entering R : " + ctx.toString());
    }

    public void exitSum(ru.diploma.parser.TVDLanguageParser.TvdlanguageContext ctx ) {
        System.out.println( "Exiting R");
    }
}
