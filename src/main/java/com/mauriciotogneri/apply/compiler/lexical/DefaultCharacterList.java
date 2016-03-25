package com.mauriciotogneri.apply.compiler.lexical;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DefaultCharacterList implements CharacterList
{
    private final InputStream inputStream;

    public DefaultCharacterList(File file) throws Exception
    {
        this.inputStream = new FileInputStream(file);
    }

    @Override
    public List<Character> characters() throws Exception
    {
        List<Character> characters = new ArrayList<>();

        Cursor cursor = new DefaultCursor(1, 1);

        int content;

        while ((content = inputStream.read()) != -1)
        {
            char character = (char) content;
            characters.add(new DefaultCharacter(character, cursor));

            cursor = cursor.advance(character);
        }

        return characters;
    }
}