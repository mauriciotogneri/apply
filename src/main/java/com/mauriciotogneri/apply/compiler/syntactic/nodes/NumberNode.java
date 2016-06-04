package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class NumberNode extends TreeNode
{
    public NumberNode(Token token)
    {
        super(token);
    }
}