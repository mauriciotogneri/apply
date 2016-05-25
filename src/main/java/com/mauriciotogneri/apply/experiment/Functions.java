package com.mauriciotogneri.apply.experiment;

@SuppressWarnings("ALL")
public class Functions
{
    public interface Function1<A, B>
    {
        B apply(A a);
    }

    public interface Function2<A, B, C>
    {
        C apply(A a, B b);
    }

    public interface Function3<A, B, C, D>
    {
        D apply(A a, B b, C c);
    }
}