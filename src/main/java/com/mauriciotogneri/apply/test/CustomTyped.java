package com.mauriciotogneri.apply.test;

import com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$F0;
import com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$F1;
import com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$F3;
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
}