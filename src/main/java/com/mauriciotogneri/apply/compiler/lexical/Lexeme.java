package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Position;

public class Lexeme implements Position
{
    private final String value;
    private final Position position;

    public Lexeme(String value, Position position)
    {
        this.value = value;
        this.position = position;
    }

    public Lexeme appended(Character character)
    {
        return new Lexeme(value + character.toString(), position);
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

    @Override
    public String toString()
    {
        return value;
    }
}