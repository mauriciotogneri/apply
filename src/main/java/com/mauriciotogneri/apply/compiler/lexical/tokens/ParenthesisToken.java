package com.mauriciotogneri.apply.compiler.lexical.tokens;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ParenthesisToken extends Token
{
    private final Type type;

    public enum Type
    {
        OPEN, CLOSE
    }

    public ParenthesisToken(Type type, Lexeme lexeme)
    {
        super(lexeme);

        this.type = type;
    }

    @Override
    public boolean isOpenParenthesis()
    {
        return (type == Type.OPEN);
    }

    @Override
    public boolean isCloseParenthesis()
    {
        return (type == Type.CLOSE);
    }
}