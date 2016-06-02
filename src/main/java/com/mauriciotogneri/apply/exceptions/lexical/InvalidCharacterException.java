package com.mauriciotogneri.apply.exceptions.lexical;

import com.mauriciotogneri.apply.compiler.lexical.Character;
import com.mauriciotogneri.apply.exceptions.CompilationException;

public class InvalidCharacterException extends CompilationException
{
    public InvalidCharacterException(Character character)
    {
        super("Invalid character '" + character + "' at: [" + character.line() + ", " + character.column() + "]");
    }
}