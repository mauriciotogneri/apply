package com.mauriciotogneri.apply.compiler.frontend.lexical;

public class FileCursor implements Position, Cursor
{
    private final int line;
    private final int column;

    public FileCursor(int line, int column)
    {
        this.line = line;
        this.column = column;
    }

    @Override
    public int line()
    {
        return line;
    }

    @Override
    public int column()
    {
        return column;
    }

    @Override
    public FileCursor advance(char character)
    {
        if (character == '\n')
        {
            return new FileCursor(line + 1, 1);
        }
        else if (character == '\t')
        {
            return new FileCursor(line, column + 4);
        }
        else
        {
            return new FileCursor(line, column + 1);
        }
    }
}