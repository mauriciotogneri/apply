package com.mauriciotogneri.apply.exceptions;

import com.mauriciotogneri.apply.compiler.lexical.base.Token;

public class SemanticException extends CompilationException
{
    public SemanticException(String message, Token token)
    {
        super(message + " '" + token + "' at: [" + token.line() + ", " + token.column() + "]");
    }

    public SemanticException(String message)
    {
        super(message);
    }
}