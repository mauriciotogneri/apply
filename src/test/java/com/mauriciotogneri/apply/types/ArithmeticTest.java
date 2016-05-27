package com.mauriciotogneri.apply.types;

import org.junit.Test;

import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.add;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.div;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.mod;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.mul;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.pow;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.sub;
import static org.junit.Assert.assertEquals;

public class ArithmeticTest
{
    @Test
    public void testAdd()
    {
        assertEquals(add(3, -3), 0L);
        assertEquals(add(3, 4), 7L);
        assertEquals(add(3, -4), -1L);
    }

    @Test
    public void testSub()
    {
        assertEquals(sub(3, 4), -1L);
        assertEquals(sub(4, 3), 1L);
        assertEquals(sub(3, 3), 0L);
    }

    @Test
    public void testMul()
    {
        assertEquals(mul(3, 4), 12L);
        assertEquals(mul(0, 4), 0L);
        assertEquals(mul(3, 0), 0L);
    }

    @Test
    public void testDiv()
    {
        assertEquals(div(3, 4), 0.75d);
        assertEquals(div(3, 3), 1L);
        assertEquals(div(0, 4), 0L);
    }

    @Test
    public void testMod()
    {
        assertEquals(mod(3, 4), 3L);
        assertEquals(mod(4, 4), 0L);
        assertEquals(mod(0, 4), 0L);
    }

    @Test
    public void testPow()
    {
        assertEquals(pow(3, 4), 81L);
        assertEquals(pow(3, 0), 1L);
        assertEquals(pow(0, 4), 0L);
        assertEquals(pow(9, 0.5), 3L);
    }
}