package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.lexical.CharProvider;

public class CharStreamStub implements CharProvider
{
    private int index = 0;
    private final char[] chars;

    public CharStreamStub(String input)
    {
        this.chars = input.toCharArray();
    }

    @Override
    public boolean hasMore() throws Exception
    {
        return index < chars.length;
    }

    @Override
    public char get() throws Exception
    {
        return chars[index++];
    }
}