package com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ArithmeticMultiplicationNode extends ArithmeticNode
{
    public ArithmeticMultiplicationNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}