package ru.diploma;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
    public void printNumberTest() {
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
    public void printSumTest() {
        context.eval("tll", "\n" +
                "START \n" +
                " println(100 + 23) \n" +
                "END\n"
        );
        print = context.getBindings("tll").getMember("START");

        Number ret = print.execute().as(Number.class);
        assertEquals(123, ret.intValue());
    }

    @Test
    public void createObjectTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " Partner: Romashka" + "\n" +
                        //" println(Romashka)" + "\n" +
                        "END\n",
                "testObject.sl").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        Value result = getValue.execute();
//        assertNotNull(result);
//        assertEquals(result.toString(), "NULL");
    }
}
