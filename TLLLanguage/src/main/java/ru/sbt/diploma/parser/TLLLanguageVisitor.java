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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TLLLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TLLLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#tlllanguage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTlllanguage(TLLLanguageParser.TlllanguageContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TLLLanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(TLLLanguageParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#init_obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_obj(TLLLanguageParser.Init_objContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(TLLLanguageParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(TLLLanguageParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#numeric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumeric(TLLLanguageParser.NumericContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TLLLanguageParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#member_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_expression(TLLLanguageParser.Member_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TLLLanguageParser#array_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray_statement(TLLLanguageParser.Array_statementContext ctx);
}