package com.mauriciotogneri.apply.compiler;

import com.mauriciotogneri.apply.compiler.lexical.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;

import java.io.File;

public class Compiler
{
    public void compile(String filePath) throws Exception
    {
        File file = new File(filePath);
        CharacterList characters = new CharacterList(file);
        TokenList tokens = new TokenList(characters);
    }
}