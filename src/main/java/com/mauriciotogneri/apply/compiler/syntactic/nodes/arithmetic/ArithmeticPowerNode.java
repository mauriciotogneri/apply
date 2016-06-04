package com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ArithmeticPowerNode extends ArithmeticNode
{
    public ArithmeticPowerNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}