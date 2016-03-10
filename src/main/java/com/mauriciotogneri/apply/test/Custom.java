package com.mauriciotogneri.apply.test;

import static com.mauriciotogneri.apply.test.Runtime.$f0;
import static com.mauriciotogneri.apply.test.Runtime.$f1;
import static com.mauriciotogneri.apply.test.Runtime.$f2;
import static com.mauriciotogneri.apply.test.Runtime.$f3;

public class Custom
{
    public static final $f0 pi = () -> 3.14d;

    public static final $f1 duplicate = (a) -> ((Double) a) * 2;
    public static final $f1 triplicate = (a) -> ((Double) a) * 3;
    public static final $f3 apply = (f, a, b) -> (($f1) f).apply(((Double) a) + ((Double) b));

    public static final $f1 factorial = (n) -> {
        if ((Double) n == 0)
        {
            return 1d;
        }
        else
        {
            return ((Double) n) * (Double) Custom.factorial.apply(((Double) n) - 1);
        }
    };

    public static final $f2 map = (f, a) -> {
        Object[] o = (Object[]) a;

        if (o.length == 0)
        {
            return new Object[0];
        }
        else
        {
            //            Object first = a[0];
            //
            //            Object[] rest = new Object[a.length - 1];
            //            System.arraycopy(a, 1, rest, 0, rest.length);
            //            Object[] result = Test1.map2.apply(f, rest);
            //
            //            Object[] response = new Object[result.length + 1];
            //            System.arraycopy(result, 0, response, 1, result.length);
            //            response[0] = f.apply(first);

            return null;
        }
    };

    //    map(f, a) =
    //        ? (a = [],
    //            [],
    //            f(head(a)) + map(f, tail(a))
    //        )
}