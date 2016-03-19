package com.mauriciotogneri.apply.exceptions;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Token;

public class SyntacticException extends RuntimeException
{
    public SyntacticException(String message, Token token)
    {
        super(message + " '" + token + "' at: [" + token.line() + ", " + token.column() + "]");
    }

    public SyntacticException(String message, int line, int column)
    {
        super(message + " at: [" + line + ", " + column + "]");
    }

    public SyntacticException(Token token)
    {
        super("Invalid token '" + token + "' at: [" + token.line() + ", " + token.column() + "]");
    }
}