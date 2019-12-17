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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, WHITESPACE=11, IDENTIFIER=12, OPERATION=13, NUMERIC_LITERAL=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "DIGIT", "LETTER", "NON_ZERO_DIGIT", "WHITESPACE", "IDENTIFIER", 
			"OPERATION", "NUMERIC_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "'return'", "':'", "'@'", "'.'", "'('", "')'", 
			"'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "WHITESPACE", 
			"IDENTIFIER", "OPERATION", "NUMERIC_LITERAL"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20a\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\5"+
		"\rH\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\7\20Q\n\20\f\20\16\20T\13\20"+
		"\3\21\3\21\3\22\3\22\3\22\7\22[\n\22\f\22\16\22^\13\22\5\22`\n\22\2\2"+
		"\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\2\33\2\35\r"+
		"\37\16!\17#\20\3\2\6\3\2\62;\6\2&&C\\aac|\3\2\63;\4\2\13\f\"\"\2a\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5+\3\2\2\2\7/\3\2\2\2\t\66\3"+
		"\2\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23@\3\2\2\2\25B"+
		"\3\2\2\2\27D\3\2\2\2\31G\3\2\2\2\33I\3\2\2\2\35K\3\2\2\2\37M\3\2\2\2!"+
		"U\3\2\2\2#_\3\2\2\2%&\7U\2\2&\'\7V\2\2\'(\7C\2\2()\7T\2\2)*\7V\2\2*\4"+
		"\3\2\2\2+,\7G\2\2,-\7P\2\2-.\7F\2\2.\6\3\2\2\2/\60\7t\2\2\60\61\7g\2\2"+
		"\61\62\7v\2\2\62\63\7w\2\2\63\64\7t\2\2\64\65\7p\2\2\65\b\3\2\2\2\66\67"+
		"\7<\2\2\67\n\3\2\2\289\7B\2\29\f\3\2\2\2:;\7\60\2\2;\16\3\2\2\2<=\7*\2"+
		"\2=\20\3\2\2\2>?\7+\2\2?\22\3\2\2\2@A\7]\2\2A\24\3\2\2\2BC\7_\2\2C\26"+
		"\3\2\2\2DE\t\2\2\2E\30\3\2\2\2FH\t\3\2\2GF\3\2\2\2H\32\3\2\2\2IJ\t\4\2"+
		"\2J\34\3\2\2\2KL\t\5\2\2L\36\3\2\2\2MR\5\31\r\2NQ\5\31\r\2OQ\5\27\f\2"+
		"PN\3\2\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S \3\2\2\2TR\3\2\2\2"+
		"UV\7-\2\2V\"\3\2\2\2W`\7\62\2\2X\\\5\33\16\2Y[\5\27\f\2ZY\3\2\2\2[^\3"+
		"\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]`\3\2\2\2^\\\3\2\2\2_W\3\2\2\2_X\3\2\2\2"+
		"`$\3\2\2\2\b\2GPR\\_\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}