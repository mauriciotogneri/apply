package com.mauriciotogneri.apply.compiler.types;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.AssignmentToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.types.BooleanToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.CommaToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.delimiters.NewLineToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.types.NumberToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.delimiters.SpaceToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.SymbolToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.special.TypeOfToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticAdditionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticDivisionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticModuleToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticMultiplicationToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticPowerToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticSubtractionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.blocks.ParenthesisCloseToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.blocks.ParenthesisOpenToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonGreaterEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonGreaterToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonLessEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonLessToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonNotEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.conditional.ConditionalElseIfToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.conditional.ConditionalElseToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.conditional.ConditionalEndIfToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.conditional.ConditionalIfToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.logic.LogicAndToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.logic.LogicNotToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.logic.LogicOrToken;

import java.util.Optional;

public enum TokenType
{
    // delimiters
    SPACE(" +"), //
    TAB("\\t+"), //
    NEW_LINE("\\n+"), //

    // literals
    NUMBER("\\d*\\.?\\d+"),
    STRING("\"[^\"]*\""),
    BOOLEAN("true|false"),

    // arithmetic
    ARITHMETIC_ADDITION("\\+"), //
    ARITHMETIC_SUBTRACTION("\\-"), //
    ARITHMETIC_MULTIPLICATION("\\*"), //
    ARITHMETIC_DIVISION("\\/"), //
    ARITHMETIC_POWER("^"), //
    ARITHMETIC_MODULE("%"), //

    // special
    MEMBER_ACCESS("\\."), //
    COMMA(","), //
    TYPE_OF(":"), //
    ASSIGNMENT("="), //

    // comparison
    LOGIC_EQUAL("=="), //
    LOGIC_NOT_EQUAL("!="), //
    LOGIC_GREATER(">"), //
    LOGIC_GREATER_EQUAL(">="), //
    LOGIC_LESS("<"), //
    LOGIC_LESS_EQUAL("<="), //

    // logic
    LOGIC_NOT("!"), //
    LOGIC_AND("&"), //
    LOGIC_OR("|"), //

    // conditional
    IF("if"), //
    ELSE("else"), //
    ELSE_IF("elsif"), //
    END_IF("end"), //

    // parenthesis
    PARENTHESIS_OPEN("\\("), //
    PARENTHESIS_CLOSE("\\)"), //

    // lists
    LIST_OPEN("\\["), //
    LIST_CLOSE("\\]"), //

    // brackets
    BRACKETS_OPEN("\\{"), //
    BRACKETS_CLOSE("\\}"), //

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

            case SYMBOL:
                return new SymbolToken(lexeme);

            case COMMA:
                return new CommaToken(lexeme);

            case TYPE_OF:
                return new TypeOfToken(lexeme);

            case ASSIGNMENT:
                return new AssignmentToken(lexeme);

            case BOOLEAN:
                return new BooleanToken(lexeme);

            case IF:
                return new ConditionalIfToken(lexeme);

            case ELSE:
                return new ConditionalElseToken(lexeme);

            case ELSE_IF:
                return new ConditionalElseIfToken(lexeme);

            case END_IF:
                return new ConditionalEndIfToken(lexeme);

            case NEW_LINE:
                return new NewLineToken(lexeme);

            case SPACE:
            case TAB:
                return new SpaceToken(lexeme);

            case LOGIC_EQUAL:
                return new ComparisonEqualToken(lexeme);

            case LOGIC_NOT_EQUAL:
                return new ComparisonNotEqualToken(lexeme);

            case LOGIC_LESS:
                return new ComparisonLessToken(lexeme);

            case LOGIC_LESS_EQUAL:
                return new ComparisonLessEqualToken(lexeme);

            case LOGIC_GREATER:
                return new ComparisonGreaterToken(lexeme);

            case LOGIC_GREATER_EQUAL:
                return new ComparisonGreaterEqualToken(lexeme);

            case LOGIC_NOT:
                return new LogicNotToken(lexeme);

            case LOGIC_AND:
                return new LogicAndToken(lexeme);

            case LOGIC_OR:
                return new LogicOrToken(lexeme);

            //--------------------

            /*case STRING:
                break;
            case MEMBER_ACCESS:
                break;
            case LIST_OPEN:
                break;
            case LIST_CLOSE:
                break;
            case BRACKETS_OPEN:
                break;
            case BRACKETS_CLOSE:
                break;
            case IMPORT:
                break;*/

            default:
                throw new RuntimeException(lexeme.toString());
        }
    }
}