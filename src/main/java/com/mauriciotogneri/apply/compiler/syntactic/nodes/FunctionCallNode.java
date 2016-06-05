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

    @Override
    public String sourceCode()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(token.lexeme());
        builder.append("(");

        for (int i = 0; i < parameters.size(); i++)
        {
            if (i != 0)
            {
                builder.append(", ");
            }

            builder.append(parameters.get(i).sourceCode());
        }

        builder.append(")");

        return builder.toString();
    }
}