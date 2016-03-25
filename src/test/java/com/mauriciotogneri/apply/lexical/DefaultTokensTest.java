package com.mauriciotogneri.apply.lexical;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Characters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultLexeme;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultToken;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultTokens;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Token;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Tokens;
import com.mauriciotogneri.apply.compiler.types.TokenType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DefaultTokensTest
{
    @Test
    public void testSimpleExpression() throws Exception
    {
        Characters characters = new FakeCharacters("f(3+4,5)");

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("f", new FakePosition(1, 1))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("(", new FakePosition(1, 2))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("3", new FakePosition(1, 3))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("+", new FakePosition(1, 4))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("4", new FakePosition(1, 5))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme(",", new FakePosition(1, 6))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("5", new FakePosition(1, 7))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme(")", new FakePosition(1, 8))));

        Tokens tokens = new DefaultTokens(characters);
        List<Token> actualTokens = tokens.tokens();

        assertEquals(expectedTokens.size(), actualTokens.size());

        for (int i = 0; i < actualTokens.size(); i++)
        {
            Token actual = actualTokens.get(i);
            Token expected = expectedTokens.get(i);

            assertEquals(actual.toString(), expected.toString());
        }
    }
}