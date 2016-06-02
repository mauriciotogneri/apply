package com.mauriciotogneri.apply.lexical;

import com.mauriciotogneri.apply.base.TestSuite;
import com.mauriciotogneri.apply.compiler.lexical.Character;
import com.mauriciotogneri.apply.compiler.lexical.CharacterList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CharacterListTest extends TestSuite
{
    @Test
    public void testArithmetic1() throws Exception
    {
        CharacterList characterList = new CharacterList(file("test1.ply"));
        List<Character> characters = characterList.characters();

        assertEquals(characters.size(), 3);

        assertEquals(characters.get(0).value(), '1');
        assertEquals(characters.get(1).value(), '+');
        assertEquals(characters.get(2).value(), '2');
    }

    @Test
    public void testArithmetic2() throws Exception
    {
        CharacterList characterList = new CharacterList(file("test2.ply"));
        List<Character> characters = characterList.characters();

        assertEquals(characters.size(), 5);

        assertEquals(characters.get(0).value(), '2');
        assertEquals(characters.get(1).value(), '+');
        assertEquals(characters.get(2).value(), '3');
        assertEquals(characters.get(3).value(), '*');
        assertEquals(characters.get(4).value(), '4');
    }
}