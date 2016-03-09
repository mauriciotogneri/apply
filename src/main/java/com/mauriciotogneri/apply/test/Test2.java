package com.mauriciotogneri.apply.test;

public class Test2
{
    public static final $f0 pi = () -> 3.14f;

    public static final $f2 $add = (a, b) -> ((Float) a) + ((Float) b);
    public static final $f2 $sub = (a, b) -> ((Float) a) - ((Float) b);

    public static final $f1 duplicate = (a) -> ((Float) a) * 2;
    public static final $f1 triplicate = (a) -> ((Float) a) * 3;

    public static final $f3 apply = (f, a, b) -> (($f1) f).apply(((Float) a) + ((Float) b));

    public static final $f1 factorial = (n) -> {
        if ((Float) n == 0)
        {
            return 1f;
        }
        else
        {
            return ((Float) n) * (Float) Test2.factorial.apply(((Float) n) - 1);
        }
    };

    public static final $f2 map2 = (f, a) -> {
        Object[] o = (Object[]) a;

        if (o.length == 0)
        {
            return new Object[0];
        }
        else
        {
            //            Object first = a[0];
            //
            //            Object[] rest = new Object[a.length - 1];
            //            System.arraycopy(a, 1, rest, 0, rest.length);
            //            Object[] result = Test1.map2.apply(f, rest);
            //
            //            Object[] response = new Object[result.length + 1];
            //            System.arraycopy(result, 0, response, 1, result.length);
            //            response[0] = f.apply(first);

            return null;
        }
    };

    //    map(f, a) =
    //        ? (a = [],
    //            [],
    //            f(head(a)) + map(f, tail(a))
    //        )

    interface $f0
    {
        Object apply();
    }

    interface $f1
    {
        Object apply(Object a);
    }

    interface $f2
    {
        Object apply(Object a, Object b);
    }

    interface $f3
    {
        Object apply(Object a, Object b, Object c);
    }

    public static void main(String[] args)
    {
        System.out.println(pi.apply());
        System.out.println(factorial.apply(5f));
        System.out.println(apply.apply(duplicate, 3f, 4f));

        //Float[] array = map.apply(triplicate, new Float[] {1f, 2f, -3f});
        //System.out.println(Arrays.toString(array));
        //System.out.println(factorial.apply(4));
    }
}