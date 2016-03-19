package com.mauriciotogneri.apply.compiler.types;

public enum TokenType
{
    // general
    SYMBOL, //
    IMPORT, //
    ANONYMOUS_FUNCTION, //

    // delimiters
    SPACE, //
    TAB, //
    NEW_LINE, //
    COMMA, //

    // literals
    INTEGER, //
    FLOAT, //
    STRING, //
    BOOLEAN, //

    // arithmetic
    ARITHMETIC_ADDITION, //
    ARITHMETIC_SUBTRACTION, //
    ARITHMETIC_MULTIPLICATION, //
    ARITHMETIC_DIVISION, //
    ARITHMETIC_POWER, //
    ARITHMETIC_MODULE, //
    ARITHMETIC_INCREMENT, //
    ARITHMETIC_DECREMENT, //

    // logic
    LOGIC_EQUAL, //
    LOGIC_NOT_EQUAL, //
    LOGIC_GREATER, //
    LOGIC_GREATER_EQUAL, //
    LOGIC_LESS, //
    LOGIC_LESS_EQUAL, //
    LOGIC_AND, //
    LOGIC_OR, //
    LOGIC_NEGATION, //

    // conditional
    CONDITIONAL_IF, //

    // arrays (lists and strings)
    ARRAY_INDEX, //
    ARRAY_REMOVE, //
    ARRAY_LENGTH, //

    // parenthesis
    PARENTHESIS_OPEN, //
    PARENTHESIS_CLOSE, //

    // lists
    LIST_OPEN, //
    LIST_CLOSE
}