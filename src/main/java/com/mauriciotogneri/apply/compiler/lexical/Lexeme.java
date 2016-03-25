package com.mauriciotogneri.apply.compiler.lexical;

public interface Lexeme extends Position
{
    Lexeme appended(Character character);
}