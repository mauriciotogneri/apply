package com.mauriciotogneri.apply.compiler.lexical;

public interface Character extends Position
{
    boolean delimiter();

    boolean digit();

    boolean letter();
}