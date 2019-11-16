package ru.diploma;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.Source;
import ru.diploma.nodes.TVDExpressionNode;
import ru.diploma.nodes.TVDRootNode;
import ru.diploma.parser.TVDLanguageParser;
import ru.diploma.runtime.TVDContext;

import java.util.Map;

@TruffleLanguage.Registration(name = "TVD", version = "0.3",
        mimeType = TVDLanguage.MIME_TYPE)
public class TVDLanguage extends TruffleLanguage<Object> {

    public final static String ID = "tvd";
    public static final String MIME_TYPE = "application/x-tvd";

    @Override
    protected Object createContext(Env env) {
        return new TVDContext();
    }

    @Override
    public CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        TVDExpressionNode[] nodes = TVDLanguageParser.parseTVD(this, source);
        //TODO Исправить на целевое решение
        return null;
    }

    //TODO кастомный парсер на первое время
    public void parseCustom(Source source) {
        //Создаем глобальный контекст
        TVDContext context = new TVDContext();
        //Получаем ноды, после разбора файла
        TVDExpressionNode[] nodes = TVDLanguageParser.parseTVD(this, source);
        //Собираем в рутовую ноду c контекстом. БЕЗ АРГУМЕНТОВ
        TVDRootNode rootNode = new TVDRootNode(nodes, context.getGlobalFrame().getFrameDescriptor());
        //Отдаем готовое дерево с рутовой нодой
        CallTarget callTarget = Truffle.getRuntime().createCallTarget(rootNode);
        callTarget.call(new Object[] {context.getGlobalFrame()});
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }


}
