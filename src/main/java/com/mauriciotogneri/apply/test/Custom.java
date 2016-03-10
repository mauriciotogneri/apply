package com.mauriciotogneri.apply.test;

import static com.mauriciotogneri.apply.test.Runtime.$appendBeginning;
import static com.mauriciotogneri.apply.test.Runtime.$f0;
import static com.mauriciotogneri.apply.test.Runtime.$f1;
import static com.mauriciotogneri.apply.test.Runtime.$f2;
import static com.mauriciotogneri.apply.test.Runtime.$f3;
import static com.mauriciotogneri.apply.test.Runtime.$noEqual;
import static com.mauriciotogneri.apply.test.Runtime.$equal;
import static com.mauriciotogneri.apply.test.Runtime.$nth;
import static com.mauriciotogneri.apply.test.Runtime.$remove;

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

    public static final $f1 head = (a) -> {
        if ((Boolean) $noEqual.apply(a, Runtime.EMPTY_LIST))
        {
            return $nth.apply(0d, a);
        }
        else
        {
            throw new RuntimeException();
        }
    };

    public static final $f1 tail = (a) -> {
        if ((Boolean) $noEqual.apply(a, Runtime.EMPTY_LIST))
        {
            return $remove.apply(0d, a);
        }
        else
        {
            throw new RuntimeException();
        }
    };

    public static final $f2 map = (f, a) -> {
        if ((Boolean) $equal.apply(a, Runtime.EMPTY_LIST))
        {
            return Runtime.EMPTY_LIST;
        }
        else
        {
            return $appendBeginning.apply((($f1) f).apply(head.apply(a)), Custom.map.apply(f, tail.apply(a)));
        }
    };
}