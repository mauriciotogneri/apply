package com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionBinaryNode;

public class ArithmeticSubtractionNode extends ExpressionBinaryNode
{
    public ArithmeticSubtractionNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}