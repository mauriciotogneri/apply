package com.mauriciotogneri.apply.compiler.lexical.base;

public interface Token extends Position
{
    boolean isSymbol();

    boolean isOpenParenthesis();

    boolean isCloseParenthesis();

    boolean isNumber();

    boolean isArithmetic();

    boolean isOperator();

    boolean isComma();

    boolean isSeparator();

    String lexeme();
}