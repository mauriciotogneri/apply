package com.mauriciotogneri.apply.compiler.lexical;

public class Cursor
{
    private final int line;
    private final int column;

    public Cursor(int line, int column)
    {
        this.line = line;
        this.column = column;
    }

    public Cursor advance(int chars)
    {
        return new Cursor(line, column + chars);
    }

    public Cursor newLine()
    {
        return new Cursor(line + 1, 0);
    }

    public Cursor tab()
    {
        return new Cursor(line, column + 3);
    }

    public Cursor space()
    {
        return new Cursor(line, column + 1);
    }
}