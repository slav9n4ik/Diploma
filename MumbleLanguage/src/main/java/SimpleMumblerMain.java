import mumbler.Reader;
import mumbler.environment.Environment;
import mumbler.node.ListNode;
import mumbler.node.Node;

import java.io.*;

public class SimpleMumblerMain {
    public static void main(String[] args) throws IOException {
        assert args.length < 2 : "SimpleMumbler only accepts 1 or 0 files";
        if (args.length == 0) {
            startREPL();
        } else {
            runMumbler(args[0]);
        }
    }

    private static void startREPL() throws IOException {
        Environment topEnv = Environment.getBaseEnvironment();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            // READ
            System.out.print("~> ");
            String data = br.readLine();
            if (data == null) {
                // EOF sent
                break;
            }

            ListNode nodes = Reader.read(new ByteArrayInputStream(data.getBytes()));

            // EVAL
            Object result = ListNode.EMPTY;
            for (Node node : nodes) {
                result = node.eval(topEnv);
            }

            // PRINT
            if (result != ListNode.EMPTY) {
                System.out.println(result);
            }
        }
    }

    private static void runMumbler(String filename) throws IOException {
        Environment topEnv = Environment.getBaseEnvironment();

        ListNode nodes = Reader.read(new FileInputStream(filename));
        for (Node node : nodes) {
            node.eval(topEnv);
        }
    }
}