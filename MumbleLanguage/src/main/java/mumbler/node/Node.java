package mumbler.node;

import mumbler.environment.Environment;

public abstract class Node {
    public abstract Object eval(Environment env);
}
