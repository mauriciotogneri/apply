package com.mauriciotogneri.apply.experiment;

import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function1;
import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function2;

import java.util.Optional;

@SuppressWarnings("ALL")
public class Runtime
{
    // ======================================= FUNCTIONS ======================================== \\

    public static class Functions
    {
        public interface Function1<A, B>
        {
            B apply(A a);
        }

        public interface Function2<A, B, C>
        {
            C apply(A a, B b);
        }

        public interface Function3<A, B, C, D>
        {
            D apply(A a, B b, C c);
        }
    }

    // ======================================= BOOLEAN ========================================== \\

    public static class BooleanOperations
    {
        public static Function2<Boolean, Boolean, Boolean> $and = (a, b) -> a && b;

        public static Boolean $and(Boolean a, Boolean b)
        {
            return $and.apply(a, b);
        }

        public static Function2<Boolean, Boolean, Boolean> $or = (a, b) -> a || b;

        public static Boolean $or(Boolean a, Boolean b)
        {
            return $or.apply(a, b);
        }

        public static Function1<Boolean, Boolean> $not = a -> !a;

        public static Boolean $not(Boolean a)
        {
            return $not.apply(a);
        }

        public static Function2<Boolean, Boolean, Boolean> $equal = (a, b) -> a.equals(b);

        public static Boolean $equal(Boolean a, Boolean b)
        {
            return $equal.apply(a, b);
        }
    }

    // ====================================)=== STRING ========================================== \\

    public static class StringOperations
    {
        public static Function1<String, Boolean> $empty = a -> a.isEmpty();

        public static Boolean $empty(String a)
        {
            return $empty.apply(a);
        }

        public static Function1<String, Number> $length = a -> a.length();

        public static Number $length(String a)
        {
            return $length.apply(a);
        }

        public static Function2<String, String, String> $concat = (a, b) -> a + b;

        public static String $concat(String a, String b)
        {
            return $concat.apply(a, b);
        }

        public static Function2<String, Number, Optional<String>> $element = (str, index) -> {
            int position = index.intValue();

            if (position < str.length())
            {
                return Optional.of(String.valueOf(str.charAt(position)));
            }
            else
            {
                return Optional.empty();
            }
        };

        public static Optional<String> $element(String str, Number index)
        {
            return $element.apply(str, index);
        }

        public static Function2<String, String, Boolean> $contains = (a, b) -> a.contains(b);

        public static Boolean $contains(String a, String b)
        {
            return $contains.apply(a, b);
        }

        public static Function2<String, String, Boolean> $startsWith = (a, b) -> a.startsWith(b);

        public static Boolean $startsWith(String a, String b)
        {
            return $startsWith.apply(a, b);
        }

        public static Function2<String, String, Boolean> $endsWith = (a, b) -> a.endsWith(b);

        public static Boolean $endsWith(String a, String b)
        {
            return $endsWith.apply(a, b);
        }

        public static Function1<String, String> $trim = a -> a.trim();

        public static String $trim(String a)
        {
            return $trim.apply(a);
        }

        public static Function1<String, String> $toLowerCase = a -> a.toLowerCase();

        public static String $toLowerCase(String a)
        {
            return $toLowerCase.apply(a);
        }

        public static Function1<String, String> $toUpperCase = a -> a.toUpperCase();

        public static String $toUpperCase(String a)
        {
            return $toUpperCase.apply(a);
        }

        public static Function2<String, String, Boolean> $equal = (a, b) -> a.equals(b);

        public static Boolean $equal(String a, String b)
        {
            return $equal.apply(a, b);
        }
    }
}