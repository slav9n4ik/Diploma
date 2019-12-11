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
		T__9=10, WHITESPACE=11, IDENTIFIER=12, OPERATION=13, NUMERIC_LITERAL=14;
	public static final int
		RULE_tlllanguage = 0, RULE_statement = 1, RULE_return_statement = 2, RULE_expression = 3, 
		RULE_init_obj = 4, RULE_init_prop = 5, RULE_init = 6, RULE_builtin_functions = 7, 
		RULE_array_statement = 8, RULE_binary = 9, RULE_numeric = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"tlllanguage", "statement", "return_statement", "expression", "init_obj", 
			"init_prop", "init", "builtin_functions", "array_statement", "binary", 
			"numeric"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "'return'", "'@'", "'.'", "':'", "'('", "')'", 
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(22);
				((TlllanguageContext)_localctx).block = match(WHITESPACE);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(28);
			((TlllanguageContext)_localctx).s = match(T__0);

			                                           factory.startBlock(((TlllanguageContext)_localctx).s, ((TlllanguageContext)_localctx).block);
			                                           List<TLLStatementNode> body = new ArrayList<>(); 
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << WHITESPACE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(30);
				((TlllanguageContext)_localctx).statement = statement();
				 body.add(((TlllanguageContext)_localctx).statement.result); 
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(32);
						match(WHITESPACE);
						}
						} 
					}
					setState(37);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
		public Token IDENTIFIER;
		public Builtin_functionsContext builtin_functions;
		public Init_objContext init_obj;
		public Return_statementContext return_statement;
		public ExpressionContext expression;
		public Init_propContext init_prop;
		public Init_objContext init_obj() {
			return getRuleContext(Init_objContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public Init_propContext init_prop() {
			return getRuleContext(Init_propContext.class,0);
		}
		public Builtin_functionsContext builtin_functions() {
			return getRuleContext(Builtin_functionsContext.class,0);
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
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(46);
					((StatementContext)_localctx).r = match(WHITESPACE);
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				{
				setState(52);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				{
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				setState(54);
				((StatementContext)_localctx).builtin_functions = builtin_functions(assignmentName);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).builtin_functions.result; 
				}
				}
				}
				break;
			case 2:
				{
				setState(57);
				((StatementContext)_localctx).init_obj = init_obj();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).init_obj.result; 
				}
				break;
			case 3:
				{
				setState(60);
				((StatementContext)_localctx).return_statement = return_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).return_statement.result; 
				}
				break;
			case 4:
				{
				setState(63);
				((StatementContext)_localctx).expression = expression();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).expression.result; 
				}
				break;
			case 5:
				{
				setState(66);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				{
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				setState(68);
				((StatementContext)_localctx).init_prop = init_prop(assignmentName);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).init_prop.result; 
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

	public static class Return_statementContext extends ParserRuleContext {
		public TLLStatementNode result;
		public Token r;
		public ExpressionContext expression;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			((Return_statementContext)_localctx).r = match(T__2);
			{
			setState(74);
			((Return_statementContext)_localctx).expression = expression();
			 TLLExpressionNode read_value = ((Return_statementContext)_localctx).expression.result; 
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

	public static class ExpressionContext extends ParserRuleContext {
		public TLLExpressionNode result;
		public Token IDENTIFIER;
		public Array_statementContext array_statement;
		public Init_propContext init_prop;
		public BinaryContext binary;
		public NumericContext numeric;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public Array_statementContext array_statement() {
			return getRuleContext(Array_statementContext.class,0);
		}
		public Init_propContext init_prop() {
			return getRuleContext(Init_propContext.class,0);
		}
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
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
		enterRule(_localctx, 6, RULE_expression);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(78);
					match(WHITESPACE);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(84);
				((ExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((ExpressionContext)_localctx).IDENTIFIER, false); 
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__2:
				case T__3:
				case T__7:
				case WHITESPACE:
				case IDENTIFIER:
				case NUMERIC_LITERAL:
					{
					{
					 ((ExpressionContext)_localctx).result =  factory.createRead(assignmentName); 
					}
					}
					break;
				case T__8:
					{
					{
					setState(87);
					((ExpressionContext)_localctx).array_statement = array_statement(assignmentName, null);
					 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).array_statement.result; 
					}
					}
					break;
				case T__4:
					{
					{
					setState(90);
					((ExpressionContext)_localctx).init_prop = init_prop(assignmentName);
					 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).init_prop.result; 
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(95);
				((ExpressionContext)_localctx).binary = binary();
				 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).binary.result; 
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				((ExpressionContext)_localctx).numeric = numeric();
				 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).numeric.result; 
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
		enterRule(_localctx, 8, RULE_init_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(103);
			match(T__3);
			setState(104);
			((Init_objContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 TLLExpressionNode assignmentName = factory.createStringLiteral(((Init_objContext)_localctx).IDENTIFIER, false); 
			{
			setState(106);
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

	public static class Init_propContext extends ParserRuleContext {
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode result;
		public Token IDENTIFIER;
		public InitContext init;
		public Array_statementContext array_statement;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public Array_statementContext array_statement() {
			return getRuleContext(Array_statementContext.class,0);
		}
		public Init_propContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Init_propContext(ParserRuleContext parent, int invokingState, TLLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_init_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterInit_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitInit_prop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitInit_prop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Init_propContext init_prop(TLLExpressionNode assignmentName) throws RecognitionException {
		Init_propContext _localctx = new Init_propContext(_ctx, getState(), assignmentName);
		enterRule(_localctx, 10, RULE_init_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(109);
			match(T__4);
			 TLLExpressionNode receiver = factory.createRead(assignmentName); 
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(111);
				((Init_propContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode nestedAssignmentName = factory.createStringLiteral(((Init_propContext)_localctx).IDENTIFIER, false); 
				 ((Init_propContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				 TLLExpressionNode readResult = _localctx.result; 
				setState(115);
				((Init_propContext)_localctx).init = init(null, receiver, nestedAssignmentName);

				                                                if(((Init_propContext)_localctx).init.result != null) {
				                                                    ((Init_propContext)_localctx).result =  ((Init_propContext)_localctx).init.result;
				                                                } else {
				                                                    ((Init_propContext)_localctx).result =  readResult;
				                                                }
				                                            
				}
				}
				break;
			case 2:
				{
				{
				setState(118);
				((Init_propContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode propName = factory.createStringLiteral(((Init_propContext)_localctx).IDENTIFIER, false); 
				setState(120);
				((Init_propContext)_localctx).array_statement = array_statement(propName, receiver);
				 ((Init_propContext)_localctx).result =  ((Init_propContext)_localctx).array_statement.result; 
				}
				}
				break;
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
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 12, RULE_init);
		int _la;
		try {
			int _alt;
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(125);
					((InitContext)_localctx).s = match(WHITESPACE);
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(131);
				match(T__5);
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(132);
						match(WHITESPACE);
						}
						} 
					}
					setState(137);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(147);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(138);
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
					break;
				case WHITESPACE:
				case NUMERIC_LITERAL:
					{
					setState(143);
					((InitContext)_localctx).numeric = numeric();
					 TLLExpressionNode index = r;

					                                                if (index != null) {
					                                                    if(assignmentReceiver == null) {
					                                                        ((InitContext)_localctx).result =  factory.createWriteArrayValue(assignmentName, ((InitContext)_localctx).numeric.result, index);
					                                                    } else {
					                                                        ((InitContext)_localctx).result =  factory.createWriteArrayProperty(assignmentReceiver, assignmentName,((InitContext)_localctx).numeric.result, index);
					                                                    }
					                                                } else {
					                                                    ((InitContext)_localctx).result =  factory.createWriteProperty(assignmentReceiver, assignmentName, ((InitContext)_localctx).numeric.result);
					                                                }
					                                            
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(149);
						match(WHITESPACE);
						}
						} 
					}
					setState(154);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Builtin_functionsContext extends ParserRuleContext {
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode result;
		public NumericContext numeric;
		public ExpressionContext expression;
		public Token e;
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Builtin_functionsContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Builtin_functionsContext(ParserRuleContext parent, int invokingState, TLLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_builtin_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterBuiltin_functions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitBuiltin_functions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitBuiltin_functions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Builtin_functionsContext builtin_functions(TLLExpressionNode assignmentName) throws RecognitionException {
		Builtin_functionsContext _localctx = new Builtin_functionsContext(_ctx, getState(), assignmentName);
		enterRule(_localctx, 14, RULE_builtin_functions);
		try {
			enterOuterAlt(_localctx, 1);
			{
			 TLLExpressionNode nestedAssignmentName = null;
			                                              List<TLLExpressionNode> parameters = new ArrayList<>(); 
			{
			setState(159);
			match(T__6);
			 TLLExpressionNode receiver = factory.createRead(assignmentName); 
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(161);
				((Builtin_functionsContext)_localctx).numeric = numeric();
				 parameters.add(((Builtin_functionsContext)_localctx).numeric.result); 
				}
				break;
			case 2:
				{
				setState(164);
				((Builtin_functionsContext)_localctx).expression = expression();
				 parameters.add(((Builtin_functionsContext)_localctx).expression.result); 
				}
				break;
			}
			setState(169);
			((Builtin_functionsContext)_localctx).e = match(T__7);
			 ((Builtin_functionsContext)_localctx).result =  factory.createCall(receiver, parameters, ((Builtin_functionsContext)_localctx).e); 
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

	public static class Array_statementContext extends ParserRuleContext {
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode receiver;
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
		public Array_statementContext(ParserRuleContext parent, int invokingState, TLLExpressionNode assignmentName, TLLExpressionNode receiver) {
			super(parent, invokingState);
			this.assignmentName = assignmentName;
			this.receiver = receiver;
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

	public final Array_statementContext array_statement(TLLExpressionNode assignmentName,TLLExpressionNode receiver) throws RecognitionException {
		Array_statementContext _localctx = new Array_statementContext(_ctx, getState(), assignmentName, receiver);
		enterRule(_localctx, 16, RULE_array_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172);
			((Array_statementContext)_localctx).s = match(T__8);
			setState(173);
			((Array_statementContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			 TLLExpressionNode index = factory.createNumericLiteral(((Array_statementContext)_localctx).NUMERIC_LITERAL); 
			setState(175);
			((Array_statementContext)_localctx).e = match(T__9);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(176);
					match(WHITESPACE);
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(182);
			((Array_statementContext)_localctx).init = init(index, receiver, assignmentName);
			 TLLExpressionNode initResult = ((Array_statementContext)_localctx).init.result; 
			  if (initResult == null) {
			                                                    if (receiver == null) {
			                                                        ((Array_statementContext)_localctx).result =  factory.createReadArrayValue(assignmentName, ((Array_statementContext)_localctx).NUMERIC_LITERAL);
			                                                    } else {
			                                                        ((Array_statementContext)_localctx).result =  factory.createReadArrayProperty(receiver, assignmentName, ((Array_statementContext)_localctx).NUMERIC_LITERAL);
			                                                    }
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

	public static class BinaryContext extends ParserRuleContext {
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
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_binary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			 TLLExpressionNode leftnode, rightnode;  
			setState(187);
			((BinaryContext)_localctx).numeric = numeric();
			 leftnode = ((BinaryContext)_localctx).numeric.result; 
			setState(189);
			((BinaryContext)_localctx).OPERATION = match(OPERATION);
			setState(190);
			((BinaryContext)_localctx).numeric = numeric();
			 rightnode = ((BinaryContext)_localctx).numeric.result; 
			 ((BinaryContext)_localctx).result =  factory.createBinary(((BinaryContext)_localctx).OPERATION, leftnode, rightnode); 
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
		enterRule(_localctx, 20, RULE_numeric);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(194);
				match(WHITESPACE);
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
			((NumericContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(201);
					match(WHITESPACE);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20\u00d4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\2\3\2\3\2\7\2"+
		"$\n\2\f\2\16\2\'\13\2\7\2)\n\2\f\2\16\2,\13\2\3\2\3\2\3\2\3\3\7\3\62\n"+
		"\3\f\3\16\3\65\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\3\4\3\5\7\5R\n\5\f"+
		"\5\16\5U\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5`\n\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5h\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7~\n\7\3\b\7\b\u0081\n\b\f\b\16\b\u0084"+
		"\13\b\3\b\3\b\7\b\u0088\n\b\f\b\16\b\u008b\13\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\b\u0096\n\b\3\b\7\b\u0099\n\b\f\b\16\b\u009c\13\b\3\b"+
		"\5\b\u009f\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00aa\n\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\7\n\u00b4\n\n\f\n\16\n\u00b7\13\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\7\f\u00c6\n\f\f\f\16"+
		"\f\u00c9\13\f\3\f\3\f\7\f\u00cd\n\f\f\f\16\f\u00d0\13\f\3\f\3\f\3\f\2"+
		"\2\r\2\4\6\b\n\f\16\20\22\24\26\2\2\2\u00e0\2\33\3\2\2\2\4\63\3\2\2\2"+
		"\6K\3\2\2\2\bg\3\2\2\2\ni\3\2\2\2\fo\3\2\2\2\16\u009e\3\2\2\2\20\u00a0"+
		"\3\2\2\2\22\u00ae\3\2\2\2\24\u00bc\3\2\2\2\26\u00c7\3\2\2\2\30\32\7\r"+
		"\2\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2"+
		"\2\2\35\33\3\2\2\2\36\37\7\3\2\2\37*\b\2\1\2 !\5\4\3\2!%\b\2\1\2\"$\7"+
		"\r\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&)\3\2\2\2\'%\3\2\2\2"+
		"( \3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\4\2\2"+
		"./\b\2\1\2/\3\3\2\2\2\60\62\7\r\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61"+
		"\3\2\2\2\63\64\3\2\2\2\64I\3\2\2\2\65\63\3\2\2\2\66\67\7\16\2\2\678\b"+
		"\3\1\289\5\20\t\29:\b\3\1\2:J\3\2\2\2;<\5\n\6\2<=\b\3\1\2=J\3\2\2\2>?"+
		"\5\6\4\2?@\b\3\1\2@J\3\2\2\2AB\5\b\5\2BC\b\3\1\2CJ\3\2\2\2DE\7\16\2\2"+
		"EF\b\3\1\2FG\5\f\7\2GH\b\3\1\2HJ\3\2\2\2I\66\3\2\2\2I;\3\2\2\2I>\3\2\2"+
		"\2IA\3\2\2\2ID\3\2\2\2J\5\3\2\2\2KL\7\5\2\2LM\5\b\5\2MN\b\4\1\2NO\b\4"+
		"\1\2O\7\3\2\2\2PR\7\r\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3"+
		"\2\2\2US\3\2\2\2VW\7\16\2\2W_\b\5\1\2X`\b\5\1\2YZ\5\22\n\2Z[\b\5\1\2["+
		"`\3\2\2\2\\]\5\f\7\2]^\b\5\1\2^`\3\2\2\2_X\3\2\2\2_Y\3\2\2\2_\\\3\2\2"+
		"\2`h\3\2\2\2ab\5\24\13\2bc\b\5\1\2ch\3\2\2\2de\5\26\f\2ef\b\5\1\2fh\3"+
		"\2\2\2gS\3\2\2\2ga\3\2\2\2gd\3\2\2\2h\t\3\2\2\2ij\7\6\2\2jk\7\16\2\2k"+
		"l\b\6\1\2lm\5\16\b\2mn\b\6\1\2n\13\3\2\2\2op\7\7\2\2p}\b\7\1\2qr\7\16"+
		"\2\2rs\b\7\1\2st\b\7\1\2tu\b\7\1\2uv\5\16\b\2vw\b\7\1\2w~\3\2\2\2xy\7"+
		"\16\2\2yz\b\7\1\2z{\5\22\n\2{|\b\7\1\2|~\3\2\2\2}q\3\2\2\2}x\3\2\2\2~"+
		"\r\3\2\2\2\177\u0081\7\r\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2"+
		"\2\2\u0085\u0089\7\b\2\2\u0086\u0088\7\r\2\2\u0087\u0086\3\2\2\2\u0088"+
		"\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0095\3\2"+
		"\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7\16\2\2\u008d\u008e\b\b\1\2\u008e"+
		"\u008f\b\b\1\2\u008f\u0090\b\b\1\2\u0090\u0096\b\b\1\2\u0091\u0092\5\26"+
		"\f\2\u0092\u0093\b\b\1\2\u0093\u0094\b\b\1\2\u0094\u0096\3\2\2\2\u0095"+
		"\u008c\3\2\2\2\u0095\u0091\3\2\2\2\u0096\u009f\3\2\2\2\u0097\u0099\7\r"+
		"\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009f\b\b"+
		"\1\2\u009e\u0082\3\2\2\2\u009e\u009a\3\2\2\2\u009f\17\3\2\2\2\u00a0\u00a1"+
		"\b\t\1\2\u00a1\u00a2\7\t\2\2\u00a2\u00a9\b\t\1\2\u00a3\u00a4\5\26\f\2"+
		"\u00a4\u00a5\b\t\1\2\u00a5\u00aa\3\2\2\2\u00a6\u00a7\5\b\5\2\u00a7\u00a8"+
		"\b\t\1\2\u00a8\u00aa\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\7\n\2\2\u00ac\u00ad\b\t"+
		"\1\2\u00ad\21\3\2\2\2\u00ae\u00af\7\13\2\2\u00af\u00b0\7\20\2\2\u00b0"+
		"\u00b1\b\n\1\2\u00b1\u00b5\7\f\2\2\u00b2\u00b4\7\r\2\2\u00b3\u00b2\3\2"+
		"\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\5\16\b\2\u00b9\u00ba\b"+
		"\n\1\2\u00ba\u00bb\b\n\1\2\u00bb\23\3\2\2\2\u00bc\u00bd\b\13\1\2\u00bd"+
		"\u00be\5\26\f\2\u00be\u00bf\b\13\1\2\u00bf\u00c0\7\17\2\2\u00c0\u00c1"+
		"\5\26\f\2\u00c1\u00c2\b\13\1\2\u00c2\u00c3\b\13\1\2\u00c3\25\3\2\2\2\u00c4"+
		"\u00c6\7\r\2\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00ce\7\20\2\2\u00cb\u00cd\7\r\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3"+
		"\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d2\b\f\1\2\u00d2\27\3\2\2\2\24\33%*\63IS_g}\u0082"+
		"\u0089\u0095\u009a\u009e\u00a9\u00b5\u00c7\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}