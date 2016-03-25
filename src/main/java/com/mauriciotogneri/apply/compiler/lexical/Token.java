package com.mauriciotogneri.apply.compiler.lexical;

public interface Token extends Position
{
    boolean separator();

    boolean primitive();

    boolean expression();
}