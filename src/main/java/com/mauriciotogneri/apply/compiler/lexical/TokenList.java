package com.mauriciotogneri.apply.compiler.lexical;

import java.util.List;

public interface TokenList
{
    List<Token> tokens() throws Exception;
}