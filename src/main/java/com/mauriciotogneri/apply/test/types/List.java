package com.mauriciotogneri.apply.test.types;

@SuppressWarnings("unchecked")
public class List<T extends BaseType> implements BaseType<List<T>>
{
    private final Object[] value;

    public static final List EMPTY = new List<>();

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

    public List appendFirst(T element)
    {
        Object[] result = new Object[value.length + 1];
        result[0] = element;

        if (value.length > 0)
        {
            System.arraycopy(value, 0, result, 1, value.length);
        }

        return new List(result);
    }

    public List appendLast(T element)
    {
        Object[] result = new Object[value.length + 1];

        if (value.length > 0)
        {
            System.arraycopy(value, 0, result, 0, value.length);
        }

        result[result.length - 1] = element;

        return new List(result);
    }

    public List concat(List list)
    {
        Object[] result = new Object[value.length + list.value.length];

        if (value.length > 0)
        {
            System.arraycopy(value, 0, result, 0, value.length);
        }

        if (list.value.length > 0)
        {
            System.arraycopy(list.value, 0, result, value.length, list.value.length);
        }

        return new List(result);
    }

    // drop
    // reverse
    // take
    // filter
    // and
    // or
    // any
    // all
    // take n xs
    // empty xs
    // zip xs [0..]
    // foldl
    // foldr

    //    public static final $f2 map = (f, a) -> {
    //        if ((Boolean) empty.apply(a))
    //        {
    //            return Runtime.EMPTY_LIST;
    //        }
    //        else
    //        {
    //            return $append.apply((($f1) f).apply(List.head.apply(a)), List.map.apply(f, List.tail.apply(a)));
    //        }
    //    };

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

    public T last()
    {
        if (value.length > 0)
        {
            return (T) value[value.length - 1];
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public List init()
    {
        if (value.length > 0)
        {
            Object[] result = new Object[value.length - 1];

            if (result.length > 0)
            {
                System.arraycopy(value, 0, result, 0, value.length - 1);
            }

            return new List(result);
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

            if (result.length > 0)
            {
                System.arraycopy(value, 1, result, 0, value.length - 1);
            }

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

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < value.length; i++)
        {
            if (i != 0)
            {
                builder.append(", ");
            }

            BaseType element = (BaseType) value[i];
            builder.append(element.toString());
        }

        builder.append("]");

        return builder.toString();
    }
}