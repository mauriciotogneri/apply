package com.mauriciotogneri.apply.compiler.frontend.lexical;

public class Lexeme implements Position
{
    private final String value;
    private final Position position;

    private Lexeme(String value, Position position)
    {
        this.value = value;
        this.position = position;
    }

    public Lexeme(Character character)
    {
        this(character.toString(), character);
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