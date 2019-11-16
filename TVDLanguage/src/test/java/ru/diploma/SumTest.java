package ru.diploma;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumTest {

    private Context context;
    private Value sum;

    @Before
    public void initEngine() throws Exception {
        context = Context.create();
        // @formatter:off
        context.eval("tvd", "77 + 23");
        // @formatter:on
        sum = context.getBindings("tvd").getMember("main");
    }

    @After
    public void dispose() {
        context.close();
    }

    @Test
    public void factorialOf5() throws Exception {
        Number ret = sum.execute().as(Number.class);
        assertEquals(100, ret.intValue());
    }
}
