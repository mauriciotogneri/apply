package com.mauriciotogneri.apply.compiler.lexical.tokens.special;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class FunctionDefToken extends Token
{
    public FunctionDefToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isFunctionDef()
    {
        return true;
    }
}