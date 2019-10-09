package mumbler.node;

import mumbler.environment.Environment;

public abstract class FunctionNode extends Node {
    public abstract Object apply(Object... args);

    @Override
    public Object eval(Environment env) {
        return this;
    }
}
