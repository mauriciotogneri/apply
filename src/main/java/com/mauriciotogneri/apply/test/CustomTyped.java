package com.mauriciotogneri.apply.test;

import com.mauriciotogneri.apply.test.FunctionHeaders.$f0;
import com.mauriciotogneri.apply.test.FunctionHeaders.$f1;
import com.mauriciotogneri.apply.test.FunctionHeaders.$f3;
import com.mauriciotogneri.apply.test.types.Num;

public class CustomTyped
{
    public static final $f0 pi = () -> new Num(3.14);

    public static final $f1 duplicate = (a) -> Num.class.cast(a).mul(new Num(2));
    public static final $f1 triplicate = (a) -> Num.class.cast(a).mul(new Num(3));
    public static final $f3 apply = (f, a, b) -> $f1.class.cast(f).apply(Num.class.cast(a).add(Num.class.cast(b)));

    public static final $f1 factorial = (n) -> {
        if (Num.class.cast(n).equal(new Num(0)).value())
        {
            return new Num(1);
        }
        else
        {
            return Num.class.cast(n).mul(Num.class.cast(CustomTyped.factorial.apply(Num.class.cast(n).sub(new Num(1)))));
        }
    };
}