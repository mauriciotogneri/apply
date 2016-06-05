package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class AssignmentNode extends ExpressionBinaryNode
{
    public AssignmentNode(Token token, TreeNode definition, TreeNode expression)
    {
        super(token, definition, expression);
    }

    @Override
    public String sourceCode()
    {
        return String.format("%s = %s", left.sourceCode(), right.sourceCode());
    }
}