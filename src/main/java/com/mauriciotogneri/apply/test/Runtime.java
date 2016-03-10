package com.mauriciotogneri.apply.test;

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
    public static final $f2 $equal = (a, b) -> a == b; // TODO
    public static final $f2 $noEqual = (a, b) -> a != b; // TODO

    // logic
    public static final $f2 $and = (a, b) -> ((Boolean) a) && ((Boolean) b);
    public static final $f2 $or = (a, b) -> ((Boolean) a) || ((Boolean) b);
    public static final $f1 $negate = (a) -> !((Boolean) a);

    // list
    public static final $f2 $nth = (a, b) -> {
        int index = ((Double) a).intValue();
        Object[] array = (Object[]) b;

        return array[index];
    };
    public static final $f1 $length = (a) -> (double)((Object[]) a).length;
    public static final $f2 $concat = (a, b) -> {
        Object[] arrayA = (Object[]) a;
        Object[] arrayB = (Object[]) b;

        Object[] result = new Object[arrayA.length + arrayB.length];
        System.arraycopy(arrayA, 0, result, 0, arrayA.length);
        System.arraycopy(arrayB, 0, result, arrayA.length, arrayB.length);

        return result;
    };
    public static final $f2 $appendBeginning = (a, b) -> {
        Object[] array = (Object[]) b;

        Object[] result = new Object[array.length + 1];
        result[0] = a;
        System.arraycopy(array, 0, result, 1, array.length);

        return result;
    };
    public static final $f2 $appendEnd = (a, b) -> {
        Object[] array = (Object[]) a;

        Object[] result = new Object[array.length + 1];
        System.arraycopy(array, 0, result, 0, array.length);
        result[result.length - 1] = b;

        return result;
    };
    public static final $f2 $remove = (a, b) -> {
        int index = ((Double) a).intValue();
        Object[] array = (Object[]) b;

        Object[] result = new Object[array.length - 1];
        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, array.length - index - 1);

        return result;
    };

    public interface $f0
    {
        Object apply();
    }

    public interface $f1
    {
        Object apply(Object a);
    }

    public interface $f2
    {
        Object apply(Object a, Object b);
    }

    public interface $f3
    {
        Object apply(Object a, Object b, Object c);
    }
}