package ru.sbt.diploma.nodes.controlflow;

import com.oracle.truffle.api.CompilerAsserts;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.ExplodeLoop;
import com.oracle.truffle.api.nodes.NodeInfo;
import lombok.extern.log4j.Log4j;
import ru.sbt.diploma.nodes.TLLStatementNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A statement node that just executes a list of other statements.
 */
@NodeInfo(shortName = "block", description = "The node implementing a source code block")
@Log4j
public final class TLLBlockNode extends TLLStatementNode {
    /**
     * The array of child nodes. The annotation {@link com.oracle.truffle.api.nodes.Node.Children
     * Children} informs Truffle that the field contains multiple children. It is a Truffle
     * requirement that the field is {@code final} and an array of nodes.
     */
    @Children private final TLLStatementNode[] bodyNodes;

    public TLLBlockNode(TLLStatementNode[] bodyNodes) {
        this.bodyNodes = bodyNodes;
    }

    /**
     * Execute all child statements. The annotation {@link ExplodeLoop} triggers full unrolling of
     * the loop during compilation. This allows the {@link TLLStatementNode#executeVoid} method of
     * all children to be inlined.
     */
    @Override
    @ExplodeLoop
    public void executeVoid(VirtualFrame frame) {
        log.info("Execute Void BlockNode");
        /*
         * This assertion illustrates that the array length is really a constant during compilation.
         */
        CompilerAsserts.compilationConstant(bodyNodes.length);

        for (TLLStatementNode statement : bodyNodes) {
            statement.executeVoid(frame);
        }
    }

    public List<TLLStatementNode> getStatements() {
        log.info("Get Statements");
        return Collections.unmodifiableList(Arrays.asList(bodyNodes));
    }
}
