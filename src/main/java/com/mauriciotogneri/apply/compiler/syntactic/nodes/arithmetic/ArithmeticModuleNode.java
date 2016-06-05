package com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionBinaryNode;

public class ArithmeticModuleNode extends ExpressionBinaryNode
{
    public ArithmeticModuleNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }

    @Override
    public String sourceCode()
    {
        return String.format("mod(%s, %s)", left.sourceCode(), right.sourceCode());
    }
}