package com.mauriciotogneri.apply.compiler.frontend.lexical;

import java.util.List;

public interface Tokens
{
    List<Token> tokens() throws Exception;
}