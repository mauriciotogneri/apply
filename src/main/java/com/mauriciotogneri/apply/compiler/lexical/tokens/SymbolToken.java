package com.mauriciotogneri.apply.compiler.lexical.tokens;

import com.mauriciotogneri.apply.compiler.lexical.Lexeme;
import com.mauriciotogneri.apply.compiler.lexical.Token;

public class SymbolToken extends Token
{
    public SymbolToken(Lexeme lexeme)
    {
        super(lexeme);
    }

    @Override
    public boolean isSymbol()
    {
        return true;
    }
}