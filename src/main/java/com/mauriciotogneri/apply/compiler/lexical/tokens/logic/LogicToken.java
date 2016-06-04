package com.mauriciotogneri.apply.compiler.lexical.tokens.logic;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class LogicToken extends Token
{
    public LogicToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isLogic()
    {
        return true;
    }
}