package mumbler.environment;

import mumbler.node.FunctionNode;
import mumbler.node.MumblerListNode;

public abstract class BuiltinFn implements FunctionNode {

    private final String name;

    public BuiltinFn(String name) {
        this.name = name;
    }

    static final FunctionNode EQUALS = new BuiltinFn("EQUALS") {
        @Override
        public Object apply(Object... args) {
            Long last = (Long) args[0];
            for (Object arg : args) {
                Long current = (Long) arg;
                if (!last.equals(current)) {
                    return false;
                } else {
                    last = current;
                }
            }
            return true;
        }
    };

    static final FunctionNode LESS_THAN = new BuiltinFn("LESS-THAN") {
        @Override
        public Object apply(Object... args) {
            return compareOperation(true, args);
        }
    };

    static final FunctionNode GREATER_THAN = new BuiltinFn("GREATER-THAN") {
        @Override
        public Object apply(Object... args) {
            return compareOperation(false, args);
        }
    };

    boolean compareOperation(boolean less, Object... args) {
        assert args.length > 1;
        long num = (Long) args[args.length - 1];
        for (int i = args.length - 2; i >= 0; i--) {
            long n = (Long) args[i];
            if (less) {
                if (n >= num) {
                    return false;
                }
            } else {
                if (n <= num) {
                    return false;
                }
            }

            num = n;
        }
        return true;
    }

    static final FunctionNode DIV = new BuiltinFn("DIV") {
        @Override
        public Object apply(Object... args) {
            if (args.length == 1) {
                return 1 / (Long) args[0];
            }
            long quotient = (Long) args[0];
            for (int i = 1; i < args.length; i++) {
                quotient /= (Long) args[i];
            }
            return quotient;
        }
    };

    static final FunctionNode MULT = new BuiltinFn("MULT") {
        @Override
        public Object apply(Object... args) {
            long product = 1;
            for (Object arg : args) {
                product *= (Long) arg;
            }
            return product;
        }
    };

    static final FunctionNode MINUS = new BuiltinFn("MINUS") {
        @Override
        public Object apply(Object... args) {
            if (args.length < 1) {
                throw new RuntimeException("MINUS requires an argument");
            }
            if (args.length == 1) {
                return -((Long) args[0]);
            }
            long diff = (Long) args[0];
            for (int i = 1; i < args.length; i++) {
                diff -= (Long) args[i];
            }
            return diff;
        }
    };

    static final FunctionNode PLUS = new BuiltinFn("PLUS") {
        @Override
        public Object apply(Object... args) {
            long sum = 0;
            for (Object arg : args) {
                sum += (Long) arg;
            }
            return sum;
        }
    };

    static final FunctionNode LIST = new BuiltinFn("list") {
        @Override
        public Object apply(Object... args) {
            return MumblerListNode.list(args);
        }
    };

    static final FunctionNode CAR = new BuiltinFn("car") {
        @Override
        public Object apply(Object... args) {
            assert args.length == 1;
            return ((MumblerListNode<?>) args[0]).car;
        }
    };

    static final FunctionNode CDR = new BuiltinFn("cdr") {
        @Override
        public Object apply(Object... args) {
            assert args.length == 1;
            return ((MumblerListNode<?>) args[0]).cdr;
        }
    };

    static final FunctionNode PRINTLN = new BuiltinFn("println") {
        @Override
        public Object apply(Object... args) {
            for (Object arg : args) {
                System.out.println(arg);
            }
            return MumblerListNode.EMPTY;
        }
    };

    static final FunctionNode NOW = new BuiltinFn("now") {
        @Override
        public Object apply(Object... args) {
            return System.currentTimeMillis();
        }
    };

    @Override
    public String toString() {
        return "<procedure: " + this.name;
    }
}