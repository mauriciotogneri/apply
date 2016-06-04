package com.mauriciotogneri.apply.compiler.lexical.tokens.conditional;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ConditionalEndIfToken extends ConditionalToken
{
    public ConditionalEndIfToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isEndIf()
    {
        return true;
    }
}