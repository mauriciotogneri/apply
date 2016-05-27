package com.mauriciotogneri.apply.experiment;

import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function1;
import com.mauriciotogneri.apply.experiment.Runtime.Functions.Function2;

@SuppressWarnings("ALL")
public class Runtime
{
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
}