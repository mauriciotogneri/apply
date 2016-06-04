package com.mauriciotogneri.apply.compiler.syntactic.nodes.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ComparisonNode extends TreeNode
{
    private final TreeNode left;
    private final TreeNode right;

    public ComparisonNode(Token token, TreeNode left, TreeNode right)
    {
        super(token);

        this.left = left;
        this.right = right;
    }

    @Override
    public boolean isExpression()
    {
        return true;
    }

    @Override
    public List<TreeNode> children()
    {
        return new ArrayList<TreeNode>()
        {{
            add(left);
            add(right);
        }};
    }
}