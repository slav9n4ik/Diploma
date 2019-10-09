package mumbler.forms;

import mumbler.environment.Environment;
import mumbler.node.ListNode;
import mumbler.node.SymbolNode;

public class DefineSpecialForm extends SpecialForm {
    public DefineSpecialForm(ListNode listNode) {
        super(listNode);
    }

    @Override
    public Object eval(Environment env) {
        SymbolNode sym = (SymbolNode) this.listNode.cdr().car(); // 2nd element
        env.putValue(sym.getName(),
                this.listNode.cdr().cdr().car().eval(env)); // 3rd element
        return ListNode.EMPTY;
    }
}
