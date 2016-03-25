package com.mauriciotogneri.apply.test;

import com.mauriciotogneri.apply.test.FunctionHeaders.$f1;
import com.mauriciotogneri.apply.test.FunctionHeaders.$f2;
import com.mauriciotogneri.apply.test.types.BasicType;
import com.mauriciotogneri.apply.test.types.Bool;
import com.mauriciotogneri.apply.test.types.List;
import com.mauriciotogneri.apply.test.types.Num;

@SuppressWarnings("unchecked")
public class RuntimeTyped
{
    // arithmetic
    public static final $f2 $add = (a, b) -> Num.class.cast(a).add(Num.class.cast(b));
    public static final $f2 $sub = (a, b) -> Num.class.cast(a).sub(Num.class.cast(b));
    public static final $f2 $mul = (a, b) -> Num.class.cast(a).mul(Num.class.cast(b));
    public static final $f2 $div = (a, b) -> Num.class.cast(a).div(Num.class.cast(b));
    public static final $f2 $pow = (a, b) -> Num.class.cast(a).pow(Num.class.cast(b));
    public static final $f2 $mod = (a, b) -> Num.class.cast(a).mod(Num.class.cast(b));

    // comparison
    public static final $f2 $less = (a, b) -> Num.class.cast(a).less(Num.class.cast(b));
    public static final $f2 $lessEqual = (a, b) -> Num.class.cast(a).lessEqual(Num.class.cast(b));
    public static final $f2 $greater = (a, b) -> Num.class.cast(a).greater(Num.class.cast(b));
    public static final $f2 $greaterEqual = (a, b) -> Num.class.cast(a).greaterEqual(Num.class.cast(b));
    public static final $f2 $equal = (a, b) -> BasicType.class.cast(a).equal(BasicType.class.cast(b));
    public static final $f2 $notEqual = (a, b) -> BasicType.class.cast(a).notEqual(BasicType.class.cast(b));

    // logic
    public static final $f2 $and = (a, b) -> Bool.class.cast(a).and(Bool.class.cast(b));
    public static final $f2 $or = (a, b) -> Bool.class.cast(a).or(Bool.class.cast(b));
    public static final $f1 $negate = (a) -> Bool.class.cast(a).neg();

    // list
    public static final $f1 $empty = (a) -> List.class.cast(a).empty();
    public static final $f1 $length = (a) -> List.class.cast(a).length();
    public static final $f2 $element = (a, b) -> List.class.cast(a).element(Num.class.cast(b));
    public static final $f2 $append = (a, b) -> List.class.cast(a).append(BasicType.class.cast(b));
    public static final $f2 $concat = (a, b) -> List.class.cast(a).concat(List.class.cast(b));
    public static final $f1 $head = (a) -> List.class.cast(a).head();
    public static final $f1 $tail = (a) -> List.class.cast(a).tail();
}