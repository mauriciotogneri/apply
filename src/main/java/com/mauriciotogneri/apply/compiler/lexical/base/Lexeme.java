package com.mauriciotogneri.apply.compiler.lexical.base;

public interface Lexeme extends Position
{
    Lexeme appended(Character character);
}