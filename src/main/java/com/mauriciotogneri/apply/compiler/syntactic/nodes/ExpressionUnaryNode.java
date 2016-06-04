package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionUnaryNode extends ExpressionNode
{
    private final TreeNode expression;

    public ExpressionUnaryNode(Token token, TreeNode expression)
    {
        super(token);

        this.expression = expression;
    }

    @Override
    public List<TreeNode> children()
    {
        return new ArrayList<TreeNode>()
        {{
            add(expression);
        }};
    }
}