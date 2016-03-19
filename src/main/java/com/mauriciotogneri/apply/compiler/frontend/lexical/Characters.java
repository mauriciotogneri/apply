package com.mauriciotogneri.apply.compiler.frontend.lexical;

public interface Characters
{
    boolean empty() throws Exception;

    Character next() throws Exception;
}