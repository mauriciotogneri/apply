package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Character;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Characters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultCharacter;

public class FakeCharacters implements Characters
{
    private int index = 0;
    private final char[] chars;

    public FakeCharacters(String input)
    {
        this.chars = input.toCharArray();
    }

    @Override
    public boolean empty() throws Exception
    {
        return (index >= chars.length);
    }

    @Override
    public Character next() throws Exception
    {
        FakePosition position = new FakePosition(1, index);

        return new DefaultCharacter(chars[index++], position);
    }
}