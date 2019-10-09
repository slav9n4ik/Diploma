package mumbler;

import mumbler.forms.SpecialForm;
import mumbler.node.*;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Reader {
    public static ListNode read(InputStream istream) throws IOException {
        return read(new PushbackReader(new InputStreamReader(istream)));
    }

    private static ListNode read(PushbackReader pstream)
            throws IOException {
        List<Node> nodes = new LinkedList<>();

        readWhitespace(pstream);
        char c = (char) pstream.read();
        while ((byte) c != -1) {
            pstream.unread(c);
            nodes.add(readNode(pstream));
            readWhitespace(pstream);
            c = (char) pstream.read();
        }

        return ListNode.list(nodes);
    }

    private static void readWhitespace(PushbackReader pstream) throws IOException {
        char c;
        do {
            c = (char) pstream.read();
        } while (Character.isWhitespace(c));
        pstream.unread(c);
    }

    public static Node readNode(PushbackReader pstream) throws IOException {
        char c = (char) pstream.read();
        pstream.unread(c);
        if (c == '(') {
            return readList(pstream);
        } else if (Character.isDigit(c)) {
            return readNumber(pstream);
        } else if (c == '#') {
            return readBoolean(pstream);
        } else if (c == ')') {
            throw new IllegalArgumentException("Unmatched close paren");
        } else {
            return readSymbol(pstream);
        }
    }

    private static NumberNode readNumber(PushbackReader pstream) throws IOException {
        StringBuffer stringNum = new StringBuffer();
        char digit = (char) pstream.read();
        while (Character.isDigit(digit)) {
            stringNum.append(digit);
            digit = (char) pstream.read();
        }
        //assert (digit == ' ' || digit == '\t' || digit == '\n') : "Reading a list must start with '('";
        pstream.unread(digit);
        return new NumberNode(Long.valueOf(stringNum.toString()));
    }

    private static Node readBoolean(PushbackReader pstream) throws IOException {
        char bool = (char) pstream.read();
        //if (bool == '#') throw new IllegalArgumentException("Reading a boolean must start with '#'");
        bool = (char) pstream.read();
        if (bool != 't' && bool != 'f') throw new IllegalArgumentException("After # there must be 't' or 'f'");
        if (bool == 'f') {
            return new BooleanNode(false);
        }
        return new BooleanNode(true);
    }

    private static Node readSymbol(PushbackReader pstream) throws IOException {
        StringBuffer symbol = new StringBuffer();
        char c = (char) pstream.read();
        while (!Character.isWhitespace(c) && c != -1 && c != ')' && c != '\uFFFF') { //\uFFFF occured at the end of line while reading in IDE
            symbol.append(c);
            c = (char) pstream.read();
        }
        //assert (digit == ' ' || digit == '\t' || digit == '\n') : "Reading a list must start with '('";
        pstream.unread(c);
        return new SymbolNode(symbol.toString());
    }

    private static Node readList(PushbackReader pstream) throws IOException {
        char paren = (char) pstream.read();
        //assert paren == '(' : "Reading a list must start with '('";
        List<Node> list = new LinkedList<>();
        do {
            readWhitespace(pstream);
            char c = (char) pstream.read();

            if (c == ')') {
                // end of list
                break;
            } else if ((byte) c == -1) {
                throw new EOFException("EOF reached before closing of list");
            } else {
                pstream.unread(c);
                list.add(readNode(pstream));
            }
        } while (true);

        return SpecialForm.check(ListNode.list(list));
    }
}
