package com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionBinaryNode;

public class ArithmeticDivisionNode extends ExpressionBinaryNode
{
    public ArithmeticDivisionNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}