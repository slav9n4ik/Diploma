// Generated from /home/viacheslav/Documents/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TVDLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;

//Generated from TVDLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TVDLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TVDLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TVDLanguageParser#sum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(TVDLanguageParser.SumContext ctx);
}