package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Characters;
import com.mauriciotogneri.apply.compiler.frontend.lexical.ReadCharacter;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Token;
import com.mauriciotogneri.apply.compiler.frontend.lexical.TokenizedSource;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Tokens;
import com.mauriciotogneri.apply.compiler.types.TokenType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TokenizedSourceTest
{
    @Test
    public void testSimpleExpression() throws Exception
    {
        Characters characters = new FakeCharacters("f(3+4,5)");

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter('f', new FakePosition(1, 1))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter('(', new FakePosition(1, 2))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter('3', new FakePosition(1, 3))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter('+', new FakePosition(1, 4))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter('4', new FakePosition(1, 5))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter(',', new FakePosition(1, 6))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter('5', new FakePosition(1, 7))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new ReadCharacter(')', new FakePosition(1, 8))));

        Tokens tokens = new TokenizedSource(characters);

        for (Token expected : expectedTokens)
        {
            Token actual = tokens.next();

            //assertEquals(actual.type(), validToken.type());
            assertEquals(actual.toString(), expected.toString());
        }

        assertTrue(tokens.empty());
    }
}