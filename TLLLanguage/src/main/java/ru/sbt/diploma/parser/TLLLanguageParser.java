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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, WHITESPACE=12, IDENTIFIER=13, OPERATION=14, NUMERIC_LITERAL=15;
	public static final int
		RULE_tlllanguage = 0, RULE_statement = 1, RULE_return_statement = 2, RULE_init_obj = 3, 
		RULE_init = 4, RULE_sum = 5, RULE_numeric = 6, RULE_expression = 7, RULE_member_expression = 8, 
		RULE_array_statement = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"tlllanguage", "statement", "return_statement", "init_obj", "init", "sum", 
			"numeric", "expression", "member_expression", "array_statement"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "'return'", "'@'", "':'", "'='", "'('", "')'", 
			"'.'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"WHITESPACE", "IDENTIFIER", "OPERATION", "NUMERIC_LITERAL"
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
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(20);
				((TlllanguageContext)_localctx).block = match(WHITESPACE);
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(26);
			((TlllanguageContext)_localctx).s = match(T__0);

			                                           factory.startBlock(((TlllanguageContext)_localctx).s, ((TlllanguageContext)_localctx).block);
			                                           List<TLLStatementNode> body = new ArrayList<>(); 
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << WHITESPACE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(28);
				((TlllanguageContext)_localctx).statement = statement();
				 body.add(((TlllanguageContext)_localctx).statement.result); 
				setState(33);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(30);
						match(WHITESPACE);
						}
						} 
					}
					setState(35);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
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
		public Array_statementContext array_statement;
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
		public Array_statementContext array_statement() {
			return getRuleContext(Array_statementContext.class,0);
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
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44);
					((StatementContext)_localctx).r = match(WHITESPACE);
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(50);
				((StatementContext)_localctx).sum = sum();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).sum.result; 
				}
				break;
			case 2:
				{
				{
				setState(53);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				{
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				setState(55);
				((StatementContext)_localctx).member_expression = member_expression(assignmentName);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).member_expression.result; 
				}
				}
				}
				break;
			case 3:
				{
				{
				setState(58);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				{
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				setState(60);
				((StatementContext)_localctx).array_statement = array_statement(assignmentName);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).array_statement.result; 
				}
				}
				}
				break;
			case 4:
				{
				setState(63);
				((StatementContext)_localctx).init_obj = init_obj();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).init_obj.result; 
				}
				break;
			case 5:
				{
				setState(66);
				((StatementContext)_localctx).return_statement = return_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).return_statement.result; 
				}
				break;
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
		public NumericContext numeric;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			((Return_statementContext)_localctx).r = match(T__2);
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				{
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(72);
					match(WHITESPACE);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				((Return_statementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((Return_statementContext)_localctx).IDENTIFIER, false); 
				 TLLExpressionNode read_value = factory.createRead(assignmentName); 
				 ((Return_statementContext)_localctx).result =  factory.createReturn(((Return_statementContext)_localctx).r, read_value); 
				}
				}
				break;
			case 2:
				{
				{
				setState(85);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(82);
						match(WHITESPACE);
						}
						} 
					}
					setState(87);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(88);
				((Return_statementContext)_localctx).numeric = numeric();
				 ((Return_statementContext)_localctx).result =  factory.createReturn(((Return_statementContext)_localctx).r, ((Return_statementContext)_localctx).numeric.result); 
				}
				}
				break;
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
			setState(93);
			match(T__3);
			setState(94);
			((Init_objContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 TLLExpressionNode assignmentName = factory.createStringLiteral(((Init_objContext)_localctx).IDENTIFIER, false); 
			{
			setState(96);
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
			int _alt;
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(99);
					((InitContext)_localctx).s = match(WHITESPACE);
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(105);
				match(T__4);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(106);
					match(WHITESPACE);
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
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
				setState(117);
				match(T__4);
				setState(118);
				((InitContext)_localctx).numeric = numeric();
				 ((InitContext)_localctx).result =  factory.createWriteProperty(assignmentReceiver, assignmentName, ((InitContext)_localctx).numeric.result); 
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(121);
				match(T__5);
				setState(122);
				((InitContext)_localctx).numeric = numeric();
				 TLLExpressionNode index = r;
				 ((InitContext)_localctx).result =  factory.createWriteArrayValue(assignmentName, ((InitContext)_localctx).numeric.result, index); 
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(126);
						match(WHITESPACE);
						}
						} 
					}
					setState(131);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				 ((InitContext)_localctx).result =  null; 
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
			setState(136);
			((SumContext)_localctx).numeric = numeric();
			 leftnode = ((SumContext)_localctx).numeric.result; 
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(138);
				match(WHITESPACE);
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			((SumContext)_localctx).OPERATION = match(OPERATION);
			setState(145);
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
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(149);
				match(WHITESPACE);
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			((NumericContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(156);
					match(WHITESPACE);
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public Array_statementContext array_statement;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public Array_statementContext array_statement() {
			return getRuleContext(Array_statementContext.class,0);
		}
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
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(164);
				((ExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((ExpressionContext)_localctx).IDENTIFIER, false); 
				{
				 ((ExpressionContext)_localctx).result =  factory.createRead(assignmentName); 
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(167);
				((ExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((ExpressionContext)_localctx).IDENTIFIER, false); 
				setState(169);
				((ExpressionContext)_localctx).array_statement = array_statement(assignmentName);
				 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).array_statement.result; 
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
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				 TLLExpressionNode nestedAssignmentName = null;
				                                               List<TLLExpressionNode> parameters = new ArrayList<>(); 
				{
				setState(175);
				match(T__6);
				 TLLExpressionNode receiver = factory.createRead(assignmentName); 
				setState(186);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(177);
					((Member_expressionContext)_localctx).sum = sum();
					 parameters.add(((Member_expressionContext)_localctx).sum.result); 
					}
					break;
				case 2:
					{
					setState(180);
					((Member_expressionContext)_localctx).numeric = numeric();
					 parameters.add(((Member_expressionContext)_localctx).numeric.result); 
					}
					break;
				case 3:
					{
					setState(183);
					((Member_expressionContext)_localctx).expression = expression();
					 parameters.add(((Member_expressionContext)_localctx).expression.result); 
					}
					break;
				}
				setState(188);
				((Member_expressionContext)_localctx).e = match(T__7);
				 ((Member_expressionContext)_localctx).result =  factory.createCall(receiver, parameters, ((Member_expressionContext)_localctx).e); 
				}
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(190);
				match(T__8);
				 TLLExpressionNode receiver = factory.createRead(assignmentName); 
				setState(192);
				((Member_expressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode nestedAssignmentName = factory.createStringLiteral(((Member_expressionContext)_localctx).IDENTIFIER, false); 
				 ((Member_expressionContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				setState(195);
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

	public static class Array_statementContext extends ParserRuleContext {
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode result;
		public Token s;
		public Token NUMERIC_LITERAL;
		public Token e;
		public InitContext init;
		public TerminalNode NUMERIC_LITERAL() { return getToken(TLLLanguageParser.NUMERIC_LITERAL, 0); }
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public Array_statementContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Array_statementContext(ParserRuleContext parent, int invokingState, TLLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_array_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterArray_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitArray_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitArray_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_statementContext array_statement(TLLExpressionNode assignmentName) throws RecognitionException {
		Array_statementContext _localctx = new Array_statementContext(_ctx, getState(), assignmentName);
		enterRule(_localctx, 18, RULE_array_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(200);
			((Array_statementContext)_localctx).s = match(T__9);
			setState(201);
			((Array_statementContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			 TLLExpressionNode index = factory.createNumericLiteral(((Array_statementContext)_localctx).NUMERIC_LITERAL); 
			setState(203);
			((Array_statementContext)_localctx).e = match(T__10);
			setState(207);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(204);
					match(WHITESPACE);
					}
					} 
				}
				setState(209);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(210);
			((Array_statementContext)_localctx).init = init(index, null, assignmentName);
			 TLLExpressionNode initResult = ((Array_statementContext)_localctx).init.result; 
			  if (initResult == null) {
			                                                    ((Array_statementContext)_localctx).result =  factory.createReadArrayValue(assignmentName, ((Array_statementContext)_localctx).NUMERIC_LITERAL);
			                                                } else {
			                                                    ((Array_statementContext)_localctx).result =  initResult;
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21\u00d9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\7\2\30\n\2\f\2\16\2\33\13\2\3\2\3\2\3\2\3\2\3\2\7\2\"\n\2\f"+
		"\2\16\2%\13\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\2\3\3\7\3\60\n\3\f\3"+
		"\16\3\63\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4\3\4"+
		"\3\4\3\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\3\4\3\4\3\4\5\4^\n\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\7\6g\n\6\f\6\16\6j\13\6\3\6\3\6\7\6n\n\6\f\6\16\6q\13"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0082"+
		"\n\6\f\6\16\6\u0085\13\6\3\6\5\6\u0088\n\6\3\7\3\7\3\7\3\7\7\7\u008e\n"+
		"\7\f\7\16\7\u0091\13\7\3\7\3\7\3\7\3\7\3\7\3\b\7\b\u0099\n\b\f\b\16\b"+
		"\u009c\13\b\3\b\3\b\7\b\u00a0\n\b\f\b\16\b\u00a3\13\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00af\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u00bd\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00c9\n\n\3\13\3\13\3\13\3\13\3\13\7\13\u00d0\n\13\f\13\16\13\u00d3"+
		"\13\13\3\13\3\13\3\13\3\13\3\13\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\2\u00e8"+
		"\2\31\3\2\2\2\4\61\3\2\2\2\6I\3\2\2\2\b_\3\2\2\2\n\u0087\3\2\2\2\f\u0089"+
		"\3\2\2\2\16\u009a\3\2\2\2\20\u00ae\3\2\2\2\22\u00c8\3\2\2\2\24\u00ca\3"+
		"\2\2\2\26\30\7\16\2\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2\2\31\32"+
		"\3\2\2\2\32\34\3\2\2\2\33\31\3\2\2\2\34\35\7\3\2\2\35(\b\2\1\2\36\37\5"+
		"\4\3\2\37#\b\2\1\2 \"\7\16\2\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2"+
		"\2$\'\3\2\2\2%#\3\2\2\2&\36\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3"+
		"\2\2\2*(\3\2\2\2+,\7\4\2\2,-\b\2\1\2-\3\3\2\2\2.\60\7\16\2\2/.\3\2\2\2"+
		"\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62G\3\2\2\2\63\61\3\2\2\2\64"+
		"\65\5\f\7\2\65\66\b\3\1\2\66H\3\2\2\2\678\7\17\2\289\b\3\1\29:\5\22\n"+
		"\2:;\b\3\1\2;H\3\2\2\2<=\7\17\2\2=>\b\3\1\2>?\5\24\13\2?@\b\3\1\2@H\3"+
		"\2\2\2AB\5\b\5\2BC\b\3\1\2CH\3\2\2\2DE\5\6\4\2EF\b\3\1\2FH\3\2\2\2G\64"+
		"\3\2\2\2G\67\3\2\2\2G<\3\2\2\2GA\3\2\2\2GD\3\2\2\2H\5\3\2\2\2I]\7\5\2"+
		"\2JL\7\16\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2"+
		"\2\2PQ\7\17\2\2QR\b\4\1\2RS\b\4\1\2S^\b\4\1\2TV\7\16\2\2UT\3\2\2\2VY\3"+
		"\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\5\16\b\2[\\\b\4\1\2\\"+
		"^\3\2\2\2]M\3\2\2\2]W\3\2\2\2^\7\3\2\2\2_`\7\6\2\2`a\7\17\2\2ab\b\5\1"+
		"\2bc\5\n\6\2cd\b\5\1\2d\t\3\2\2\2eg\7\16\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2"+
		"\2\2hi\3\2\2\2ik\3\2\2\2jh\3\2\2\2ko\7\7\2\2ln\7\16\2\2ml\3\2\2\2nq\3"+
		"\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7\17\2\2st\b\6\1\2tu"+
		"\b\6\1\2uv\b\6\1\2v\u0088\b\6\1\2wx\7\7\2\2xy\5\16\b\2yz\b\6\1\2z\u0088"+
		"\3\2\2\2{|\7\b\2\2|}\5\16\b\2}~\b\6\1\2~\177\b\6\1\2\177\u0088\3\2\2\2"+
		"\u0080\u0082\7\16\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0088\b\6\1\2\u0087h\3\2\2\2\u0087w\3\2\2\2\u0087{\3\2\2\2\u0087\u0083"+
		"\3\2\2\2\u0088\13\3\2\2\2\u0089\u008a\b\7\1\2\u008a\u008b\5\16\b\2\u008b"+
		"\u008f\b\7\1\2\u008c\u008e\7\16\2\2\u008d\u008c\3\2\2\2\u008e\u0091\3"+
		"\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0093\7\20\2\2\u0093\u0094\5\16\b\2\u0094\u0095\b"+
		"\7\1\2\u0095\u0096\b\7\1\2\u0096\r\3\2\2\2\u0097\u0099\7\16\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u00a1\7\21\2\2\u009e"+
		"\u00a0\7\16\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a5\b\b\1\2\u00a5\17\3\2\2\2\u00a6\u00a7\7\17\2\2\u00a7\u00a8\b\t\1"+
		"\2\u00a8\u00af\b\t\1\2\u00a9\u00aa\7\17\2\2\u00aa\u00ab\b\t\1\2\u00ab"+
		"\u00ac\5\24\13\2\u00ac\u00ad\b\t\1\2\u00ad\u00af\3\2\2\2\u00ae\u00a6\3"+
		"\2\2\2\u00ae\u00a9\3\2\2\2\u00af\21\3\2\2\2\u00b0\u00b1\b\n\1\2\u00b1"+
		"\u00b2\7\t\2\2\u00b2\u00bc\b\n\1\2\u00b3\u00b4\5\f\7\2\u00b4\u00b5\b\n"+
		"\1\2\u00b5\u00bd\3\2\2\2\u00b6\u00b7\5\16\b\2\u00b7\u00b8\b\n\1\2\u00b8"+
		"\u00bd\3\2\2\2\u00b9\u00ba\5\20\t\2\u00ba\u00bb\b\n\1\2\u00bb\u00bd\3"+
		"\2\2\2\u00bc\u00b3\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bc\u00b9\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\7\n\2\2\u00bf\u00c9\b\n"+
		"\1\2\u00c0\u00c1\7\13\2\2\u00c1\u00c2\b\n\1\2\u00c2\u00c3\7\17\2\2\u00c3"+
		"\u00c4\b\n\1\2\u00c4\u00c5\b\n\1\2\u00c5\u00c6\5\n\6\2\u00c6\u00c7\b\n"+
		"\1\2\u00c7\u00c9\3\2\2\2\u00c8\u00b0\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c9"+
		"\23\3\2\2\2\u00ca\u00cb\7\f\2\2\u00cb\u00cc\7\21\2\2\u00cc\u00cd\b\13"+
		"\1\2\u00cd\u00d1\7\r\2\2\u00ce\u00d0\7\16\2\2\u00cf\u00ce\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2"+
		"\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d5\5\n\6\2\u00d5\u00d6\b\13\1\2\u00d6"+
		"\u00d7\b\13\1\2\u00d7\25\3\2\2\2\25\31#(\61GMW]ho\u0083\u0087\u008f\u009a"+
		"\u00a1\u00ae\u00bc\u00c8\u00d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}