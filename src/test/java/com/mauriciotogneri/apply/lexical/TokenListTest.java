package com.mauriciotogneri.apply.lexical;

import com.mauriciotogneri.apply.base.TestSuite;
import com.mauriciotogneri.apply.compiler.lexical.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TokenListTest extends TestSuite
{
    @Test
    public void testArithmetic1() throws Exception
    {
        CharacterList characterList = new CharacterList(file("test1.ply"));
        TokenList tokenList = new TokenList(characterList);
        List<Token> tokens = tokenList.tokens();

        assertEquals(3, tokens.size());

        assertTrue(tokens.get(0).isNumber());
        assertTrue(tokens.get(1).isArithmetic());
        assertTrue(tokens.get(2).isNumber());
    }

    @Test
    public void testArithmetic2() throws Exception
    {
        CharacterList characterList = new CharacterList(file("test2.ply"));
        TokenList tokenList = new TokenList(characterList);
        List<Token> tokens = tokenList.tokens();

        assertEquals(5, tokens.size());

        assertTrue(tokens.get(0).isNumber());
        assertTrue(tokens.get(1).isArithmetic());
        assertTrue(tokens.get(2).isNumber());
        assertTrue(tokens.get(3).isArithmetic());
        assertTrue(tokens.get(4).isNumber());
    }
}