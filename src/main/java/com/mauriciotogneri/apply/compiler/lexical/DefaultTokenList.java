package com.mauriciotogneri.apply.compiler.lexical;

import com.mauriciotogneri.apply.compiler.lexical.base.Character;
import com.mauriciotogneri.apply.compiler.lexical.base.CharacterList;
import com.mauriciotogneri.apply.compiler.lexical.base.Token;
import com.mauriciotogneri.apply.compiler.lexical.base.TokenList;
import com.mauriciotogneri.apply.compiler.types.TokenType;
import com.mauriciotogneri.apply.exceptions.lexical.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        private void check(List<Token> tokens)
        {
            if (!matchesPattern() && (size() > 1))
            {
                Optional<TokenType> tokenType = tokenType(1);

                if (tokenType.isPresent())
                {
                    tokens.add(
                            new DefaultToken(
                                    tokenType.get(),
                                    new DefaultLexeme(
                                            content(1),
                                            get(0)
                                    )
                            )
                    );

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
            return tokenType(0).isPresent();
        }

        private void checkRemaining(List<Token> tokens)
        {
            if (matchesPattern())
            {
                Optional<TokenType> tokenType = tokenType(0);

                if (tokenType.isPresent())
                {
                    tokens.add(
                            new DefaultToken(
                                    tokenType.get(),
                                    new DefaultLexeme(content(0), get(0))
                            )
                    );
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

        private Optional<TokenType> tokenType(int remove)
        {
            String content = content(remove);

            for (TokenType tokenType : TokenType.values())
            {
                if (content.matches(tokenType.pattern()))
                {
                    return Optional.of(tokenType);
                }
            }

            return Optional.empty();
        }

        private String content(int remove)
        {
            StringBuilder builder = new StringBuilder();

            int limit = size() - remove;

            for (int i = 0; i < limit; i++)
            {
                Character character = get(i);

                builder.append(character.value());
            }

            return builder.toString();
        }
    }
}