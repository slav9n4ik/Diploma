package ru.diploma;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.source.Source;
import ru.diploma.parser.TVDLanguageParser;

import java.util.Map;

public class TVDLanguage {

    public CallTarget parse(TruffleLanguage.ParsingRequest request) throws Exception {
        Source source = request.getSource();
        Map<String, RootCallTarget> functions = TVDLanguageParser.parseTVD(this, source);

        return null;
    }

    public CallTarget parse(Source source) throws Exception {
        Map<String, RootCallTarget> functions = TVDLanguageParser.parseTVD(this, source);

        return null;
    }
}
