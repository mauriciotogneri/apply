package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticAdditionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticDivisionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticModuleToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticMultiplicationToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticPowerToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticSubtractionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticToken;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticAdditionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticDivisionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticModuleNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticMultiplicationNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticPowerNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.arithmetic.ArithmeticSubtractionNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.NumberNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.OpenParenthesisNode;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.conditional.ConditionalIfNode;

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
        else if (token.isOpenParenthesis())
        {
            push(new OpenParenthesisNode(token));
        }
        else if (token.isIfElse() || token.isIf())
        {
            addConditionalIf(token);
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private void addArithmeticNode(Token token)
    {
        if (size() >= 2)
        {
            TreeNode right = pop();
            TreeNode left = pop();

            if (right.isExpression() && left.isExpression())
            {
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
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }

    private void addConditionalIf(Token token)
    {
        if (size() >= 3)
        {
            TreeNode right = pop();
            TreeNode left = pop();
            TreeNode condition = pop();

            if (right.isExpression() && left.isExpression() && condition.isExpression())
            {
                push(new ConditionalIfNode(token, left, right, condition));
            }
            else
            {
                throw new RuntimeException();
            }
        }
        else
        {
            throw new RuntimeException();
        }
    }
}