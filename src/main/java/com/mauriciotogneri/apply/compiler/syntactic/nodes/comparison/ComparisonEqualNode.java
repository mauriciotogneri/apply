package com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ComparisonEqualNode extends ComparisonNode
{
    public ComparisonEqualNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}