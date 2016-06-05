package com.mauriciotogneri.apply.compiler.lexical.tokens.types;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class StringToken extends Token
{
    public StringToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isNumber()
    {
        return true;
    }
}