package com.mauriciotogneri.apply.compiler;

import com.mauriciotogneri.apply.compiler.code.SourceCode;
import com.mauriciotogneri.apply.compiler.lexical.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.TokenList;
import com.mauriciotogneri.apply.compiler.syntactic.NodeStack;
import com.mauriciotogneri.apply.compiler.syntactic.ParsedExpression;
import com.mauriciotogneri.apply.test.CustomJavaCompiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Compiler
{
    public void compile(File file, String packageName, String className) throws Exception
    {
        CharacterList characters = new CharacterList(file);
        TokenList tokenList = new TokenList(characters);
        ParsedExpression parsedExpression = new ParsedExpression(tokenList);
        NodeStack nodeStack = parsedExpression.parse();
        SourceCode sourceCode = new SourceCode(nodeStack);

        String code = sourceCode.generate(packageName, className);

        File javaFile = new File(String.format("src/main/java/com/mauriciotogneri/apply/tmp/%s.java", className));
        writeFile(javaFile, code);

        File byteCodeFile = new File("/home/max/github/apply/target/classes");

        CustomJavaCompiler customJavaCompiler = new CustomJavaCompiler();
        customJavaCompiler.compile(javaFile, byteCodeFile);
    }

    private void writeFile(File file, String data) throws Exception
    {
        if (file.exists() || file.createNewFile())
        {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        }
    }
}