package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Character;
import com.mauriciotogneri.apply.compiler.lexical.base.Position;
import com.mauriciotogneri.apply.compiler.types.TokenType;
import com.mauriciotogneri.apply.exceptions.lexical.InvalidCharacterException;

public class DefaultCharacter implements Character
{
    private final char character;
    private final Position position;

    private static final char TAB = '\t'; // 9
    private static final char NEW_LINE = '\n'; // 10
    private static final char CARRIAGE_RETURN = '\r'; // 13
    private static final char SPACE = ' '; // 32
    private static final char EXCLAMATION = '!'; // 33
    private static final char DOUBLE_QUOTES = '"'; // 34
    private static final char SHARP = '#'; // 35
    private static final char DOLLAR = '$'; // 36
    private static final char PERCENT = '%'; // 37
    private static final char AMPERSAND = '&'; // 38
    private static final char APOSTROPHE = '\''; // 39
    private static final char OPEN_PARENTHESES = '('; // 40
    private static final char CLOSE_PARENTHESES = ')'; // 41
    private static final char STAR = '*'; // 42
    private static final char PLUS = '+'; // 43
    private static final char COMMA = ','; // 44
    private static final char MINUS = '-'; // 45
    private static final char DOT = '.'; // 46
    private static final char SLASH = '/'; // 47
    private static final char COLON = ':'; // 58
    private static final char SEMICOLON = ';'; // 59
    private static final char LESS = '<'; // 60
    private static final char EQUAL = '='; // 61
    private static final char GREATER = '>'; // 62
    private static final char QUESTION = '?'; // 63
    private static final char AT = '@'; // 64
    private static final char OPEN_BRACKETS = '['; // 91
    private static final char BACK_SLASH = '\\'; // 92
    private static final char CLOSE_BRACKETS = ']'; // 93
    private static final char CARET = '^'; // 94
    private static final char UNDERSCORE = '_'; // 95
    private static final char GRAVE_ACCENT = '`'; // 96
    private static final char OPEN_BRACES = '{'; // 123
    private static final char VERTICAL_BAR = '|'; // 124
    private static final char CLOSE_BRACES = '}'; // 125
    private static final char TILDE = '~'; // 126

    private static final char DIGIT_0 = '0'; // 48
    private static final char DIGIT_1 = '1'; // 49
    private static final char DIGIT_2 = '2'; // 50
    private static final char DIGIT_3 = '3'; // 51
    private static final char DIGIT_4 = '4'; // 52
    private static final char DIGIT_5 = '5'; // 53
    private static final char DIGIT_6 = '6'; // 54
    private static final char DIGIT_7 = '7'; // 55
    private static final char DIGIT_8 = '8'; // 56
    private static final char DIGIT_9 = '9'; // 57

    private static final char A = 'A'; // 65
    private static final char B = 'B'; // 66
    private static final char C = 'C'; // 67
    private static final char D = 'D'; // 68
    private static final char E = 'E'; // 69
    private static final char F = 'F'; // 70
    private static final char G = 'G'; // 71
    private static final char H = 'H'; // 72
    private static final char I = 'I'; // 73
    private static final char J = 'J'; // 74
    private static final char K = 'K'; // 75
    private static final char L = 'L'; // 76
    private static final char M = 'M'; // 77
    private static final char N = 'N'; // 78
    private static final char O = 'O'; // 79
    private static final char P = 'P'; // 80
    private static final char Q = 'Q'; // 81
    private static final char R = 'R'; // 82
    private static final char S = 'S'; // 83
    private static final char T = 'T'; // 84
    private static final char U = 'U'; // 85
    private static final char V = 'V'; // 86
    private static final char W = 'W'; // 87
    private static final char X = 'X'; // 88
    private static final char Y = 'Y'; // 89
    private static final char Z = 'Z'; // 90

    private static final char a = 'a'; // 97
    private static final char b = 'b'; // 98
    private static final char c = 'c'; // 99
    private static final char d = 'd'; // 100
    private static final char e = 'e'; // 101
    private static final char f = 'f'; // 102
    private static final char g = 'g'; // 103
    private static final char h = 'h'; // 104
    private static final char i = 'i'; // 105
    private static final char j = 'j'; // 106
    private static final char k = 'k'; // 107
    private static final char l = 'l'; // 108
    private static final char m = 'm'; // 109
    private static final char n = 'n'; // 110
    private static final char o = 'o'; // 111
    private static final char p = 'p'; // 112
    private static final char q = 'q'; // 113
    private static final char r = 'r'; // 114
    private static final char s = 's'; // 115
    private static final char t = 't'; // 116
    private static final char u = 'u'; // 117
    private static final char v = 'v'; // 118
    private static final char w = 'w'; // 119
    private static final char x = 'x'; // 120
    private static final char y = 'y'; // 121
    private static final char z = 'z'; // 122

    public DefaultCharacter(char character, Position position)
    {
        this.character = character;
        this.position = position;
    }

    private boolean delimiter()
    {
        return (character == SPACE) || //
                (character == TAB) || //
                (character == CARRIAGE_RETURN) || //
                (character == NEW_LINE);
    }

    private boolean digit()
    {
        return (character == DIGIT_0) || //
                (character == DIGIT_1) || //
                (character == DIGIT_2) || //
                (character == DIGIT_3) || //
                (character == DIGIT_4) || //
                (character == DIGIT_5) || //
                (character == DIGIT_6) || //
                (character == DIGIT_7) || //
                (character == DIGIT_8) || //
                (character == DIGIT_9);
    }

    private boolean newLine()
    {
        return (character == CARRIAGE_RETURN) || //
                (character == NEW_LINE);
    }

    private boolean letter()
    {
        return (lowercaseLetter() || uppercaseLetter());
    }

    private boolean uppercaseLetter()
    {
        return (character == A) || //
                (character == B) || //
                (character == C) || //
                (character == D) || //
                (character == E) || //
                (character == F) || //
                (character == G) || //
                (character == H) || //
                (character == I) || //
                (character == J) || //
                (character == K) || //
                (character == L) || //
                (character == M) || //
                (character == N) || //
                (character == O) || //
                (character == P) || //
                (character == Q) || //
                (character == R) || //
                (character == S) || //
                (character == T) || //
                (character == U) || //
                (character == V) || //
                (character == W) || //
                (character == X) || //
                (character == Y) || //
                (character == Z);
    }

    private boolean lowercaseLetter()
    {
        return (character == a) || //
                (character == b) || //
                (character == c) || //
                (character == d) || //
                (character == e) || //
                (character == f) || //
                (character == g) || //
                (character == h) || //
                (character == i) || //
                (character == j) || //
                (character == k) || //
                (character == l) || //
                (character == m) || //
                (character == n) || //
                (character == o) || //
                (character == p) || //
                (character == q) || //
                (character == r) || //
                (character == s) || //
                (character == t) || //
                (character == u) || //
                (character == v) || //
                (character == w) || //
                (character == x) || //
                (character == y) || //
                (character == z);
    }

    public TokenType delimiterType()
    {
        if (character == SPACE)
        {
            return TokenType.SPACE;
        }
        else if (character == TAB)
        {
            return TokenType.TAB;
        }
        else if (newLine())
        {
            return TokenType.NEW_LINE;
        }

        throw new InvalidCharacterException(this);
    }

    public TokenType operatorType()
    {
        if (character == STAR)
        {
            return TokenType.ARITHMETIC_MULTIPLICATION;
        }
        else if (character == SLASH)
        {
            return TokenType.ARITHMETIC_DIVISION;
        }
        else if (character == CARET)
        {
            return TokenType.ARITHMETIC_POWER;
        }
        else if (character == PERCENT)
        {
            return TokenType.ARITHMETIC_MODULE;
        }
        else if (character == EQUAL)
        {
            return TokenType.LOGIC_EQUAL;
        }
        else if (character == AMPERSAND)
        {
            return TokenType.LOGIC_AND;
        }
        else if (character == VERTICAL_BAR)
        {
            return TokenType.LOGIC_OR;
        }
        else if (character == DOLLAR)
        {
            return TokenType.IMPORT;
        }
        else if (character == AT)
        {
            return TokenType.ARRAY_INDEX;
        }
        else if (character == TILDE)
        {
            return TokenType.ARRAY_REMOVE;
        }
        else if (character == SHARP)
        {
            return TokenType.ARRAY_LENGTH;
        }
        else if (character == OPEN_BRACKETS)
        {
            return TokenType.LIST_OPEN;
        }
        else if (character == CLOSE_BRACKETS)
        {
            return TokenType.LIST_CLOSE;
        }
        else if ((character == DOT) || (character == COLON))
        {
            return TokenType.BOOLEAN;
        }

        throw new InvalidCharacterException(this);
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
    public char value()
    {
        return character;
    }

    @Override
    public String toString()
    {
        if (character == TAB)
        {
            return "\\t";
        }
        else if (character == CARRIAGE_RETURN)
        {
            return "\\r";
        }
        else if (character == NEW_LINE)
        {
            return "\\n";
        }
        else
        {
            return String.valueOf(character);
        }
    }
}