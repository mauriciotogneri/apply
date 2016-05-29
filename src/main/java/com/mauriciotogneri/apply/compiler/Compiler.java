package com.mauriciotogneri.apply.compiler;

import com.mauriciotogneri.apply.compiler.lexical.base.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.DefaultCharacterList;
import com.mauriciotogneri.apply.compiler.lexical.DefaultTokenList;
import com.mauriciotogneri.apply.compiler.lexical.base.TokenList;

import java.io.File;

public class Compiler
{
    public void compile(String filePath) throws Exception
    {
        File file = new File(filePath);
        CharacterList characters = new DefaultCharacterList(file);
        TokenList tokens = new DefaultTokenList(characters);
    }
}