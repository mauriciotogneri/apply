package com.mauriciotogneri.apply.compiler.frontend.lexical;

import com.mauriciotogneri.apply.compiler.types.TokenType;

public class DefaultTokens implements Tokens
{
    private final Characters characters;

    public DefaultTokens(Characters characters)
    {
        this.characters = characters;
    }

    @Override
    public boolean empty() throws Exception
    {
        return characters.empty();
    }

    @Override
    public DefaultToken next() throws Exception
    {
        Character readCharacter = characters.next();

        return new DefaultToken(TokenType.ANONYMOUS_FUNCTION, readCharacter); // TODO
    }
}