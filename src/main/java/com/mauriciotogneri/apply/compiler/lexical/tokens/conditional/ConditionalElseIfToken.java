package com.mauriciotogneri.apply.compiler.lexical.tokens.conditional;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ConditionalElseIfToken extends ConditionalToken
{
    public ConditionalElseIfToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isIfElse()
    {
        return true;
    }
}