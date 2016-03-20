package com.mauriciotogneri.apply.compiler.frontend.lexical;

public interface Character extends Position
{
    boolean delimiter();

    boolean digit();

    boolean letter();
}