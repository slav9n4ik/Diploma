package mumbler.forms;

import mumbler.node.ListNode;
import mumbler.node.Node;
import mumbler.node.SymbolNode;

public abstract class SpecialForm extends Node {
    private static final SymbolNode DEFINE = new SymbolNode("define");
    private static final SymbolNode LAMBDA = new SymbolNode("lambda");
    private static final SymbolNode IF = new SymbolNode("if");
    private static final SymbolNode QUOTE = new SymbolNode("quote");

    protected ListNode listNode;

    public SpecialForm(ListNode listNode) {
        this.listNode = listNode;
    }

    public static Node check(ListNode l) {

        if (l == ListNode.EMPTY) {
            return l;
        } else if (l.car().equals(DEFINE)) {
            return new DefineSpecialForm(l);
        } else if (l.car().equals(LAMBDA)) {
            return new LambdaSpecialForm(l);
        } else if (l.car().equals(IF)) {
            return new IfSpecialForm(l);
        } else if (l.car().equals(QUOTE)) {
            return new QuoteSpecialForm(l);
        }
        return l;
    }
}