grammar TLLLanguage;

@parser::header
{
//Generated from TLLLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.nodes.TLLExpressionNode;
import ru.sbt.diploma.nodes.TLLStatementNode;

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

statement returns [TLLStatementNode result]
:
r = WHITESPACE*
(
(
    IDENTIFIER
    (
                                          { TLLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
        builtin_functions[assignmentName] { $result = $builtin_functions.result; }
    )
)
|
        init_obj                        { $result = $init_obj.result; }
|
        return_statement                { $result = $return_statement.result; }
|
        expression                      { $result = $expression.result; }
|
    IDENTIFIER
    (
                                        { TLLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
        init_prop[assignmentName]       { $result = $init_prop.result; }
    )
)
;

return_statement returns [TLLStatementNode result]
:
r='return'
(
    expression                              { TLLExpressionNode read_value = $expression.result; }
                                            { $result = factory.createReturn($r, read_value); }
)
;

expression returns [TLLExpressionNode result]
:
WHITESPACE*
(
//local vars or builtin Funcs
    IDENTIFIER
                                            { TLLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
    (
        (
                                            { $result = factory.createRead(assignmentName); }
        )
        |
        (
            array_statement[assignmentName, null]
                                            { $result = $array_statement.result; }
        )
        |
        (
            init_prop[assignmentName]
                                            { $result = $init_prop.result; }
        )
    )
)
|
(
        binary                              { $result = $binary.result; }
)
|
        numeric                             { $result = $numeric.result; }
;

init_obj returns [TLLExpressionNode result]
:
(
    '@' IDENTIFIER
                                            { TLLExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
    (
        init[null, null, assignmentName]    { $result = $init.result; }
    )
)
;

init_prop[TLLExpressionNode assignmentName] returns [TLLExpressionNode result]
:
(
    '.'
                                            { TLLExpressionNode receiver = factory.createRead(assignmentName); }
    (
        (
            IDENTIFIER
                                            { TLLExpressionNode nestedAssignmentName = factory.createStringLiteral($IDENTIFIER, false); }
                                            { $result = factory.createReadProperty(receiver, nestedAssignmentName); }
            init[$result, receiver, nestedAssignmentName]
                                            { $result = $init.result; }
        )
        |
        (
            IDENTIFIER
                                            { TLLExpressionNode propName = factory.createStringLiteral($IDENTIFIER, false); }
            array_statement[propName, receiver]
                                            { $result = $array_statement.result; }
        )
    )
)
;

init[TLLExpressionNode r, TLLExpressionNode assignmentReceiver, TLLExpressionNode assignmentName] returns [TLLExpressionNode result]
:
s = WHITESPACE*

(
    ':'
    WHITESPACE*
    (
        IDENTIFIER
                                            { TLLExpressionNode receiver = factory.createRead(assignmentName); }
                                            { TLLExpressionNode newEmptyObj = factory.createCall(receiver, Collections.emptyList(), $IDENTIFIER); }
                                            { TLLExpressionNode localVarName = factory.createStringLiteral($IDENTIFIER, false); }
                                            { if (assignmentReceiver == null) {
                                                $result = factory.createAssignment(localVarName, newEmptyObj);
                                              } else {
                                                $result = factory.createWriteProperty(assignmentReceiver, assignmentName, localVarName);
                                              }
                                            }
        |
        numeric                             { $result = factory.createWriteProperty(assignmentReceiver, assignmentName, $numeric.result); }
    )
)
|
//Массив. Присваивание значения.
(
    '='
    numeric                                 { TLLExpressionNode index = r;}
                                            { if(assignmentReceiver == null) {
                                                  $result = factory.createWriteArrayValue(assignmentName, $numeric.result, index);
                                              } else {
                                                  $result = factory.createWriteArrayProperty(assignmentReceiver, assignmentName,$numeric.result, index);
                                              }
                                            }
)
|
(
    WHITESPACE*                             { $result = null; }
)
;

//Функции из builtin
builtin_functions[TLLExpressionNode assignmentName] returns [TLLExpressionNode result]
:                                           { TLLExpressionNode nestedAssignmentName = null;
                                              List<TLLExpressionNode> parameters = new ArrayList<>(); }
(
    '('                                     { TLLExpressionNode receiver = factory.createRead(assignmentName); }
        (
            numeric                         { parameters.add($numeric.result); }
            |
            expression                      { parameters.add($expression.result); }
        )?
    e=')'                                   { $result = factory.createCall(receiver, parameters, $e); }
)
;

//Инициализация массива
array_statement[TLLExpressionNode assignmentName, TLLExpressionNode receiver] returns [TLLExpressionNode result]
:
//TODO обработать проперти массив
(
    s='['
        NUMERIC_LITERAL
                                            { TLLExpressionNode index = factory.createNumericLiteral($NUMERIC_LITERAL); }
    e=']'
        WHITESPACE*
    init[index, receiver, assignmentName]   { TLLExpressionNode initResult = $init.result; }
                                            {  if (initResult == null) {
                                                    if (receiver == null) {
                                                        $result = factory.createReadArrayValue(assignmentName, $NUMERIC_LITERAL);
                                                    } else {
                                                        $result = factory.createReadArrayProperty(receiver, assignmentName, $NUMERIC_LITERAL);
                                                    }
                                                } else {
                                                    $result = initResult;
                                                }
                                            }
)
;

binary returns [TLLExpressionNode result]
:
(
                                            { TLLExpressionNode leftnode, rightnode;  }
    numeric                                 { leftnode = $numeric.result; }
        OPERATION
    numeric                                 { rightnode = $numeric.result; }
                                            { $result = factory.createBinary($OPERATION, leftnode, rightnode); }
)
;

numeric returns [TLLExpressionNode result]
:
    WHITESPACE*
        NUMERIC_LITERAL
    WHITESPACE*
                                            { $result = factory.createNumericLiteral($NUMERIC_LITERAL); }
;

//lexer
fragment DIGIT : [0-9];
fragment LETTER : [A-Z] | [a-z] | '_' | '$';
fragment NON_ZERO_DIGIT : [1-9];

WHITESPACE : (' ' | '\t' | '\n');
IDENTIFIER : LETTER (LETTER | DIGIT)*;
OPERATION : ('+');

NUMERIC_LITERAL : '0' | NON_ZERO_DIGIT DIGIT*;