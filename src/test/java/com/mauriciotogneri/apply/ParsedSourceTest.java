package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Character;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Characters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.FileCursor;
import com.mauriciotogneri.apply.compiler.frontend.lexical.ParsedSource;
import com.mauriciotogneri.apply.compiler.types.CharacterType;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ParsedSourceTest
{
    @Test
    public void fromFile() throws Exception
    {
        File file = new File("src/test/resources/sample.ply");
        Characters characters = new ParsedSource(file);

        assertEquals(characters.next(), new Character(CharacterType.f, new FileCursor(1, 1)));
        assertEquals(characters.next(), new Character(CharacterType.OPEN_PARENTHESES, new FileCursor(1, 2)));
        assertEquals(characters.next(), new Character(CharacterType.NUMBER_3, new FileCursor(1, 3)));
        assertEquals(characters.next(), new Character(CharacterType.PLUS, new FileCursor(1, 4)));
        assertEquals(characters.next(), new Character(CharacterType.NUMBER_4, new FileCursor(1, 5)));
        assertEquals(characters.next(), new Character(CharacterType.COMMA, new FileCursor(1, 6)));
        assertEquals(characters.next(), new Character(CharacterType.NUMBER_5, new FileCursor(1, 7)));
        assertEquals(characters.next(), new Character(CharacterType.CLOSE_PARENTHESES, new FileCursor(1, 8)));
    }
}