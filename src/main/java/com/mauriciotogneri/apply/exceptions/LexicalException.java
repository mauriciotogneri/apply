package com.mauriciotogneri.apply.exceptions;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Character;

public class LexicalException extends RuntimeException
{
    private LexicalException(String character, int line, int column)
    {
        super("Invalid character '" + character + "' at: [" + line + ", " + column + "]");
    }

    public LexicalException(Character character)
    {
        this(character.toString(), character.line(), character.column());
    }
}