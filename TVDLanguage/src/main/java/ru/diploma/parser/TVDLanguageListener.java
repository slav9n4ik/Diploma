// Generated from /Users/u17079332/Documents/IdeaProject/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TVDLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;

//Generated from TVDLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDStatementNode;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TVDLanguageParser}.
 */
public interface TVDLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TVDLanguageParser#tvdlanguage}.
	 * @param ctx the parse tree
	 */
	void enterTvdlanguage(TVDLanguageParser.TvdlanguageContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVDLanguageParser#tvdlanguage}.
	 * @param ctx the parse tree
	 */
	void exitTvdlanguage(TVDLanguageParser.TvdlanguageContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVDLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TVDLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVDLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TVDLanguageParser.StatementContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link TVDLanguageParser#numeric}.
	 * @param ctx the parse tree
	 */
	void enterNumeric(TVDLanguageParser.NumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVDLanguageParser#numeric}.
	 * @param ctx the parse tree
	 */
	void exitNumeric(TVDLanguageParser.NumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link TVDLanguageParser#member_expression}.
	 * @param ctx the parse tree
	 */
	void enterMember_expression(TVDLanguageParser.Member_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TVDLanguageParser#member_expression}.
	 * @param ctx the parse tree
	 */
	void exitMember_expression(TVDLanguageParser.Member_expressionContext ctx);
}