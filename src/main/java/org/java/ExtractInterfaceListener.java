package org.java;
import org.antlr.v4.runtime.TokenStream;
import org.java.antlr4.JavaBaseListener;
import org.java.antlr4.JavaParser;

public class ExtractInterfaceListener extends JavaBaseListener
{
  private JavaParser parser;
  public ExtractInterfaceListener(JavaParser parser){
    this.parser = parser;
  }

  @Override
  public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx)
  {
    System.out.println("interface I"+ctx.Identifier().getText()+" {");
  }

  @Override
  public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx)
  {
    System.out.println("}");
  }

  @Override
  public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx)
  {
    TokenStream tokenStream = parser.getTokenStream();
    String type = "void";
    if(ctx.type() != null){
      type = tokenStream.getText(ctx.type());
    }
    String args = tokenStream.getText((ctx.formalParameters()));
    System.out.println(type +" "+ctx.Identifier().getText()+""+args+";");
  }
}
