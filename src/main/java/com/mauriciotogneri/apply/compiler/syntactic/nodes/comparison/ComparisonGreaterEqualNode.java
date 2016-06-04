package com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class ComparisonGreaterEqualNode extends ComparisonNode
{
    public ComparisonGreaterEqualNode(Token token, TreeNode left, TreeNode right)
    {
        super(token, left, right);
    }
}