package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ArithmeticSubtractionNode extends ArithmeticNode
{
    public ArithmeticSubtractionNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}