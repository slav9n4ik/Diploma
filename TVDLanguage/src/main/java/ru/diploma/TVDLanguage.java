package ru.diploma;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.source.Source;
import ru.diploma.parser.TVDLanguageParser;

import java.util.Map;

@TruffleLanguage.Registration(id = TVDLanguage.ID,
        name = "SL", defaultMimeType = TVDLanguage.MIME_TYPE,
        characterMimeTypes = TVDLanguage.MIME_TYPE,
        contextPolicy = TruffleLanguage.ContextPolicy.SHARED,
        fileTypeDetectors = TVDFileDetector.class)
@ProvidedTags({StandardTags.CallTag.class, StandardTags.StatementTag.class, StandardTags.RootTag.class, StandardTags.RootBodyTag.class, StandardTags.ExpressionTag.class,
        DebuggerTags.AlwaysHalt.class})
public class TVDLanguage extends TruffleLanguage<TVDContext> {

    public final static String ID = "tvd";
    public static final String MIME_TYPE = "application/x-tvd";

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
