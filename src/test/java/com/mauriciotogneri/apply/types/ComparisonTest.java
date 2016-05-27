package com.mauriciotogneri.apply.types;

import com.mauriciotogneri.apply.experiment.Runtime.NumberOperations;

import org.junit.Test;

import static com.mauriciotogneri.apply.experiment.Runtime.AnyOperations.equal;
import static com.mauriciotogneri.apply.experiment.Runtime.AnyOperations.notEqual;
import static com.mauriciotogneri.apply.experiment.ListOperations.listOf;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.less;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.lessEqual;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.greaterEqual;
import static org.junit.Assert.assertEquals;

public class ComparisonTest
{
    @Test
    public void testLess()
    {
        assertEquals(less(3, 4), true);
        assertEquals(less(4, 3), false);
        assertEquals(less(3, 3), false);
    }

    @Test
    public void testLessEqual()
    {
        assertEquals(lessEqual(3, 4), true);
        assertEquals(lessEqual(4, 3), false);
        assertEquals(lessEqual(3, 3), true);
    }

    @Test
    public void testGreater()
    {
        assertEquals(NumberOperations.greater(3, 4), false);
        assertEquals(NumberOperations.greater(4, 3), true);
        assertEquals(NumberOperations.greater(3, 3), false);
    }

    @Test
    public void testGreaterEqual()
    {
        assertEquals(greaterEqual(3, 4), false);
        assertEquals(greaterEqual(4, 3), true);
        assertEquals(greaterEqual(3, 3), true);
    }

    @Test
    public void testEqual()
    {
        assertEquals(equal(3, 3), true);
        assertEquals(equal(3, 4), false);
        assertEquals(equal(true, true), true);
        assertEquals(equal(true, false), false);
        assertEquals(equal(false, true), false);
        assertEquals(equal(false, false), true);
        assertEquals(equal("X", "X"), true);
        assertEquals(equal("X", "Y"), false);
        assertEquals(equal(listOf(), listOf()), true);
        assertEquals(equal(listOf(), listOf(1, 2, 3)), false);
        assertEquals(equal(listOf(1, 2, 3), listOf()), false);
        assertEquals(equal(listOf(1, 2, 3), listOf(1, 2, 3)), true);
        assertEquals(equal(listOf(1, 2, 3), listOf(1, 2, 3, 4)), false);
    }

    @Test
    public void testNotEqual()
    {
        assertEquals(notEqual(3, 3), false);
        assertEquals(notEqual(3, 4), true);
        assertEquals(notEqual(true, true), false);
        assertEquals(notEqual(true, false), true);
        assertEquals(notEqual(false, true), true);
        assertEquals(notEqual(false, false), false);
        assertEquals(notEqual("X", "X"), false);
        assertEquals(notEqual("X", "Y"), true);
        assertEquals(notEqual(listOf(), listOf()), false);
        assertEquals(notEqual(listOf(), listOf(1, 2, 3)), true);
        assertEquals(notEqual(listOf(1, 2, 3), listOf()), true);
        assertEquals(notEqual(listOf(1, 2, 3), listOf(1, 2, 3)), false);
        assertEquals(notEqual(listOf(1, 2, 3), listOf(1, 2, 3, 4)), true);
    }
}