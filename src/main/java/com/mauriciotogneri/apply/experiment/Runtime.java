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

    // ======================================== STRING ========================================== \\

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

    // ======================================== NUMBER ========================================== \\

    public static class NumberOperations
    {
        public static Function2<Number, Number, Number> $add = (a, b) -> normalize(a.doubleValue() + b.doubleValue());

        public static Number $add(Number a, Number b)
        {
            return $add.apply(a, b);
        }

        public static Function2<Number, Number, Number> $sub = (a, b) -> normalize(a.doubleValue() - b.doubleValue());

        public static Number $sub(Number a, Number b)
        {
            return $sub.apply(a, b);
        }

        public static Function2<Number, Number, Number> $mul = (a, b) -> normalize(a.doubleValue() * b.doubleValue());

        public static Number $mul(Number a, Number b)
        {
            return $mul.apply(a, b);
        }

        public static Function2<Number, Number, Number> $div = (a, b) -> normalize(a.doubleValue() / b.doubleValue());

        public static Number $div(Number a, Number b)
        {
            return $div.apply(a, b);
        }

        public static Function2<Number, Number, Number> $mod = (a, b) -> normalize(a.doubleValue() % b.doubleValue());

        public static Number $mod(Number a, Number b)
        {
            return $mod.apply(a, b);
        }

        public static Function2<Number, Number, Number> $pow = (a, b) -> normalize(Math.pow(a.doubleValue(), b.doubleValue()));

        public static Number $pow(Number a, Number b)
        {
            return $pow.apply(a, b);
        }

        public static Function2<Number, Number, Boolean> $less = (a, b) -> a.doubleValue() < b.doubleValue();

        public static Boolean $less(Number a, Number b)
        {
            return $less.apply(a, b);
        }

        public static Function2<Number, Number, Boolean> $lessEqual = (a, b) -> a.doubleValue() <= b.doubleValue();

        public static Boolean $lessEqual(Number a, Number b)
        {
            return $lessEqual.apply(a, b);
        }

        public static Function2<Number, Number, Boolean> $greater = (a, b) -> a.doubleValue() > b.doubleValue();

        public static Boolean $greater(Number a, Number b)
        {
            return $greater.apply(a, b);
        }

        public static Function2<Number, Number, Boolean> $greaterEqual = (a, b) -> a.doubleValue() >= b.doubleValue();

        public static Boolean $greaterEqual(Number a, Number b)
        {
            return $greaterEqual.apply(a, b);
        }

        public static Function2<Number, Number, Boolean> $equal = (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()) == 0;

        public static Boolean $equal(Number a, Number b)
        {
            return $equal.apply(a, b);
        }

        private static Number normalize(Number n)
        {
            if (Double.compare(n.doubleValue(), n.intValue()) == 0)
            {
                return n.longValue();
            }
            else
            {
                return n.doubleValue();
            }
        }
    }
}