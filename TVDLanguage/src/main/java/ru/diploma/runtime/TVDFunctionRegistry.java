package ru.diploma.runtime;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.source.Source;
import ru.diploma.TVDLanguage;
import ru.diploma.parser.TVDLanguageParser;
import ru.diploma.runtime.TVDFunction;

import java.util.*;

/**
 * Manages the mapping from function names to {@link TVDFunction function objects}.
 */
public class TVDFunctionRegistry {
    private final TVDLanguage language;
    private final FunctionsObject functionsObject = new FunctionsObject();

    public TVDFunctionRegistry(TVDLanguage language) {
        this.language = language;
    }

    /**
     * Returns the canonical {@link TVDFunction} object for the given name. If it does not exist yet,
     * it is created.
     */
    public TVDFunction lookup(String name, boolean createIfNotPresent) {
        TVDFunction result = functionsObject.functions.get(name);
        if (result == null && createIfNotPresent) {
            result = new TVDFunction(language, name);
            functionsObject.functions.put(name, result);
        }
        return result;
    }

    /**
     * Associates the {@link TVDFunction} with the given name with the given implementation root
     * node. If the function did not exist before, it defines the function. If the function existed
     * before, it redefines the function and the old implementation is discarded.
     */
    public TVDFunction register(String name, RootCallTarget callTarget) {
        TVDFunction function = lookup(name, true);
        function.setCallTarget(callTarget);
        return function;
    }

    public void register(Map<String, RootCallTarget> newFunctions) {
        for (Map.Entry<String, RootCallTarget> entry : newFunctions.entrySet()) {
            register(entry.getKey(), entry.getValue());
        }
    }

    public void register(Source newFunctions) {
        register(TVDLanguageParser.parseTVD(language, newFunctions));
    }

    public TVDFunction getFunction(String name) {
        return functionsObject.functions.get(name);
    }

    /**
     * Returns the sorted list of all functions, for printing purposes only.
     */
    public List<TVDFunction> getFunctions() {
        List<TVDFunction> result = new ArrayList<>(functionsObject.functions.values());
        Collections.sort(result, new Comparator<TVDFunction>() {
            public int compare(TVDFunction f1, TVDFunction f2) {
                return f1.toString().compareTo(f2.toString());
            }
        });
        return result;
    }

    public TruffleObject getFunctionsObject() {
        return functionsObject;
    }
}
