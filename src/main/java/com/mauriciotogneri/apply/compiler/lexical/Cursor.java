package com.mauriciotogneri.apply.compiler.lexical;

public interface Cursor extends Position
{
    Cursor advance(char character);
}