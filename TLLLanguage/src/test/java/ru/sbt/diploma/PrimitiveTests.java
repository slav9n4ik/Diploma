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
    public void initEngine() {
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
                " return 100 \n" +
                "END\n"
        );
        print = context.getBindings("tll").getMember("START");
        Number ret = print.execute().as(Number.class);
        assertEquals(ret.longValue(), 100);
    }

    @Test
    public void printSumTest() {
        context.eval("tll", "\n" +
                "START \n" +
                " println(100 + 23) \n" +
                " return 100 + 23 \n" +
                "END\n"
        );
        print = context.getBindings("tll").getMember("START");
        Number ret = print.execute().as(Number.class);
        assertEquals(ret.longValue(), 123);
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
                        " Romashka.b: 54321" + "\n" +
                        " Romashka.c: kek" + "\n" +     //Strings not allowed
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

        Value b = obj.getMember("b");
        Assert.assertNotNull(b);
        Assert.assertTrue(b.isNumber());
        Assert.assertEquals(54321, b.asInt());

        Value c = obj.getMember("c");
        Assert.assertNotNull(c);
        Assert.assertFalse(b.isString());
    }

    @Test
    public void createArrayTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " array[1]: 1234" + "\n" +
                        " array[2]: 5678" + "\n" +
                        " println(array[1])" + "\n" +
                        " println(array[2])" + "\n" +
                        " return array[1] " + "\n" +
                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        Number ret = getValue.execute().as(Number.class);
        assertEquals(ret.longValue(), 1234);
    }

    @Test
    public void createObjectArrayPropTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " @Partner: Romashka" + "\n" +
                        " Romashka.sublimit[1]: 12345" + "\n" +
                        " Romashka.sublimit[2]: 54321" + "\n" +
                        " return Romashka.sublimit[2]" + "\n" +
                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        Number ret = getValue.execute().as(Number.class);
        assertEquals(ret.longValue(), 54321);
    }

    @Test
    public void printObjectArrayPropTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " @Partner: Romashka" + "\n" +
                        " Romashka.sublimit[1]: 12345" + "\n" +
                        " Romashka.sublimit[2]: 54321" + "\n" +
                        " println(Romashka.sublimit[2])" + "\n" +
                        " println(Romashka.sublimit[1])" + "\n" +
                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        getValue.execute();
    }

    @Test
    public void complexTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " @Partner: Romashka" + "\n" +
                        " Romashka.limit: 100000" + "\n" +

                        " @Partner: SuperRomashka" + "\n" +
                        " SuperRomashka.limit: 200000" + "\n" +

                        " Romashka.sublimit[1]: 12345" + "\n" +
                        " Romashka.sublimit[2]: 54321" + "\n" +

                        " SuperRomashka.sublimit[1]: 67890" + "\n" +
                        " SuperRomashka.sublimit[2]: 9876" + "\n" +

                        " println(Romashka.limit)" + "\n" +
                        " println(Romashka.sublimit[2])" + "\n" +
                        " println(Romashka.sublimit[1])" + "\n" +

                        " println(SuperRomashka.limit)" + "\n" +
                        " println(SuperRomashka.sublimit[2])" + "\n" +
                        " println(SuperRomashka.sublimit[1])" + "\n" +
                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        getValue.execute();
    }

    @Test
    public void checkFunctionTest() {
        final Source src = Source.newBuilder("tll",
                "\n" +
                        "START \n" +
                        " @Partner: Romashka" + "\n" +
                        " Romashka.limit: 100000" + "\n" +

                        " Romashka.sublimit[1]: 12345" + "\n" +
                        " Romashka.sublimit[2]: 554321" + "\n" +

                        " check(Romashka)" + "\n" +

                        "END\n",
                "testObject.tll").buildLiteral();
        context.eval(src);

        Value getValue = context.getBindings("tll").getMember("START");
        getValue.execute();
    }
}
