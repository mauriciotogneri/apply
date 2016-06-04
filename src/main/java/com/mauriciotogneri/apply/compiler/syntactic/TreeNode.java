package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;

import java.util.ArrayList;
import java.util.List;

public abstract class TreeNode
{
    private final Token token;

    public TreeNode(Token token)
    {
        this.token = token;
    }

    public List<TreeNode> children()
    {
        return new ArrayList<>();
    }

    public String printPretty(String indent, boolean last)
    {
        String newIndent = indent;
        StringBuilder builder = new StringBuilder();

        builder.append(indent);

        if (last)
        {
            builder.append("└─");
            newIndent += "   ";
        }
        else
        {
            builder.append("├─");
            newIndent += "│ ";
        }

        builder.append(" ").append(token.toString()).append("\n");

        List<TreeNode> children = children();

        for (int i = 0; i < children.size(); i++)
        {
            TreeNode child = children.get(i);
            builder.append(child.printPretty(newIndent, i == children.size() - 1));
        }

        return builder.toString();
    }

    @Override
    public String toString()
    {
        return printPretty("", true);
    }
}