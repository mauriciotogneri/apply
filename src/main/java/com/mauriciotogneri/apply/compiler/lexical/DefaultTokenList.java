package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.types.TokenType;
import com.mauriciotogneri.apply.exceptions.lexical.InvalidTokenException;

import java.util.ArrayList;
import java.util.List;

public class DefaultTokenList implements TokenList
{
    private final CharacterList characters;

    public DefaultTokenList(CharacterList characters)
    {
        this.characters = characters;
    }

    @Override
    public List<Token> tokens() throws Exception
    {
        List<Token> tokens = new ArrayList<>();
        List<Character> characters = this.characters.characters();

        CharacterBuffer characterBuffer = new CharacterBuffer();

        for (Character character : characters)
        {
            characterBuffer.add(character);
            characterBuffer.check(tokens);
        }

        if (!characterBuffer.isEmpty())
        {
            characterBuffer.checkRemaining(tokens);
        }

        return tokens;
    }

    private static class CharacterBuffer extends ArrayList<Character>
    {
        public void check(List<Token> tokens)
        {
            if (!matchesPattern())
            {
                if (size() > 1)
                {
                    TokenType tokenType = tokenType();
                    Lexeme lexeme = new DefaultLexeme(content(1), get(0));

                    tokens.add(new DefaultToken(tokenType, lexeme));

                    Character lastCharacter = get(size() - 1);
                    clear();
                    add(lastCharacter);
                }
                else
                {
                    throw new InvalidTokenException(null); // TODO
                }
            }
        }

        public void checkRemaining(List<Token> tokens)
        {
            if (matchesPattern())
            {
                TokenType tokenType = tokenType();
                Lexeme lexeme = new DefaultLexeme(content(0), get(0));

                tokens.add(new DefaultToken(tokenType, lexeme));
            }
            else
            {
                throw new InvalidTokenException(null); // TODO
            }
        }

        private boolean matchesPattern()
        {
            String content = content(0);

            for (TokenType tokenType : TokenType.values())
            {
                if (content.matches(tokenType.pattern()))
                {
                    return true;
                }
            }

            return false;
        }

        private TokenType tokenType()
        {
            String content = content(1);

            for (TokenType tokenType : TokenType.values())
            {
                if (content.matches(tokenType.pattern()))
                {
                    return tokenType;
                }
            }

            throw new InvalidTokenException(null); // TODO
        }

        private String content(int remove)
        {
            StringBuilder builder = new StringBuilder();

            int limit = size() - remove;

            for (int i = 0; i < limit; i++)
            {
                Character character = get(i);

                builder.append(character.toString());
            }

            return builder.toString();
        }
    }
}