package com.mauriciotogneri.apply.lexical;

import com.mauriciotogneri.apply.compiler.lexical.DefaultTokenList;
import com.mauriciotogneri.apply.compiler.lexical.base.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.base.Token;
import com.mauriciotogneri.apply.compiler.lexical.base.TokenList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefaultTokenListTest
{
    @Test
    public void testSimpleExpression() throws Exception
    {
        CharacterList characters = new FakeCharacters("f(3+4,5)");

        TokenList tokens = new DefaultTokenList(characters);
        List<Token> actualTokens = tokens.tokens();

        assertEquals(8, actualTokens.size());

        assertTrue(actualTokens.get(0).isSymbol());
        assertTrue(actualTokens.get(1).isOpenParenthesis());
        assertTrue(actualTokens.get(2).isNumber());
        assertTrue(actualTokens.get(3).isArithmetic());
        assertTrue(actualTokens.get(4).isNumber());
        assertTrue(actualTokens.get(5).isComma());
        assertTrue(actualTokens.get(6).isNumber());
        assertTrue(actualTokens.get(7).isCloseParenthesis());
    }
}