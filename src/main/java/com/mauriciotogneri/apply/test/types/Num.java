package com.mauriciotogneri.apply.test.types;

public class Num implements BaseType<Num>
{
    private final double value;

    public Num(double value)
    {
        this.value = value;
    }

    public Num add(Num num)
    {
        return new Num(value + num.value);
    }

    public Num sub(Num num)
    {
        return new Num(value - num.value);
    }

    public Num mul(Num num)
    {
        return new Num(value * num.value);
    }

    public Num div(Num num)
    {
        return new Num(value / num.value);
    }

    public Num pow(Num num)
    {
        return new Num(Math.pow(value, num.value));
    }

    public Num mod(Num num)
    {
        return new Num(value % num.value);
    }

    public Bool less(Num num)
    {
        return Bool.valueOf(value < num.value);
    }

    public Bool lessEqual(Num num)
    {
        return Bool.valueOf(value <= num.value);
    }

    public Bool greater(Num num)
    {
        return Bool.valueOf(value > num.value);
    }

    public Bool greaterEqual(Num num)
    {
        return Bool.valueOf(value >= num.value);
    }

    public int intValue()
    {
        return (int) value;
    }

    public long longValue()
    {
        return (long) value;
    }

    public float floatValue()
    {
        return (float) value;
    }

    public double doubleValue()
    {
        return value;
    }

    @Override
    public Bool equal(Num num)
    {
        return Bool.valueOf(Double.compare(num.value, value) == 0);
    }

    @Override
    public Bool notEqual(Num num)
    {
        return equal(num).neg();
    }

    @Override
    public boolean equals(Object o)
    {
        return equal(Num.class.cast(o)).value();
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}