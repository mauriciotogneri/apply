package com.mauriciotogneri.apply.compiler.frontend.lexical;

import com.mauriciotogneri.apply.compiler.types.TokenType;

public class TokenizedSource implements Tokens
{
    private final Characters characters;

    public TokenizedSource(Characters characters)
    {
        this.characters = characters;
    }

    @Override
    public boolean empty() throws Exception
    {
        return characters.empty();
    }

    @Override
    public Token next() throws Exception
    {
        Character readCharacter = characters.next();

        return new Token(TokenType.ANONYMOUS_FUNCTION, readCharacter); // TODO
    }
}