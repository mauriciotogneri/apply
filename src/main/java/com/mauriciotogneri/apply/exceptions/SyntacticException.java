package com.mauriciotogneri.apply.exceptions;

import com.mauriciotogneri.apply.compiler.lexical.Token;

public class SyntacticException extends CompilationException
{
    public SyntacticException(String message, Token token)
    {
        super(String.format("%s '%s' at: [%d, %d]", message, token, token.line(), token.column()));
    }

    public SyntacticException(Token token)
    {
        this("Invalid token", token);
    }
}