package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Character;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Token;
import com.mauriciotogneri.apply.compiler.frontend.lexical.TokenizedSource;
import com.mauriciotogneri.apply.compiler.frontend.lexical.Tokens;
import com.mauriciotogneri.apply.compiler.types.CharacterType;
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
        FakeCharacters fakeCharacters = new FakeCharacters("f(3+4,5)");

        List<Token> expectedTokens = new ArrayList<>();
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.f, new FakePosition(1, 1))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.OPEN_PARENTHESES, new FakePosition(1, 2))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.NUMBER_3, new FakePosition(1, 3))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.PLUS, new FakePosition(1, 4))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.NUMBER_4, new FakePosition(1, 5))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.COMMA, new FakePosition(1, 6))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.NUMBER_5, new FakePosition(1, 7))));
        expectedTokens.add(new Token(TokenType.SYMBOL, new Character(CharacterType.CLOSE_PARENTHESES, new FakePosition(1, 8))));

        Tokens tokens = new TokenizedSource(fakeCharacters);

        for (Token expected : expectedTokens)
        {
            Token actual = tokens.next();

            //assertEquals(actual.type(), validToken.type());
            assertEquals(actual.toString(), expected.toString());
        }

        assertTrue(tokens.empty());
    }
}