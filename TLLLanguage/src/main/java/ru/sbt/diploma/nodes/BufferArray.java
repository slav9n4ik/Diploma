package ru.sbt.diploma.nodes;

import java.util.ArrayList;
import java.util.List;

public final class BufferArray {
    public Object length;
    public List<Object> buffer;

    public BufferArray() {
        this.buffer = new ArrayList<>();
    }
}
