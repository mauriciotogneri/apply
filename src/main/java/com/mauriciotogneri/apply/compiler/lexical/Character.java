package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Position;

public class Character implements Position
{
    private final char character;
    private final Position position;

    public Character(char character, Position position)
    {
        this.character = character;
        this.position = position;
    }

    @Override
    public int line()
    {
        return position.line();
    }

    @Override
    public int column()
    {
        return position.column();
    }

    public char value()
    {
        return character;
    }

    @Override
    public String toString()
    {
        if (character == '\t')
        {
            return "\\t";
        }
        else if (character == '\r')
        {
            return "\\r";
        }
        else if (character == '\n')
        {
            return "\\n";
        }
        else
        {
            return String.valueOf(character);
        }
    }
}