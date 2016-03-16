package com.mauriciotogneri.apply.test.stdlib;

import com.mauriciotogneri.apply.test.Runtime;
import com.mauriciotogneri.apply.test.Runtime.$f1;
import com.mauriciotogneri.apply.test.Runtime.$f2;

import static com.mauriciotogneri.apply.test.Runtime.$appendBeginning;
import static com.mauriciotogneri.apply.test.Runtime.$equal;
import static com.mauriciotogneri.apply.test.Runtime.$greater;
import static com.mauriciotogneri.apply.test.Runtime.$notEqual;
import static com.mauriciotogneri.apply.test.Runtime.$nth;
import static com.mauriciotogneri.apply.test.Runtime.$remove;

public class List
{
    // [a] -> Bool
    public static final $f1 empty = (a) -> ((Boolean) $equal.apply(a, Runtime.EMPTY_LIST));

    // [a] -> Bool
    public static final $f1 notEmpty = (a) -> ((Boolean) $notEqual.apply(a, Runtime.EMPTY_LIST));

    // [a] -> Int
    public static final $f1 length = (a) -> {
        if ((Boolean) empty.apply(a))
        {
            return 0d;
        }
        else
        {
            return 1d + (Double) List.length.apply(List.tail.apply(a));
        }
    };

    // [a] -> a
    public static final $f1 head = (a) -> {
        if ((Boolean) notEmpty.apply(a))
        {
            return $nth.apply(0d, a);
        }
        else
        {
            throw new RuntimeException();
        }
    };

    // [a] -> [a]
    public static final $f1 tail = (a) -> {
        if ((Boolean) notEmpty.apply(a))
        {
            return $remove.apply(0d, a);
        }
        else
        {
            throw new RuntimeException();
        }
    };

    // [a] -> a
    public static final $f1 last = (a) -> {
        if ((Boolean) $equal.apply(List.length.apply(a), 1d))
        {
            return List.head.apply(a);
        }
        else if ((Boolean) notEmpty.apply(a))
        {
            return List.last.apply(List.tail.apply(a));
        }
        else
        {
            throw new RuntimeException();
        }
    };

    // [a] -> [a]
    public static final $f1 init = (a) -> {
        if ((Boolean) $equal.apply(List.length.apply(a), 1d))
        {
            return Runtime.EMPTY_LIST;
        }
        else if ((Boolean) notEmpty.apply(a))
        {
            return $appendBeginning.apply(List.head.apply(a), List.init.apply(List.tail.apply(a)));
        }
        else
        {
            throw new RuntimeException();
        }
    };

    // Num -> [a] -> a
    public static final $f2 nth = (a, b) -> {
        if (((Boolean) $equal.apply(a, 0d)) && ((Boolean) notEmpty.apply(a)))
        {
            return List.head.apply(b);
        }
        else if (((Boolean) $greater.apply(a, 0d)) && ((Boolean) notEmpty.apply(a)))
        {
            return List.nth.apply((Double) a - 1, tail.apply(b));
        }
        else
        {
            throw new RuntimeException();
        }
    };

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

    public static final $f2 concat = (a, b) -> {
        if (((Boolean) empty.apply(a)) && ((Boolean) empty.apply(b)))
        {
            return Runtime.EMPTY_LIST;
        }
        else if ((Boolean) notEmpty.apply(a))
        {
            return $appendBeginning.apply(List.head.apply(a), List.concat.apply(List.tail.apply(a), b));
        }
        else
        {
            return $appendBeginning.apply(List.head.apply(b), List.concat.apply(a, List.tail.apply(b)));
        }
    };

    public static final $f2 map = (f, a) -> {
        if ((Boolean) empty.apply(a))
        {
            return Runtime.EMPTY_LIST;
        }
        else
        {
            return $appendBeginning.apply((($f1) f).apply(List.head.apply(a)), List.map.apply(f, List.tail.apply(a)));
        }
    };
}