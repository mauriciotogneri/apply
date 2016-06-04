package com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ArithmeticToken extends Token
{
    public ArithmeticToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isArithmetic()
    {
        return true;
    }
}