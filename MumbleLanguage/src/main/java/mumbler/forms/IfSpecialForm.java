package mumbler.forms;

import mumbler.environment.Environment;
import mumbler.node.ListNode;
import mumbler.node.Node;

public class IfSpecialForm extends SpecialForm {
    public IfSpecialForm(ListNode listNode) {
        super(listNode);
    }

    @Override
    public Object eval(Environment env) {
        Node testNode = this.listNode.cdr().car();
        Node thenNode = this.listNode.cdr().cdr().car();
        Node elseNode = this.listNode.cdr().cdr().cdr().car();

        Object result = testNode.eval(env);
        if (result == ListNode.EMPTY || Boolean.FALSE == result) {
            return elseNode.eval(env);
        } else {
            return thenNode.eval(env);
        }
    }
}