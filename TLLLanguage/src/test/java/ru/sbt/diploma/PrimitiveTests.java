package ru.sbt.diploma;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
                        " @Partner: Romashka" + "\n" +
                        " println(Romashka)" + "\n" +
                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        Value result = getValue.execute();
        assertNotNull(result);
        assertEquals(result.toString(), "NULL");
    }

    @Test
    public void createObjectPropTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " @Partner: Romashka" + "\n" +
                        " Romashka.a: 12345" + "\n" +
                        " println(12) " +
                        " return Romashka" + "\n" +
                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        Value obj = getValue.execute();
        Assert.assertTrue(obj.hasMembers());

        Value a = obj.getMember("a");
        Assert.assertNotNull(a);
        Assert.assertTrue(a.isNumber());
        Assert.assertEquals(12345, a.asInt());
    }

    @Test
    public void createArrayTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " array[0] = 123" + "\n" +
                        " println(array[0])" + "\n" +
                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src); 

        Value getValue = context.getBindings("tll").getMember("START");
        Number ret = getValue.execute().as(Number.class);
        assertEquals(123, ret.intValue());
    }
}
