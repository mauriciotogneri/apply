package com.mauriciotogneri.apply.experiment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mauriciotogneri.apply.experiment.Runtime.AnyOperations.equal;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.any;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.appendLast;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.drop;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.element;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.equal;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.filter;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.find;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.join;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.listOf;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.map;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.add;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.greaterEqual;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.less;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.mul;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.sub;

@SuppressWarnings("ALL")
public class Experiment
{
    public static Optional<Number> optionExample(Number n)
    {
        if (n.equals(0))
        {
            return Optional.empty();
        }
        else
        {
            return Optional.of(mul(n, 2));
        }
    }

    public static Number optionExample2(Optional<Number> o)
    {
        if (o.isPresent())
        {
            return mul(o.get(), 2);
        }
        else
        {
            return -1;
        }
    }

    private static Optional<List<Number>> fibonacci(Number limit)
    {
        if (less(limit, 0))
        {
            return Optional.empty();
        }
        else if (equal(limit, 0))
        {
            return Optional.of(listOf());
        }
        else if (equal(limit, 1))
        {
            return Optional.of(listOf(1));
        }
        else if (equal(limit, 2))
        {
            return Optional.of(listOf(1, 1));
        }
        else
        {
            return Optional.of(fibo(2, limit, listOf(1, 1)));
        }
    }

    private static List<Number> fibo(Number index, Number limit, List<Number> list)
    {
        if (greaterEqual(index, limit))
        {
            return list;
        }
        else
        {
            Optional<Number> first = element(list, sub(index, 1));
            Optional<Number> second = element(list, sub(index, 2));
            Number sum = add(first.get(), second.get());

            return fibo(add(index, 1), limit, appendLast(list, sum));
        }
    }

    private static Number duplicate(Number n)
    {
        return mul(n, 2);
    }

    public class Person
    {
        public final String name;
        public final Number age;
        public final Number weight;

        public Person(String name, Number age, Number weight)
        {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
    }

    public static void main(String[] args)
    {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);

        List<Double> b = new ArrayList<>();
        b.add(1d);
        b.add(2d);
        b.add(3d);

        System.out.println(equal(a, b));

        Optional<List<Number>> result = fibonacci(10);
        System.out.println(result.get());

        System.out.println(map(Experiment::duplicate, result.get()));

        System.out.println(filter(x -> x > 5, listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        System.out.println(any(x -> x > 5, listOf(1, 2, 3, 4, 5)));

        System.out.println(find(x -> x > 5, listOf(1, 2, 3, 4, 5, 9)));

        System.out.println(join(",", listOf(1, 2, 3, 4, 5)));

        System.out.println(drop(-1, listOf(1, 2, 3)));
    }
}