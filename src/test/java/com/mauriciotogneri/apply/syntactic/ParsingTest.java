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
        //CharacterList characters = new FakeCharacters("m(3+4,a.b(1)-f(c,d*2))");
        CharacterList characters = new FakeCharacters("if(if(x) y else z) b else c");

        TokenList tokenList = new DefaultTokenList(characters);
        List<Token> tokens = tokenList.tokens();
        ParsedExpression parsedExpression = new ParsedExpression(tokens);
        List<Token> parsedTokens = parsedExpression.parse();

        System.out.println(parsedTokens);
    }
}