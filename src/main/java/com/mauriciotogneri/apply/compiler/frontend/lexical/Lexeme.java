package com.mauriciotogneri.apply.compiler.frontend.lexical;

public interface Lexeme extends Position
{
    Lexeme appended(Character character);
}