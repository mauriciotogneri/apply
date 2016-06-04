package com.mauriciotogneri.apply.compiler.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;

import java.util.List;

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
                // TODO: handle associativity
                //  CASE "+","-","*","/","^","%"
                //  TOKEN_A = INPUT(TOKEN_NUMBER)
                //  DO WHILE ISOPERATOR(PEEK(TOKEN_STACK))
                //      TOKEN_B = PEEK(TOKEN_STACK)
                //          IF (ASSOCIATIVITY(TOKEN_B) = "left" AND PRECEDENCE(TOKEN_A) = PRECEDENCE(TOKEN_B)) OR (PRECEDENCE(TOKEN_A) < PRECEDENCE(TOKEN_B)) THEN
                //              CALL PUSH(POP(TOKEN_STACK), TOKEN_QUEUE)
                //          ELSE
                //  EXIT DO

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
                    nodeStack.addToken(operatorStack.pop());
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
}