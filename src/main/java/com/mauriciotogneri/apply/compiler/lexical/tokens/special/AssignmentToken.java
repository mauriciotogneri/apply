package com.mauriciotogneri.apply.compiler.lexical.tokens.special;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class AssignmentToken extends Token
{
    public AssignmentToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isAssignment()
    {
        return true;
    }
}