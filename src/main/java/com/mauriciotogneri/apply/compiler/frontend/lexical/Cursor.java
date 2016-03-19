package com.mauriciotogneri.apply.compiler.frontend.lexical;

public interface Cursor extends Position
{
    Cursor advance(char character);
}