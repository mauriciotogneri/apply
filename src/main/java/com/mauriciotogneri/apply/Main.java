package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.Compiler;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Compiler compiler = new Compiler();
        compiler.compile(args[0]);
    }
}