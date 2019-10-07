package mumbler.node;

import mumbler.environment.Environment;

public interface Node {
    Object eval(Environment env);

}
