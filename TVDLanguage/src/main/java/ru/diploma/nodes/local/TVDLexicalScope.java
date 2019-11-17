package ru.diploma.nodes.local;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.frame.FrameSlot;
import com.oracle.truffle.api.interop.*;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeUtil;
import com.oracle.truffle.api.nodes.NodeVisitor;
import com.oracle.truffle.api.nodes.RootNode;
import ru.diploma.nodes.TVDEvalRootNode;
import ru.diploma.nodes.TVDStatementNode;
import ru.diploma.nodes.controlflow.TVDBlockNode;
import ru.diploma.runtime.TVDNull;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Simple language lexical scope. There can be a block scope and fuctional scope.
 */
public final class TVDLexicalScope {
    private final Node current;
    private final TVDBlockNode block;
    private final TVDBlockNode parentBlock;
    private final RootNode root;
    private TVDLexicalScope parent;
    private Map<String, FrameSlot> varSlots;

    /**
     * Create a new block TVD lexical scope.
     *
     * @param current the current node
     * @param block a nearest block enclosing the current node
     * @param parentBlock a next parent block
     */
    private TVDLexicalScope(Node current, TVDBlockNode block, TVDBlockNode parentBlock) {
        this.current = current;
        this.block = block;
        this.parentBlock = parentBlock;
        this.root = null;
    }

    //TODO Убрать потом
    /**
     * Create a new functional TVD lexical scope.
     *
     * @param current the current node, or <code>null</code> when it would be above the block
     * @param block a nearest block enclosing the current node
     * @param root a functional root node for top-most block
     */
    private TVDLexicalScope(Node current, TVDBlockNode block, RootNode root) {
        this.current = current;
        this.block = block;
        this.parentBlock = null;
        this.root = root;
    }

    @SuppressWarnings("all") // The parameter node should not be assigned
    public static TVDLexicalScope createScope(Node node) {
        TVDBlockNode block = getParentBlock(node);
        if (block == null) {
            // We're in the root.
            block = findChildrenBlock(node);
            if (block == null) {
                // Corrupted TVD AST, no block was found
                assert node.getRootNode() instanceof TVDEvalRootNode : "Corrupted TVD AST under " + node;
                return new TVDLexicalScope(null, null, (TVDBlockNode) null);
            }
            node = null; // node is above the block
        }
        // Test if there is a parent block. If not, we're in the root scope.
        TVDBlockNode parentBlock = getParentBlock(block);
        if (parentBlock == null) {
            return new TVDLexicalScope(node, block, block.getRootNode());
        } else {
            return new TVDLexicalScope(node, block, parentBlock);
        }
    }

    private static TVDBlockNode getParentBlock(Node node) {
        TVDBlockNode block;
        Node parent = node.getParent();
        // Find a nearest block node.
        while (parent != null && !(parent instanceof TVDBlockNode)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            block = (TVDBlockNode) parent;
        } else {
            block = null;
        }
        return block;
    }

    private static TVDBlockNode findChildrenBlock(Node node) {
        TVDBlockNode[] blockPtr = new TVDBlockNode[1];
        node.accept(new NodeVisitor() {
            @Override
            public boolean visit(Node n) {
                if (n instanceof TVDBlockNode) {
                    blockPtr[0] = (TVDBlockNode) n;
                    return false;
                } else {
                    return true;
                }
            }
        });
        return blockPtr[0];
    }

    public TVDLexicalScope findParent() {
        if (parentBlock == null) {
            // This was a root scope.
            return null;
        }
        if (parent == null) {
            Node node = block;
            TVDBlockNode newBlock = parentBlock;
            // Test if there is a next parent block. If not, we're in the root scope.
            TVDBlockNode newParentBlock = getParentBlock(newBlock);
            if (newParentBlock == null) {
                parent = new TVDLexicalScope(node, newBlock, newBlock.getRootNode());
            } else {
                parent = new TVDLexicalScope(node, newBlock, newParentBlock);
            }
        }
        return parent;
    }

    /**
     * @return the function name for function scope, "block" otherwise.
     */
    public String getName() {
        if (root != null) {
            return root.getName();
        } else {
            return "block";
        }
    }

    /**
     * @return the node representing the scope, the block node for block scopes and the
     *         {@link RootNode} for functional scope.
     */
    public Node getNode() {
        if (root != null) {
            return root;
        } else {
            return block;
        }
    }

    public Object getVariables(Frame frame) {
        Map<String, FrameSlot> vars = getVars();
        Object[] args = null;
        // Use arguments when the current node is above the block
        if (current == null) {
            args = (frame != null) ? frame.getArguments() : null;
        }
        return new VariablesMapObject(vars, args, frame);
    }

    public Object getArguments(Frame frame) {
        if (root == null) {
            // No arguments for block scope
            return null;
        }
        // The slots give us names of the arguments:
        Map<String, FrameSlot> argSlots = collectArgs(block);
        // The frame's arguments array give us the argument values:
        Object[] args = (frame != null) ? frame.getArguments() : null;
        // Create a TruffleObject having the arguments as properties:
        return new VariablesMapObject(argSlots, args, frame);
    }

    private Map<String, FrameSlot> getVars() {
        if (varSlots == null) {
            if (current != null) {
                varSlots = collectVars(block, current);
            } else if (block != null) {
                // Provide the arguments only when the current node is above the block
                varSlots = collectArgs(block);
            } else {
                varSlots = Collections.emptyMap();
            }
        }
        return varSlots;
    }

    private boolean hasParentVar(String name) {
        TVDLexicalScope p = this;
        while ((p = p.findParent()) != null) {
            if (p.getVars().containsKey(name)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, FrameSlot> collectVars(Node varsBlock, Node currentNode) {
        // Variables are slot-based.
        // To collect declared variables, traverse the block's AST and find slots associated
        // with TVDWriteLocalVariableNode. The traversal stops when we hit the current node.
        Map<String, FrameSlot> slots = new LinkedHashMap<>(4);
        NodeUtil.forEachChild(varsBlock, new NodeVisitor() {
            @Override
            public boolean visit(Node node) {
                if (node == currentNode) {
                    return false;
                }
                // Do not enter any nested blocks.
                if (!(node instanceof TVDBlockNode)) {
                    boolean all = NodeUtil.forEachChild(node, this);
                    if (!all) {
                        return false;
                    }
                }
                // Write to a variable is a declaration unless it exists already in a parent scope.
                if (node instanceof TVDWriteLocalVariableNode) {
                    TVDWriteLocalVariableNode wn = (TVDWriteLocalVariableNode) node;
                    String name = Objects.toString(wn.getSlot().getIdentifier());
                    if (!hasParentVar(name)) {
                        slots.put(name, wn.getSlot());
                    }
                }
                return true;
            }
        });
        return slots;
    }

    private static Map<String, FrameSlot> collectArgs(Node block) {
        // Arguments are pushed to frame slots at the beginning of the function block.
        // To collect argument slots, search for TVDReadArgumentNode inside of
        // TVDWriteLocalVariableNode.
        Map<String, FrameSlot> args = new LinkedHashMap<>(4);
        NodeUtil.forEachChild(block, new NodeVisitor() {

            private TVDWriteLocalVariableNode wn; // The current write node containing a slot

            @Override
            public boolean visit(Node node) {
                // When there is a write node, search for TVDReadArgumentNode among its children:
                if (node instanceof TVDWriteLocalVariableNode) {
                    wn = (TVDWriteLocalVariableNode) node;
                    boolean all = NodeUtil.forEachChild(node, this);
                    wn = null;
                    return all;
                } else if (wn != null && (node instanceof TVDReadArgumentNode)) {
                    FrameSlot slot = wn.getSlot();
                    String name = Objects.toString(slot.getIdentifier());
                    assert !args.containsKey(name) : name + " argument exists already.";
                    args.put(name, slot);
                    return true;
                } else if (wn == null && (node instanceof TVDStatementNode)) {
                    // A different TVD node - we're done.
                    return false;
                } else {
                    return NodeUtil.forEachChild(node, this);
                }
            }
        });
        return args;
    }

    @ExportLibrary(InteropLibrary.class)
    static final class VariablesMapObject implements TruffleObject {

        final Map<String, ? extends FrameSlot> slots;
        final Object[] args;
        final Frame frame;

        private VariablesMapObject(Map<String, ? extends FrameSlot> slots, Object[] args, Frame frame) {
            this.slots = slots;
            this.args = args;
            this.frame = frame;
        }

        @SuppressWarnings("static-method")
        @ExportMessage
        boolean hasMembers() {
            return true;
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        Object getMembers(@SuppressWarnings("unused") boolean includeInternal) {
            return new KeysArray(slots.keySet().toArray(new String[0]));
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        void writeMember(String member, Object value) throws UnsupportedMessageException, UnknownIdentifierException {
            if (frame == null) {
                throw UnsupportedMessageException.create();
            }
            FrameSlot slot = slots.get(member);
            if (slot == null) {
                throw UnknownIdentifierException.create(member);
            } else {
                Object info = slot.getInfo();
                if (args != null && info != null) {
                    args[(Integer) info] = value;
                } else {
                    frame.setObject(slot, value);
                }
            }
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        Object readMember(String member) throws UnknownIdentifierException {
            if (frame == null) {
                return TVDNull.SINGLETON;
            }
            FrameSlot slot = slots.get(member);
            if (slot == null) {
                throw UnknownIdentifierException.create(member);
            } else {
                Object value;
                Object info = slot.getInfo();
                if (args != null && info != null) {
                    value = args[(Integer) info];
                } else {
                    value = frame.getValue(slot);
                }
                return value;
            }
        }

        @SuppressWarnings("static-method")
        @ExportMessage
        boolean isMemberInsertable(@SuppressWarnings("unused") String member) {
            return false;
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        boolean isMemberModifiable(String member) {
            return slots.containsKey(member);
        }

        @ExportMessage
        @CompilerDirectives.TruffleBoundary
        boolean isMemberReadable(String member) {
            return frame == null || slots.containsKey(member);
        }

    }

    @ExportLibrary(InteropLibrary.class)
    static final class KeysArray implements TruffleObject {

        private final String[] keys;

        KeysArray(String[] keys) {
            this.keys = keys;
        }

        @SuppressWarnings("static-method")
        @ExportMessage
        boolean hasArrayElements() {
            return true;
        }

        @ExportMessage
        boolean isArrayElementReadable(long index) {
            return index >= 0 && index < keys.length;
        }

        @ExportMessage
        long getArraySize() {
            return keys.length;
        }

        @ExportMessage
        Object readArrayElement(long index) throws InvalidArrayIndexException {
            if (!isArrayElementReadable(index)) {
                throw InvalidArrayIndexException.create(index);
            }
            return keys[(int) index];
        }

    }

}
