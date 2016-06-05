package com.mauriciotogneri.apply.compiler.lexical.tokens.special;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class TypeOfToken extends Token
{
    public TypeOfToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isTypeOf()
    {
        return true;
    }
}