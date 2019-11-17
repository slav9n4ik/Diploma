// Generated from /Users/u17079332/Documents/IdeaProject/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TLLLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;

//Generated from TLLLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TLLLanguage;
import ru.diploma.nodes.TLLExpressionNode;
import ru.diploma.nodes.TLLStatementNode;

import java.util.*;
import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TLLLanguageParser}.
 */
public interface TLLLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#tlllanguage}.
	 * @param ctx the parse tree
	 */
	void enterTlllanguage(TLLLanguageParser.TlllanguageContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#tlllanguage}.
	 * @param ctx the parse tree
	 */
	void exitTlllanguage(TLLLanguageParser.TlllanguageContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TLLLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TLLLanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#sum}.
	 * @param ctx the parse tree
	 */
	void enterSum(TLLLanguageParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#sum}.
	 * @param ctx the parse tree
	 */
	void exitSum(TLLLanguageParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#numeric}.
	 * @param ctx the parse tree
	 */
	void enterNumeric(TLLLanguageParser.NumericContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#numeric}.
	 * @param ctx the parse tree
	 */
	void exitNumeric(TLLLanguageParser.NumericContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#member_expression}.
	 * @param ctx the parse tree
	 */
	void enterMember_expression(TLLLanguageParser.Member_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#member_expression}.
	 * @param ctx the parse tree
	 */
	void exitMember_expression(TLLLanguageParser.Member_expressionContext ctx);
}