package mumbler.node;

import mumbler.environment.Environment;

public class BooleanNode extends Node {
    public static final BooleanNode TRUE = new BooleanNode(Boolean.TRUE);
    public static final BooleanNode FALSE = new BooleanNode(Boolean.FALSE);

    private Boolean bool;
    public BooleanNode(Boolean bool) {
        this.bool = bool;
    }

    @Override
    public Object eval(Environment env) {
        return this.bool;
    }
}
