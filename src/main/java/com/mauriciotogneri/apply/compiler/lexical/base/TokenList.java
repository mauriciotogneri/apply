package com.mauriciotogneri.apply.compiler.lexical.base;

import java.util.List;

public interface TokenList
{
    List<Token> tokens() throws Exception;
}