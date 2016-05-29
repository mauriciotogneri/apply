package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Character;
import com.mauriciotogneri.apply.compiler.lexical.base.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.base.Position;

public class DefaultLexeme implements Lexeme
{
    private final String value;
    private final Position position;

    public DefaultLexeme(String value, Position position)
    {
        this.value = value;
        this.position = position;
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