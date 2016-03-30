package com.mauriciotogneri.apply.test;

import com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$F0;
import com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$F1;
import com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$F2;
import com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$F3;
import com.mauriciotogneri.apply.test.types.List;
import com.mauriciotogneri.apply.test.types.Num;

public class CustomTyped
{
    public static final $F0<Num> pi = () -> new Num(3.14);

    public static final $F1<Num, Num> duplicate = (a) -> a.mul(new Num(2));
    public static final $F1<Num, Num> triplicate = (a) -> a.mul(new Num(3));
    public static final $F3<$F1<Num, Num>, Num, Num, Num> apply = (f, a, b) -> f.apply(a.add(b));

    public static final $F1<Num, Num> factorial = (n) -> {
        if (n.equal(new Num(0)).value())
        {
            return new Num(1);
        }
        else
        {
            return n.mul(CustomTyped.factorial.apply(n.sub(new Num(1))));
        }
    };

    public static final $F1<Num, List<Num>> fibonacci = (n) -> {
        if (n.lessEqual(new Num(0)).value())
        {
            throw new RuntimeException("ERROR");
        }
        else
        {
            return CustomTyped.fibo.apply(n, List.EMPTY);
        }
    };

    public static final $F2<Num, List<Num>, List<Num>> fibo = (limit, list) -> {
        if (limit.greater(list.length()).value())
        {
            if (list.length().equal(new Num(0)).value())
            {
                return CustomTyped.fibo.apply(limit, new List<>(new Num(1)));
            }
            else
            {
                if (list.length().equal(new Num(1)).value())
                {
                    return CustomTyped.fibo.apply(limit, new List<>(new Num(1), new Num(1)));
                }
                else
                {
                    Num last1 = list.element(list.length().sub(new Num(1)));
                    Num last2 = list.element(list.length().sub(new Num(2)));

                    return CustomTyped.fibo.apply(limit, list.concat(new List<>(last1.add(last2))));
                }
            }
        }
        else
        {
            return list;
        }
    };
}