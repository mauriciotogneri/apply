package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ArithmeticAdditionNode extends ArithmeticNode
{
    public ArithmeticAdditionNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}