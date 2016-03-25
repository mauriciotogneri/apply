package com.mauriciotogneri.apply.test.types;

@SuppressWarnings("unchecked")
public class List<T extends BasicType> implements BasicType<List<T>>
{
    private final Object[] value;

    public List()
    {
        this.value = new Object[0];
    }

    public List(Object... value)
    {
        this.value = value;
    }

    public Bool empty()
    {
        return Bool.valueOf(value.length == 0);
    }

    public Num length()
    {
        return new Num(value.length);
    }

    public T element(Num num)
    {
        int index = num.intValue();

        if (index < value.length)
        {
            return (T) value[index];
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public List append(T element)
    {
        Object[] result = new Object[value.length + 1];
        result[0] = element;
        System.arraycopy(value, 0, result, 1, value.length);

        return new List(result);
    }

    public List concat(List list)
    {
        Object[] result = new Object[value.length + list.value.length];
        System.arraycopy(value, 0, result, 0, value.length);
        System.arraycopy(list.value, 0, result, value.length, list.value.length);

        return new List(result);
    }

    public T head()
    {
        if (value.length > 0)
        {
            return (T) value[0];
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public List tail()
    {
        if (value.length > 0)
        {
            Object[] result = new Object[value.length - 1];
            System.arraycopy(value, 1, result, 0, value.length - 1);

            return new List(result);
        }
        else
        {
            throw new RuntimeException();
        }
    }

    @Override
    public Bool equal(List<T> list)
    {
        if (value.length == list.value.length)
        {
            for (int i = 0; i < value.length; i++)
            {
                T element1 = (T) value[i];
                T element2 = (T) list.value[i];

                if (!element1.equal(element2).value())
                {
                    return Bool.FALSE;
                }
            }

            return Bool.TRUE;
        }
        else
        {
            return Bool.FALSE;
        }
    }

    @Override
    public Bool notEqual(List<T> list)
    {
        return equal(list).neg();
    }

    @Override
    public boolean equals(Object o)
    {
        return equal(List.class.cast(o)).value();
    }
}