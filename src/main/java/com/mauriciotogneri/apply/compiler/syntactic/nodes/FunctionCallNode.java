package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

import java.util.List;

public class FunctionCallNode extends ExpressionNode
{
    private final List<TreeNode> parameters;

    public FunctionCallNode(Token token, List<TreeNode> parameters)
    {
        super(token);

        this.parameters = parameters;
    }

    @Override
    public List<TreeNode> children()
    {
        return parameters;
    }
}