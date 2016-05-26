package com.mauriciotogneri.apply.experiment;

import com.mauriciotogneri.apply.experiment.Functions.Function1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
public class ListOperations
{
    public static <T> List<T> listOf(T... values)
    {
        List<T> result = new ArrayList<>();
        Collections.addAll(result, values);

        return result;
    }

    public static Boolean empty(List<?> list)
    {
        return list.isEmpty();
    }

    public static Number length(List<?> list)
    {
        return list.size();
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

    public static <T> Optional<T> head(List<T> list)
    {
        if (list.isEmpty())
        {
            return Optional.empty();
        }
        else
        {
            return Optional.of(list.get(0));
        }
    }

    public static <T> Optional<T> last(List<T> list)
    {
        if (list.isEmpty())
        {
            return Optional.empty();
        }
        else
        {
            return Optional.of(list.get(list.size() - 1));
        }
    }

    public static <T> Optional<List<T>> init(List<T> list)
    {
        if (list.size() <= 1)
        {
            return Optional.empty();
        }
        else
        {
            List<T> result = listOf();
            result.addAll(list);
            result.remove(result.size() - 1);

            return Optional.of(result);
        }
    }

    public static <T> Optional<List<T>> tail(List<T> list)
    {
        if (list.size() <= 1)
        {
            return Optional.empty();
        }
        else
        {
            List<T> result = listOf();
            result.addAll(list);
            result.remove(0);

            return Optional.of(result);
        }
    }

    public static <A, B> List<B> map(List<A> list, Function1<A, B> function)
    {
        List<B> result = listOf();

        for (A element : list)
        {
            result.add(function.apply(element));
        }

        return result;
    }

    public static Boolean equal(List<?> a, List<?> b)
    {
        int size1 = a.size();
        int size2 = b.size();

        if (size1 == size2)
        {
            for (int i = 0; i < size1; i++)
            {
                if (Any.notEqual(a.get(i), b.get(i)))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

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

            builder.append(Any.toString(list.get(i)));
        }

        builder.append("]");

        return builder.toString();
    }

    // TODO
    // take
    // drop
    // reverse
    // filter
    // and
    // or
    // any
    // all
    // take n xs
    // empty xs
    // zip xs [0..]
    // foldl
    // foldr
}