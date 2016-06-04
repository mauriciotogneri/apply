package com.mauriciotogneri.apply.compiler.lexical.tokens.comparison;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class ComparisonToken extends Token
{
    public ComparisonToken(Lexeme lexeme)
    {
        super(lexeme);
    }

     @Override
     public boolean isComparison()
     {
         return true;
     }
}