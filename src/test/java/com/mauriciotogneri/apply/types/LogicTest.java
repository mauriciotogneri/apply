package com.mauriciotogneri.apply.types;

import org.junit.Test;

import static com.mauriciotogneri.apply.experiment.Runtime.BooleanOperations.and;
import static com.mauriciotogneri.apply.experiment.Runtime.BooleanOperations.not;
import static com.mauriciotogneri.apply.experiment.Runtime.BooleanOperations.or;
import static org.junit.Assert.assertEquals;

public class LogicTest
{
    @Test
    public void testAnd()
    {
        assertEquals(and(true, true), true);
        assertEquals(and(true, false), false);
        assertEquals(and(false, true), false);
        assertEquals(and(false, false), false);
    }

    @Test
    public void testOr()
    {
        assertEquals(or(true, true), true);
        assertEquals(or(true, false), true);
        assertEquals(or(false, true), true);
        assertEquals(or(false, false), false);
    }

    @Test
    public void testNot()
    {
        assertEquals(not(true), false);
        assertEquals(not(false), true);
    }
}