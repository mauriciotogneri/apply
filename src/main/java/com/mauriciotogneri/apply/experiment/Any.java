package com.mauriciotogneri.apply.experiment;

import java.util.List;

@SuppressWarnings("ALL")
public class Any
{
    public static Boolean equal(Object a, Object b)
    {
        if ((a instanceof Number) && (b instanceof Number))
        {
            return NumberOperations.equal(Number.class.cast(a), Number.class.cast(b));
        }
        else if ((a instanceof Boolean) && (b instanceof Boolean))
        {
            return BooleanOperations.equal(Boolean.class.cast(a), Boolean.class.cast(b));
        }
        else if ((a instanceof String) && (b instanceof String))
        {
            return StringOperations.equal(String.class.cast(a), String.class.cast(b));
        }
        else if ((a instanceof List) && (b instanceof List))
        {
            return ListOperations.equal(List.class.cast(a), List.class.cast(b));
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
            return ListOperations.toString(List.class.cast(obj));
        }
        else
        {
            throw new RuntimeException(String.format("Invalid type: %s", obj.getClass()));
        }
    }
}