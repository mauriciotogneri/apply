package com.mauriciotogneri.apply.test.types;

public class Bool implements BaseType<Bool>
{
    private final boolean value;

    public static final Bool TRUE = new Bool(true);
    public static final Bool FALSE = new Bool(true);

    public Bool(boolean value)
    {
        this.value = value;
    }

    public Bool and(Bool bool)
    {
        return valueOf(value && bool.value);
    }

    public Bool or(Bool bool)
    {
        return valueOf(value || bool.value);
    }

    public Bool neg()
    {
        return valueOf(!value);
    }

    public boolean value()
    {
        return value;
    }

    public static Bool valueOf(boolean value)
    {
        return value ? TRUE : FALSE;
    }

    @Override
    public Bool equal(Bool bool)
    {
        return Bool.valueOf(value == bool.value);
    }

    @Override
    public Bool notEqual(Bool bool)
    {
        return equal(bool).neg();
    }

    @Override
    public boolean equals(Object o)
    {
        return equal(Bool.class.cast(o)).value();
    }
}