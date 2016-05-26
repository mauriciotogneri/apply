package com.mauriciotogneri.apply.experiment;

import java.util.Optional;

@SuppressWarnings("ALL")
public class StringOperations
{
    public static Boolean empty(String str)
    {
        return str.isEmpty();
    }

    public static Number length(String str)
    {
        return str.length();
    }

    public static String concat(String a, String b)
    {
        return a + b;
    }

    public static Optional<String> element(String str, Number index)
    {
        int position = index.intValue();

        if (position < str.length())
        {
            return Optional.of(String.valueOf(str.charAt(position)));
        }
        else
        {
            return Optional.empty();
        }
    }

    public static Boolean contains(String a, String b)
    {
        return a.contains(b);
    }

    public static Boolean startsWith(String a, String b)
    {
        return a.startsWith(b);
    }

    public static Boolean endsWith(String a, String b)
    {
        return a.endsWith(b);
    }

    public static String trim(String str)
    {
        return str.trim();
    }

    public static String toLowerCase(String str)
    {
        return str.toLowerCase();
    }

    public static String toUpperCase(String str)
    {
        return str.toUpperCase();
    }

    public static Boolean equal(String a, String b)
    {
        return a.equals(b);
    }
}