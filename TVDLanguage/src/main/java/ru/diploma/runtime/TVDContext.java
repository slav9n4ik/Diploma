package ru.diploma.runtime;

import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.frame.VirtualFrame;
import ru.diploma.TVDLanguage;
import ru.diploma.builtin.AddBuiltinNodeFactory;

import static ru.diploma.builtin.BuiltinNode.createBuiltinFunction;

/**
 * The run-time state of SL during execution. The context is created by the {@link TVDLanguage}. It
 * is used, for example, by {@link TVDBuiltinNode#getContext() builtin functions}.
 * <p>
 * It would be an error to have two different context instances during the execution of one script.
 * However, if two separate scripts run in one Java VM at the same time, they have a different
 * context. Therefore, the context is not a singleton.
 */
public class TVDContext {
    private final FrameDescriptor globalFrameDescriptor;
    private final MaterializedFrame globalFrame;

    public TVDContext() {
        this.globalFrameDescriptor = new FrameDescriptor();
        this.globalFrame = this.initGlobalFrame();
    }

    private MaterializedFrame initGlobalFrame() {
        VirtualFrame frame = Truffle.getRuntime().createVirtualFrame(null,
                this.globalFrameDescriptor);
        addGlobalFunctions(frame);
        return frame.materialize();
    }

    private static void addGlobalFunctions(VirtualFrame virtualFrame) {
        FrameDescriptor frameDescriptor = virtualFrame.getFrameDescriptor();
        virtualFrame.setObject(frameDescriptor.addFrameSlot("+"),
                createBuiltinFunction(AddBuiltinNodeFactory.getInstance(),
                        virtualFrame));
    }

    /**
     * @return A {@link MaterializedFrame} on the heap that contains all global
     * values.
     */
    public MaterializedFrame getGlobalFrame() {
        return this.globalFrame;
    }
}
