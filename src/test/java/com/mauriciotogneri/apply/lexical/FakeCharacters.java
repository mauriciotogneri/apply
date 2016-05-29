package com.mauriciotogneri.apply.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Character;
import com.mauriciotogneri.apply.compiler.lexical.base.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.DefaultCharacter;

import java.util.ArrayList;
import java.util.List;

public class FakeCharacters implements CharacterList
{
    private final List<Character> characters;

    public FakeCharacters(String input)
    {
        this.characters = new ArrayList<>();

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++)
        {
            FakePosition position = new FakePosition(1, i);

            this.characters.add(new DefaultCharacter(chars[i], position));
        }
    }

    @Override
    public List<Character> characters() throws Exception
    {
        return characters;
    }
}