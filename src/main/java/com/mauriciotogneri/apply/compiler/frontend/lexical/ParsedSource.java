package com.mauriciotogneri.apply.compiler.frontend.lexical;

import java.io.File;
import java.io.RandomAccessFile;

public class ParsedSource implements Characters
{
    private final RandomAccessFile randomAccessFile;
    private Cursor cursor;

    public ParsedSource(File file) throws Exception
    {
        this.randomAccessFile = new RandomAccessFile(file, "r");
        this.cursor = new FileCursor(1, 1);
    }

    @Override
    public boolean empty() throws Exception
    {
        return randomAccessFile.getFilePointer() < randomAccessFile.length();
    }

    public ReadCharacter next() throws Exception
    {
        Position position = cursor;
        char character = (char) randomAccessFile.readByte();
        this.cursor = cursor.advance(character);

        return new ReadCharacter(character, position);
    }
}