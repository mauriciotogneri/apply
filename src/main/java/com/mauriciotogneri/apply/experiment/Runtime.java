package com.mauriciotogneri.apply.experiment;

import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function1;
import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        public static Boolean and(Boolean a, Boolean b)
        {
            return a && b;
        }

        public static Boolean or(Boolean a, Boolean b)
        {
            return a || b;
        }

        public static Boolean not(Boolean a)
        {
            return !a;
        }

        public static Boolean equal(Boolean a, Boolean b)
        {
            return a.equals(b);
        }
    }

    // ======================================== STRING ========================================== \\

    public static class StringOperations
    {
        public static Boolean empty(String a)
        {
            return a.isEmpty();
        }

        public static Number length(String a)
        {
            return a.length();
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

        public static String trim(String a)
        {
            return a.trim();
        }

        public static String toLowerCase(String a)
        {
            return a.toLowerCase();
        }

        public static String toUpperCase(String a)
        {
            return a.toUpperCase();
        }

        public static Boolean equal(String a, String b)
        {
            return a.equals(b);
        }
    }

    // ======================================== NUMBER ========================================== \\

    public static class NumberOperations
    {
        public static Number add(Number a, Number b)
        {
            return normalize(a.doubleValue() + b.doubleValue());
        }

        public static Number sub(Number a, Number b)
        {
            return normalize(a.doubleValue() - b.doubleValue());
        }

        public static Number mul(Number a, Number b)
        {
            return normalize(a.doubleValue() * b.doubleValue());
        }

        public static Number div(Number a, Number b)
        {
            return normalize(a.doubleValue() / b.doubleValue());
        }

        public static Number mod(Number a, Number b)
        {
            return normalize(a.doubleValue() % b.doubleValue());
        }

        public static Number pow(Number a, Number b)
        {
            return normalize(Math.pow(a.doubleValue(), b.doubleValue()));
        }

        public static Boolean less(Number a, Number b)
        {
            return a.doubleValue() < b.doubleValue();
        }

        public static Boolean lessEqual(Number a, Number b)
        {
            return a.doubleValue() <= b.doubleValue();
        }

        public static Boolean greater(Number a, Number b)
        {
            return a.doubleValue() > b.doubleValue();
        }

        public static Boolean greaterEqual(Number a, Number b)
        {
            return a.doubleValue() >= b.doubleValue();
        }

        public static Boolean equal(Number a, Number b)
        {
            return Double.compare(a.doubleValue(), b.doubleValue()) == 0;
        }

        public static Number toInt(Number a)
        {
            return a.intValue();
        }

        public static Number toLong(Number a)
        {
            return a.longValue();
        }

        public static Number toFloat(Number a)
        {
            return a.floatValue();
        }

        public static Number toDouble(Number a)
        {
            return a.doubleValue();
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

    // ========================================== LIST ========================================== \\

    public static class ListOperations
    {
        public static <T> List<T> listOf(T... values)
        {
            List<T> result = new ArrayList<>();
            Collections.addAll(result, values);

            return result;
        }

        public static Boolean empty(List<?> a)
        {
            return a.isEmpty();
        }

        public static Number length(List<?> a)
        {
            return a.size();
        }

        public static <T> Optional<T> element(List<T> list, Number index)
        {
            int position = index.intValue();

            if ((position >= 0) && (position < list.size()))
            {
                return Optional.of(list.get(position));
            }
            else
            {
                return Optional.empty();
            }
        }

        public static <T> List<T> appendFirst(List<T> list, T element)
        {
            List<T> result = listOf(element);
            result.addAll(list);

            return result;
        }

        public static <T> List<T> appendLast(List<T> list, T element)
        {
            List<T> result = listOf();
            result.addAll(list);
            result.add(element);

            return result;
        }

        public static <T> List<T> concat(List<T> list1, List<T> list2)
        {
            List<T> result = listOf();
            result.addAll(list1);
            result.addAll(list2);

            return result;
        }

        public static <T> List<T> reverse(List<T> a)
        {
            List<T> result = listOf();

            for (T element : a)
            {
                result.add(0, element);
            }

            return result;
        }

        public static <T> Optional<T> head(List<T> a)
        {
            if (a.isEmpty())
            {
                return Optional.empty();
            }
            else
            {
                return Optional.of(a.get(0));
            }
        }

        public static <T> Optional<T> last(List<T> a)
        {
            if (a.isEmpty())
            {
                return Optional.empty();
            }
            else
            {
                return Optional.of(a.get(a.size() - 1));
            }
        }

        public static <T> Optional<List<T>> init(List<T> a)
        {
            if (a.size() <= 1)
            {
                return Optional.empty();
            }
            else
            {
                List<T> result = listOf();
                result.addAll(a);
                result.remove(result.size() - 1);

                return Optional.of(result);
            }
        }

        public static <T> Optional<List<T>> tail(List<T> a)
        {
            if (a.size() <= 1)
            {
                return Optional.empty();
            }
            else
            {
                List<T> result = listOf();
                result.addAll(a);
                result.remove(0);

                return Optional.of(result);
            }
        }

        public static <A, B> List<B> map(Function1<A, B> function, List<A> list)
        {
            List<B> result = listOf();

            for (A element : list)
            {
                result.add(function.apply(element));
            }

            return result;
        }

        public static <A> List<A> filter(Function1<A, Boolean> function, List<A> list)
        {
            List<A> result = listOf();

            for (A element : list)
            {
                if (function.apply(element))
                {
                    result.add(element);
                }
            }

            return result;
        }

        public static <A> Boolean any(Function1<A, Boolean> function, List<A> list)
        {
            for (A element : list)
            {
                if (function.apply(element))
                {
                    return true;
                }
            }

            return false;
        }

        public static <A> Boolean all(Function1<A, Boolean> function, List<A> list)
        {
            for (A element : list)
            {
                if (!function.apply(element))
                {
                    return false;
                }
            }

            return true;
        }

        public static <A> Optional<A> find(Function1<A, Boolean> function, List<A> list)
        {
            for (A element : list)
            {
                if (function.apply(element))
                {
                    return Optional.of(element);
                }
            }

            return Optional.empty();
        }

        public static <A> List<A> take(Number number, List<A> list)
        {
            List<A> result = listOf();
            int size = list.size();
            int limit = number.intValue();

            for (int i = 0; (i < size) && (i < limit); i++)
            {
                result.add(list.get(i));
            }

            return result;
        }

        public static <A> List<A> drop(Number number, List<A> list)
        {
            List<A> result = listOf();
            int size = list.size();
            int start = number.intValue();

            if (start < 0)
            {
                start = 0;
            }

            for (int i = start; i < size; i++)
            {
                result.add(list.get(i));
            }

            return result;
        }

        public static <A> String join(String separator, List<A> list)
        {
            StringBuilder builder = new StringBuilder();

            for (A element : list)
            {
                if (builder.length() != 0)
                {
                    builder.append(separator);
                }

                builder.append(AnyOperations.toString(element));
            }

            return builder.toString();
        }

        public static <A, B> B foldr(Function2<A, B, B> function, B initial, List<A> list)
        {
            if (list.isEmpty())
            {
                return initial;
            }
            else
            {
                B result = initial;
                List<A> reverseList = reverse(list);

                for (A element : reverseList)
                {
                    result = function.apply(element, result);
                }

                return result;
            }
        }

        public static <A, B> B foldl(Function2<B, A, B> function, B initial, List<A> list)
        {
            if (list.isEmpty())
            {
                return initial;
            }
            else
            {
                B result = initial;

                for (A element : list)
                {
                    result = function.apply(result, element);
                }

                return result;
            }
        }

        // TODO
        // max
        // min
        // abs
        // cos
        // sin
        // ceil
        // floor
        // sqrt
        // round
        // log

        // TODO
        // takeWhile
        // dropWhile
        // sort (a -> b) -> [a] -> [a]
        // zip xs [0..]

        public static Boolean equal(List<?> a, List<?> b)
        {
            int size1 = a.size();
            int size2 = b.size();

            if (size1 == size2)
            {
                for (int i = 0; i < size1; i++)
                {
                    if (AnyOperations.notEqual(a.get(i), b.get(i)))
                    {
                        return false;
                    }
                }

                return true;
            }

            return false;
        }

        // TODO: for testing purposes
        public static String toString(List<?> list)
        {
            StringBuilder builder = new StringBuilder();
            builder.append("[");

            int size = list.size();

            for (int i = 0; i < size; i++)
            {
                if (i != 0)
                {
                    builder.append(", ");
                }

                builder.append(AnyOperations.toString(list.get(i)));
            }

            builder.append("]");

            return builder.toString();
        }
    }

    // ========================================== ANY =========================================== \\

    public static class AnyOperations
    {
        public static Boolean equal(Object a, Object b)
        {
            if ((a instanceof Number) && (b instanceof Number))
            {
                return NumberOperations.equal(Number.class.cast(a), Number.class.cast(b));
            }
            else if ((a instanceof Boolean) && (b instanceof Boolean))
            {
                return BooleanOperations.equal(Boolean.class.cast(a), Boolean.class.cast(b));
            }
            else if ((a instanceof String) && (b instanceof String))
            {
                return StringOperations.equal(String.class.cast(a), String.class.cast(b));
            }
            else if ((a instanceof List) && (b instanceof List))
            {
                return ListOperations.equal(List.class.cast(a), List.class.cast(b));
            }
            else
            {
                throw new RuntimeException(String.format("Incompatible types: %s and %s", a.getClass(), b.getClass()));
            }
        }

        public static Boolean notEqual(Object a, Object b)
        {
            return !equal(a, b);
        }

        public static String toString(Object obj)
        {
            if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String))
            {
                return obj.toString();
            }
            else if (obj instanceof List)
            {
                return ListOperations.toString(List.class.cast(obj));
            }
            else
            {
                throw new RuntimeException(String.format("Invalid type: %s", obj.getClass()));
            }
        }
    }
}