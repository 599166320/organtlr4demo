package org.arrayinit;

import org.arrayinit.antlr4.ArrayInitBaseListener;
import org.arrayinit.antlr4.ArrayInitParser;

import java.io.PrintStream;

public class ShortToUnicodeString extends ArrayInitBaseListener {

    private PrintStream out = System.out;

    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        out.print("\"");
    }

    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        out.print("\"");
    }

    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        final int value = Integer.parseInt(ctx.INIT().getText());
        out.format("\\u%04x", value);
    }


}