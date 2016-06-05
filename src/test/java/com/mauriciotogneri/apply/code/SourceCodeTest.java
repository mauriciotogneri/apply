package com.mauriciotogneri.apply.code;

import com.mauriciotogneri.apply.base.TestSuite;
import com.mauriciotogneri.apply.compiler.lexical.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;
import com.mauriciotogneri.apply.compiler.code.SourceCode;
import com.mauriciotogneri.apply.compiler.syntactic.NodeStack;
import com.mauriciotogneri.apply.compiler.syntactic.ParsedExpression;

import org.junit.Test;

public class SourceCodeTest extends TestSuite
{
    @Test
    public void test() throws Exception
    {
        CharacterList characters = new CharacterList(file("test4.ply"));
        TokenList tokenList = new TokenList(characters);
        ParsedExpression parsedExpression = new ParsedExpression(tokenList);
        NodeStack nodeStack = parsedExpression.parse();
        SourceCode sourceCode = new SourceCode(nodeStack);

        System.out.println(sourceCode.generate("com.test", "Test"));
    }
}