package com.mauriciotogneri.apply.compiler.frontend.lexical;

public interface Tokens
{
    boolean empty() throws Exception;

    Token next() throws Exception;
}