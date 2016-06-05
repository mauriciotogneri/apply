package com.mauriciotogneri.apply.compiler.lexical.tokens.special;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class TypeReturnToken extends Token
{
    public TypeReturnToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isTypeOf()
    {
        return true;
    }
}