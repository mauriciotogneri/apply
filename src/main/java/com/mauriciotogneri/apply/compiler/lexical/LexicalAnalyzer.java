package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.types.TokenType;

import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer implements Tokenizer
{
    @Override
    public List<Token> tokens(CharProvider charProvider) throws Exception
    {
        List<Token> tokens = new ArrayList<>();

        Cursor cursor = new Cursor(1, 1);

        while (charProvider.hasMore())
        {
            char character = charProvider.get();

            Token token = null;

            if (character == 'f')
            {
                token = new Token(TokenType.SYMBOL, String.valueOf(character), cursor);
            }
            else if (character == '(')
            {
                token = new Token(TokenType.PARENTHESIS_OPEN, String.valueOf(character), cursor);
            }
            else if (character == ')')
            {
                token = new Token(TokenType.PARENTHESIS_CLOSE, String.valueOf(character), cursor);
            }
            else if ((character == '3') || (character == '4') || (character == '5'))
            {
                token = new Token(TokenType.FLOAT, String.valueOf(character), cursor);
            }
            else if (character == ',')
            {
                token = new Token(TokenType.COMMA, String.valueOf(character), cursor);
            }
            else if (character == '+')
            {
                token = new Token(TokenType.ARITHMETIC_ADDITION, String.valueOf(character), cursor);
            }

            tokens.add(token);

            cursor = cursor.advance(1);
        }

        return tokens;
    }
}