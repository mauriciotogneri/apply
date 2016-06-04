package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsedExpression
{
    private final TokenList tokenList;

    public ParsedExpression(TokenList tokenList)
    {
        this.tokenList = tokenList;
    }

    private Map<String, Integer> ops = new HashMap<String, Integer>()
    {{
        put("+", 1);
        put("-", 2);
        put("*", 3);
        put("/", 4);
        put(".", 5);
        put("e", 6);
    }};

    public NodeStack parse() throws Exception
    {
        List<Token> tokens = tokenList.tokens();
        NodeStack nodeStack = new NodeStack();
        OperatorStack operatorStack = new OperatorStack();

        for (int i = 0; i < tokens.size(); i++)
        {
            Token token = tokens.get(i);

            if (token.isOperator())
            {
                operatorStack.dequeueLowerPreference(token, nodeStack);
                operatorStack.push(token);
            }
            else if (token.isOpenParenthesis())
            {
                operatorStack.push(token);
            }
            else if (token.isCloseParenthesis())
            {
                //                while (!operatorStack.peek().isOpenParenthesis())
                //                {
                //                    nodeStack.add(operatorStack.pop());
                //                }
                //
                //                operatorStack.pop();
                //
                //                if (!operatorStack.isEmpty() && operatorStack.peek().isSymbol())
                //                {
                //                    nodeStack.add(operatorStack.pop());
                //                }
            }
            else if (token.isComma())
            {
                //                while (!operatorStack.isEmpty() && !operatorStack.peek().isOpenParenthesis())
                //                {
                //                    nodeStack.add(operatorStack.pop());
                //                }
            }
            else if (token.isNumber())
            {
                nodeStack.addToken(token);
            }
            else if (token.isSymbol())
            {
                //                if ((i < (tokens.size() - 1)) && (tokens.get(i + 1).isOpenParenthesis()))
                //                {
                //                    operatorStack.push(token);
                //                }
                //                else
                //                {
                //                    nodeStack.add(token);
                //                }
            }
            else if (token.isSeparator())
            {
                // do nothing
            }
            else
            {
                throw new RuntimeException(token.toString());
            }
        }

        while (!operatorStack.isEmpty())
        {
            nodeStack.addToken(operatorStack.pop());
        }

        return nodeStack;
    }
}