package com.mauriciotogneri.apply.compiler.lexical;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CharStream implements CharProvider
{
    private final InputStream stream;

    public CharStream(InputStream stream)
    {
        this.stream = stream;
    }

    public CharStream(File file) throws FileNotFoundException
    {
        this(new FileInputStream(file));
    }

    public char get() throws IOException
    {
        return (char) stream.read();
    }
}