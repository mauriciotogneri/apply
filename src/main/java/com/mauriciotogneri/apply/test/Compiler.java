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

    public void compile(String sourceCode, String canonicalClassName) throws Exception
    {
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        List<JavaSourceFromString> sources = new LinkedList<>();
//        String className = calculateSimpleClassName(canonicalClassName);
//        sources.add(new JavaSourceFromString(className, sourceCode));
//
//        StringWriter sw = new StringWriter();
//        MemoryJavaFileManager fm = new MemoryJavaFileManager(compiler.getStandardFileManager(null, null, null));
//        JavaCompiler.CompilationTask task = compiler.getTask(sw, fm, null, null, null, sources);
//
//        Boolean compilationWasSuccessful = task.call();
//        if (compilationWasSuccessful)
//        {
//            ByteClassLoader byteClassLoader = new ByteClassLoader(new URL[0], classLoader, classesByteArraysMap(fm));
//
//            Class<?> klass = byteClassLoader.loadClass(canonicalClassName);
//            byteClassLoader.close();
//            return klass;
//        }
//        else
//        {
//            compilerErrorOutput = sw.toString();
//            return null;
//        }
    }
}