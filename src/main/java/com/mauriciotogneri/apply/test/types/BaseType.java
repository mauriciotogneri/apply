package com.mauriciotogneri.apply.test.types;

public interface BaseType<T>
{
    Bool equal(T value);

    Bool notEqual(T value);
}