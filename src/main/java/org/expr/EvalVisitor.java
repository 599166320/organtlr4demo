package org.expr;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.expr.antlr4.ExprBaseVisitor;
import org.expr.antlr4.ExprParser;

public class EvalVisitor extends ExprBaseVisitor<String>
{
  @Override
  public String visitExpr(ExprParser.ExprContext ctx)
  {
    return super.visitExpr(ctx);
  }

  @Override
  public String visitTerminal(TerminalNode node)
  {
    return super.visitTerminal(node);
  }
}
