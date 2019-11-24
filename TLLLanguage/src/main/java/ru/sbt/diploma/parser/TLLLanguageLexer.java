// Generated from /Users/u17079332/Documents/IdeaProject/Diploma/TLLLanguage/src/main/java/ru/sbt/diploma/parser/TLLLanguage.g4 by ANTLR 4.7.2
package ru.sbt.diploma.parser;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, WHITESPACE=6, IDENTIFIER=7, OPERATION=8, 
		NUMERIC_LITERAL=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "DIGIT", "LETTER", "NON_ZERO_DIGIT", 
			"WHITESPACE", "IDENTIFIER", "OPERATION", "NUMERIC_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "'('", "')'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "WHITESPACE", "IDENTIFIER", "OPERATION", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13H\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\5\b/\n\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\7\13"+
		"8\n\13\f\13\16\13;\13\13\3\f\3\f\3\r\3\r\3\r\7\rB\n\r\f\r\16\rE\13\r\5"+
		"\rG\n\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\b\25\t\27\n\31\13"+
		"\3\2\6\3\2\62;\6\2&&C\\aac|\3\2\63;\4\2\13\f\"\"\2H\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5!\3\2\2\2\7%\3\2\2\2\t\'\3\2"+
		"\2\2\13)\3\2\2\2\r+\3\2\2\2\17.\3\2\2\2\21\60\3\2\2\2\23\62\3\2\2\2\25"+
		"\64\3\2\2\2\27<\3\2\2\2\31F\3\2\2\2\33\34\7U\2\2\34\35\7V\2\2\35\36\7"+
		"C\2\2\36\37\7T\2\2\37 \7V\2\2 \4\3\2\2\2!\"\7G\2\2\"#\7P\2\2#$\7F\2\2"+
		"$\6\3\2\2\2%&\7*\2\2&\b\3\2\2\2\'(\7+\2\2(\n\3\2\2\2)*\7<\2\2*\f\3\2\2"+
		"\2+,\t\2\2\2,\16\3\2\2\2-/\t\3\2\2.-\3\2\2\2/\20\3\2\2\2\60\61\t\4\2\2"+
		"\61\22\3\2\2\2\62\63\t\5\2\2\63\24\3\2\2\2\649\5\17\b\2\658\5\17\b\2\66"+
		"8\5\r\7\2\67\65\3\2\2\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2"+
		":\26\3\2\2\2;9\3\2\2\2<=\7-\2\2=\30\3\2\2\2>G\7\62\2\2?C\5\21\t\2@B\5"+
		"\r\7\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DG\3\2\2\2EC\3\2\2\2F>\3"+
		"\2\2\2F?\3\2\2\2G\32\3\2\2\2\b\2.\679CF\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}