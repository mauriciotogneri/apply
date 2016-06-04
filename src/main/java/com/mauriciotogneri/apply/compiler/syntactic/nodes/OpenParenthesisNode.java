package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

public class OpenParenthesisNode extends TreeNode
{
    public OpenParenthesisNode(Token token)
    {
        super(token);
    }
}