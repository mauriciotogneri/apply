package com.mauriciotogneri.apply.compiler.lexical.base;

public interface Cursor extends Position
{
    Cursor advance(char character);
}