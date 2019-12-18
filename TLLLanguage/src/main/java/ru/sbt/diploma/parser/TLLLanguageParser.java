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
		RULE_tlllanguage = 0, RULE_statement = 1, RULE_return_statement = 2, RULE_expression = 3, 
		RULE_createLocalVar = 4, RULE_init_obj = 5, RULE_property = 6, RULE_init = 7, 
		RULE_builtin_functions = 8, RULE_array_statement = 9, RULE_binary = 10, 
		RULE_numeric = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"tlllanguage", "statement", "return_statement", "expression", "createLocalVar", 
			"init_obj", "property", "init", "builtin_functions", "array_statement", 
			"binary", "numeric"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'START'", "'END'", "'return'", "':'", "'@'", "'.'", "'('", "','", 
			"')'", "'['", "']'"
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(24);
				((TlllanguageContext)_localctx).block = match(WHITESPACE);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(30);
			((TlllanguageContext)_localctx).s = match(T__0);

			                                           factory.startBlock(((TlllanguageContext)_localctx).s, ((TlllanguageContext)_localctx).block);
			                                           List<TLLStatementNode> body = new ArrayList<>(); 
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__4) | (1L << WHITESPACE) | (1L << IDENTIFIER) | (1L << NUMERIC_LITERAL))) != 0)) {
				{
				{
				setState(32);
				((TlllanguageContext)_localctx).statement = statement();
				 body.add(((TlllanguageContext)_localctx).statement.result); 
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(34);
						match(WHITESPACE);
						}
						} 
					}
					setState(39);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				}
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
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
		public PropertyContext property;
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
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
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
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					((StatementContext)_localctx).r = match(WHITESPACE);
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				{
				setState(54);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				{
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				setState(56);
				((StatementContext)_localctx).builtin_functions = builtin_functions(assignmentName);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).builtin_functions.result; 
				}
				}
				}
				break;
			case 2:
				{
				setState(59);
				((StatementContext)_localctx).init_obj = init_obj();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).init_obj.result; 
				}
				break;
			case 3:
				{
				setState(62);
				((StatementContext)_localctx).return_statement = return_statement();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).return_statement.result; 
				}
				break;
			case 4:
				{
				setState(65);
				((StatementContext)_localctx).expression = expression();
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).expression.result; 
				}
				break;
			case 5:
				{
				setState(68);
				((StatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				{
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((StatementContext)_localctx).IDENTIFIER, false); 
				setState(70);
				((StatementContext)_localctx).property = property(assignmentName);
				 ((StatementContext)_localctx).result =  ((StatementContext)_localctx).property.result; 
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
			setState(75);
			((Return_statementContext)_localctx).r = match(T__2);
			{
			setState(76);
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
		public PropertyContext property;
		public CreateLocalVarContext createLocalVar;
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
		public PropertyContext property() {
			return getRuleContext(PropertyContext.class,0);
		}
		public CreateLocalVarContext createLocalVar() {
			return getRuleContext(CreateLocalVarContext.class,0);
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(80);
					match(WHITESPACE);
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(86);
				((ExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode assignmentName = factory.createStringLiteral(((ExpressionContext)_localctx).IDENTIFIER, false); 
				setState(98);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__2:
				case T__4:
				case T__7:
				case T__8:
				case WHITESPACE:
				case IDENTIFIER:
				case NUMERIC_LITERAL:
					{
					{
					 ((ExpressionContext)_localctx).result =  factory.createRead(assignmentName); 
					}
					}
					break;
				case T__9:
					{
					{
					setState(89);
					((ExpressionContext)_localctx).array_statement = array_statement(assignmentName, null);
					 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).array_statement.result; 
					}
					}
					break;
				case T__5:
					{
					{
					setState(92);
					((ExpressionContext)_localctx).property = property(assignmentName);
					 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).property.result; 
					}
					}
					break;
				case T__3:
					{
					{
					setState(95);
					((ExpressionContext)_localctx).createLocalVar = createLocalVar(assignmentName);
					 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).createLocalVar.result; 
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
				setState(100);
				((ExpressionContext)_localctx).binary = binary();
				 ((ExpressionContext)_localctx).result =  ((ExpressionContext)_localctx).binary.result; 
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
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

	public static class CreateLocalVarContext extends ParserRuleContext {
		public TLLExpressionNode assignmentName;
		public TLLExpressionNode result;
		public Token IDENTIFIER;
		public Builtin_functionsContext builtin_functions;
		public TerminalNode IDENTIFIER() { return getToken(TLLLanguageParser.IDENTIFIER, 0); }
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
		}
		public Builtin_functionsContext builtin_functions() {
			return getRuleContext(Builtin_functionsContext.class,0);
		}
		public CreateLocalVarContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public CreateLocalVarContext(ParserRuleContext parent, int invokingState, TLLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_createLocalVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterCreateLocalVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitCreateLocalVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitCreateLocalVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateLocalVarContext createLocalVar(TLLExpressionNode assignmentName) throws RecognitionException {
		CreateLocalVarContext _localctx = new CreateLocalVarContext(_ctx, getState(), assignmentName);
		enterRule(_localctx, 8, RULE_createLocalVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(108);
			match(T__3);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(109);
				match(WHITESPACE);
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(115);
			((CreateLocalVarContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			{
			 TLLExpressionNode arg = factory.createStringLiteral(((CreateLocalVarContext)_localctx).IDENTIFIER, false); 
			setState(117);
			((CreateLocalVarContext)_localctx).builtin_functions = builtin_functions(arg);
			 ((CreateLocalVarContext)_localctx).result =  factory.createAssignment(assignmentName, ((CreateLocalVarContext)_localctx).builtin_functions.result); 
			}
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
		enterRule(_localctx, 10, RULE_init_obj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(120);
			match(T__4);
			setState(121);
			((Init_objContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			 TLLExpressionNode assignmentName = factory.createStringLiteral(((Init_objContext)_localctx).IDENTIFIER, false); 
			{
			setState(123);
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

	public static class PropertyContext extends ParserRuleContext {
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
		public PropertyContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public PropertyContext(ParserRuleContext parent, int invokingState, TLLExpressionNode assignmentName) {
			super(parent, invokingState);
			this.assignmentName = assignmentName;
		}
		@Override public int getRuleIndex() { return RULE_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).enterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TLLLanguageListener ) ((TLLLanguageListener)listener).exitProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TLLLanguageVisitor ) return ((TLLLanguageVisitor<? extends T>)visitor).visitProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyContext property(TLLExpressionNode assignmentName) throws RecognitionException {
		PropertyContext _localctx = new PropertyContext(_ctx, getState(), assignmentName);
		enterRule(_localctx, 12, RULE_property);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(126);
			match(T__5);
			 TLLExpressionNode receiver = factory.createRead(assignmentName); 
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				{
				setState(128);
				((PropertyContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode nestedAssignmentName = factory.createStringLiteral(((PropertyContext)_localctx).IDENTIFIER, false); 
				 ((PropertyContext)_localctx).result =  factory.createReadProperty(receiver, nestedAssignmentName); 
				 TLLExpressionNode readResult = _localctx.result; 
				setState(132);
				((PropertyContext)_localctx).init = init(null, receiver, nestedAssignmentName);

				                                                if(((PropertyContext)_localctx).init.result != null) {
				                                                    ((PropertyContext)_localctx).result =  ((PropertyContext)_localctx).init.result;
				                                                } else {
				                                                    ((PropertyContext)_localctx).result =  readResult;
				                                                }
				                                            
				}
				}
				break;
			case 2:
				{
				{
				setState(135);
				((PropertyContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 TLLExpressionNode propName = factory.createStringLiteral(((PropertyContext)_localctx).IDENTIFIER, false); 
				setState(137);
				((PropertyContext)_localctx).array_statement = array_statement(propName, receiver);
				 ((PropertyContext)_localctx).result =  ((PropertyContext)_localctx).array_statement.result; 
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
		enterRule(_localctx, 14, RULE_init);
		int _la;
		try {
			int _alt;
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITESPACE) {
					{
					{
					setState(142);
					((InitContext)_localctx).s = match(WHITESPACE);
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				{
				setState(148);
				match(T__3);
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				setState(164);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(155);
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
					setState(160);
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
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(166);
						match(WHITESPACE);
						}
						} 
					}
					setState(171);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(TLLLanguageParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(TLLLanguageParser.WHITESPACE, i);
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
		enterRule(_localctx, 16, RULE_builtin_functions);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 TLLExpressionNode nestedAssignmentName = null;
			                                              List<TLLExpressionNode> parameters = new ArrayList<>(); 
			 TLLExpressionNode receiver = factory.createRead(assignmentName); 
			{
			setState(177);
			match(T__6);
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(178);
				((Builtin_functionsContext)_localctx).numeric = numeric();
				 parameters.add(((Builtin_functionsContext)_localctx).numeric.result); 
				}
				break;
			case 2:
				{
				setState(181);
				((Builtin_functionsContext)_localctx).expression = expression();
				 parameters.add(((Builtin_functionsContext)_localctx).expression.result); 
				}
				break;
			case 3:
				{
				{
				setState(184);
				((Builtin_functionsContext)_localctx).expression = expression();
				 parameters.add(((Builtin_functionsContext)_localctx).expression.result); 
				setState(186);
				match(T__7);
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(187);
						match(WHITESPACE);
						}
						} 
					}
					setState(192);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(193);
				((Builtin_functionsContext)_localctx).expression = expression();
				 parameters.add(((Builtin_functionsContext)_localctx).expression.result); 
				}
				}
				break;
			}
			setState(198);
			((Builtin_functionsContext)_localctx).e = match(T__8);
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
		enterRule(_localctx, 18, RULE_array_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(201);
			((Array_statementContext)_localctx).s = match(T__9);
			setState(202);
			((Array_statementContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			 TLLExpressionNode index = factory.createNumericLiteral(((Array_statementContext)_localctx).NUMERIC_LITERAL); 
			setState(204);
			((Array_statementContext)_localctx).e = match(T__10);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(205);
					match(WHITESPACE);
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(211);
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
		enterRule(_localctx, 20, RULE_binary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			 TLLExpressionNode leftnode, rightnode;  
			setState(216);
			((BinaryContext)_localctx).numeric = numeric();
			 leftnode = ((BinaryContext)_localctx).numeric.result; 
			setState(218);
			((BinaryContext)_localctx).OPERATION = match(OPERATION);
			setState(219);
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
		enterRule(_localctx, 22, RULE_numeric);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITESPACE) {
				{
				{
				setState(223);
				match(WHITESPACE);
				}
				}
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(229);
			((NumericContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(230);
					match(WHITESPACE);
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21\u00f1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2&\n\2\f\2\16\2)\13\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\3\2\3\3\7"+
		"\3\64\n\3\f\3\16\3\67\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3L\n\3\3\4\3\4\3\4\3\4\3\4\3\5\7\5"+
		"T\n\5\f\5\16\5W\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5e\n\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5m\n\5\3\6\3\6\7\6q\n\6\f\6\16\6t\13"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u008f\n\b\3\t\7\t\u0092\n\t\f\t\16"+
		"\t\u0095\13\t\3\t\3\t\7\t\u0099\n\t\f\t\16\t\u009c\13\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a7\n\t\3\t\7\t\u00aa\n\t\f\t\16\t\u00ad"+
		"\13\t\3\t\5\t\u00b0\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\7\n\u00bf\n\n\f\n\16\n\u00c2\13\n\3\n\3\n\3\n\5\n\u00c7\n\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\7\13\u00d1\n\13\f\13\16\13\u00d4\13"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\7\r\u00e3"+
		"\n\r\f\r\16\r\u00e6\13\r\3\r\3\r\7\r\u00ea\n\r\f\r\16\r\u00ed\13\r\3\r"+
		"\3\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u00ff\2\35\3\2\2\2"+
		"\4\65\3\2\2\2\6M\3\2\2\2\bl\3\2\2\2\nn\3\2\2\2\fz\3\2\2\2\16\u0080\3\2"+
		"\2\2\20\u00af\3\2\2\2\22\u00b1\3\2\2\2\24\u00cb\3\2\2\2\26\u00d9\3\2\2"+
		"\2\30\u00e4\3\2\2\2\32\34\7\16\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3"+
		"\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\3\2\2!,\b\2\1\2\"#"+
		"\5\4\3\2#\'\b\2\1\2$&\7\16\2\2%$\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2"+
		"\2(+\3\2\2\2)\'\3\2\2\2*\"\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2"+
		"\2\2.,\3\2\2\2/\60\7\4\2\2\60\61\b\2\1\2\61\3\3\2\2\2\62\64\7\16\2\2\63"+
		"\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66K\3\2\2\2\67\65"+
		"\3\2\2\289\7\17\2\29:\b\3\1\2:;\5\22\n\2;<\b\3\1\2<L\3\2\2\2=>\5\f\7\2"+
		">?\b\3\1\2?L\3\2\2\2@A\5\6\4\2AB\b\3\1\2BL\3\2\2\2CD\5\b\5\2DE\b\3\1\2"+
		"EL\3\2\2\2FG\7\17\2\2GH\b\3\1\2HI\5\16\b\2IJ\b\3\1\2JL\3\2\2\2K8\3\2\2"+
		"\2K=\3\2\2\2K@\3\2\2\2KC\3\2\2\2KF\3\2\2\2L\5\3\2\2\2MN\7\5\2\2NO\5\b"+
		"\5\2OP\b\4\1\2PQ\b\4\1\2Q\7\3\2\2\2RT\7\16\2\2SR\3\2\2\2TW\3\2\2\2US\3"+
		"\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\17\2\2Yd\b\5\1\2Ze\b\5\1\2[\\"+
		"\5\24\13\2\\]\b\5\1\2]e\3\2\2\2^_\5\16\b\2_`\b\5\1\2`e\3\2\2\2ab\5\n\6"+
		"\2bc\b\5\1\2ce\3\2\2\2dZ\3\2\2\2d[\3\2\2\2d^\3\2\2\2da\3\2\2\2em\3\2\2"+
		"\2fg\5\26\f\2gh\b\5\1\2hm\3\2\2\2ij\5\30\r\2jk\b\5\1\2km\3\2\2\2lU\3\2"+
		"\2\2lf\3\2\2\2li\3\2\2\2m\t\3\2\2\2nr\7\6\2\2oq\7\16\2\2po\3\2\2\2qt\3"+
		"\2\2\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\7\17\2\2vw\b\6\1\2wx"+
		"\5\22\n\2xy\b\6\1\2y\13\3\2\2\2z{\7\7\2\2{|\7\17\2\2|}\b\7\1\2}~\5\20"+
		"\t\2~\177\b\7\1\2\177\r\3\2\2\2\u0080\u0081\7\b\2\2\u0081\u008e\b\b\1"+
		"\2\u0082\u0083\7\17\2\2\u0083\u0084\b\b\1\2\u0084\u0085\b\b\1\2\u0085"+
		"\u0086\b\b\1\2\u0086\u0087\5\20\t\2\u0087\u0088\b\b\1\2\u0088\u008f\3"+
		"\2\2\2\u0089\u008a\7\17\2\2\u008a\u008b\b\b\1\2\u008b\u008c\5\24\13\2"+
		"\u008c\u008d\b\b\1\2\u008d\u008f\3\2\2\2\u008e\u0082\3\2\2\2\u008e\u0089"+
		"\3\2\2\2\u008f\17\3\2\2\2\u0090\u0092\7\16\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0096\u009a\7\6\2\2\u0097\u0099\7\16\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\u00a6\3\2\2\2\u009c\u009a\3\2\2\2\u009d\u009e\7\17\2\2\u009e"+
		"\u009f\b\t\1\2\u009f\u00a0\b\t\1\2\u00a0\u00a1\b\t\1\2\u00a1\u00a7\b\t"+
		"\1\2\u00a2\u00a3\5\30\r\2\u00a3\u00a4\b\t\1\2\u00a4\u00a5\b\t\1\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u009d\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a7\u00b0\3\2"+
		"\2\2\u00a8\u00aa\7\16\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2"+
		"\2\2\u00ae\u00b0\b\t\1\2\u00af\u0093\3\2\2\2\u00af\u00ab\3\2\2\2\u00b0"+
		"\21\3\2\2\2\u00b1\u00b2\b\n\1\2\u00b2\u00b3\b\n\1\2\u00b3\u00c6\7\t\2"+
		"\2\u00b4\u00b5\5\30\r\2\u00b5\u00b6\b\n\1\2\u00b6\u00c7\3\2\2\2\u00b7"+
		"\u00b8\5\b\5\2\u00b8\u00b9\b\n\1\2\u00b9\u00c7\3\2\2\2\u00ba\u00bb\5\b"+
		"\5\2\u00bb\u00bc\b\n\1\2\u00bc\u00c0\7\n\2\2\u00bd\u00bf\7\16\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\5\b\5\2\u00c4"+
		"\u00c5\b\n\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00b4\3\2\2\2\u00c6\u00b7\3\2"+
		"\2\2\u00c6\u00ba\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\7\13\2\2\u00c9"+
		"\u00ca\b\n\1\2\u00ca\23\3\2\2\2\u00cb\u00cc\7\f\2\2\u00cc\u00cd\7\21\2"+
		"\2\u00cd\u00ce\b\13\1\2\u00ce\u00d2\7\r\2\2\u00cf\u00d1\7\16\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\5\20\t\2\u00d6"+
		"\u00d7\b\13\1\2\u00d7\u00d8\b\13\1\2\u00d8\25\3\2\2\2\u00d9\u00da\b\f"+
		"\1\2\u00da\u00db\5\30\r\2\u00db\u00dc\b\f\1\2\u00dc\u00dd\7\20\2\2\u00dd"+
		"\u00de\5\30\r\2\u00de\u00df\b\f\1\2\u00df\u00e0\b\f\1\2\u00e0\27\3\2\2"+
		"\2\u00e1\u00e3\7\16\2\2\u00e2\u00e1\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e7\u00eb\7\21\2\2\u00e8\u00ea\7\16\2\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ee\3\2"+
		"\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\b\r\1\2\u00ef\31\3\2\2\2\26\35\'"+
		",\65KUdlr\u008e\u0093\u009a\u00a6\u00ab\u00af\u00c0\u00c6\u00d2\u00e4"+
		"\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}