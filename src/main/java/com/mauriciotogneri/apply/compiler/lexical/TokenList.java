package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.types.TokenType;
import com.mauriciotogneri.apply.exceptions.lexical.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TokenList
{
    private final CharacterList characters;

    public TokenList(CharacterList characters)
    {
        this.characters = characters;
    }

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
        private void check(List<Token> tokens)
        {
            if (!matchesPattern() && (size() > 1))
            {
                Optional<Token> token = token(1);

                if (token.isPresent())
                {
                    tokens.add(token.get());

                    Character lastCharacter = get(size() - 1);
                    clear();
                    add(lastCharacter);
                }
                else
                {
                    throw new InvalidCharacterException(get(size() - 1));
                }
            }
        }

        private boolean matchesPattern()
        {
            return token(0).isPresent();
        }

        private void checkRemaining(List<Token> tokens)
        {
            if (matchesPattern())
            {
                Optional<Token> token = token(0);

                if (token.isPresent())
                {
                    tokens.add(token.get());
                }
                else
                {
                    throw new InvalidCharacterException(get(size() - 1));
                }
            }
            else
            {
                throw new InvalidCharacterException(get(0));
            }
        }

        private Optional<Token> token(int remove)
        {
            Lexeme lexeme = lexeme(remove);

            return TokenType.ofLexeme(lexeme);
        }

        private Lexeme lexeme(int remove)
        {
            StringBuilder builder = new StringBuilder();

            int limit = size() - remove;

            for (int i = 0; i < limit; i++)
            {
                Character character = get(i);

                builder.append(character.value());
            }

            return new Lexeme(builder.toString(), get(0));
        }
    }
}