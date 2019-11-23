grammar TLLLanguage;

@parser::header
{
//Generated from TLLLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TLLLanguage;
import ru.diploma.nodes.TLLExpressionNode;
import ru.diploma.nodes.TLLStatementNode;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
}

@parser::members
{
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
}

//parser
tlllanguage
:
block =
WHITESPACE*
(
s='START'
                                         {
                                           factory.startBlock($s, $block);
                                           List<TLLStatementNode> body = new ArrayList<>(); }
(
    statement                            { body.add($statement.result); }
    WHITESPACE*
)*
e='END'
                                         { factory.finishBlock(body, $s.getStartIndex(), $e.getStopIndex() - $s.getStartIndex() + 1); }
)
;

//TODO отрефакторить эту сраку
statement returns [TLLStatementNode result]
:
r = WHITESPACE* (
sum
                                        { $result = $sum.result; }
|
(
    IDENTIFIER
                                        { TLLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
    (
        member_expression[assignmentName]
                                        { $result = $member_expression.result; }
    )
)
//|
//(
//    IDENTIFIER
//                                        { TLLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
//        member_expression[assignmentName]
//                                        { $result = factory.createReturn($r, $member_expression.result); }
//)
)
;

sum returns [TLLExpressionNode result]
:
                                        { TLLExpressionNode leftnode, rightnode;  }
    numeric
                                        { leftnode = $numeric.result; }
    WHITESPACE*
        OPERATION                       { factory.showOperation($OPERATION); }
    numeric
                                        { rightnode = $numeric.result; }
                                        { $result = factory.createBinary($OPERATION, leftnode, rightnode); }
;

numeric returns [TLLExpressionNode result]
:
    WHITESPACE*
        NUMERIC_LITERAL
    WHITESPACE*
                                        { factory.showNumber($NUMERIC_LITERAL); }
                                        { $result = factory.createNumericLiteral($NUMERIC_LITERAL); }
;

expression returns [TLLExpressionNode result]
:
(
    IDENTIFIER
                                        { TLLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
    (
                                        { $result = factory.createRead(assignmentName); }
    )
)
;

//TODO пока не делаем присваивание проперти, оставляем три аргумента
member_expression[TLLExpressionNode assignmentName] returns [TLLExpressionNode result]
:                                            { TLLExpressionNode nestedAssignmentName = null;
                                               List<TLLExpressionNode> parameters = new ArrayList<>(); }
(
    '('                                      { TLLExpressionNode receiver = factory.createRead(assignmentName); }
        (
            sum                              { parameters.add($sum.result); }
            |
            numeric                          { parameters.add($numeric.result); }
            |
            expression
                                             { parameters.add($expression.result); }
        )?
    e=')'
                                             { $result = factory.createCall(receiver, parameters, $e); }
)
|
(
    ':'                                      { TLLExpressionNode receiver = factory.createRead(assignmentName); }
        WHITESPACE*
        IDENTIFIER
                                             { TLLExpressionNode newEmptyObj = factory.createCall(receiver, Collections.emptyList(), $IDENTIFIER); }
                                             { TLLExpressionNode localVarName = factory.createStringLiteral($IDENTIFIER, false); }
                                             { $result = factory.createAssignment(localVarName, newEmptyObj);}
)
;

//lexer
fragment DIGIT : [0-9];
fragment LETTER : [A-Z] | [a-z] | '_' | '$';
fragment NON_ZERO_DIGIT : [1-9];

WHITESPACE : (' ' | '\t' | '\n');
IDENTIFIER : LETTER (LETTER | DIGIT)*;
OPERATION : ('+');

NUMERIC_LITERAL : '0' | NON_ZERO_DIGIT DIGIT*;