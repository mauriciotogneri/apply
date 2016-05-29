package com.mauriciotogneri.apply.syntactic;

import com.mauriciotogneri.apply.compiler.lexical.DefaultTokenList;
import com.mauriciotogneri.apply.compiler.lexical.base.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.base.Token;
import com.mauriciotogneri.apply.compiler.lexical.base.TokenList;
import com.mauriciotogneri.apply.compiler.syntactic.ParsedExpression;
import com.mauriciotogneri.apply.lexical.FakeCharacters;

import org.junit.Test;

import java.util.List;

public class ParsingTest
{
    @Test
    public void test() throws Exception
    {
        // m(3+4,a.b-f(c,d*2))

        // exp        = function | arithmetic
        // function   = symbol | symbol ( params )
        // params     = exp | epx ,
        // arithmetic = number | epx + exp | exp - exp | exp * exp

        //        List<Token> tokens = new ArrayList<>();
        //        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("m", new FakePosition(1, 1))));
        //        tokens.add(new DefaultToken(TokenType.PARENTHESIS_OPEN, new DefaultLexeme("(", new FakePosition(1, 2))));
        //        tokens.add(new DefaultToken(TokenType.INTEGER, new DefaultLexeme("3", new FakePosition(1, 3))));
        //        tokens.add(new DefaultToken(TokenType.ARITHMETIC_ADDITION, new DefaultLexeme("+", new FakePosition(1, 4))));
        //        tokens.add(new DefaultToken(TokenType.INTEGER, new DefaultLexeme("4", new FakePosition(1, 5))));
        //        tokens.add(new DefaultToken(TokenType.COMMA, new DefaultLexeme(",", new FakePosition(1, 6))));
        //        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("a", new FakePosition(1, 7))));
        //        tokens.add(new DefaultToken(TokenType.MEMBER_ACCESS, new DefaultLexeme(".", new FakePosition(1, 8))));
        //        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("b", new FakePosition(1, 9))));
        //        tokens.add(new DefaultToken(TokenType.ARITHMETIC_SUBTRACTION, new DefaultLexeme("-", new FakePosition(1, 10))));
        //        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("f", new FakePosition(1, 11))));
        //        tokens.add(new DefaultToken(TokenType.PARENTHESIS_OPEN, new DefaultLexeme("(", new FakePosition(1, 12))));
        //        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("c", new FakePosition(1, 13))));
        //        tokens.add(new DefaultToken(TokenType.COMMA, new DefaultLexeme(",", new FakePosition(1, 14))));
        //        tokens.add(new DefaultToken(TokenType.SYMBOL, new DefaultLexeme("d", new FakePosition(1, 15))));
        //        tokens.add(new DefaultToken(TokenType.ARITHMETIC_MULTIPLICATION, new DefaultLexeme("*", new FakePosition(1, 16))));
        //        tokens.add(new DefaultToken(TokenType.INTEGER, new DefaultLexeme("2", new FakePosition(1, 17))));
        //        tokens.add(new DefaultToken(TokenType.PARENTHESIS_CLOSE, new DefaultLexeme(")", new FakePosition(1, 18))));
        //        tokens.add(new DefaultToken(TokenType.PARENTHESIS_CLOSE, new DefaultLexeme(")", new FakePosition(1, 19))));

        CharacterList characters = new FakeCharacters("m(3+4,a.b(1)-f(c,d*2))");

        TokenList tokenList = new DefaultTokenList(characters);
        List<Token> tokens = tokenList.tokens();
        ParsedExpression parsedExpression = new ParsedExpression(tokens);
        List<Token> parsedTokens = parsedExpression.parse();

        System.out.println(parsedTokens);
    }
}