package com.mauriciotogneri.apply.test;

import java.util.Arrays;

public class Test1
{
    public static final $i2 $add = (a, b) -> a + b;
    public static final $i2 $sub = (a, b) -> a - b;

    public static final $i1 duplicate = (a) -> a * 2;
    public static final $i1 triplicate = (a) -> a * 3;

    public static final $i1 factorial = (n) -> {
        if (n == 0)
        {
            return 1f;
        }
        else
        {
            return n * Test1.factorial.apply(n - 1);
        }
    };

    public static final $i3<Float> map = (f, a) -> {
        if (a.length == 0)
        {
            return new Float[0];
        }
        else
        {
            Float first = a[0];

            Float[] rest = new Float[a.length - 1];
            System.arraycopy(a, 1, rest, 0, rest.length);
            Float[] result = Test1.map.apply(f, rest);

            Float[] response = new Float[result.length + 1];
            System.arraycopy(result, 0, response, 1, result.length);
            response[0] = f.apply(first);

            return response;
        }
    };

    interface $i1
    {
        Float apply(Float a);
    }

    interface $i2
    {
        Float apply(Float a, Float b);
    }

    interface $i3<A>
    {
        A[] apply($i1 f, A[] a);
    }

    public static void main(String[] args)
    {
        System.out.println(factorial.apply(5f));

        Float[] array = map.apply(triplicate, new Float[] {1f, 2f, -3f});
        System.out.println(Arrays.toString(array));
        //System.out.println(factorial.apply(4));
    }
}