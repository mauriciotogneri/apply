package com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ComparisonNotEqualNode extends ComparisonNode
{
    public ComparisonNotEqualNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}