package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Position;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticAdditionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticDivisionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticModuleToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticMultiplicationToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticPowerToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticSubtractionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.conditional.ConditionalToken;

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

    public boolean isComma()
    {
        return false;
    }

    public boolean isIf()
    {
        return false;
    }

    public boolean isIfElse()
    {
        return false;
    }

    public boolean isElse()
    {
        return false;
    }

    public boolean isConditional()
    {
        return isIf() || isIfElse() || isElse();
    }

    public boolean isEndIf()
    {
        return false;
    }

    public boolean isOperator()
    {
        return isArithmetic() || isConditional(); // ||
        //(type == TokenType.MEMBER_ACCESS) ||
        //(type == TokenType.ELSE);
    }

    public boolean isNewLine()
    {
        return false;
    }

    public boolean hasHigherPreference(Token token)
    {
        return precedence() < token.precedence();
    }

    //    1	    ()   []   ->   .   ::   Function call, scope, array/member access
    //    2	    !   ~   -   +   *   &   (most) unary operators, sizeof and type casts (right to left)
    //    3	    *   /   %    	        Multiplication, division, modulo
    //    4	    +   -	                Addition and subtraction
    //    5 	<<   >>	                Bitwise shift left and right
    //    6	    <   <=   >   >=	        Comparisons: less-than, ...
    //    7	    ==   !=	                Comparisons: equal and not equal
    //    8	    &	                    Bitwise AND
    //    9	    ^	                    Bitwise exclusive OR (XOR)
    //    10	|	                    Bitwise inclusive (normal) OR
    //    11	&&	                    Logical AND
    //    12	||	                    Logical OR
    //    13	 ? :	                Conditional expression (ternary)
    //    14	=   +=   -=   *=   /=   %=   &=   |=   ^=   <<=   >>=	Assignment operators (right to left)
    //    15	,	                    Comma operator
    private int precedence()
    {
        if (this instanceof ArithmeticPowerToken) // right
        {
            return 2;
        }
        else if (this instanceof ArithmeticModuleToken) // left
        {
            return 3;
        }
        else if (this instanceof ArithmeticDivisionToken) // left
        {
            return 3;
        }
        else if (this instanceof ArithmeticMultiplicationToken) // left
        {
            return 3;
        }
        else if (this instanceof ArithmeticSubtractionToken) // left
        {
            return 4;
        }
        else if (this instanceof ArithmeticAdditionToken) // left
        {
            return 4;
        }
        else if (this instanceof ConditionalToken)
        {
            return 8;
        }
        else
        {
            throw new RuntimeException();
        }
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