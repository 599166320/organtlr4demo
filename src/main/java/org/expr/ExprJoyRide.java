package org.expr;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.expr.antlr4.ExprLexer;
import org.expr.antlr4.ExprParser;

public class ExprJoyRide {
    public static void main(String[] args) {
        CharStream input = CharStreams.fromString("a=1+1   ");
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prag();
        System.out.println(tree.toStringTree(parser));
    }
}
