package com.mauriciotogneri.apply.experiment;

@SuppressWarnings("ALL")
public class BooleanOperations
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

    //    public static Boolean equal(Boolean a, Boolean b)
    //    {
    //        return a == b;
    //    }
    //
    //    public static Boolean notEqual(Boolean a, Boolean b)
    //    {
    //        return a != b;
    //    }
}