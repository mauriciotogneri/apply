package com.mauriciotogneri.apply.compiler.frontend.lexical;

public class DefaultCursor implements Position, Cursor
{
    private final int line;
    private final int column;

    public DefaultCursor(int line, int column)
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
    public Cursor advance(char character)
    {
        if (character == '\n')
        {
            return new DefaultCursor(line + 1, 1);
        }
        else if (character == '\t')
        {
            return new DefaultCursor(line, column + 4);
        }
        else
        {
            return new DefaultCursor(line, column + 1);
        }
    }
}