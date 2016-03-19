package com.mauriciotogneri.apply.compiler.types;

import com.mauriciotogneri.apply.compiler.frontend.lexical.Position;
import com.mauriciotogneri.apply.exceptions.LexicalException;

public enum CharacterType
{
    TAB('\t'), // 9
    NEW_LINE('\n'), // 10
    CARRIAGE_RETURN('\r'), // 13
    SPACE(' '), // 32
    EXCLAMATION('!'), // 33
    DOUBLE_QUOTES('"'), // 34
    SHARP('#'), // 35
    DOLLAR('$'), // 36
    PERCENT('%'), // 37
    AMPERSAND('&'), // 38
    APOSTROPHE('\''), // 39
    OPEN_PARENTHESES('('), // 40
    CLOSE_PARENTHESES(')'), // 41
    STAR('*'), // 42
    PLUS('+'), // 43
    COMMA(','), // 44
    MINUS('-'), // 45
    DOT('.'), // 46
    SLASH('/'), // 47
    COLON(':'), // 58
    SEMICOLON(';'), // 59
    LESS('<'), // 60
    EQUAL('='), // 61
    GREATER('>'), // 62
    QUESTION('?'), // 63
    AT('@'), // 64
    OPEN_BRACKETS('['), // 91
    BACK_SLASH('\\'), // 92
    CLOSE_BRACKETS(']'), // 93
    CARET('^'), // 94
    UNDERSCORE('_'), // 95
    GRAVE_ACCENT('`'), // 96
    OPEN_BRACES('{'), // 123
    VERTICAL_BAR('|'), // 124
    CLOSE_BRACES('}'), // 125
    TILDE('~'), // 126

    NUMBER_0('0'), // 48
    NUMBER_1('1'), // 49
    NUMBER_2('2'), // 50
    NUMBER_3('3'), // 51
    NUMBER_4('4'), // 52
    NUMBER_5('5'), // 53
    NUMBER_6('6'), // 54
    NUMBER_7('7'), // 55
    NUMBER_8('8'), // 56
    NUMBER_9('9'), // 57

    A('A'), // 65
    B('B'), // 66
    C('C'), // 67
    D('D'), // 68
    E('E'), // 69
    F('F'), // 70
    G('G'), // 71
    H('H'), // 72
    I('I'), // 73
    J('J'), // 74
    K('K'), // 75
    L('L'), // 76
    M('M'), // 77
    N('N'), // 78
    O('O'), // 79
    P('P'), // 80
    Q('Q'), // 81
    R('R'), // 82
    S('S'), // 83
    T('T'), // 84
    U('U'), // 85
    V('V'), // 86
    W('W'), // 87
    X('X'), // 88
    Y('Y'), // 89
    Z('Z'), // 90

    a('a'), // 97
    b('b'), // 98
    c('c'), // 99
    d('d'), // 100
    e('e'), // 101
    f('f'), // 102
    g('g'), // 103
    h('h'), // 104
    i('i'), // 105
    j('j'), // 106
    k('k'), // 107
    l('l'), // 108
    m('m'), // 109
    n('n'), // 110
    o('o'), // 111
    p('p'), // 112
    q('q'), // 113
    r('r'), // 114
    s('s'), // 115
    t('t'), // 116
    u('u'), // 117
    v('v'), // 118
    w('w'), // 119
    x('x'), // 120
    y('y'), // 121
    z('z'); // 122

    private final Character character;

    CharacterType(Character character)
    {
        this.character = character;
    }

    @Override
    public String toString()
    {
        return character.toString();
    }

    public static CharacterType fromChar(Character value, Position position)
    {
        CharacterType[] types = CharacterType.values();

        for (CharacterType characterType : types)
        {
            if (characterType.character.equals(value))
            {
                return characterType;
            }
        }

        throw new LexicalException(value, position);
    }
}