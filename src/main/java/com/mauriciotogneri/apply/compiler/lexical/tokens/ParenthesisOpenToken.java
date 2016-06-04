package com.mauriciotogneri.apply.compiler.lexical.tokens;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ParenthesisOpenToken extends Token
{
    public ParenthesisOpenToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isOpenParenthesis()
    {
        return true;
    }
}