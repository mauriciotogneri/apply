package com.mauriciotogneri.apply.compiler.types;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticAdditionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticDivisionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticModuleToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticMultiplicationToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticPowerToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ArithmeticSubtractionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.BooleanToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.CommaToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.NumberToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ParenthesisCloseToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.ParenthesisOpenToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.SeparatorToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.SymbolToken;

import java.util.Optional;

public enum TokenType
{
    // delimiters
    SPACE(" +"), //
    TAB("\\t+"), //
    NEW_LINE("\\n+"), //
    COMMA(","), //

    // literals
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

    public static Optional<Token> ofLexeme(Lexeme lexeme)
    {
        for (TokenType tokenType : TokenType.values())
        {
            if (lexeme.matches(tokenType.pattern()))
            {
                return Optional.of(ofType(tokenType, lexeme));
            }
        }

        return Optional.empty();
    }

    private static Token ofType(TokenType type, Lexeme lexeme)
    {
        switch (type)
        {
            case NUMBER:
                return new NumberToken(lexeme);

            case PARENTHESIS_OPEN:
                return new ParenthesisOpenToken(lexeme);

            case PARENTHESIS_CLOSE:
                return new ParenthesisCloseToken(lexeme);

            case ARITHMETIC_ADDITION:
                return new ArithmeticAdditionToken(lexeme);

            case ARITHMETIC_SUBTRACTION:
                return new ArithmeticSubtractionToken(lexeme);

            case ARITHMETIC_MULTIPLICATION:
                return new ArithmeticMultiplicationToken(lexeme);

            case ARITHMETIC_DIVISION:
                return new ArithmeticDivisionToken(lexeme);

            case ARITHMETIC_POWER:
                return new ArithmeticPowerToken(lexeme);

            case ARITHMETIC_MODULE:
                return new ArithmeticModuleToken(lexeme);

            case TAB:
            case SPACE:
                return new SeparatorToken(lexeme);

            case SYMBOL:
                return new SymbolToken(lexeme);

            case COMMA:
                return new CommaToken(lexeme);

            case BOOLEAN:
                return new BooleanToken(lexeme);

            //--------------------

            case NEW_LINE:
                break;
            case STRING:
                break;
            case MEMBER_ACCESS:
                break;
            case LOGIC_EQUAL:
                break;
            case LOGIC_NOT_EQUAL:
                break;
            case LOGIC_GREATER:
                break;
            case LOGIC_GREATER_EQUAL:
                break;
            case LOGIC_LESS:
                break;
            case LOGIC_LESS_EQUAL:
                break;
            case LOGIC_AND:
                break;
            case LOGIC_OR:
                break;
            case LOGIC_NEGATION:
                break;
            case IF:
                break;
            case ELSE:
                break;
            case ARRAY_INDEX:
                break;
            case ARRAY_REMOVE:
                break;
            case ARRAY_LENGTH:
                break;
            case LIST_OPEN:
                break;
            case LIST_CLOSE:
                break;
            case IMPORT:
                break;
        }

        throw new RuntimeException();
    }
}