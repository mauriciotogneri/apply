package com.mauriciotogneri.apply.test.types;

public interface BasicType<T>
{
    Bool equal(T value);

    Bool notEqual(T value);
}