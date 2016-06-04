package com.mauriciotogneri.apply.compiler.lexical.tokens.logic;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;

public class LogicNotToken extends LogicToken
{
    public LogicNotToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    public boolean isNegation()
    {
        return true;
    }
}