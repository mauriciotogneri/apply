package com.mauriciotogneri.apply.exceptions.lexical;

import com.mauriciotogneri.apply.compiler.lexical.Token;

public class InvalidTokenException extends RuntimeException
{
    public InvalidTokenException(Token token)
    {
        super("Invalid token '" + token + "' at: [" + token.line() + ", " + token.column() + "]");
    }
}