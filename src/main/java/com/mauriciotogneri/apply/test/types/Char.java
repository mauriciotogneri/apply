package com.mauriciotogneri.apply.test.types;

public class Char implements BaseType<Char>
{
    private final char value;

    public Char(char value)
    {
        this.value = value;
    }

    public char value()
    {
        return value;
    }

    @Override
    public Bool equal(Char character)
    {
        return Bool.valueOf(value == character.value);
    }

    @Override
    public Bool notEqual(Char character)
    {
        return equal(character).neg();
    }

    @Override
    public boolean equals(Object o)
    {
        return equal(Char.class.cast(o)).value();
    }
}