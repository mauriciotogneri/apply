package com.mauriciotogneri.apply.compiler.frontend.lexical;

public interface Token extends Position
{
    boolean separator();

    boolean primitive();

    boolean expression();
}