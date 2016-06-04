package com.mauriciotogneri.apply.compiler.lexical.tokens.conditional;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;

public class ConditionalIfToken extends ConditionalToken
{
    public ConditionalIfToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isIf()
    {
        return true;
    }
}