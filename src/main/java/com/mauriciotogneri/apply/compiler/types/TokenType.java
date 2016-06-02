package com.mauriciotogneri.apply.compiler.types;

public enum TokenType
{
        // delimiters
    SPACE(" "), //
    TAB("\\t"), //
    NEW_LINE("\\n"), //
    COMMA(","), //

    // literals
    //INTEGER("-?\\d+"),
    //FLOAT("\\d+\\.?\\d*"),
    NUMBER("\\d*\\.?\\d+"),
    STRING("\"[^\"]*\""), // TODO
    BOOLEAN("true|false"), // TODO

    // arithmetic
    ARITHMETIC_ADDITION("\\+"), //
    ARITHMETIC_SUBTRACTION("\\-"), //
    ARITHMETIC_MULTIPLICATION("\\*"), //
    ARITHMETIC_DIVISION("\\/"), //
    ARITHMETIC_POWER("^"), //
    ARITHMETIC_MODULE("%"), //

    // special
    MEMBER_ACCESS("\\."), //

    // logic
    LOGIC_EQUAL("="), //
    LOGIC_NOT_EQUAL("!="), //
    LOGIC_GREATER(">"), //
    LOGIC_GREATER_EQUAL(">="), //
    LOGIC_LESS("<"), //
    LOGIC_LESS_EQUAL("<="), //
    LOGIC_AND("&"), //
    LOGIC_OR("|"), //
    LOGIC_NEGATION("!"), //

    // conditional
    IF("if"), //
    ELSE("else"), //

    // arrays (lists and strings)
    ARRAY_INDEX(""), // TODO
    ARRAY_REMOVE(""), // TODO
    ARRAY_LENGTH(""), // TODO

    // parenthesis
    PARENTHESIS_OPEN("\\("), //
    PARENTHESIS_CLOSE("\\)"), //

    // lists
    LIST_OPEN("\\["), //
    LIST_CLOSE("\\]"), //

    // general
    SYMBOL("[a-zA-Z]\\w*"), //
    IMPORT("\\$");

    private final String pattern;

    TokenType(String pattern)
    {
        this.pattern = pattern;
    }

    public String pattern()
    {
        return pattern;
    }
}