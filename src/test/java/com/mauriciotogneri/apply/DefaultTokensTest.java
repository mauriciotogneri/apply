package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Characters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultCharacter;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultToken;
import com.mauriciotogneri.apply.compiler.frontend.lexical.DefaultTokens;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Token;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Tokens;
import com.mauriciotogneri.apply.compiler.types.TokenType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefaultTokensTest
{
    @Test
    public void testSimpleExpression() throws Exception
    {
        Characters characters = new FakeCharacters("f(3+4,5)");

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter('f', new FakePosition(1, 1))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter('(', new FakePosition(1, 2))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter('3', new FakePosition(1, 3))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter('+', new FakePosition(1, 4))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter('4', new FakePosition(1, 5))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter(',', new FakePosition(1, 6))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter('5', new FakePosition(1, 7))));
        expectedTokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultCharacter(')', new FakePosition(1, 8))));

        Tokens tokens = new DefaultTokens(characters);

        for (Token expected : expectedTokens)
        {
            Token actual = tokens.next();

            //assertEquals(actual.type(), validToken.type());
            assertEquals(actual.toString(), expected.toString());
        }

        assertTrue(tokens.empty());
    }
}