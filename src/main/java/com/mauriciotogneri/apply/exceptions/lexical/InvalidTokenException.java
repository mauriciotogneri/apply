package com.mauriciotogneri.apply.exceptions.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Token;
import com.mauriciotogneri.apply.exceptions.CompilationException;

public class InvalidTokenException extends CompilationException
{
    public InvalidTokenException(Token token)
    {
        super("Invalid token '" + token + "' at: [" + token.line() + ", " + token.column() + "]");
    }
}