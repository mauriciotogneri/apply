package com.mauriciotogneri.apply.experiment;

import java.util.List;

@SuppressWarnings("ALL")
public class Any
{
    public static Boolean equal(Object a, Object b)
    {
        if ((a instanceof Number) && (b instanceof Number))
        {
            return Double.compare(Number.class.cast(a).doubleValue(), Number.class.cast(b).doubleValue()) == 0;
        }
        else if ((a instanceof Boolean) && (b instanceof Boolean))
        {
            return Boolean.class.cast(a).equals(Boolean.class.cast(b));
        }
        else if ((a instanceof String) && (b instanceof String))
        {
            return String.class.cast(a).equals(String.class.cast(b));
        }
        else if ((a instanceof List) && (b instanceof List))
        {
            List<?> list1 = List.class.cast(a);
            List<?> list2 = List.class.cast(b);

            int size1 = list1.size();
            int size2 = list2.size();

            if (size1 == size2)
            {
                for (int i = 0; i < size1; i++)
                {
                    if (notEqual(list1.get(i), list2.get(i)))
                    {
                        return false;
                    }
                }

                return true;
            }

            return false;
        }
        else
        {
            throw new RuntimeException(String.format("Incompatible types: %s and %s", a.getClass(), b.getClass()));
        }
    }

    public static Boolean notEqual(Object a, Object b)
    {
        return !equal(a, b);
    }

    public static String toString(Object obj)
    {
        if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String))
        {
            return obj.toString();
        }
        else if (obj instanceof List)
        {
            StringBuilder builder = new StringBuilder();
            builder.append("[");

            List<?> list = List.class.cast(obj);
            int size = list.size();

            for (int i = 0; i < size; i++)
            {
                if (i != 0)
                {
                    builder.append(", ");
                }

                builder.append(toString(list.get(i)));
            }

            builder.append("]");

            return builder.toString();
        }
        else
        {
            throw new RuntimeException(String.format("Invalid type: %s", obj.getClass()));
        }
    }
}