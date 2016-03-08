package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.types.TokenType;

public class Token
{
    private final TokenType type;
    private final String lexeme;
    private final Cursor cursor;

    public Token(TokenType type, String lexeme, Cursor cursor)
    {
        this.lexeme = lexeme;
        this.type = type;
        this.cursor = cursor;
    }

    public TokenType type()
    {
        return type;
    }

    @Override
    public String toString()
    {
        return lexeme;
    }
}