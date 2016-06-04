package com.mauriciotogneri.apply.compiler.lexical.tokens;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class NewLineToken extends Token
{
    public NewLineToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    public boolean isNewLine()
    {
        return true;
    }
}