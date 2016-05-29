package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.base.Token;
import com.mauriciotogneri.apply.compiler.types.TokenType;

public class DefaultToken implements Token
{
    private final TokenType type;
    private final Lexeme lexeme;

    public DefaultToken(TokenType type, Lexeme lexeme)
    {
        this.lexeme = lexeme;
        this.type = type;
    }

    @Override
    public boolean isSymbol()
    {
        return (type == TokenType.SYMBOL);
    }

    @Override
    public boolean isOpenParenthesis()
    {
        return (type == TokenType.PARENTHESIS_OPEN);
    }

    @Override
    public boolean isCloseParenthesis()
    {
        return (type == TokenType.PARENTHESIS_CLOSE);
    }

    @Override
    public boolean isNumber()
    {
        return (type == TokenType.INTEGER) ||
                (type == TokenType.FLOAT);
    }

    @Override
    public boolean isArithmetic()
    {
        return (type == TokenType.ARITHMETIC_ADDITION) ||
                (type == TokenType.ARITHMETIC_SUBTRACTION) ||
                (type == TokenType.ARITHMETIC_MULTIPLICATION) ||
                (type == TokenType.ARITHMETIC_DIVISION) ||
                (type == TokenType.ARITHMETIC_POWER) ||
                (type == TokenType.ARITHMETIC_MODULE);
    }

    @Override
    public boolean isOperator()
    {
        return isArithmetic() ||
                (type == TokenType.MEMBER_ACCESS);
    }

    @Override
    public boolean isComma()
    {
        return (type == TokenType.COMMA);
    }

    @Override
    public String lexeme()
    {
        return lexeme.toString();
    }

    private boolean separator()
    {
        return (type == TokenType.SPACE) || //
                (type == TokenType.TAB);
    }

    private boolean literal()
    {
        return (type == TokenType.INTEGER) || //
                (type == TokenType.FLOAT) || //
                (type == TokenType.STRING) || //
                (type == TokenType.BOOLEAN);
    }

    private boolean arithmetic()
    {
        return (type == TokenType.ARITHMETIC_ADDITION) || //
                (type == TokenType.ARITHMETIC_SUBTRACTION) || //
                (type == TokenType.ARITHMETIC_MULTIPLICATION) || //
                (type == TokenType.ARITHMETIC_DIVISION) || //
                (type == TokenType.ARITHMETIC_POWER) || //
                (type == TokenType.ARITHMETIC_MODULE);
    }

    private boolean logic()
    {
        return (type == TokenType.LOGIC_EQUAL) || //
                (type == TokenType.LOGIC_NOT_EQUAL) || //
                (type == TokenType.LOGIC_GREATER) || //
                (type == TokenType.LOGIC_GREATER_EQUAL) || //
                (type == TokenType.LOGIC_LESS) || //
                (type == TokenType.LOGIC_LESS_EQUAL) || //
                (type == TokenType.LOGIC_AND) || //
                (type == TokenType.LOGIC_OR) || //
                (type == TokenType.LOGIC_NEGATION);
    }

    private boolean conditional()
    {
        return (type == TokenType.IF);
    }

    private boolean array()
    {
        return (type == TokenType.ARRAY_INDEX) || //
                (type == TokenType.ARRAY_REMOVE) || //
                (type == TokenType.ARRAY_LENGTH);
    }

    private boolean list()
    {
        return (type == TokenType.LIST_OPEN) || //
                (type == TokenType.LIST_CLOSE);
    }

    private boolean primitive()
    {
        return conditional() || //
                arithmetic() || //
                logic() || //
                array() || //
                list();
    }

    private boolean expression()
    {
        return (type == TokenType.SYMBOL) || //
                conditional() || //
                literal() || //
                arithmetic() || //
                logic() || //
                array() || //
                list();
    }

    @Override
    public int line()
    {
        return lexeme.line();
    }

    @Override
    public int column()
    {
        return lexeme.column();
    }

    @Override
    public String toString()
    {
        return lexeme.toString();
    }
}