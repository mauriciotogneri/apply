package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.base.Token;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParsedExpression
{
    private final List<Token> expression;

    public ParsedExpression(List<Token> expression)
    {
        this.expression = expression;
    }

    private Map<String, Integer> ops = new HashMap<String, Integer>()
    {{
        put("+", 1);
        put("-", 2);
        put("*", 3);
        put("/", 4);
        put(".", 5);
    }};

    private boolean isHigherPrecedence(String op, String sub)
    {
        return (ops.containsKey(sub) && ops.get(sub) >= ops.get(op));
    }

    public List<Token> parse()
    {
        List<Token> output = new ArrayList<>();
        Deque<Token> stack = new LinkedList<>();

        for (int i = 0; i < expression.size(); i++)
        {
            Token token = expression.get(i);

            if (token.isOperator())
            {
                while (!stack.isEmpty() && isHigherPrecedence(token.lexeme(), stack.peek().lexeme()))
                {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
            else if (token.isOpenParenthesis())
            {
                stack.push(token);
            }
            else if (token.isCloseParenthesis())
            {
                while (!stack.peek().isOpenParenthesis())
                {
                    output.add(stack.pop());
                }

                stack.pop();

                if (stack.peek().isSymbol())
                {
                    output.add(stack.pop());
                }
            }
            else if (token.isComma())
            {
                while (!stack.peek().isOpenParenthesis())
                {
                    output.add(stack.pop());
                }
            }
            else if (token.isNumber())
            {
                output.add(token);
            }
            else if (token.isSymbol())
            {
                Token nextToken = expression.get(i + 1);

                if (nextToken.isOpenParenthesis())
                {
                    stack.push(token);
                }
                else
                {
                    output.add(token);
                }
            }
            else
            {
                throw new RuntimeException(token.toString());
            }
        }

        while (!stack.isEmpty())
        {
            output.add(stack.pop());
        }

        return output;
    }

    private boolean isSymbol(String value)
    {
        return Character.isLetter(value.charAt(0));
    }

    private boolean isOperator(String value)
    {
        return value.equals(".") || value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }

    private boolean isNumber(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}