package com.mauriciotogneri.apply.compiler.syntactic.nodes.conditional;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ExpressionNode;

import java.util.ArrayList;
import java.util.List;

public class ConditionalIfNode extends ExpressionNode
{
    private final TreeNode condition;
    private final TreeNode ifTrue;
    private final TreeNode ifFalse;

    public ConditionalIfNode(Token token, TreeNode condition, TreeNode ifTrue, TreeNode ifFalse)
    {
        super(token);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    @Override
    public List<TreeNode> children()
    {
        return new ArrayList<TreeNode>()
        {{
            add(condition);
            add(ifTrue);
            add(ifFalse);
        }};
    }

    @Override
    public String sourceCode()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("if (%s)\n", condition.sourceCode()));
        builder.append("{\n");
        builder.append(String.format("return %s;\n", ifTrue.sourceCode()));
        builder.append("}\n");
        builder.append("else\n");
        builder.append("{\n");
        builder.append(String.format("return %s;\n", ifFalse.sourceCode()));
        builder.append("}\n");

        return builder.toString();
    }
}