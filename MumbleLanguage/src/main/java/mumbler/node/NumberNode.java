package mumbler.node;

import mumbler.environment.Environment;

public class NumberNode extends Node {
    private final Long num;

    public NumberNode(Long num) {
        this.num = num;
    }

    @Override
    public Object eval(Environment env) {
        return this.num;
    }
}
