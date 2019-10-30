package ru.diploma.language.types;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.frame.MaterializedFrame;

public class MumblerFunction {
    private final RootCallTarget rootCallTarget;
    private MaterializedFrame lexicalScope;

    public MumblerFunction(RootCallTarget rootCallTarget) {
        this.rootCallTarget = rootCallTarget;
    }

    public MaterializedFrame getLexicalScope() {
        return this.lexicalScope;
    }

    public void setLexicalScope(MaterializedFrame lexicalScope) {
        this.lexicalScope = lexicalScope;
    }
}
