package mumbler.node;

import mumbler.environment.Environment;

import java.util.ArrayList;
import java.util.List;

public class MumblerListNode implements Node, Iterable<Node> {
    // other code...

    @Override
    public Object eval(Environment env) {
        FunctionNode function = (FunctionNode) this.car.eval(env);

        List<Object> args = new ArrayList<Object>();
        for (Node node : this.cdr) {
            args.add(node.eval(env));
        }
        return function.apply(args.toArray());
    }
}