package com.mauriciotogneri.apply.lexical;

import com.mauriciotogneri.apply.compiler.lexical.DefaultLexeme;
import com.mauriciotogneri.apply.compiler.lexical.DefaultToken;
import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.types.TokenType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ParsingTest
{
    @Test
    public void test() throws Exception
    {
        // m(3+4,a.b-f(c,d*2))

        // exp        = function | arithmetic
        // function   = symbol | symbol ( params )
        // params     = exp | epx ,
        // arithmetic = number | epx + exp | exp - exp | exp * exp

        List<Token> tokens = new ArrayList<>();
        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("m", new FakePosition(1, 1))));
        tokens.add(new DefaultToken(TokenType.PARENTHESIS_OPEN, new DefaultLexeme("(", new FakePosition(1, 2))));
        tokens.add(new DefaultToken(TokenType.INTEGER, new DefaultLexeme("3", new FakePosition(1, 3))));
        tokens.add(new DefaultToken(TokenType.ARITHMETIC_ADDITION, new DefaultLexeme("+", new FakePosition(1, 4))));
        tokens.add(new DefaultToken(TokenType.INTEGER, new DefaultLexeme("4", new FakePosition(1, 5))));
        tokens.add(new DefaultToken(TokenType.COMMA, new DefaultLexeme(",", new FakePosition(1, 6))));
        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("a", new FakePosition(1, 7))));
        tokens.add(new DefaultToken(TokenType.MEMBER_ACCESS, new DefaultLexeme(".", new FakePosition(1, 8))));
        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("b", new FakePosition(1, 9))));
        tokens.add(new DefaultToken(TokenType.ARITHMETIC_SUBTRACTION, new DefaultLexeme("-", new FakePosition(1, 10))));
        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("f", new FakePosition(1, 11))));
        tokens.add(new DefaultToken(TokenType.PARENTHESIS_OPEN, new DefaultLexeme("(", new FakePosition(1, 12))));
        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("c", new FakePosition(1, 13))));
        tokens.add(new DefaultToken(TokenType.COMMA, new DefaultLexeme(",", new FakePosition(1, 14))));
        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("d", new FakePosition(1, 15))));
        tokens.add(new DefaultToken(TokenType.ARITHMETIC_MULTIPLICATION, new DefaultLexeme("*", new FakePosition(1, 16))));
        tokens.add(new DefaultToken(TokenType.INTEGER, new DefaultLexeme("2", new FakePosition(1, 17))));
        tokens.add(new DefaultToken(TokenType.PARENTHESIS_CLOSE, new DefaultLexeme(")", new FakePosition(1, 18))));
        tokens.add(new DefaultToken(TokenType.PARENTHESIS_CLOSE, new DefaultLexeme(")", new FakePosition(1, 19))));

        System.out.println(postfix("m(3+4,a.b(1)-f(c,d*2))"));
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

    private String postfix(String expression)
    {
        String[] tokens = new String[expression.length()];

        for (int i = 0; i < expression.length(); i++)
        {
            tokens[i] = String.valueOf(expression.charAt(i));
        }

        List<String> output = new ArrayList<>();
        Deque<String> stack = new LinkedList<>();

        for (int i = 0; i < tokens.length; i++)
        {
            String token = tokens[i];

            if (isOperator(token))
            {
                while (!stack.isEmpty() && isHigherPrecedence(token, stack.peek()))
                {
                    output.add(stack.pop());
                }
                stack.push(token);
            }
            else if (token.equals("("))
            {
                stack.push(token);
            }
            else if (token.equals(")"))
            {
                while (!stack.peek().equals("("))
                {
                    output.add(stack.pop());
                }

                stack.pop();

                if (isSymbol(stack.peek()))
                {
                    output.add(stack.pop());
                }
            }
            else if (token.equals(","))
            {
                while (!stack.peek().equals("("))
                {
                    output.add(stack.pop());
                }
            }
            else if (isNumber(token))
            {
                output.add(token);
            }
            else if (isSymbol(token))
            {
                if (tokens[i + 1].equals("("))
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
                throw new RuntimeException(token);
            }
        }

        while (!stack.isEmpty())
        {
            output.add(stack.pop());
        }

        return output.toString();
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