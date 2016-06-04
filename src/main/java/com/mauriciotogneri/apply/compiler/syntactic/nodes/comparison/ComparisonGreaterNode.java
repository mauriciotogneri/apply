package com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionBinaryNode;

public class ComparisonGreaterNode extends ExpressionBinaryNode
{
    public ComparisonGreaterNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}