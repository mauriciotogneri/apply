package com.mauriciotogneri.apply.compiler.frontend.lexical;

import java.io.File;
import java.io.RandomAccessFile;

public class DefaultCharacters implements Characters
{
    private final RandomAccessFile randomAccessFile;
    private Cursor cursor;

    public DefaultCharacters(File file) throws Exception
    {
        this.randomAccessFile = new RandomAccessFile(file, "r");
        this.cursor = new DefaultCursor(1, 1);
    }

    @Override
    public boolean empty() throws Exception
    {
        return randomAccessFile.getFilePointer() < randomAccessFile.length();
    }

    public Character next() throws Exception
    {
        Position position = cursor;
        char character = (char) randomAccessFile.readByte();
        this.cursor = cursor.advance(character);

        return new DefaultCharacter(character, position);
    }
}