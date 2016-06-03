package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Position;

public class Cursor implements Position
{
    private final int line;
    private final int column;

    public Cursor(int line, int column)
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

    public Cursor advance(char character)
    {
        if (character == '\n')
        {
            return new Cursor(line + 1, 1);
        }
        else if (character == '\t')
        {
            return new Cursor(line, column + 4);
        }
        else
        {
            return new Cursor(line, column + 1);
        }
    }
}