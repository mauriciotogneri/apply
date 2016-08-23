package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefNode extends TreeNode
{
    private final List<TreeNode> parameters;
    private final TreeNode returnType;
    private final TreeNode body;

    private FunctionDefNode(Token token, List<TreeNode> parameters, TreeNode returnType, TreeNode body)
    {
        super(token);

        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    public FunctionDefNode(Token token)
    {
        this(token, new ArrayList<>(), null, null);
    }

    public FunctionDefNode withTypes(List<TreeNode> parameters, TreeNode returnType)
    {
        return new FunctionDefNode(token, parameters, returnType, body);
    }

    public FunctionDefNode withBody(TreeNode body)
    {
        return new FunctionDefNode(token, parameters, returnType, body);
    }

    @Override
    public boolean isFunctionDef()
    {
        return true;
    }

    @Override
    public List<TreeNode> children()
    {
        return new ArrayList<TreeNode>()
        {{
            addAll(parameters);
            add(returnType);
            add(body);
        }};
    }

    @Override
    public String sourceCode()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("public static %s %s", returnType.sourceCode(), token.lexeme().substring(1)));

        if (!parameters.isEmpty())
        {
            builder.append("(");

            for (int i = 0; i < parameters.size(); i++)
            {
                if (i != 0)
                {
                    builder.append(", ");
                }

                builder.append(parameters.get(i).sourceCode());
            }

            builder.append(")\n");
        }

        builder.append("{\n");
        builder.append(String.format("%s", body.sourceCode()));
        builder.append("}\n");

        return builder.toString();
    }
}