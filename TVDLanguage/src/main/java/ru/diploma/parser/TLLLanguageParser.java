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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TLLLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, WHITESPACE=5, IDENTIFIER=6, OPERATION=7, 
		NUMERIC_LITERAL=8;
	public static final int
		RULE_tlllanguage = 0, RULE_statement = 1, RULE_sum = 2, RULE_numeric = 3, 
		RULE_member_expression = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"tlllanguage", "statement", "sum", "numeric", "member_expression"
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

	@Override
	public String getGrammarFileName() { return "TLLLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	//Generated from TLLLanguage.g4
	private TLLNodeFactory factory;
	private Source source;

	private static final class BailoutErrorListener extends BaseErrorListener {
	    private final Source source;
	    BailoutErrorListener(Source source) {
	        this.source = source;
	    }
	    @Override
	    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	        throwParseError(source, line, charPositionInLine, (Token) offendingSymbol, msg);
	    }
	}

	public void SemErr(Token token, String message) {
	    assert token != null;
	    throwParseError(source, token.getLine(), token.getCharPositionInLine(), token, message);
	}

	private static void throwParseError(Source source, int line, int charPositionInLine, Token token, String message) {
	    int col = charPositionInLine + 1;
	    String location = "-- line " + line + " col " + col + ": ";
	    int length = token == null ? 1 : Math.max(token.getStopIndex() - token.getStartIndex(), 0);
	    throw new TLLParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
	}

	public static Map<String, RootCallTarget> parseTLL(TLLLanguage language, Source source) {
	    TLLLanguageLexer lexer = new TLLLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
	    TLLLanguageParser parser = new TLLLanguageParser(new CommonTokenStream(lexer));
	    lexer.removeErrorListeners();
	    parser.removeErrorListeners();
	    BailoutErrorListener listener = new BailoutErrorListener(source);
	    lexer.addErrorListener(listener);
	    parser.addErrorListener(listener);
	    parser.factory = new TLLNodeFactory(language, source);
	    parser.source = source;
	    parser.tlllanguage();
	    return parser.factory.getAllBlocks();
	}

	public TLLLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class TlllanguageContext extends ParserRuleContext {
		public Token block;
		public Token s;
		public StatementContext statement;
		public Token e;
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TlllanguageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tlllanguage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterTlllanguage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitTlllanguage(this);
		}
	}

	public final TlllanguageContext tlllanguage() throws RecognitionException {
		TlllanguageContext _localctx = new TlllanguageContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tlllanguage);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(10);
				((TlllanguageContext)_localctx).block = match(WHITESPACE);
				}
				}
				setState(15);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(16);
			((TlllanguageContext)_localctx).s = match(T__0);

			                                           factory.startBlock(((TlllanguageContext)_localctx).s, ((TlllanguageContext)_localctx).block);
			                                           List<TLLStatementNode> body = new ArrayList<>(); 
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WHITESPACE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(19); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(18);
						((TlllanguageContext)_localctx).statement = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(21); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				 body.add(((TlllanguageContext)_localctx).statement.result); 
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(24);
						match(WHITESPACE);
						}
						} 
					}
					setState(29);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			((TlllanguageContext)_localctx).e = match(T__1);
			 factory.finishBlock(body, ((TlllanguageContext)_localctx).s.getStartIndex(), ((TlllanguageContext)_localctx).e.getStopIndex() - ((TlllanguageContext)_localctx).s.getStartIndex() + 1); 
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

	public static class StatementContext extends ParserRuleContext {
		public TLLStatementNode result;
		public Token r;
		public SumContext sum;
		public Token IDENTIFIER;
		public Member_expressionContext member_expression;
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public Member_expressionContext member_expression() {
			return getRuleContext(Member_expressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					((StatementContext)_localctx).r = match(WHITESPACE);
					}
					} 
				}
				setState(43);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
			case NUMERIC_LITERAL:
				{
				setState(44);
				((StatementContext)_localctx).sum = sum();
				 ((StatementContext)_localctx).result =  factory.createReturn(((StatementContext)_localctx).r, ((StatementContext)_localctx).sum.result); 
				}
				break;
			case IDENTIFIER:
				{
				{
				setState(47);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				setState(49);
				((StatementContext)_localctx).member_expression = member_expression(assignmentName);
				 ((StatementContext)_localctx).result =  factory.createReturn(((StatementContext)_localctx).r, ((StatementContext)_localctx).member_expression.result); 
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public TLLExpressionNode result;
		public NumericContext numeric;
		public Token OPERATION;
		public List<NumericContext> numeric() {
			return getRuleContexts(NumericContext.class);
		}
		public NumericContext numeric(int i) {
			return getRuleContext(NumericContext.class,i);
		}
		public TerminalNode OPERATION() { return getToken(TLLLanguageParser.OPERATION, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitSum(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 TLLExpressionNode leftnode, rightnode;  
			setState(55);
			((SumContext)_localctx).numeric = numeric();
			 leftnode = ((SumContext)_localctx).numeric.result; 
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(57);
				match(WHITESPACE);
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			((SumContext)_localctx).OPERATION = match(OPERATION);
			 factory.showOperation(((SumContext)_localctx).OPERATION); 
			setState(65);
			((SumContext)_localctx).numeric = numeric();
			 rightnode = ((SumContext)_localctx).numeric.result; 
			 ((SumContext)_localctx).result =  factory.createBinary(((SumContext)_localctx).OPERATION, leftnode, rightnode); 
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

	public static class NumericContext extends ParserRuleContext {
		public TLLExpressionNode result;
		public Token NUMERIC_LITERAL;
		public TerminalNode NUMERIC_LITERAL() { return getToken(TLLLanguageParser.NUMERIC_LITERAL, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public NumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitNumeric(this);
		}
	}

	public final NumericContext numeric() throws RecognitionException {
		NumericContext _localctx = new NumericContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numeric);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(69);
				match(WHITESPACE);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			((NumericContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(76);
					match(WHITESPACE);
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			 factory.showNumber(((NumericContext)_localctx).NUMERIC_LITERAL); 
			 ((NumericContext)_localctx).result =  factory.createNumericLiteral(((NumericContext)_localctx).NUMERIC_LITERAL); 
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

	public static class Member_expressionContext extends ParserRuleContext {
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode result;
		public SumContext sum;
		public NumericContext numeric;
		public Token e;
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public Member_expressionContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Member_expressionContext(ParserRuleContext parent, int invokingState, TLLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_member_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterMember_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitMember_expression(this);
		}
	}

	public final Member_expressionContext member_expression(TLLExpressionNode assignmentName) throws RecognitionException {
		Member_expressionContext _localctx = new Member_expressionContext(_ctx, getState(), assignmentName);
		enterRule(_localctx, 8, RULE_member_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 TLLExpressionNode nestedAssignmentName = null; 
			{
			setState(86);
			match(T__2);
			 List<TLLExpressionNode> parameters = new ArrayList<>();
			                                               TLLExpressionNode receiver = factory.createRead(assignmentName); 
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(88);
				((Member_expressionContext)_localctx).sum = sum();
				 parameters.add(((Member_expressionContext)_localctx).sum.result); 
				}
				break;
			case 2:
				{
				setState(91);
				((Member_expressionContext)_localctx).numeric = numeric();
				 parameters.add(((Member_expressionContext)_localctx).numeric.result); 
				}
				break;
			}
			setState(96);
			((Member_expressionContext)_localctx).e = match(T__3);
			 ((Member_expressionContext)_localctx).result =  factory.createCall(receiver, parameters, ((Member_expressionContext)_localctx).e); 
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\nf\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\2\3\2\3\2"+
		"\6\2\26\n\2\r\2\16\2\27\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\7\2!\n\2\f"+
		"\2\16\2$\13\2\3\2\3\2\3\2\3\3\7\3*\n\3\f\3\16\3-\13\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\7\5I\n\5\f\5\16\5L\13\5\3\5\3\5\7\5P\n\5\f"+
		"\5\16\5S\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6a\n\6"+
		"\3\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\2\2k\2\17\3\2\2\2\4+\3\2\2\2\68\3\2"+
		"\2\2\bJ\3\2\2\2\nW\3\2\2\2\f\16\7\7\2\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r"+
		"\3\2\2\2\17\20\3\2\2\2\20\22\3\2\2\2\21\17\3\2\2\2\22\23\7\3\2\2\23\""+
		"\b\2\1\2\24\26\5\4\3\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27\30"+
		"\3\2\2\2\30\31\3\2\2\2\31\35\b\2\1\2\32\34\7\7\2\2\33\32\3\2\2\2\34\37"+
		"\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2 \25\3\2"+
		"\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7\4\2\2&\'"+
		"\b\2\1\2\'\3\3\2\2\2(*\7\7\2\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2"+
		",\66\3\2\2\2-+\3\2\2\2./\5\6\4\2/\60\b\3\1\2\60\67\3\2\2\2\61\62\7\b\2"+
		"\2\62\63\b\3\1\2\63\64\5\n\6\2\64\65\b\3\1\2\65\67\3\2\2\2\66.\3\2\2\2"+
		"\66\61\3\2\2\2\67\5\3\2\2\289\b\4\1\29:\5\b\5\2:>\b\4\1\2;=\7\7\2\2<;"+
		"\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7\t\2\2B"+
		"C\b\4\1\2CD\5\b\5\2DE\b\4\1\2EF\b\4\1\2F\7\3\2\2\2GI\7\7\2\2HG\3\2\2\2"+
		"IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MQ\7\n\2\2NP\7\7\2\2"+
		"ON\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\b\5\1\2"+
		"UV\b\5\1\2V\t\3\2\2\2WX\b\6\1\2XY\7\5\2\2Y`\b\6\1\2Z[\5\6\4\2[\\\b\6\1"+
		"\2\\a\3\2\2\2]^\5\b\5\2^_\b\6\1\2_a\3\2\2\2`Z\3\2\2\2`]\3\2\2\2`a\3\2"+
		"\2\2ab\3\2\2\2bc\7\6\2\2cd\b\6\1\2d\13\3\2\2\2\f\17\27\35\"+\66>JQ`";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}