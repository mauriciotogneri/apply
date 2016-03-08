package com.mauriciotogneri.apply;

import com.mauriciotogneri.apply.compiler.lexical.CharStream;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CharStreamTest
{
    @Test
    public void fromFile() throws IOException
    {
        File file = new File("src/test/resources/sample.ply");
        CharStream charStream = new CharStream(file);

        assertEquals(charStream.get(), 'f');
        assertEquals(charStream.get(), '(');
        assertEquals(charStream.get(), '3');
        assertEquals(charStream.get(), '+');
        assertEquals(charStream.get(), '4');
        assertEquals(charStream.get(), ',');
        assertEquals(charStream.get(), '5');
        assertEquals(charStream.get(), ')');
    }
}