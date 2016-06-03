package com.mauriciotogneri.apply.compiler.lexical.tokens;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class SeparatorToken extends Token
{
    public SeparatorToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isSeparator()
    {
        return true;
    }
}