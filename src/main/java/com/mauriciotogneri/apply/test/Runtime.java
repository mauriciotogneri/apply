package com.mauriciotogneri.apply.test;

import com.mauriciotogneri.apply.test.FunctionHeaders.$f1;
import com.mauriciotogneri.apply.test.FunctionHeaders.$f2;

public class Runtime
{
    // arithmetic
    public static final $f2 $add = (a, b) -> ((Double) a) + ((Double) b);
    public static final $f2 $sub = (a, b) -> ((Double) a) - ((Double) b);
    public static final $f2 $mul = (a, b) -> ((Double) a) * ((Double) b);
    public static final $f2 $div = (a, b) -> ((Double) a) / ((Double) b);
    public static final $f2 $pow = (a, b) -> Math.pow((Double) a, (Double) b);
    public static final $f2 $mod = (a, b) -> ((Double) a) % ((Double) b);

    // comparison
    public static final $f2 $less = (a, b) -> ((Double) a) < ((Double) b);
    public static final $f2 $lessEqual = (a, b) -> ((Double) a) <= ((Double) b);
    public static final $f2 $greater = (a, b) -> ((Double) a) > ((Double) b);
    public static final $f2 $greaterEqual = (a, b) -> ((Double) a) >= ((Double) b);
    public static final $f2 $equal = (a, b) -> {
        if (a.getClass().isArray() && b.getClass().isArray())
        {
            Object[] arrayA = (Object[]) a;
            Object[] arrayB = (Object[]) b;

            if (arrayA.length != arrayB.length)
            {
                return false;
            }
            else
            {
                for (int i = 0; i < arrayA.length; i++)
                {
                    if (!(Boolean) Runtime.$equal.apply(arrayA[i], arrayB[i]))
                    {
                        return false;
                    }
                }

                return true;
            }
        }
        else
        {
            return a.equals(b);
        }
    };
    public static final $f2 $notEqual = (a, b) -> !(Boolean) $equal.apply(a, b);

    // logic
    public static final $f2 $and = (a, b) -> ((Boolean) a) && ((Boolean) b);
    public static final $f2 $or = (a, b) -> ((Boolean) a) || ((Boolean) b);
    public static final $f1 $negate = (a) -> !((Boolean) a);

    // list
    public static final Object[] EMPTY_LIST = new Object[0];

    public static final $f2 $append = (a, b) -> {
        Object[] array = (Object[]) b;

        Object[] result = new Object[array.length + 1];
        result[0] = a;
        System.arraycopy(array, 0, result, 1, array.length);

        return result;
    };
    public static final $f1 $head = (a) -> {
        Object[] array = (Object[]) a;

        return (array.length > 0) ? array[0] : null;
    };
    public static final $f1 $tail = (a) -> {
        Object[] array = (Object[]) a;

        if (array.length > 0)
        {
            Object[] result = new Object[array.length - 1];
            System.arraycopy(array, 1, result, 0, array.length - 1);

            return result;
        }
        else
        {
            return null;
        }
    };
}