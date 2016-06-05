package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class TypeOfNode extends ExpressionBinaryNode
{
    public TypeOfNode(Token token, TreeNode name, TreeNode type)
    {
        super(token, name, type);
    }

    @Override
    public boolean isTypeOf()
    {
        return true;
    }

    @Override
    public String sourceCode()
    {
        return String.format("%s %s", right.sourceCode(), left.sourceCode());
    }
}