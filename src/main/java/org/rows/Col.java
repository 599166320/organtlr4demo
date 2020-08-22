package org.rows;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.rows.antlr4.RowsLexer;
import org.rows.antlr4.RowsParser;
import java.io.FileInputStream;
import java.io.IOException;
public class Col
{
  public static void main(String[] args) throws IOException
  {
    CharStream input = CharStreams.fromStream(new FileInputStream("D:\\yy\\organtlr4demo\\src\\main\\resources\\rows.txt"));
    RowsLexer lexer = new RowsLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    final RowsParser parser = new RowsParser(tokens, 2);
    parser.setBuildParseTree(false);
    parser.file();  // parse
  }
}
