package com.mauriciotogneri.apply.experiment;

import java.util.Optional;

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
            return Optional.of(new Num(n.doubleValue() * 2));
        }
    };

    public static Optional<Number> optionExample(Number n)
    {
        return optionExample.apply(n);
    }

    private static Function1<Optional<Number>, Number> optionExample2 = o -> {
        if (o.isPresent())
        {
            return new Num(o.get().doubleValue() * 2);
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
        if (limit.doubleValue() < 0)
        {
            return Optional.empty();
        }
        else if (limit.doubleValue() == 0)
        {
            return Optional.of(new List());
        }
        else if (limit.doubleValue() == 1)
        {
            return Optional.of(new List(new Num(1)));
        }
        else if (limit.doubleValue() == 2)
        {
            return Optional.of(new List(new Num(1), new Num(1)));
        }
        else
        {
            return Optional.of(Experiment.fibo.apply(new Num(2), limit, new List(new Num(1), new Num(1))));
        }
    };

    private static Optional<List<Number>> fibonacci(Number limit)
    {
        return fibonacci.apply(limit);
    }

    private static Function3<Number, Number, List<Number>, List<Number>> fibo = (index, limit, list) -> {
        if (index.doubleValue() >= limit.doubleValue())
        {
            return list;
        }
        else
        {
            Number first = list.element(new Num(index.doubleValue() - 1));
            Number second = list.element(new Num(index.doubleValue() - 2));
            Number sum = new Num(first.doubleValue() + second.doubleValue());

            return Experiment.fibo.apply(new Num(index.doubleValue() + 1), limit, list.appendLast(sum));
        }
    };

    private static List<Number> fibo(Number index, Number limit, List<Number> list)
    {
        return fibo.apply(index, limit, list);
    }

    public interface Function1<A, B>
    {
        B apply(A a);
    }

    public interface Function3<A, B, C, D>
    {
        D apply(A a, B b, C c);
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
        Optional<List<Number>> result = fibonacci(new Num(10));
        System.out.println(result);
    }
}