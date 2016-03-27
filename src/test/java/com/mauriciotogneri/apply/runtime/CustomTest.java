package com.mauriciotogneri.apply.runtime;

import com.mauriciotogneri.apply.test.types.Num;

import org.junit.Test;

import static com.mauriciotogneri.apply.test.CustomTyped.apply;
import static com.mauriciotogneri.apply.test.CustomTyped.duplicate;
import static com.mauriciotogneri.apply.test.CustomTyped.factorial;
import static com.mauriciotogneri.apply.test.CustomTyped.pi;
import static com.mauriciotogneri.apply.test.CustomTyped.triplicate;
import static org.junit.Assert.assertEquals;

public class CustomTest
{
    @Test
    public void tests()
    {
        assertEquals(pi.apply(), new Num(3.14));
        assertEquals(factorial.apply(new Num(5)), new Num(120));
        assertEquals(duplicate.apply(new Num(3)), new Num(6));
        assertEquals(triplicate.apply(new Num(3)), new Num(9));
        assertEquals(apply.apply(duplicate, new Num(3), new Num(4)), new Num(14));
    }
}