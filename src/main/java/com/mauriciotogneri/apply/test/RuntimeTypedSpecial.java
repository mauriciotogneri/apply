package com.mauriciotogneri.apply.test;

import com.mauriciotogneri.apply.test.types.BaseType;
import com.mauriciotogneri.apply.test.types.Bool;
import com.mauriciotogneri.apply.test.types.List;
import com.mauriciotogneri.apply.test.types.Num;

@SuppressWarnings("unchecked")
public class RuntimeTypedSpecial
{
    // arithmetic
    public static final $F2<Num, Num, Num> $add = Num::add;
    public static final $F2<Num, Num, Num> $sub = Num::sub;
    public static final $F2<Num, Num, Num> $mul = Num::mul;
    public static final $F2<Num, Num, Num> $div = Num::div;
    public static final $F2<Num, Num, Num> $pow = Num::pow;
    public static final $F2<Num, Num, Num> $mod = Num::mod;

    // comparison
    public static final $F2<Num, Num, Bool> $less = Num::less;
    public static final $F2<Num, Num, Bool> $lessEqual = Num::lessEqual;
    public static final $F2<Num, Num, Bool> $greater = Num::greater;
    public static final $F2<Num, Num, Bool> $greaterEqual = Num::greaterEqual;
    public static final $F2<BaseType, BaseType, Bool> $equal = BaseType::equal;
    public static final $F2<BaseType, BaseType, Bool> $notEqual = BaseType::notEqual;

    // logic
    public static final $F2<Bool, Bool, Bool> $and = Bool::and;
    public static final $F2<Bool, Bool, Bool> $or = Bool::or;
    public static final $F1<Bool, Bool> $negate = Bool::neg;

    // list
    public static final $F1<List, Bool> $empty = List::empty;
    public static final $F1<List, Num> $length = List::length;
    public static final $F2<List, Num, BaseType> $element = List::element;
    public static final $F2<List, BaseType, List> $append = List::append;
    public static final $F2<List, List, List> $concat = List::concat;
    public static final $F1<List, BaseType> $head = List::head;
    public static final $F1<List, List> $tail = List::tail;

    public interface $F0<A>
    {
        A apply();
    }

    public interface $F1<A, B>
    {
        B apply(A a);
    }

    public interface $F2<A, B, C>
    {
        C apply(A a, B b);
    }

    public interface $F3<A, B, C, D>
    {
        D apply(A a, B b, C c);
    }
}