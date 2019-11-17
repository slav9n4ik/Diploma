package ru.diploma;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimitiveTests {

    private Context context;
    private Value print;

    @Before
    public void initEngine() throws Exception {
        context = Context.create();
    }

    @After
    public void dispose() {
        context.close();
    }

    @Test
    public void printNumberTest() throws Exception {
        context.eval("tll", "\n" +
                "START \n" +
                " println(100) \n" +
                "END\n"
        );
        print = context.getBindings("tll").getMember("START");

        Number ret = print.execute().as(Number.class);
        assertEquals(100, ret.intValue());
    }

    @Test
    public void printSumTest() throws Exception {
        context.eval("tll", "\n" +
                "START \n" +
                " println(100 + 23) \n" +
                "END\n"
        );
        print = context.getBindings("tll").getMember("START");

        Number ret = print.execute().as(Number.class);
        assertEquals(123, ret.intValue());
    }
}
