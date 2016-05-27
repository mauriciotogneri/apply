package com.mauriciotogneri.apply.experiment;

import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function1;
import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function2;
import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function3;

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
        public static Function2<Boolean, Boolean, Boolean> and = (a, b) -> a && b;

        public static Function2<Boolean, Boolean, Boolean> or = (a, b) -> a || b;

        public static Function1<Boolean, Boolean> not = a -> !a;

        public static Function2<Boolean, Boolean, Boolean> equal = (a, b) -> a.equals(b);

        public static Boolean and(Boolean a, Boolean b)
        {
            return and.apply(a, b);
        }

        public static Boolean or(Boolean a, Boolean b)
        {
            return or.apply(a, b);
        }

        public static Boolean not(Boolean a)
        {
            return not.apply(a);
        }

        public static Boolean equal(Boolean a, Boolean b)
        {
            return equal.apply(a, b);
        }
    }

    // ======================================== STRING ========================================== \\

    public static class StringOperations
    {
        public static Function1<String, Boolean> empty = a -> a.isEmpty();

        public static Function1<String, Number> length = a -> a.length();

        public static Function2<String, String, String> concat = (a, b) -> a + b;

        public static Function2<String, Number, Optional<String>> element = (str, index) -> {
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

        public static Function2<String, String, Boolean> contains = (a, b) -> a.contains(b);

        public static Function2<String, String, Boolean> startsWith = (a, b) -> a.startsWith(b);

        public static Function2<String, String, Boolean> endsWith = (a, b) -> a.endsWith(b);

        public static Function1<String, String> toLowerCase = a -> a.toLowerCase();

        public static Function1<String, String> toUpperCase = a -> a.toUpperCase();

        public static Function2<String, String, Boolean> equal = (a, b) -> a.equals(b);

        public static Boolean empty(String a)
        {
            return empty.apply(a);
        }

        public static Number length(String a)
        {
            return length.apply(a);
        }

        public static String concat(String a, String b)
        {
            return concat.apply(a, b);
        }

        public static Optional<String> element(String str, Number index)
        {
            return element.apply(str, index);
        }

        public static Boolean contains(String a, String b)
        {
            return contains.apply(a, b);
        }

        public static Boolean startsWith(String a, String b)
        {
            return startsWith.apply(a, b);
        }

        public static Boolean endsWith(String a, String b)
        {
            return endsWith.apply(a, b);
        }

        public static Function1<String, String> trim = a -> a.trim();

        public static String trim(String a)
        {
            return trim.apply(a);
        }

        public static String toLowerCase(String a)
        {
            return toLowerCase.apply(a);
        }

        public static String toUpperCase(String a)
        {
            return toUpperCase.apply(a);
        }

        public static Boolean equal(String a, String b)
        {
            return equal.apply(a, b);
        }
    }

    // ======================================== NUMBER ========================================== \\

    public static class NumberOperations
    {
        public static Function2<Number, Number, Number> add = (a, b) -> normalize(a.doubleValue() + b.doubleValue());

        public static Function2<Number, Number, Number> sub = (a, b) -> normalize(a.doubleValue() - b.doubleValue());

        public static Function2<Number, Number, Number> mul = (a, b) -> normalize(a.doubleValue() * b.doubleValue());

        public static Function2<Number, Number, Number> div = (a, b) -> normalize(a.doubleValue() / b.doubleValue());

        public static Function2<Number, Number, Number> mod = (a, b) -> normalize(a.doubleValue() % b.doubleValue());

        public static Function2<Number, Number, Number> pow = (a, b) -> normalize(Math.pow(a.doubleValue(), b.doubleValue()));

        public static Function2<Number, Number, Boolean> less = (a, b) -> a.doubleValue() < b.doubleValue();

        public static Function2<Number, Number, Boolean> lessEqual = (a, b) -> a.doubleValue() <= b.doubleValue();

        public static Function2<Number, Number, Boolean> greater = (a, b) -> a.doubleValue() > b.doubleValue();

        public static Function2<Number, Number, Boolean> greaterEqual = (a, b) -> a.doubleValue() >= b.doubleValue();

        public static Function2<Number, Number, Boolean> equal = (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()) == 0;

        public static Function1<Number, Number> toInt = a -> a.intValue();

        public static Function1<Number, Number> toLong = a -> a.longValue();

        public static Function1<Number, Number> toFloat = a -> a.floatValue();

        public static Function1<Number, Number> toDouble = a -> a.doubleValue();

        public static Number add(Number a, Number b)
        {
            return add.apply(a, b);
        }

        public static Number sub(Number a, Number b)
        {
            return sub.apply(a, b);
        }

        public static Number mul(Number a, Number b)
        {
            return mul.apply(a, b);
        }

        public static Number div(Number a, Number b)
        {
            return div.apply(a, b);
        }

        public static Number mod(Number a, Number b)
        {
            return mod.apply(a, b);
        }

        public static Number pow(Number a, Number b)
        {
            return pow.apply(a, b);
        }

        public static Boolean less(Number a, Number b)
        {
            return less.apply(a, b);
        }

        public static Boolean lessEqual(Number a, Number b)
        {
            return lessEqual.apply(a, b);
        }

        public static Boolean greater(Number a, Number b)
        {
            return greater.apply(a, b);
        }

        public static Boolean greaterEqual(Number a, Number b)
        {
            return greaterEqual.apply(a, b);
        }

        public static Boolean equal(Number a, Number b)
        {
            return equal.apply(a, b);
        }

        public static Number toInt(Number a)
        {
            return toInt.apply(a);
        }

        public static Number toLong(Number a)
        {
            return toLong.apply(a);
        }

        public static Number toFloat(Number a)
        {
            return toFloat.apply(a);
        }

        public static Number toDouble(Number a)
        {
            return toDouble.apply(a);
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
        public static Function1<List, Boolean> empty = a -> a.isEmpty();

        public static Function1<List, Number> length = a -> a.size();

        public static Function2<List, Number, Optional> element = (list, index) -> {
            int position = index.intValue();

            if ((position >= 0) && (position < list.size()))
            {
                return Optional.of(list.get(position));
            }
            else
            {
                return Optional.empty();
            }
        };

        public static Function2<List, Object, List> appendFirst = (list, element) -> {
            List result = listOf(element);
            result.addAll(list);

            return result;
        };

        public static Function2<List, Object, List> appendLast = (list, element) -> {
            List result = listOf();
            result.addAll(list);
            result.add(element);

            return result;
        };

        public static Function2<List, List, List> concat = (list1, list2) -> {
            List result = listOf();
            result.addAll(list1);
            result.addAll(list2);

            return result;
        };

        public static Function1<List, List> reverse = a -> {
            List result = listOf();

            for (Object element : a)
            {
                result.add(0, element);
            }

            return result;
        };

        public static Function1<List, Optional> head = a -> {
            if (a.isEmpty())
            {
                return Optional.empty();
            }
            else
            {
                return Optional.of(a.get(0));
            }
        };

        public static Function1<List, Optional> last = a -> {
            if (a.isEmpty())
            {
                return Optional.empty();
            }
            else
            {
                return Optional.of(a.get(a.size() - 1));
            }
        };

        public static Function1<List, Optional> init = a -> {
            if (a.size() <= 1)
            {
                return Optional.empty();
            }
            else
            {
                List result = listOf();
                result.addAll(a);
                result.remove(result.size() - 1);

                return Optional.of(result);
            }
        };

        public static Function1<List, Optional> tail = a -> {
            if (a.size() <= 1)
            {
                return Optional.empty();
            }
            else
            {
                List result = listOf();
                result.addAll(a);
                result.remove(0);

                return Optional.of(result);
            }
        };

        public static Function2<Function1, List, List> map = (function, list) -> {
            List result = listOf();

            for (Object element : list)
            {
                result.add(function.apply(element));
            }

            return result;
        };

        public static Function2<Function1<Object, Boolean>, List, List> filter = (function, list) -> {
            List result = listOf();

            for (Object element : list)
            {
                if (function.apply(element))
                {
                    result.add(element);
                }
            }

            return result;
        };

        public static Function3<Function2, Object, List, Object> foldr = (function, initial, list) -> {
            if (list.isEmpty())
            {
                return initial;
            }
            else
            {
                Object result = initial;
                List reverseList = reverse.apply(list);

                for (Object element : reverseList)
                {
                    result = function.apply(element, result);
                }

                return result;
            }
        };

        public static Function3<Function2, Object, List, Object> foldl = (function, initial, list) -> {
            if (list.isEmpty())
            {
                return initial;
            }
            else
            {
                Object result = initial;

                for (Object element : list)
                {
                    result = function.apply(result, element);
                }

                return result;
            }
        };

        public static Function2<List, List, Boolean> equal = (a, b) -> {
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
        };

        public static <T> List<T> listOf(T... values)
        {
            List<T> result = new ArrayList<>();
            Collections.addAll(result, values);

            return result;
        }

        public static Boolean empty(List a)
        {
            return empty.apply(a);
        }

        public static Number length(List a)
        {
            return length.apply(a);
        }

        public static <T> Optional<T> element(List<T> list, Number index)
        {
            return element.apply(list, index);
        }

        public static <T> List<T> appendFirst(List<T> list, T element)
        {
            return appendFirst.apply(list, element);
        }

        public static <T> List<T> appendLast(List<T> list, T element)
        {
            return appendLast.apply(list, element);
        }

        public static <T> List<T> concat(List<T> list1, List<T> list2)
        {
            return concat.apply(list1, list2);
        }

        public static <T> List<T> reverse(List<T> a)
        {
            return reverse.apply(a);
        }

        public static <T> Optional<T> head(List<T> a)
        {
            return head.apply(a);
        }

        public static <T> Optional<T> last(List<T> a)
        {
            return last.apply(a);
        }

        public static <T> Optional<List<T>> init(List<T> a)
        {
            return init.apply(a);
        }

        public static <T> Optional<List<T>> tail(List<T> a)
        {
            return tail.apply(a);
        }

        public static <A, B> List<B> map(Function1<A, B> function, List<A> list)
        {
            return map.apply(function, list);
        }

        public static <A> List<A> filter(Function1<A, Boolean> function, List<A> list)
        {
            return filter.apply((Function1<Object, Boolean>) function, list);
        }

        public static <A, B> B foldr(Function2<A, B, B> function, B initial, List<A> list)
        {
            return (B) foldr.apply(function, initial, list);
        }

        public static <A, B> B foldl(Function2<A, B, B> function, B initial, List<A> list)
        {
            return (B) foldl.apply(function, initial, list);
        }

        // TODO
        // take
        // drop
        // and
        // or
        // any
        // all
        // zip xs [0..]

        public static Boolean equal(List a, List b)
        {
            return equal.apply(a, b);
        }

        // TODO: for testing purposes
        public static String toString(List list)
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