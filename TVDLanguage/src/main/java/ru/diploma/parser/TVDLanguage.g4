grammar TVDLanguage;

@parser::header
{
//Generated from TVDLanguage.g4
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import ru.diploma.nodes.TVDExpressionNode;
import java.util.Map;
}

@parser::members
{
//Generated from TVDLanguage.g4
private TVDNodeFactory factory;
private Source source;

public static TVDExpressionNode[] parseTVD(TVDLanguage language, Source source) {
	    TVDLanguageLexer lexer = new TVDLanguageLexer(CharStreams.fromString(source.getCharacters().toString()));
	    TVDLanguageParser parser = new TVDLanguageParser(new CommonTokenStream(lexer));
	    parser.factory = new TVDNodeFactory(language, source);
	    parser.source = source;
	    parser.tvdlanguage();
	    return parser.factory.getNodes();
}
}

//parser
tvdlanguage
:
start =
WHITESPACE*
(
                                        { factory.startFunction(); }
    sum
    print
                                        { factory.finishFunction($start, $sum.result); }
    WHITESPACE*
)
;


sum returns [List<TVDExpressionNode> result]
:
                                        { List<TVDExpressionNode> sumNodes = new ArrayList<>(); }
    leftnode
    WHITESPACE*
        OPERATION                       { factory.showOperation($OPERATION); }
    rightnode
                                        //{ opNode = factory.createBinary($OPERATION, $leftnode.result, $rightnode.result);}
                                        { sumNodes.add(factory.createBinary($OPERATION, $leftnode.result, $rightnode.result)); }
                                        { $result = sumNodes; }
;

leftnode returns [TVDExpressionNode result]
:
    WHITESPACE*
        NUMERIC_LITERAL
                                        { factory.showNumber($NUMERIC_LITERAL); }
                                        { $result = factory.createNumericLiteral($NUMERIC_LITERAL); }
;

rightnode returns [TVDExpressionNode result]
:
    WHITESPACE*
        NUMERIC_LITERAL
                                        { factory.showNumber($NUMERIC_LITERAL); }
                                        { $result = factory.createNumericLiteral($NUMERIC_LITERAL); }
;

print returns [List<TVDExpressionNode> result]
:
s =
    WHITESPACE*
        'print('
            sum                         { $result = $sum.result }
        ')'
    WHITESPACE*

;

//lexer

fragment DIGIT : [0-9];
fragment NON_ZERO_DIGIT : [1-9];

WHITESPACE : (' ' | '\t');
OPERATION : ('+');

NUMERIC_LITERAL : '0' | NON_ZERO_DIGIT DIGIT*;