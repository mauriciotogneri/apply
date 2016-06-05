package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;

public class SymbolNode extends ExpressionNode
{
    public SymbolNode(Token token)
    {
        super(token);
    }

    @Override
    public boolean isSymbol()
    {
        return true;
    }
}