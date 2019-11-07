// Generated from /home/viacheslav/Documents/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TVDLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;

//Generated from TVDLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import java.util.Map;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link TVDLanguageVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class TVDLanguageBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements TVDLanguageVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSum(TVDLanguageParser.SumContext ctx) { return visitChildren(ctx); }
}