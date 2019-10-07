package mumbler;

import mumbler.environment.BuiltinFn;
import mumbler.environment.Environment;
import mumbler.node.FunctionNode;
import mumbler.node.MumblerListNode;
import mumbler.node.Node;
import mumbler.node.SymbolNode;

public class SpecialForm {
    private static final SymbolNode DEFINE = new SymbolNode("define");
    private static final SymbolNode LAMBDA = new SymbolNode("lambda");
    private static final SymbolNode IF = new SymbolNode("if");
    private static final SymbolNode QUOTE = new SymbolNode("quote");

    public static Node check(MumblerListNode l) {
        if (l == MumblerListNode.EMPTY) {
            return l;
        } else if (l.car.equals(DEFINE)) {
            return new DefineSpecialForm(l);
        } else if (l.car.equals(LAMBDA)) {
            return new LambdaSpecialForm(l);
        } else if (l.car.equals(IF)) {
            return new IfSpecialForm(l);
        } else if (l.car.equals(QUOTE)) {
            return new QuoteSpecialForm(l);
        }
        return l;
    }


    private static class DefineSpecialForm extends SpecialForm {
        public DefineSpecialForm(MumblerListNode listNode) {
            super(listNode);
        }

        @Override
        public Object eval(Environment env) {
            SymbolNode sym = (SymbolNode) this.node.cdr.car; // 2nd element
            env.putValue(sym.name,
                    this.node.cdr.cdr.car.eval(env)); // 3rd element
            return MumblerListNode.EMPTY;
        }
    }

    private static class LambdaSpecialForm extends SpecialForm {
        public LambdaSpecialForm(MumblerListNode paramsAndBody) {
            super(paramsAndBody);
        }

        @Override
        public Object eval(final Environment parentEnv) {
            final MumblerListNode formalParams = (MumblerListNode) this.node.cdr.car;
            final MumblerListNode body = this.node.cdr.cdr;
            return new FunctionNode() {
                @Override
                public Object apply(Object... args) {
                    Environment lambdaEnv = new Environment(parentEnv);
                    if (args.length != formalParams.length()) {
                        throw new RuntimeException(
                                "Wrong number of arguments. Expected: " +
                                        formalParams.length() + ". Got: " +
                                        args.length);
                    }

                    // Map parameter values to formal parameter names
                    int i = 0;
                    for (Node param : formalParams) {
                        SymbolNode paramSymbol = (SymbolNode) param;
                        lambdaEnv.putValue(paramSymbol.name, args[i]);
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
}

