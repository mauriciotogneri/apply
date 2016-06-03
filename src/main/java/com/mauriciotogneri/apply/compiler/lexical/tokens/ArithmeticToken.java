package com.mauriciotogneri.apply.compiler.lexical.tokens;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ArithmeticToken extends Token
{
    private final Type type;

    public enum Type
    {
        ADDITION, //
        SUBTRACTION, //
        MULTIPLICATION, //
        DIVISION, //
        POWER, //
        MODULE, //
    }

    public ArithmeticToken(Type type, Lexeme lexeme)
    {
        super(lexeme);

        this.type = type;
    }

    @Override
    public boolean isArithmetic()
    {
        return true;
    }
}