grammar TVDLanguage;

@parser::header
{
//Generated from TVDLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDStatementNode;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
}

@parser::members
{
//Generated from TVDLanguage.g4
private TVDNodeFactory factory;
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
    throw new TVDParseError(source, line, col, length, String.format("Error(s) parsing script:%n" + location + message));
}

public static Map<String, RootCallTarget> parseTVD(TVDLanguage language, Source source) {
    TVDLanguageLexer lexer = new TVDLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
    TVDLanguageParser parser = new TVDLanguageParser(new CommonTokenStream(lexer));
    lexer.removeErrorListeners();
    parser.removeErrorListeners();
    BailoutErrorListener listener = new BailoutErrorListener(source);
    lexer.addErrorListener(listener);
    parser.addErrorListener(listener);
    parser.factory = new TVDNodeFactory(language, source);
    parser.source = source;
    parser.tvdlanguage();
    return parser.factory.getAllBlocks();
}
}

//parser
tvdlanguage
:
block =
WHITESPACE*
(
s='START'
                                         {
                                           factory.startBlock($s, $block);
                                           List<TVDStatementNode> body = new ArrayList<>(); }
(
    statement+
                                         { body.add($statement.result); }
    WHITESPACE*
)*
e='END'
                                         { factory.finishBlock(body, $s.getStartIndex(), $e.getStopIndex() - $s.getStartIndex() + 1); }
)
;

statement returns [TVDStatementNode result]
:
r = WHITESPACE* (
sum
                                        { $result = factory.createReturn($r, $sum.result); }
|
(
    IDENTIFIER
                                        { TVDExpressionNode assignmentName = factory.createStringLiteral($IDENTIFIER, false); }
        member_expression[assignmentName]
                                        { $result = factory.createReturn($r, $member_expression.result); }
)
)
;

sum returns [TVDExpressionNode result]
:
                                        { TVDExpressionNode leftnode, rightnode;  }
    numeric
                                        { leftnode = $numeric.result; }
    WHITESPACE*
        OPERATION                       { factory.showOperation($OPERATION); }
    numeric
                                        { rightnode = $numeric.result; }
                                        { $result = factory.createBinary($OPERATION, leftnode, rightnode); }
;

numeric returns [TVDExpressionNode result]
:
    WHITESPACE*
        NUMERIC_LITERAL
    WHITESPACE*
                                        { factory.showNumber($NUMERIC_LITERAL); }
                                        { $result = factory.createNumericLiteral($NUMERIC_LITERAL); }
;

member_expression[TVDExpressionNode assignmentName] returns [TVDExpressionNode result]
:                                            { TVDExpressionNode nestedAssignmentName = null; }
(
        '('                                  { List<TVDExpressionNode> parameters = new ArrayList<>();
                                               TVDExpressionNode receiver = factory.createRead(assignmentName); }
        (
            sum                              { parameters.add($sum.result); }
            |
            numeric                          { parameters.add($numeric.result); }
        )?
        e=')'
                                             { $result = factory.createCall(receiver, parameters, $e); }
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