package com.mauriciotogneri.apply.compiler;

import com.mauriciotogneri.apply.compiler.frontend.lexical.ParsedSource;
import com.mauriciotogneri.apply.compiler.frontend.lexical.TokenizedSource;

import java.io.File;

public class Compiler
{
    public void compile(String filePath) throws Exception
    {
        File file = new File(filePath);
        ParsedSource parsedSource = new ParsedSource(file);
        TokenizedSource tokenizedSource = new TokenizedSource(parsedSource);
    }
}