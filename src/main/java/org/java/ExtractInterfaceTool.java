package org.java;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.java.antlr4.JavaLexer;
import org.java.antlr4.JavaParser;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExtractInterfaceTool
{
  public static void main(String[] args) throws IOException
  {
    CharStream input = CharStreams.fromStream(new FileInputStream("D:\\ide\\git项目\\op_service_manage\\apm-service\\src\\main\\java\\com\\yy\\devops\\apm\\service\\ApmQueryService.java"));
    JavaLexer lexer = new JavaLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);
    ParseTree tree = parser.compilationUnit();
    ParseTreeWalker walker = new ParseTreeWalker();
    ExtractInterfaceListener extract = new ExtractInterfaceListener(parser);
    walker.walk(extract,tree);
  }

  interface IApmQueryService {
    void queryModelTimeseries(String scode,String start,String end);
    String queryGroupBy(String scode, String start, String end, Map<String,String> filterMap, List<String> dims, int limit);
  }
  interface IMapKeyComparator {
    int compare(Long str1, Long str2);
  }
}


























