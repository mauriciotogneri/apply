package com.mauriciotogneri.apply.compiler.frontend.lexical;

public class DefaultLexeme implements Lexeme
{
    private final String value;
    private final Position position;

    private DefaultLexeme(String value, Position position)
    {
        this.value = value;
        this.position = position;
    }

    public DefaultLexeme(Character character)
    {
        this(character.toString(), character);
    }

    @Override
    public Lexeme appended(Character character)
    {
        return new DefaultLexeme(value + character.toString(), position);
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