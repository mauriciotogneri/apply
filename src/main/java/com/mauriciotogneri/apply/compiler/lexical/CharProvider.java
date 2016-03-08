package com.mauriciotogneri.apply.compiler.lexical;

public interface CharProvider
{
    boolean hasMore() throws Exception;

    char get() throws Exception;
}