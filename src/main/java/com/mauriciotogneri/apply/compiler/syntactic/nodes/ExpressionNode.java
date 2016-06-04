package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ExpressionNode extends TreeNode
{
    public ExpressionNode(Token token)
    {
        super(token);
    }

    @Override
    public boolean isExpression()
    {
        return true;
    }
}