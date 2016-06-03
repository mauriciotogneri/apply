package com.mauriciotogneri.apply.compiler.lexical.tokens;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class CommaToken extends Token
{
    public CommaToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isComma()
    {
        return true;
    }
}