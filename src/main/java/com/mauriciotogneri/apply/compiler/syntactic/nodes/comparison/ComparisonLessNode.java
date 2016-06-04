package com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ComparisonLessNode extends ComparisonNode
{
    public ComparisonLessNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}