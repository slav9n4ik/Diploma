package mumbler.node;

import mumbler.environment.Environment;

public interface FunctionNode extends Node {
    Object apply(Object... args);

    @Override
    default Object eval(Environment env) {
        return this;
    }
}
