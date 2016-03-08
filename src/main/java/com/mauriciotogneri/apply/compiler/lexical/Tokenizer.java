package com.mauriciotogneri.apply.compiler.lexical;

import java.util.Collection;

public interface Tokenizer
{
    Collection<Token> tokens(CharProvider charProvider) throws Exception;
}