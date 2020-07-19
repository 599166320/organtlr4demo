package org.arrayinit;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.arrayinit.antlr4.ArrayInitLexer;
import org.arrayinit.antlr4.ArrayInitParser;

import java.io.IOException;

public class ArrayInitMain {
    public static void main(String[] args) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        //CharStream input = CharStreams.fromString("{1,2,3}");
        ArrayInitLexer lexer = new ArrayInitLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokens);
        ParseTree tree = parser.init();
        //System.out.println(tree.toStringTree(parser));
        ParseTreeWalker walker  = new ParseTreeWalker();
        walker.walk(new ShortToUnicodeString(),tree);
        System.out.println();
    }
}
