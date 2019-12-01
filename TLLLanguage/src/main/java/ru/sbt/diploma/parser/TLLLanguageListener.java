// Generated from /Users/u17079332/Documents/IdeaProject/Diploma/TLLLanguage/src/main/java/ru/sbt/diploma/parser/TLLLanguage.g4 by ANTLR 4.7.2
package ru.sbt.diploma.parser;

//Generated from TLLLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLStatementNode;

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
	 * Enter a parse tree produced by {@link TLLLanguageParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(TLLLanguageParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(TLLLanguageParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(TLLLanguageParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(TLLLanguageParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#init_obj}.
	 * @param ctx the parse tree
	 */
	void enterInit_obj(TLLLanguageParser.Init_objContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#init_obj}.
	 * @param ctx the parse tree
	 */
	void exitInit_obj(TLLLanguageParser.Init_objContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#init_prop}.
	 * @param ctx the parse tree
	 */
	void enterInit_prop(TLLLanguageParser.Init_propContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#init_prop}.
	 * @param ctx the parse tree
	 */
	void exitInit_prop(TLLLanguageParser.Init_propContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(TLLLanguageParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(TLLLanguageParser.InitContext ctx);
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
	 * Enter a parse tree produced by {@link TLLLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TLLLanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TLLLanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#builtin_functions}.
	 * @param ctx the parse tree
	 */
	void enterBuiltin_functions(TLLLanguageParser.Builtin_functionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#builtin_functions}.
	 * @param ctx the parse tree
	 */
	void exitBuiltin_functions(TLLLanguageParser.Builtin_functionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TLLLanguageParser#array_statement}.
	 * @param ctx the parse tree
	 */
	void enterArray_statement(TLLLanguageParser.Array_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TLLLanguageParser#array_statement}.
	 * @param ctx the parse tree
	 */
	void exitArray_statement(TLLLanguageParser.Array_statementContext ctx);
}