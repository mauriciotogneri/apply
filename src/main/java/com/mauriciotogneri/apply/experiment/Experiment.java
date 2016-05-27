package com.mauriciotogneri.apply.experiment;


import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function1;
import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mauriciotogneri.apply.experiment.Any.equal;
import static com.mauriciotogneri.apply.experiment.ListOperations.appendLast;
import static com.mauriciotogneri.apply.experiment.ListOperations.element;
import static com.mauriciotogneri.apply.experiment.ListOperations.listOf;
import static com.mauriciotogneri.apply.experiment.ListOperations.map;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.$add;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.$greaterEqual;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.$less;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.$mul;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.$sub;

@SuppressWarnings("ALL")
public class Experiment
{
    private static Function1<Number, Optional<Number>> optionExample = n -> {
        if (n.equals(0))
        {
            return Optional.empty();
        }
        else
        {
            return Optional.of($mul(n, 2));
        }
    };

    public static Optional<Number> optionExample(Number n)
    {
        return optionExample.apply(n);
    }

    private static Function1<Optional<Number>, Number> optionExample2 = o -> {
        if (o.isPresent())
        {
            return $mul(o.get(), 2);
        }
        else
        {
            return -1;
        }
    };

    public static Number optionExample2(Optional<Number> o)
    {
        return optionExample2.apply(o);
    }

    private static Function1<Number, Optional<List<Number>>> fibonacci = limit -> {
        if ($less(limit, 0))
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
            return Optional.of(Experiment.fibo.apply(2, limit, listOf(1, 1)));
        }
    };

    private static Optional<List<Number>> fibonacci(Number limit)
    {
        return fibonacci.apply(limit);
    }

    private static Function3<Number, Number, List<Number>, List<Number>> fibo = (index, limit, list) -> {
        if ($greaterEqual(index, limit))
        {
            return list;
        }
        else
        {
            Optional<Number> first = element(list, $sub(index, 1));
            Optional<Number> second = element(list, $sub(index, 2));
            Number sum = $add(first.get(), second.get());

            return Experiment.fibo.apply($add(index, 1), limit, appendLast(list, sum));
        }
    };

    private static List<Number> fibo(Number index, Number limit, List<Number> list)
    {
        return fibo.apply(index, limit, list);
    }

    private static Function1<Number, Number> duplicate = n -> {
        return $mul(n, 2);
    };

    private static Number duplicate(Number n)
    {
        return duplicate.apply(n);
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

        System.out.println(map(result.get(), duplicate));
    }
}