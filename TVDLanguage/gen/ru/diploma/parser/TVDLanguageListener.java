// Generated from /home/viacheslav/Documents/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TVDLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TVDLanguageParser}.
 */
public interface TVDLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TVDLanguageParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterSum(TVDLanguageParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVDLanguageParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitSum(TVDLanguageParser.SumContext ctx);
}