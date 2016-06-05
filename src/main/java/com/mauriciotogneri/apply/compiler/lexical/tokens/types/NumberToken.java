package com.mauriciotogneri.apply.compiler.lexical.tokens.types;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class NumberToken extends Token
{
    public NumberToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isNumber()
    {
        return true;
    }
}