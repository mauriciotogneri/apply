package com.mauriciotogneri.apply.exceptions;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Character;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Position;

public class LexicalException extends RuntimeException
{
    private LexicalException(String character, int line, int column)
    {
        super("Invalid character '" + character + "' at: [" + line + ", " + column + "]");
    }

    public LexicalException(char character, Position position)
    {
        this(String.valueOf(character), position.line(), position.column());
    }

    public LexicalException(Character character)
    {
        this(character.toString(), character.line(), character.column());
    }
}