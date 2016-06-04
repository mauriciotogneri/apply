package com.mauriciotogneri.apply.syntactic;

import com.mauriciotogneri.apply.base.TestSuite;
import com.mauriciotogneri.apply.compiler.lexical.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;
import com.mauriciotogneri.apply.compiler.syntactic.NodeStack;
import com.mauriciotogneri.apply.compiler.syntactic.ParsedExpression;

import org.junit.Test;

public class ParsingTest extends TestSuite
{
    @Test
    public void test() throws Exception
    {
        //CharacterList characters = new FakeCharacters("m(3+4,a.b(1)-f(c,d*2))");
        //CharacterList characters = new CharacterList("if(if(x) y else z) b else c");
        CharacterList characters = new CharacterList(file("test3.ply"));

        TokenList tokenList = new TokenList(characters);
        ParsedExpression parsedExpression = new ParsedExpression(tokenList);
        NodeStack nodeStack = parsedExpression.parse();

        System.out.println(nodeStack.getFirst().toString());
    }
}