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
        // @formatter:off
        context.eval("tvd", "\n" +
                "START \n" +
                " println(100) \n" +
                "END\n"
        );
        // @formatter:on
        print = context.getBindings("tvd").getMember("START");
    }

    @After
    public void dispose() {
        context.close();
    }

    @Test
    public void printNumberTest() throws Exception {
        Number ret = print.execute().as(Number.class);
        assertEquals(100, ret.intValue());
    }
}
