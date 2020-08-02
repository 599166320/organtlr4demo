package org.label;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.label.antlr4.LabeledExprLexer;
import org.label.antlr4.LabeledExprParser;
public class LabelExprMain
{
  public static void main(String[] args)
  {
    CharStream input = CharStreams.fromString("i=1 \r\n j=10 \r\n i+j \r\n");
    LabeledExprLexer lexer = new LabeledExprLexer(input);
    CommonTokenStream tokenStream = new CommonTokenStream(lexer);
    LabeledExprParser parser = new LabeledExprParser(tokenStream);
    EvalVisitor visitor = new EvalVisitor();
    System.out.println(visitor.visit(parser.prag()));;
  }
}
