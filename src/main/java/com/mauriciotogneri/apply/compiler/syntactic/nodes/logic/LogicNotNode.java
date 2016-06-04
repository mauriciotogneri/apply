package com.mauriciotogneri.apply.compiler.syntactic.nodes.logic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionUnaryNode;

public class LogicNotNode extends ExpressionUnaryNode
{
    public LogicNotNode(Token token, TreeNode expression)
    {
        super(token, expression);
    }
}