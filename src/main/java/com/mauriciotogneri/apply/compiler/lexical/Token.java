package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Position;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticAdditionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticDivisionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticModuleToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticMultiplicationToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticPowerToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.arithmetic.ArithmeticSubtractionToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonGreaterEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonGreaterToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonLessEqualToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonLessToken;
import com.mauriciotogneri.apply.compiler.lexical.tokens.comparison.ComparisonNotEqualToken;
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

    public boolean isComparison()
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
        return isArithmetic() || isComparison() || isConditional();
    }

    public boolean isNewLine()
    {
        return false;
    }

    public boolean hasHigherPreference(Token token)
    {
        return precedence() < token.precedence();
    }

    //    1	    ()   []  {}  .          Function call, scope, array/member access
    //    2	    !   ^                   Most unary operators, sizeof and type casts (right to left)
    //    3	    *   /   %    	        Multiplication, division, modulo
    //    4	    +   -	                Addition and subtraction
    //    5	    <   <=   >   >=	        Comparisons: less-than, ...
    //    6	    ==   !=	                Comparisons: equal and not equal
    //    7 	&	                    Logical AND
    //    8	    |	                    Logical OR
    //    9	    if elsif else end       Conditional expression (ternary)
    //    10	=                      	Assignment operators (right to left)
    //    11	,	                    Comma operator
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
        else if ((this instanceof ComparisonLessToken) ||
                (this instanceof ComparisonLessEqualToken) ||
                (this instanceof ComparisonGreaterToken) ||
                (this instanceof ComparisonGreaterEqualToken))
        {
            return 5;
        }
        else if ((this instanceof ComparisonEqualToken) ||
                (this instanceof ComparisonNotEqualToken))
        {
            return 5;
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