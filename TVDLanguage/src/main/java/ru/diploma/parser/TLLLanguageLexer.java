// Generated from /Users/u17079332/Documents/IdeaProject/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TLLLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TLLLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, WHITESPACE=5, IDENTIFIER=6, OPERATION=7, 
		NUMERIC_LITERAL=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "DIGIT", "LETTER", "NON_ZERO_DIGIT", 
			"WHITESPACE", "IDENTIFIER", "OPERATION", "NUMERIC_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "WHITESPACE", "IDENTIFIER", "OPERATION", 
			"NUMERIC_LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public TLLLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TLLLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\nD\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\5\7+\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\n\64\n\n\f\n\16\n\67"+
		"\13\n\3\13\3\13\3\f\3\f\3\f\7\f>\n\f\f\f\16\fA\13\f\5\fC\n\f\2\2\r\3\3"+
		"\5\4\7\5\t\6\13\2\r\2\17\2\21\7\23\b\25\t\27\n\3\2\6\3\2\62;\6\2&&C\\"+
		"aac|\3\2\63;\4\2\13\f\"\"\2D\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\3\31\3\2\2"+
		"\2\5\37\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\'\3\2\2\2\r*\3\2\2\2\17,\3\2"+
		"\2\2\21.\3\2\2\2\23\60\3\2\2\2\258\3\2\2\2\27B\3\2\2\2\31\32\7U\2\2\32"+
		"\33\7V\2\2\33\34\7C\2\2\34\35\7T\2\2\35\36\7V\2\2\36\4\3\2\2\2\37 \7G"+
		"\2\2 !\7P\2\2!\"\7F\2\2\"\6\3\2\2\2#$\7*\2\2$\b\3\2\2\2%&\7+\2\2&\n\3"+
		"\2\2\2\'(\t\2\2\2(\f\3\2\2\2)+\t\3\2\2*)\3\2\2\2+\16\3\2\2\2,-\t\4\2\2"+
		"-\20\3\2\2\2./\t\5\2\2/\22\3\2\2\2\60\65\5\r\7\2\61\64\5\r\7\2\62\64\5"+
		"\13\6\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\24\3\2\2\2\67\65\3\2\2\289\7-\2\29\26\3\2\2\2:C\7\62\2\2;"+
		"?\5\17\b\2<>\5\13\6\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@C\3\2\2"+
		"\2A?\3\2\2\2B:\3\2\2\2B;\3\2\2\2C\30\3\2\2\2\b\2*\63\65?B\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}