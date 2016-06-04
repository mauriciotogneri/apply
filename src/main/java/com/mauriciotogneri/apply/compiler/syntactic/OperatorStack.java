package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;

import java.util.ArrayDeque;

public class OperatorStack extends ArrayDeque<Token>
{
    public void dequeueLowerPreference(Token token, NodeStack nodeStack)
    {
        while (!isEmpty() && peek().isOperator() && peek().hasHigherPreference(token))
        {
            nodeStack.addToken(pop());
        }
    }

    public void dequeueUntilOpenParenthesis(NodeStack nodeStack)
    {
        while (!isEmpty() && !peek().isOpenParenthesis())
        {
            nodeStack.addToken(pop());
        }
    }

    public void dequeueConditional(NodeStack nodeStack)
    {
        if (!isEmpty() && peek().isElse())
        {
            pop();
        }
        else
        {
            throw new RuntimeException();
        }

        while (!isEmpty() && peek().isIfElse())
        {
            nodeStack.addToken(pop());
        }

        if (!isEmpty() && peek().isIf())
        {
            nodeStack.addToken(pop());
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public boolean isTopSymbol()
    {
        return (!isEmpty() && peek().isSymbol());
    }
}