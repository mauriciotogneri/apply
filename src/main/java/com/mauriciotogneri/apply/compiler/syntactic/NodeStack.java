package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticAdditionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticDivisionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticModuleToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticMultiplicationToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticPowerToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticSubtractionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticToken;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ArithmeticAdditionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ArithmeticDivisionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ArithmeticModuleNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ArithmeticMultiplicationNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ArithmeticPowerNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.ArithmeticSubtractionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.NumberNode;

import java.util.ArrayDeque;

public class NodeStack extends ArrayDeque<TreeNode>
{
    public void addToken(Token token)
    {
        if (token.isNumber())
        {
            push(new NumberNode(token));
        }
        else if (token instanceof ArithmeticToken)
        {
            addArithmeticNode(token);
        }
    }

    private void addArithmeticNode(Token token)
    {
        TreeNode right = extractNode();
        TreeNode left = extractNode();

        if (token instanceof ArithmeticAdditionToken)
        {
            push(new ArithmeticAdditionNode(token, left, right));
        }
        else if (token instanceof ArithmeticSubtractionToken)
        {
            push(new ArithmeticSubtractionNode(token, left, right));
        }
        else if (token instanceof ArithmeticMultiplicationToken)
        {
            push(new ArithmeticMultiplicationNode(token, left, right));
        }
        else if (token instanceof ArithmeticDivisionToken)
        {
            push(new ArithmeticDivisionNode(token, left, right));
        }
        else if (token instanceof ArithmeticPowerToken)
        {
            push(new ArithmeticPowerNode(token, left, right));
        }
        else if (token instanceof ArithmeticModuleToken)
        {
            push(new ArithmeticModuleNode(token, left, right));
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private TreeNode extractNode()
    {
        if (isEmpty())
        {
            throw new RuntimeException();
        }

        return pop();
    }
}