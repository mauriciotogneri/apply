package com.mauriciotogneri.apply.compiler.lexical.tokens.blocks;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ParenthesisCloseToken extends Token
{
    public ParenthesisCloseToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isCloseParenthesis()
    {
        return true;
    }
}