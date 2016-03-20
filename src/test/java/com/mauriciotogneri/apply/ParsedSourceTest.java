package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Character;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Characters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.ParsedSource;

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

        Character characterLetterF = characters.next();
        assertEquals(characterLetterF.digit(), false);
        assertEquals(characterLetterF.delimiter(), false);
        assertEquals(characterLetterF.letter(), true);
        assertEquals(characterLetterF.line(), 1);
        assertEquals(characterLetterF.column(), 1);

        Character characterOpenParenthesis = characters.next();
        assertEquals(characterOpenParenthesis.digit(), false);
        assertEquals(characterOpenParenthesis.delimiter(), false);
        assertEquals(characterOpenParenthesis.letter(), false);
        assertEquals(characterOpenParenthesis.line(), 1);
        assertEquals(characterOpenParenthesis.column(), 2);

        Character characterDigit3 = characters.next();
        assertEquals(characterDigit3.digit(), true);
        assertEquals(characterDigit3.delimiter(), false);
        assertEquals(characterDigit3.letter(), false);
        assertEquals(characterDigit3.line(), 1);
        assertEquals(characterDigit3.column(), 3);

        Character characterPlus = characters.next();
        assertEquals(characterPlus.digit(), false);
        assertEquals(characterPlus.delimiter(), false);
        assertEquals(characterPlus.letter(), false);
        assertEquals(characterPlus.line(), 1);
        assertEquals(characterPlus.column(), 4);

        Character characterDigit4 = characters.next();
        assertEquals(characterDigit4.digit(), true);
        assertEquals(characterDigit4.delimiter(), false);
        assertEquals(characterDigit4.letter(), false);
        assertEquals(characterDigit4.line(), 1);
        assertEquals(characterDigit4.column(), 5);

        Character characterComma = characters.next();
        assertEquals(characterComma.digit(), false);
        assertEquals(characterComma.delimiter(), false);
        assertEquals(characterComma.letter(), false);
        assertEquals(characterComma.line(), 1);
        assertEquals(characterComma.column(), 6);

        Character characterDigit5 = characters.next();
        assertEquals(characterDigit5.digit(), true);
        assertEquals(characterDigit5.delimiter(), false);
        assertEquals(characterDigit5.letter(), false);
        assertEquals(characterDigit5.line(), 1);
        assertEquals(characterDigit5.column(), 7);

        Character characterCloseParenthesis = characters.next();
        assertEquals(characterCloseParenthesis.digit(), false);
        assertEquals(characterCloseParenthesis.delimiter(), false);
        assertEquals(characterCloseParenthesis.letter(), false);
        assertEquals(characterCloseParenthesis.line(), 1);
        assertEquals(characterCloseParenthesis.column(), 8);
    }
}