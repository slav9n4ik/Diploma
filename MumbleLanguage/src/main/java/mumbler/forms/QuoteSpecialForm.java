package mumbler.forms;

import mumbler.environment.Environment;
import mumbler.node.ListNode;

public class QuoteSpecialForm extends SpecialForm {
    public QuoteSpecialForm(ListNode listNode) {
        super(listNode);
    }

    @Override
    public Object eval(Environment env) {
        //return unevaluated second element
        return this.listNode.cdr().car();
    }
}
