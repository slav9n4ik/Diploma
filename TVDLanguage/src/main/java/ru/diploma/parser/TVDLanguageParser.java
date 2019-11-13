// Generated from /Users/u17079332/Documents/IdeaProject/Diploma/TVDLanguage/src/main/java/ru/diploma/parser/TVDLanguage.g4 by ANTLR 4.7.2
package ru.diploma.parser;

//Generated from TVDLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import ru.diploma.nodes.TVDExpressionNode;
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
		RULE_tvdlanguage = 0, RULE_sum = 1, RULE_leftnode = 2, RULE_rightnode = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"tvdlanguage", "sum", "leftnode", "rightnode"
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
	    parser.factory = new TVDNodeFactory(language, source);
	    parser.source = source;
	    parser.tvdlanguage();
	    return parser.factory.getAllFunctions();
	}

	public TVDLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TvdlanguageContext extends ParserRuleContext {
		public Token block;
		public SumContext sum;
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TVDLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TVDLanguageParser.WHITESPACE, i);
		}
		public TvdlanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tvdlanguage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).enterTvdlanguage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).exitTvdlanguage(this);
		}
	}

	public final TvdlanguageContext tvdlanguage() throws RecognitionException {
		TvdlanguageContext _localctx = new TvdlanguageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tvdlanguage);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(8);
					((TvdlanguageContext)_localctx).block = match(WHITESPACE);
					}
					} 
				}
				setState(13);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			{
			 factory.startFunction(); 
			setState(15);
			((TvdlanguageContext)_localctx).sum = sum();
			 factory.finishFunction(((TvdlanguageContext)_localctx).block, ((TvdlanguageContext)_localctx).sum.result); 
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(17);
				match(WHITESPACE);
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
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

	public static class SumContext extends ParserRuleContext {
		public TVDExpressionNode result;
		public LeftnodeContext leftnode;
		public Token OPERATION;
		public RightnodeContext rightnode;
		public LeftnodeContext leftnode() {
			return getRuleContext(LeftnodeContext.class,0);
		}
		public TerminalNode OPERATION() { return getToken(TVDLanguageParser.OPERATION, 0); }
		public RightnodeContext rightnode() {
			return getRuleContext(RightnodeContext.class,0);
		}
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
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			((SumContext)_localctx).leftnode = leftnode();
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(24);
				match(WHITESPACE);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
			((SumContext)_localctx).OPERATION = match(OPERATION);
			 factory.showOperation(((SumContext)_localctx).OPERATION); 
			setState(32);
			((SumContext)_localctx).rightnode = rightnode();
			 ((SumContext)_localctx).result =  factory.createBinary(((SumContext)_localctx).OPERATION, ((SumContext)_localctx).leftnode.result, ((SumContext)_localctx).rightnode.result); 
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

	public static class LeftnodeContext extends ParserRuleContext {
		public TVDExpressionNode result;
		public Token NUMERIC_LITERAL;
		public TerminalNode NUMERIC_LITERAL() { return getToken(TVDLanguageParser.NUMERIC_LITERAL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TVDLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TVDLanguageParser.WHITESPACE, i);
		}
		public LeftnodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftnode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).enterLeftnode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).exitLeftnode(this);
		}
	}

	public final LeftnodeContext leftnode() throws RecognitionException {
		LeftnodeContext _localctx = new LeftnodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_leftnode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(35);
				match(WHITESPACE);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			((LeftnodeContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			 factory.showNumber(((LeftnodeContext)_localctx).NUMERIC_LITERAL); 
			 ((LeftnodeContext)_localctx).result =  factory.createNumericLiteral(((LeftnodeContext)_localctx).NUMERIC_LITERAL); 
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

	public static class RightnodeContext extends ParserRuleContext {
		public TVDExpressionNode result;
		public Token NUMERIC_LITERAL;
		public TerminalNode NUMERIC_LITERAL() { return getToken(TVDLanguageParser.NUMERIC_LITERAL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TVDLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TVDLanguageParser.WHITESPACE, i);
		}
		public RightnodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightnode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).enterRightnode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TVDLanguageListener ) ((TVDLanguageListener)listener).exitRightnode(this);
		}
	}

	public final RightnodeContext rightnode() throws RecognitionException {
		RightnodeContext _localctx = new RightnodeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rightnode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(45);
				match(WHITESPACE);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			((RightnodeContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			 factory.showNumber(((RightnodeContext)_localctx).NUMERIC_LITERAL); 
			 ((RightnodeContext)_localctx).result =  factory.createNumericLiteral(((RightnodeContext)_localctx).NUMERIC_LITERAL); 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\5:\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\3\2\3\2\3\2\7\2"+
		"\25\n\2\f\2\16\2\30\13\2\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\4\3\4\3\5\7\5\61\n\5"+
		"\f\5\16\5\64\13\5\3\5\3\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\2\2:\2\r\3\2\2\2"+
		"\4\31\3\2\2\2\6(\3\2\2\2\b\62\3\2\2\2\n\f\7\3\2\2\13\n\3\2\2\2\f\17\3"+
		"\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2\16\20\3\2\2\2\17\r\3\2\2\2\20\21\b\2"+
		"\1\2\21\22\5\4\3\2\22\26\b\2\1\2\23\25\7\3\2\2\24\23\3\2\2\2\25\30\3\2"+
		"\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\3\3\2\2\2\30\26\3\2\2\2\31\35\5\6"+
		"\4\2\32\34\7\3\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2"+
		"\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\4\2\2!\"\b\3\1\2\"#\5\b\5\2#$\b\3\1"+
		"\2$\5\3\2\2\2%\'\7\3\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3"+
		"\2\2\2*(\3\2\2\2+,\7\5\2\2,-\b\4\1\2-.\b\4\1\2.\7\3\2\2\2/\61\7\3\2\2"+
		"\60/\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64"+
		"\62\3\2\2\2\65\66\7\5\2\2\66\67\b\5\1\2\678\b\5\1\28\t\3\2\2\2\7\r\26"+
		"\35(\62";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}