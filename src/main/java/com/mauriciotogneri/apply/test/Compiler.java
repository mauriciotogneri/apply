package com.mauriciotogneri.apply.test;

import java.io.IOException;
import java.util.Arrays;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class Compiler
{
    public static void main(String[] args) throws IOException
    {
        String filePath = "src/com/mauriciotogneri/apply/Test.java";
        String outputPath = "./output";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(filePath);
        CompilationTask task = compiler.getTask(null, fileManager, diagnostics, Arrays.asList("-d", outputPath), null, compilationUnits);
        task.call();
        fileManager.close();

        for (final Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics())
        {
            System.err.format("%s, line %d in %s", diagnostic.getMessage(null), diagnostic.getLineNumber(), diagnostic.getSource().getName());
        }
    }
}