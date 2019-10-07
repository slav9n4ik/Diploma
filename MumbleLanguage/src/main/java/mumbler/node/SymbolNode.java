package mumbler.node;

import mumbler.environment.Environment;

public class SymbolNode extends Node {
    private String name;
    public SymbolNode(String name) {
        this.name = name;
    }

    @Override
    public Object eval(Environment env) {
        return env.getValue(this.name);
    }
}