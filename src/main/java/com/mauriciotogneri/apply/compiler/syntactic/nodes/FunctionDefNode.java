package com.mauriciotogneri.apply.compiler.syntactic.nodes;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.syntactic.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefNode extends TreeNode
{
    private final List<TreeNode> parameters;
    private final TreeNode returnType;

    public FunctionDefNode(Token token, List<TreeNode> parameters, TreeNode returnType)
    {
        super(token);

        this.parameters = parameters;
        this.returnType = returnType;
    }

    public FunctionDefNode(Token token)
    {
        this(token, new ArrayList<>(), null);
    }

    @Override
    public boolean isFunctionDef()
    {
        return true;
    }

    @Override
    public List<TreeNode> children()
    {
        return parameters;
    }
}