package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Position;

public abstract class Token implements Position
{
    private final Lexeme lexeme;

    public Token(Lexeme lexeme)
    {
        this.lexeme = lexeme;
    }

    public boolean isSymbol()
    {
        return false;
        //(type == TokenType.SYMBOL) ||
        //(type == TokenType.IF);
    }

    public boolean isOpenParenthesis()
    {
        return false;
    }

    public boolean isCloseParenthesis()
    {
        return false;
    }

    public boolean isNumber()
    {
        return false;
    }

    public boolean isBoolean()
    {
        return false;
    }

    public boolean isArithmetic()
    {
        return false;
    }

    public boolean isSeparator()
    {
        return false;
    }

    public boolean isComma()
    {
        return false;
    }

    public boolean isOperator()
    {
        return isArithmetic(); // ||
        //(type == TokenType.MEMBER_ACCESS) ||
        //(type == TokenType.ELSE);
    }

    public boolean hasHigherPreference(Token token)
    {
        return false;
    }

    //    private boolean literal()
    //    {
    //        return isNumber() || //
    //                (type == TokenType.STRING) || //
    //                (type == TokenType.BOOLEAN);
    //    }

    //    private boolean logic()
    //    {
    //        return (type == TokenType.LOGIC_EQUAL) || //
    //                (type == TokenType.LOGIC_NOT_EQUAL) || //
    //                (type == TokenType.LOGIC_GREATER) || //
    //                (type == TokenType.LOGIC_GREATER_EQUAL) || //
    //                (type == TokenType.LOGIC_LESS) || //
    //                (type == TokenType.LOGIC_LESS_EQUAL) || //
    //                (type == TokenType.LOGIC_AND) || //
    //                (type == TokenType.LOGIC_OR) || //
    //                (type == TokenType.LOGIC_NEGATION);
    //    }

    //    private boolean conditional()
    //    {
    //        return (type == TokenType.IF);
    //    }

    //    private boolean array()
    //    {
    //        return (type == TokenType.ARRAY_INDEX) || //
    //                (type == TokenType.ARRAY_REMOVE) || //
    //                (type == TokenType.ARRAY_LENGTH);
    //    }

    //    private boolean list()
    //    {
    //        return (type == TokenType.LIST_OPEN) || //
    //                (type == TokenType.LIST_CLOSE);
    //    }

    //    private boolean primitive()
    //    {
    //        return conditional() || //
    //                arithmetic() || //
    //                logic() || //
    //                array() || //
    //                list();
    //    }

    //    private boolean expression()
    //    {
    //        return (type == TokenType.SYMBOL) || //
    //                conditional() || //
    //                literal() || //
    //                arithmetic() || //
    //                logic() || //
    //                array() || //
    //                list();
    //    }

    public String lexeme()
    {
        return lexeme.toString();
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