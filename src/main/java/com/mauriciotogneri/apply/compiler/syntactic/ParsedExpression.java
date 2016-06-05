package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;
import com.mauriciotogneri.apply.compiler.syntactic.nodes.OpenParenthesisNode;

import java.util.List;
import java.util.Optional;

public class ParsedExpression
{
    private final TokenList tokenList;

    public ParsedExpression(TokenList tokenList)
    {
        this.tokenList = tokenList;
    }

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
                operatorStack.dequeueUntilOpenParenthesis(nodeStack);
                operatorStack.pop();

                if (operatorStack.isTopSymbol() || operatorStack.isNegation())
                {
                    nodeStack.addFunctionCall(operatorStack.pop());
                }
            }
            else if (token.isConditional())
            {
                operatorStack.push(token);
            }
            else if (token.isEndIf())
            {
                operatorStack.dequeueLowerPreference(token, nodeStack);
                operatorStack.dequeueConditional(nodeStack);
            }
            else if (token.isComma())
            {
                operatorStack.dequeueUntilOpenParenthesis(nodeStack);
            }
            else if (token.isNumber())
            {
                nodeStack.addToken(token);
            }
            else if (token.isSymbol())
            {
                Optional<Token> nextToken = nextToken(tokens, i);

                if (nextToken.isPresent() && nextToken.get().isOpenParenthesis())
                {
                    nodeStack.push(new OpenParenthesisNode(nextToken.get()));
                    operatorStack.push(token);
                }
                else
                {
                    nodeStack.addToken(token);
                }
            }
            else if (token.isFunctionDef())
            {
                nodeStack.addToken(token);
            }
            else if (token.isNewLine())
            {
                // TODO
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

    private Optional<Token> nextToken(List<Token> tokens, int index)
    {
        if (index < (tokens.size() - 1))
        {
            return Optional.of(tokens.get(index + 1));
        }

        return Optional.empty();
    }
}