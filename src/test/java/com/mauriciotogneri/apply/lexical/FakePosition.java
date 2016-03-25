package com.mauriciotogneri.apply.lexical;

import com.mauriciotogneri.apply.compiler.lexical.Position;

public class FakePosition implements Position
{
    private final int line;
    private final int column;

    public FakePosition(int line, int column)
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
}