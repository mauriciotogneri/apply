package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.Compiler;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Compiler compiler = new Compiler();
        compiler.compile(args[0]);
    }

    public boolean isWholeNumber(BigDecimal number)
    {
        return (number.scale() <= 0) || number.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0;
    }
}