// Generated from /home/viacheslav/Documents/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TVDLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;

//Generated from TVDLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import java.util.Map;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TVDLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, OPERATION=2, NUMERIC_LITERAL=3;
	public static final int
		RULE_sum = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"sum"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITESPACE", "OPERATION", "NUMERIC_LITERAL"
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

	@Override
	public String getGrammarFileName() { return "TVDLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	//Generated from TVDLanguage.g4
	private TVDNodeFactory factory;
	private Source source;

	public static Map<String, RootCallTarget> parseTVD(TVDLanguage language, Source source) {
	    TVDLanguageLexer lexer = new TVDLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
	    TVDLanguageParser parser = new TVDLanguageParser(new CommonTokenStream(lexer));
	    //lexer.removeErrorListeners();
	    //parser.removeErrorListeners();
	    //BailoutErrorListener listener = new BailoutErrorListener(source);
	    //lexer.addErrorListener(listener);
	    //parser.addErrorListener(listener);
	    parser.factory = new TVDNodeFactory(language, source);
	    parser.source = source;
	    parser.sum();
	    return parser.factory.getAllFunctions();
	}

	public TVDLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SumContext extends ParserRuleContext {
		public Token NUMERIC_LITERAL;
		public Token OPERATION;
		public List<TerminalNode> NUMERIC_LITERAL() { return getTokens(TVDLanguageParser.NUMERIC_LITERAL); }
		public TerminalNode NUMERIC_LITERAL(int i) {
			return getToken(TVDLanguageParser.NUMERIC_LITERAL, i);
		}
		public TerminalNode OPERATION() { return getToken(TVDLanguageParser.OPERATION, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TVDLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TVDLanguageParser.WHITESPACE, i);
		}
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TVDLanguageVisitor ) return ((TVDLanguageVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(5);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(2);
				match(WHITESPACE);
				}
				}
				setState(7);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(8);
			((SumContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			 factory.showNumber(((SumContext)_localctx).NUMERIC_LITERAL); 
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(10);
				match(WHITESPACE);
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(16);
			((SumContext)_localctx).OPERATION = match(OPERATION);
			 factory.showOperation(((SumContext)_localctx).OPERATION); 
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(18);
				match(WHITESPACE);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			((SumContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			 factory.showNumber(((SumContext)_localctx).NUMERIC_LITERAL); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\5\36\4\2\t\2\3\2"+
		"\7\2\6\n\2\f\2\16\2\t\13\2\3\2\3\2\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2"+
		"\3\2\3\2\7\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\2\2\2\3\2\2\2\2\37"+
		"\2\7\3\2\2\2\4\6\7\3\2\2\5\4\3\2\2\2\6\t\3\2\2\2\7\5\3\2\2\2\7\b\3\2\2"+
		"\2\b\n\3\2\2\2\t\7\3\2\2\2\n\13\7\5\2\2\13\17\b\2\1\2\f\16\7\3\2\2\r\f"+
		"\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\22\3\2\2\2\21\17"+
		"\3\2\2\2\22\23\7\4\2\2\23\27\b\2\1\2\24\26\7\3\2\2\25\24\3\2\2\2\26\31"+
		"\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33"+
		"\7\5\2\2\33\34\b\2\1\2\34\3\3\2\2\2\5\7\17\27";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}