package com.mauriciotogneri.apply.compiler;

import com.mauriciotogneri.apply.compiler.lexical.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;

import java.io.File;

public class Compiler
{
    public void compile(String filePath) throws Exception
    {
        File file = new File(filePath);
        TokenList tokens = tokens(file);
        Object syntactic = syntactic(tokens);
        Object semantic = semantic(syntactic);
        System.out.println(semantic);
    }

    private TokenList tokens(File file) throws Exception
    {
        CharacterList characters = new CharacterList(file);
        return new TokenList(characters);
    }

    private Object syntactic(TokenList tokens)
    {
        return null;
    }

    private Object semantic(Object syntactic)
    {
        return null;
    }
}