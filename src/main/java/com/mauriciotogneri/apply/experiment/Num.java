package com.mauriciotogneri.apply.experiment;

import com.mauriciotogneri.apply.test.types.Bool;

import java.math.BigDecimal;

public class Num extends Number
{
    private final BigDecimal value;

    private Num(BigDecimal value)
    {
        this.value = value;
    }

    public Num(double value)
    {
        this.value = BigDecimal.valueOf(value);
    }

    public Num add(Num num)
    {
        return new Num(value.add(num.value));
    }

    public Num sub(Num num)
    {
        return new Num(value.subtract(num.value));
    }

    public Num mul(Num num)
    {
        return new Num(value.multiply(num.value));
    }

    public Num div(Num num)
    {
        return new Num(value.divide(num.value));
    }

    public Num pow(Num num)
    {
        return new Num(value.pow(num.intValue()));
    }

    public Num mod(Num num)
    {
        return new Num(value.remainder(num.value));
    }

    public Bool less(Num num)
    {
        return Bool.valueOf(value.compareTo(num.value) == -1);
    }

    public Bool lessEqual(Num num)
    {
        return Bool.valueOf(value.compareTo(num.value) != 1);
    }

    public Bool greater(Num num)
    {
        return Bool.valueOf(value.compareTo(num.value) == 1);
    }

    public Bool greaterEqual(Num num)
    {
        return Bool.valueOf(value.compareTo(num.value) != -1);
    }

    public int intValue()
    {
        return value.intValue();
    }

    public long longValue()
    {
        return value.longValue();
    }

    public float floatValue()
    {
        return value.floatValue();
    }

    public double doubleValue()
    {
        return value.doubleValue();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        else if ((o == null) || (getClass() != o.getClass()))
        {
            return false;
        }

        Num num = (Num) o;

        return value.equals(num.value);

    }

    @Override
    public int hashCode()
    {
        return value.hashCode();
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}