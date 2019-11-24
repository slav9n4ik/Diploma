package ru.sbt.diploma.runtime;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.source.Source;
import ru.sbt.diploma.TLLLanguage;
import ru.sbt.diploma.parser.TLLLanguageParser;

import java.util.*;

/**
 * Manages the mapping from function names to {@link TLLFunction function objects}.
 */
public class TLLFunctionRegistry {
    private final TLLLanguage language;
    private final FunctionsObject functionsObject = new FunctionsObject();

    public TLLFunctionRegistry(TLLLanguage language) {
        this.language = language;
    }

    /**
     * Returns the canonical {@link TLLFunction} object for the given name. If it does not exist yet,
     * it is created.
     */
    public TLLFunction lookup(String name, boolean createIfNotPresent) {
        TLLFunction result = functionsObject.functions.get(name);
        if (result == null && createIfNotPresent) {
            result = new TLLFunction(language, name);
            functionsObject.functions.put(name, result);
        }
        return result;
    }

    /**
     * Associates the {@link TLLFunction} with the given name with the given implementation root
     * node. If the function did not exist before, it defines the function. If the function existed
     * before, it redefines the function and the old implementation is discarded.
     */
    public TLLFunction register(String name, RootCallTarget callTarget) {
        TLLFunction function = lookup(name, true);
        function.setCallTarget(callTarget);
        return function;
    }

    public void register(Map<String, RootCallTarget> newFunctions) {
        for (Map.Entry<String, RootCallTarget> entry : newFunctions.entrySet()) {
            register(entry.getKey(), entry.getValue());
        }
    }

    public void register(Source newFunctions) {
        register(TLLLanguageParser.parseTLL(language, newFunctions));
    }

    public TLLFunction getFunction(String name) {
        return functionsObject.functions.get(name);
    }

    /**
     * Returns the sorted list of all functions, for printing purposes only.
     */
    public List<TLLFunction> getFunctions() {
        List<TLLFunction> result = new ArrayList<>(functionsObject.functions.values());
        Collections.sort(result, new Comparator<TLLFunction>() {
            public int compare(TLLFunction f1, TLLFunction f2) {
                return f1.toString().compareTo(f2.toString());
            }
        });
        return result;
    }

    public TruffleObject getFunctionsObject() {
        return functionsObject;
    }
}
