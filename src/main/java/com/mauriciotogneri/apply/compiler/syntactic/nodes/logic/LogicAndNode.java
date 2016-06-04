package com.mauriciotogneri.apply.compiler.syntactic.nodes.logic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionBinaryNode;

public class LogicAndNode extends ExpressionBinaryNode
{
    public LogicAndNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}