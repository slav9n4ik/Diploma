package mumbler.forms;

import mumbler.environment.Environment;
import mumbler.node.FunctionNode;
import mumbler.node.ListNode;
import mumbler.node.Node;
import mumbler.node.SymbolNode;

public class LambdaSpecialForm extends SpecialForm {
    public LambdaSpecialForm(ListNode paramsAndBody) {
        super(paramsAndBody);
    }

    @Override
    public Object eval(final Environment parentEnv) {
        final ListNode formalParams = (ListNode) this.listNode.cdr().car();
        final ListNode body = this.listNode.cdr().cdr();
        return new FunctionNode() {
            @Override
            public Object apply(Object... args) {
                Environment lambdaEnv = new Environment(parentEnv);
                if (args.length != formalParams.getLength()) {
                    throw new RuntimeException(
                            "Wrong number of arguments. Expected: " +
                                    formalParams.getLength() + ". Got: " +
                                    args.length);
                }

                // Map parameter values to formal parameter names
                int i = 0;
                for (Node param : formalParams) {
                    SymbolNode paramSymbol = (SymbolNode) param;
                    lambdaEnv.putValue(paramSymbol.getName(), args[i]);
                    i++;
                }

                // Evaluate body
                Object output = null;
                for (Node node : body) {
                    output = node.eval(lambdaEnv);
                }

                return output;
            }
        };
    }
}
