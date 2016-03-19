package com.mauriciotogneri.apply.compiler.frontend.lexical;

import com.mauriciotogneri.apply.compiler.types.CharacterType;
import com.mauriciotogneri.apply.compiler.types.TokenType;
import com.mauriciotogneri.apply.exceptions.LexicalException;

public class Character implements Position
{
    private final CharacterType type;
    private final Position position;

    public Character(CharacterType type, Position position)
    {
        this.type = type;
        this.position = position;
    }

    public boolean delimiter()
    {
        return (type == CharacterType.SPACE) || //
                (type == CharacterType.TAB) || //
                (type == CharacterType.CARRIAGE_RETURN) || //
                (type == CharacterType.NEW_LINE);
    }

    public boolean digit()
    {
        return (type == CharacterType.NUMBER_0) || //
                (type == CharacterType.NUMBER_1) || //
                (type == CharacterType.NUMBER_2) || //
                (type == CharacterType.NUMBER_3) || //
                (type == CharacterType.NUMBER_4) || //
                (type == CharacterType.NUMBER_5) || //
                (type == CharacterType.NUMBER_6) || //
                (type == CharacterType.NUMBER_7) || //
                (type == CharacterType.NUMBER_8) || //
                (type == CharacterType.NUMBER_9);
    }

    private boolean newLine()
    {
        return (type == CharacterType.CARRIAGE_RETURN) || //
                (type == CharacterType.NEW_LINE);
    }

    public boolean letter()
    {
        return (lowercaseLetter() || uppercaseLetter());
    }

    private boolean uppercaseLetter()
    {
        return (type == CharacterType.A) || //
                (type == CharacterType.B) || //
                (type == CharacterType.C) || //
                (type == CharacterType.D) || //
                (type == CharacterType.E) || //
                (type == CharacterType.F) || //
                (type == CharacterType.G) || //
                (type == CharacterType.H) || //
                (type == CharacterType.I) || //
                (type == CharacterType.J) || //
                (type == CharacterType.K) || //
                (type == CharacterType.L) || //
                (type == CharacterType.M) || //
                (type == CharacterType.N) || //
                (type == CharacterType.O) || //
                (type == CharacterType.P) || //
                (type == CharacterType.Q) || //
                (type == CharacterType.R) || //
                (type == CharacterType.S) || //
                (type == CharacterType.T) || //
                (type == CharacterType.U) || //
                (type == CharacterType.V) || //
                (type == CharacterType.W) || //
                (type == CharacterType.X) || //
                (type == CharacterType.Y) || //
                (type == CharacterType.Z);
    }

    private boolean lowercaseLetter()
    {
        return (type == CharacterType.a) || //
                (type == CharacterType.b) || //
                (type == CharacterType.c) || //
                (type == CharacterType.d) || //
                (type == CharacterType.e) || //
                (type == CharacterType.f) || //
                (type == CharacterType.g) || //
                (type == CharacterType.h) || //
                (type == CharacterType.i) || //
                (type == CharacterType.j) || //
                (type == CharacterType.k) || //
                (type == CharacterType.l) || //
                (type == CharacterType.m) || //
                (type == CharacterType.n) || //
                (type == CharacterType.o) || //
                (type == CharacterType.p) || //
                (type == CharacterType.q) || //
                (type == CharacterType.r) || //
                (type == CharacterType.s) || //
                (type == CharacterType.t) || //
                (type == CharacterType.u) || //
                (type == CharacterType.v) || //
                (type == CharacterType.w) || //
                (type == CharacterType.x) || //
                (type == CharacterType.y) || //
                (type == CharacterType.z);
    }

    public TokenType delimiterType()
    {
        if (type == CharacterType.SPACE)
        {
            return TokenType.SPACE;
        }
        else if (type == CharacterType.TAB)
        {
            return TokenType.TAB;
        }
        else if (newLine())
        {
            return TokenType.NEW_LINE;
        }

        throw new LexicalException(this);
    }

    public TokenType operatorType()
    {
        if (type == CharacterType.STAR)
        {
            return TokenType.ARITHMETIC_MULTIPLICATION;
        }
        else if (type == CharacterType.SLASH)
        {
            return TokenType.ARITHMETIC_DIVISION;
        }
        else if (type == CharacterType.CARET)
        {
            return TokenType.ARITHMETIC_POWER;
        }
        else if (type == CharacterType.PERCENT)
        {
            return TokenType.ARITHMETIC_MODULE;
        }
        else if (type == CharacterType.EQUAL)
        {
            return TokenType.LOGIC_EQUAL;
        }
        else if (type == CharacterType.AMPERSAND)
        {
            return TokenType.LOGIC_AND;
        }
        else if (type == CharacterType.VERTICAL_BAR)
        {
            return TokenType.LOGIC_OR;
        }
        else if (type == CharacterType.DOLLAR)
        {
            return TokenType.IMPORT;
        }
        else if (type == CharacterType.AT)
        {
            return TokenType.ARRAY_INDEX;
        }
        else if (type == CharacterType.TILDE)
        {
            return TokenType.ARRAY_REMOVE;
        }
        else if (type == CharacterType.SHARP)
        {
            return TokenType.ARRAY_LENGTH;
        }
        else if (type == CharacterType.OPEN_BRACKETS)
        {
            return TokenType.LIST_OPEN;
        }
        else if (type == CharacterType.CLOSE_BRACKETS)
        {
            return TokenType.LIST_CLOSE;
        }
        else if ((type == CharacterType.DOT) || (type == CharacterType.COLON))
        {
            return TokenType.BOOLEAN;
        }
        else if (type == CharacterType.BACK_SLASH)
        {
            return TokenType.ANONYMOUS_FUNCTION;
        }

        throw new LexicalException(this);
    }

    @Override
    public int line()
    {
        return position.line();
    }

    @Override
    public int column()
    {
        return position.column();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        else if ((o == null) || (getClass() != o.getClass()))
        {
            return false;
        }

        Character character = (Character) o;

        return (type == character.type) && position.equals(character.position);
    }

    @Override
    public String toString()
    {
        if (type == CharacterType.TAB)
        {
            return "\\t";
        }
        else if (type == CharacterType.CARRIAGE_RETURN)
        {
            return "\\r";
        }
        else if (type == CharacterType.NEW_LINE)
        {
            return "\\n";
        }
        else
        {
            return type.toString();
        }
    }
}