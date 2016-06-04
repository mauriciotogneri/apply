package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;

public class NumberNode extends ExpressionNode
{
    public NumberNode(Token token)
    {
        super(token);
    }
}