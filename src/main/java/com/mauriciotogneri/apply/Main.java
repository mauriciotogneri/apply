package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.Compiler;

import java.io.File;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        Compiler compiler = new Compiler();
        compiler.compile(new File(args[0]), args[1], args[2]);
    }
}