package com.mauriciotogneri.apply.exceptions.lexical;

import com.mauriciotogneri.apply.compiler.lexical.Character;

public class InvalidCharacterException extends RuntimeException
{
    public InvalidCharacterException(Character character)
    {
        super("Invalid character '" + character + "' at: [" + character.line() + ", " + character.column() + "]");
    }
}