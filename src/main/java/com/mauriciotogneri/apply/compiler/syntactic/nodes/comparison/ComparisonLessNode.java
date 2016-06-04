package com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionBinaryNode;

public class ComparisonLessNode extends ExpressionBinaryNode
{
    public ComparisonLessNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}