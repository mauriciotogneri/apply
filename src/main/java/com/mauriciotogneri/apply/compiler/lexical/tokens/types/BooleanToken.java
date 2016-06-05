package com.mauriciotogneri.apply.compiler.lexical.tokens.types;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class BooleanToken extends Token
{
    public BooleanToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isBoolean()
    {
        return true;
    }
}