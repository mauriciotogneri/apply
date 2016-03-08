package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.lexical.Cursor;
import com.mauriciotogneri.apply.compiler.lexical.LexicalAnalyzer;
import com.mauriciotogneri.apply.compiler.lexical.Token;
import com.mauriciotogneri.apply.compiler.types.TokenType;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LexicalAnalyzerTest
{
    @Test
    public void testSimpleExpression() throws Exception
    {
        FakeCharStream charStream = new FakeCharStream("f(3+4,5)");

        List<Token> validTokens = new ArrayList<>();
        validTokens.add(new Token(TokenType.SYMBOL, "f", new Cursor(0, 0)));
        validTokens.add(new Token(TokenType.PARENTHESIS_OPEN, "(", new Cursor(0, 0)));
        validTokens.add(new Token(TokenType.FLOAT, "3", new Cursor(0, 0)));
        validTokens.add(new Token(TokenType.ARITHMETIC_ADDITION, "+", new Cursor(0, 0)));
        validTokens.add(new Token(TokenType.FLOAT, "4", new Cursor(0, 0)));
        validTokens.add(new Token(TokenType.COMMA, ",", new Cursor(0, 0)));
        validTokens.add(new Token(TokenType.FLOAT, "5", new Cursor(0, 0)));
        validTokens.add(new Token(TokenType.PARENTHESIS_CLOSE, ")", new Cursor(0, 0)));

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        List<Token> tokens = lexicalAnalyzer.tokens(charStream);

        assertEquals(tokens.size(), validTokens.size());

        for (int i = 0; i < tokens.size(); i++)
        {
            Token actual = tokens.get(i);
            Token expected = validTokens.get(i);

            assertEquals(actual.type(), expected.type());
            assertEquals(actual.toString(), expected.toString());
        }
    }
}