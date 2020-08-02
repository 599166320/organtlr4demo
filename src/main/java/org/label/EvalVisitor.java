package org.label;
import org.label.antlr4.LabeledExprBaseVisitor;
import org.label.antlr4.LabeledExprParser;

import java.util.HashMap;
import java.util.Map;
public class EvalVisitor extends LabeledExprBaseVisitor<Integer>
{
  private Map<String,Integer> memory = new HashMap<String, Integer>();

  @Override
  public Integer visitInt(LabeledExprParser.IntContext ctx)
  {
    return Integer.parseInt(ctx.INT().getText());
  }

  public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx)
  {
    Integer val = visit(ctx.expr());
    if(val == null){
      val = 0;
    }
    return val;
  }

  public Integer visitAssign(LabeledExprParser.AssignContext ctx)
  {
    String id = ctx.ID().getText();
    Integer val = visit(ctx.expr());
    memory.put(id,val);
    return val;
  }

  public Integer visitParens(LabeledExprParser.ParensContext ctx)
  {
    return visit(ctx.expr());
  }

  public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx)
  {
    Integer left = visit(ctx.expr(0));
    Integer rigth = visit(ctx.expr(1));
    return left/rigth;
  }

  public Integer visitAddSub(LabeledExprParser.AddSubContext ctx)
  {
    Integer left = visit(ctx.expr(0));
    Integer rigth = visit(ctx.expr(1));
    if(ctx.op.getType()==LabeledExprParser.ADD){
      return left+rigth;
    }
    return left-rigth;
  }

  public Integer visitId(LabeledExprParser.IdContext ctx)
  {
    String id = ctx.ID().getText();
    if(memory.containsKey(id)){
      return memory.get(id);
    }
    return 0;
  }
}
