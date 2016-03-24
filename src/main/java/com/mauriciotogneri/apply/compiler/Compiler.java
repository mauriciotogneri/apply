package com.mauriciotogneri.apply.compiler;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Characters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultCharacters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultTokens;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Tokens;

import java.io.File;

public class Compiler
{
    public void compile(String filePath) throws Exception
    {
        File file = new File(filePath);
        Characters characters = new DefaultCharacters(file);
        Tokens tokens = new DefaultTokens(characters);
    }
}