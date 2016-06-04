package com.mauriciotogneri.apply.compiler.lexical.tokens.conditional;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ConditionalElseToken extends ConditionalToken
{
    public ConditionalElseToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isElse()
    {
        return true;
    }
}