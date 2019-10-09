package mumbler.node;

import mumbler.environment.Environment;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListNode extends Node implements Iterable<Node> {

    public static ListNode EMPTY = new ListNode();

    private final Node car;
    private final ListNode cdr;
    private int length;


    public ListNode() {
        this.car = null;
        this.cdr = null;
        this.length = 0;
    }

    public ListNode(Node car, ListNode cdr) {
        this.car = car;
        this.cdr = cdr;
        this.length = cdr.length + 1;
    }

    public static ListNode list(List<Node> objs) {
        ListNode listNode = EMPTY;
        for (int i=objs.size()-1; i>=0; i--) {
            listNode = listNode.cons(objs.get(i));
        }

        return listNode;
    }

    public static ListNode list(Object... objs) {
        ListNode listNode = EMPTY;

        for (Object obj : objs) {
            listNode.cons((Node) obj);
        }

        return listNode;
    }

//    public static  ListNode list(List<ListNode> objs) {
//        ListNode l = EMPTY;
//        for (int i=objs.size()-1; i>=0; i--) {
//            l = l.cons(objs.get(i));
//        }
//        return l;
//    }

    public ListNode cons(Node node) {
        return new ListNode(node, this);
    }

    public Node car() {
        if (this != EMPTY) {
            return this.car;
        }
        //throw new SchemeException("Cannot car the empty list");
        return null;
    }

    public ListNode cdr() {
        if (this != EMPTY) {
            return this.cdr;
        }
        //throw new SchemeException("Cannot cdr the empty list");
        return null;
    }

    public long size() {
        return this.length;
    }


    @Override
    public Iterator<Node> iterator() {
        return new Iterator() {
            private ListNode listNode = ListNode.this;

            @Override
            public boolean hasNext() {
                return this.listNode != EMPTY;
            }

            @Override
            public Node next() {
                if (this.listNode == EMPTY) {
                    //throw new SchemeException("At end of list");
                    return null;
                }
                Node car = this.listNode.car;
                this.listNode = this.listNode.cdr;
                return car;
            }

            @Override
            public void remove() {
                //throw new SchemeException("Iterator is immutable");
            }
        };
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ListNode)) {
            return false;
        }
        if (this == EMPTY && other == EMPTY) {
            return true;
        }

        ListNode that = (ListNode) other;
        if (this.cdr == EMPTY && that.cdr != EMPTY) {
            return false;
        }
        return this.car.equals(that.car) && this.cdr.equals(that.cdr);
    }

    @Override
    public String toString() {
        if (this == EMPTY) {
            return "()";
        }

        StringBuilder b = new StringBuilder("(" + this.car);
        ListNode rest = this.cdr;
        while (rest != null && rest != EMPTY) {
            b.append(" ");
            b.append(rest.car);
            rest = rest.cdr;
        }
        b.append(")");
        return b.toString();
    }

    public int getLength() {
        return length;
    }


    @Override
    public Object eval(Environment env) {
        //return this.toString();

        FunctionNode function = (FunctionNode) this.car.eval(env);

        List<Object> args = new LinkedList<>();
        for (Node node : this.cdr) {
            args.add(node.eval(env));
        }
        return function.apply(args.toArray());
    }
}
