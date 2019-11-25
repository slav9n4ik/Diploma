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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, WHITESPACE=9, 
		IDENTIFIER=10, OPERATION=11, NUMERIC_LITERAL=12;
	public static final int
		RULE_tlllanguage = 0, RULE_statement = 1, RULE_return_statement = 2, RULE_init_obj = 3, 
		RULE_init = 4, RULE_sum = 5, RULE_numeric = 6, RULE_expression = 7, RULE_member_expression = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"tlllanguage", "statement", "return_statement", "init_obj", "init", "sum", 
			"numeric", "expression", "member_expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "'return'", "'@'", "':'", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "WHITESPACE", "IDENTIFIER", 
			"OPERATION", "NUMERIC_LITERAL"
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitTlllanguage(this);
			else return visitor.visitChildren(this);
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(18);
				((TlllanguageContext)_localctx).block = match(WHITESPACE);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(24);
			((TlllanguageContext)_localctx).s = match(T__0);

			                                           factory.startBlock(((TlllanguageContext)_localctx).s, ((TlllanguageContext)_localctx).block);
			                                           List<TLLStatementNode> body = new ArrayList<>(); 
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << WHITESPACE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(26);
				((TlllanguageContext)_localctx).statement = statement();
				 body.add(((TlllanguageContext)_localctx).statement.result); 
				setState(31);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(28);
						match(WHITESPACE);
						}
						} 
					}
					setState(33);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
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
		public Init_objContext init_obj;
		public Return_statementContext return_statement;
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public Init_objContext init_obj() {
			return getRuleContext(Init_objContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(42);
					((StatementContext)_localctx).r = match(WHITESPACE);
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHITESPACE:
			case NUMERIC_LITERAL:
				{
				setState(48);
				((StatementContext)_localctx).sum = sum();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).sum.result; 
				}
				break;
			case IDENTIFIER:
				{
				{
				setState(51);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				{
				setState(53);
				((StatementContext)_localctx).member_expression = member_expression(assignmentName);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).member_expression.result; 
				}
				}
				}
				break;
			case T__3:
				{
				setState(56);
				((StatementContext)_localctx).init_obj = init_obj();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).init_obj.result; 
				}
				break;
			case T__2:
				{
				setState(59);
				((StatementContext)_localctx).return_statement = return_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).return_statement.result; 
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

	public static class Return_statementContext extends ParserRuleContext {
		public TLLStatementNode result;
		public Token r;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitReturn_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			((Return_statementContext)_localctx).r = match(T__2);
			 TLLExpressionNode value = null; 
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(66);
				match(WHITESPACE);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			((Return_statementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 TLLExpressionNode assignmentName = factory.createStringLiteral(((Return_statementContext)_localctx).IDENTIFIER, false); 
			 TLLExpressionNode read_value = factory.createRead(assignmentName); 
			 ((Return_statementContext)_localctx).result =  factory.createReturn(((Return_statementContext)_localctx).r, read_value); 
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

	public static class Init_objContext extends ParserRuleContext {
		public TLLExpressionNode result;
		public Token IDENTIFIER;
		public InitContext init;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public Init_objContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterInit_obj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitInit_obj(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitInit_obj(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_objContext init_obj() throws RecognitionException {
		Init_objContext _localctx = new Init_objContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_init_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(77);
			match(T__3);
			setState(78);
			((Init_objContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 TLLExpressionNode assignmentName = factory.createStringLiteral(((Init_objContext)_localctx).IDENTIFIER, false); 
			{
			setState(80);
			((Init_objContext)_localctx).init = init(null, null, assignmentName);
			 ((Init_objContext)_localctx).result =  ((Init_objContext)_localctx).init.result; 
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

	public static class InitContext extends ParserRuleContext {
		public TLLExpressionNode r;
		public TLLExpressionNode assignmentReceiver;
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode result;
		public Token s;
		public Token IDENTIFIER;
		public NumericContext numeric;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public InitContext(ParserRuleContext parent, int invokingState, TLLExpressionNode r, TLLExpressionNode assignmentReceiver, TLLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.r = r;
			this.assignmentReceiver = assignmentReceiver;
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitContext init(TLLExpressionNode r,TLLExpressionNode assignmentReceiver,TLLExpressionNode assignmentName) throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState(), r, assignmentReceiver, assignmentName);
		enterRule(_localctx, 8, RULE_init);
		int _la;
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(83);
					((InitContext)_localctx).s = match(WHITESPACE);
					}
					}
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(89);
				match(T__4);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(90);
					match(WHITESPACE);
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				((InitContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode receiver = factory.createRead(assignmentName); 
				 TLLExpressionNode newEmptyObj = factory.createCall(receiver, Collections.emptyList(), ((InitContext)_localctx).IDENTIFIER); 
				 TLLExpressionNode localVarName = factory.createStringLiteral(((InitContext)_localctx).IDENTIFIER, false); 
				 if (assignmentReceiver == null) {
				                                            ((InitContext)_localctx).result =  factory.createAssignment(localVarName, newEmptyObj);
				                                          } else {
				                                            ((InitContext)_localctx).result =  factory.createWriteProperty(assignmentReceiver, assignmentName, localVarName);
				                                          }
				                                        
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(101);
				match(T__4);
				setState(102);
				((InitContext)_localctx).numeric = numeric();
				 ((InitContext)_localctx).result =  factory.createWriteProperty(assignmentReceiver, assignmentName, ((InitContext)_localctx).numeric.result); 
				}
				}
				break;
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		SumContext _localctx = new SumContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sum);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 TLLExpressionNode leftnode, rightnode;  
			setState(108);
			((SumContext)_localctx).numeric = numeric();
			 leftnode = ((SumContext)_localctx).numeric.result; 
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(110);
				match(WHITESPACE);
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			((SumContext)_localctx).OPERATION = match(OPERATION);
			setState(117);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitNumeric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericContext numeric() throws RecognitionException {
		NumericContext _localctx = new NumericContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_numeric);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(121);
				match(WHITESPACE);
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			((NumericContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(128);
					match(WHITESPACE);
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
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

	public static class ExpressionContext extends ParserRuleContext {
		public TLLExpressionNode result;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(136);
			((ExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 TLLExpressionNode assignmentName = factory.createStringLiteral(((ExpressionContext)_localctx).IDENTIFIER, false); 
			{
			 ((ExpressionContext)_localctx).result =  factory.createRead(assignmentName); 
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

	public static class Member_expressionContext extends ParserRuleContext {
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode result;
		public SumContext sum;
		public NumericContext numeric;
		public ExpressionContext expression;
		public Token e;
		public Token IDENTIFIER;
		public InitContext init;
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitMember_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_expressionContext member_expression(TLLExpressionNode assignmentName) throws RecognitionException {
		Member_expressionContext _localctx = new Member_expressionContext(_ctx, getState(), assignmentName);
		enterRule(_localctx, 16, RULE_member_expression);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				 TLLExpressionNode nestedAssignmentName = null;
				                                               List<TLLExpressionNode> parameters = new ArrayList<>(); 
				{
				setState(141);
				match(T__5);
				 TLLExpressionNode receiver = factory.createRead(assignmentName); 
				setState(152);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(143);
					((Member_expressionContext)_localctx).sum = sum();
					 parameters.add(((Member_expressionContext)_localctx).sum.result); 
					}
					break;
				case 2:
					{
					setState(146);
					((Member_expressionContext)_localctx).numeric = numeric();
					 parameters.add(((Member_expressionContext)_localctx).numeric.result); 
					}
					break;
				case 3:
					{
					setState(149);
					((Member_expressionContext)_localctx).expression = expression();
					 parameters.add(((Member_expressionContext)_localctx).expression.result); 
					}
					break;
				}
				setState(154);
				((Member_expressionContext)_localctx).e = match(T__6);
				 ((Member_expressionContext)_localctx).result =  factory.createCall(receiver, parameters, ((Member_expressionContext)_localctx).e); 
				}
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(156);
				match(T__7);
				 TLLExpressionNode receiver = factory.createRead(assignmentName); 
				setState(158);
				((Member_expressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode nestedAssignmentName = factory.createStringLiteral(((Member_expressionContext)_localctx).IDENTIFIER, false); 
				 ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				setState(161);
				((Member_expressionContext)_localctx).init = init(_localctx.result, receiver, nestedAssignmentName);
				 ((Member_expressionContext)_localctx).result =  ((Member_expressionContext)_localctx).init.result; 
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16\u00a9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7"+
		"\2\26\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2"+
		"\7\2%\n\2\f\2\16\2(\13\2\3\2\3\2\3\2\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\4\3\4"+
		"\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\7\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6l\n\6\3\7\3\7\3\7\3\7\7\7r\n\7\f\7\16"+
		"\7u\13\7\3\7\3\7\3\7\3\7\3\7\3\b\7\b}\n\b\f\b\16\b\u0080\13\b\3\b\3\b"+
		"\7\b\u0084\n\b\f\b\16\b\u0087\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u009b\n\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00a7\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2"+
		"\2\u00b1\2\27\3\2\2\2\4/\3\2\2\2\6B\3\2\2\2\bO\3\2\2\2\nk\3\2\2\2\fm\3"+
		"\2\2\2\16~\3\2\2\2\20\u008a\3\2\2\2\22\u00a6\3\2\2\2\24\26\7\13\2\2\25"+
		"\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31"+
		"\27\3\2\2\2\32\33\7\3\2\2\33&\b\2\1\2\34\35\5\4\3\2\35!\b\2\1\2\36 \7"+
		"\13\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"%\3\2\2\2#!\3"+
		"\2\2\2$\34\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2"+
		")*\7\4\2\2*+\b\2\1\2+\3\3\2\2\2,.\7\13\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2"+
		"\2\2/\60\3\2\2\2\60@\3\2\2\2\61/\3\2\2\2\62\63\5\f\7\2\63\64\b\3\1\2\64"+
		"A\3\2\2\2\65\66\7\f\2\2\66\67\b\3\1\2\678\5\22\n\289\b\3\1\29A\3\2\2\2"+
		":;\5\b\5\2;<\b\3\1\2<A\3\2\2\2=>\5\6\4\2>?\b\3\1\2?A\3\2\2\2@\62\3\2\2"+
		"\2@\65\3\2\2\2@:\3\2\2\2@=\3\2\2\2A\5\3\2\2\2BC\7\5\2\2CG\b\4\1\2DF\7"+
		"\13\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK"+
		"\7\f\2\2KL\b\4\1\2LM\b\4\1\2MN\b\4\1\2N\7\3\2\2\2OP\7\6\2\2PQ\7\f\2\2"+
		"QR\b\5\1\2RS\5\n\6\2ST\b\5\1\2T\t\3\2\2\2UW\7\13\2\2VU\3\2\2\2WZ\3\2\2"+
		"\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[_\7\7\2\2\\^\7\13\2\2]\\\3"+
		"\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7\f\2\2cd\b"+
		"\6\1\2de\b\6\1\2ef\b\6\1\2fl\b\6\1\2gh\7\7\2\2hi\5\16\b\2ij\b\6\1\2jl"+
		"\3\2\2\2kX\3\2\2\2kg\3\2\2\2l\13\3\2\2\2mn\b\7\1\2no\5\16\b\2os\b\7\1"+
		"\2pr\7\13\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2"+
		"\2\2vw\7\r\2\2wx\5\16\b\2xy\b\7\1\2yz\b\7\1\2z\r\3\2\2\2{}\7\13\2\2|{"+
		"\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080"+
		"~\3\2\2\2\u0081\u0085\7\16\2\2\u0082\u0084\7\13\2\2\u0083\u0082\3\2\2"+
		"\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088"+
		"\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\b\b\1\2\u0089\17\3\2\2\2\u008a"+
		"\u008b\7\f\2\2\u008b\u008c\b\t\1\2\u008c\u008d\b\t\1\2\u008d\21\3\2\2"+
		"\2\u008e\u008f\b\n\1\2\u008f\u0090\7\b\2\2\u0090\u009a\b\n\1\2\u0091\u0092"+
		"\5\f\7\2\u0092\u0093\b\n\1\2\u0093\u009b\3\2\2\2\u0094\u0095\5\16\b\2"+
		"\u0095\u0096\b\n\1\2\u0096\u009b\3\2\2\2\u0097\u0098\5\20\t\2\u0098\u0099"+
		"\b\n\1\2\u0099\u009b\3\2\2\2\u009a\u0091\3\2\2\2\u009a\u0094\3\2\2\2\u009a"+
		"\u0097\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\7\t"+
		"\2\2\u009d\u00a7\b\n\1\2\u009e\u009f\7\n\2\2\u009f\u00a0\b\n\1\2\u00a0"+
		"\u00a1\7\f\2\2\u00a1\u00a2\b\n\1\2\u00a2\u00a3\b\n\1\2\u00a3\u00a4\5\n"+
		"\6\2\u00a4\u00a5\b\n\1\2\u00a5\u00a7\3\2\2\2\u00a6\u008e\3\2\2\2\u00a6"+
		"\u009e\3\2\2\2\u00a7\23\3\2\2\2\20\27!&/@GX_ks~\u0085\u009a\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}