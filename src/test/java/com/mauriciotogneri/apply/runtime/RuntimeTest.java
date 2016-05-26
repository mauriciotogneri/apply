package com.mauriciotogneri.apply.runtime;

import org.junit.Test;

import java.util.Optional;

import static com.mauriciotogneri.apply.experiment.Any.equal;
import static com.mauriciotogneri.apply.experiment.Any.notEqual;
import static com.mauriciotogneri.apply.experiment.BooleanOperations.and;
import static com.mauriciotogneri.apply.experiment.BooleanOperations.not;
import static com.mauriciotogneri.apply.experiment.BooleanOperations.or;
import static com.mauriciotogneri.apply.experiment.ListOperations.appendFirst;
import static com.mauriciotogneri.apply.experiment.ListOperations.appendLast;
import static com.mauriciotogneri.apply.experiment.ListOperations.concat;
import static com.mauriciotogneri.apply.experiment.ListOperations.element;
import static com.mauriciotogneri.apply.experiment.ListOperations.empty;
import static com.mauriciotogneri.apply.experiment.ListOperations.head;
import static com.mauriciotogneri.apply.experiment.ListOperations.length;
import static com.mauriciotogneri.apply.experiment.ListOperations.listOf;
import static com.mauriciotogneri.apply.experiment.ListOperations.tail;
import static com.mauriciotogneri.apply.experiment.NumberOperations.add;
import static com.mauriciotogneri.apply.experiment.NumberOperations.div;
import static com.mauriciotogneri.apply.experiment.NumberOperations.greater;
import static com.mauriciotogneri.apply.experiment.NumberOperations.greaterEqual;
import static com.mauriciotogneri.apply.experiment.NumberOperations.less;
import static com.mauriciotogneri.apply.experiment.NumberOperations.lessEqual;
import static com.mauriciotogneri.apply.experiment.NumberOperations.mod;
import static com.mauriciotogneri.apply.experiment.NumberOperations.mul;
import static com.mauriciotogneri.apply.experiment.NumberOperations.pow;
import static com.mauriciotogneri.apply.experiment.NumberOperations.sub;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class RuntimeTest
{
    @Test
    public void testArithmetic()
    {
        assertEquals(add(3, -3), 0L);
        assertEquals(add(3, 4), 7L);
        assertEquals(add(3, -4), -1L);

        assertEquals(sub(3, 4), -1L);
        assertEquals(sub(4, 3), 1L);
        assertEquals(sub(3, 3), 0L);

        assertEquals(mul(3, 4), 12L);
        assertEquals(mul(0, 4), 0L);
        assertEquals(mul(3, 0), 0L);

        assertEquals(div(3, 4), 0.75d);
        assertEquals(div(3, 3), 1L);
        assertEquals(div(0, 4), 0L);

        assertEquals(pow(3, 4), 81L);
        assertEquals(pow(3, 0), 1L);
        assertEquals(pow(0, 4), 0L);
        assertEquals(pow(9, 0.5), 3L);

        assertEquals(mod(3, 4), 3L);
        assertEquals(mod(4, 4), 0L);
        assertEquals(mod(0, 4), 0L);
    }

    @Test
    public void testComparison()
    {
        assertEquals(less(3, 4), true);
        assertEquals(less(4, 3), false);
        assertEquals(less(3, 3), false);

        assertEquals(lessEqual(3, 4), true);
        assertEquals(lessEqual(4, 3), false);
        assertEquals(lessEqual(3, 3), true);

        assertEquals(greater(3, 4), false);
        assertEquals(greater(4, 3), true);
        assertEquals(greater(3, 3), false);

        assertEquals(greaterEqual(3, 4), false);
        assertEquals(greaterEqual(4, 3), true);
        assertEquals(greaterEqual(3, 3), true);

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

        assertEquals(notEqual(3, 4), true);
    }

    @Test
    public void testLogic()
    {
        assertEquals(and(true, true), true);
        assertEquals(and(true, false), false);
        assertEquals(and(false, true), false);
        assertEquals(and(false, false), false);

        assertEquals(or(true, true), true);
        assertEquals(or(true, false), true);
        assertEquals(or(false, true), true);
        assertEquals(or(false, false), false);

        assertEquals(not(true), false);
        assertEquals(not(false), true);
    }

    @Test
    public void testList()
    {
        assertEquals(empty(listOf()), true);
        assertEquals(empty(listOf(1, 2)), false);

        assertEquals(length(listOf()), 0);
        assertEquals(length(listOf(1)), 1);
        assertEquals(length(listOf(1, 2, 3)), 3);

        assertEquals(element(listOf(), 0), Optional.empty());
        assertEquals(element(listOf(1), 0), Optional.of(1));
        assertEquals(element(listOf(1, 2, 3), 2), Optional.of(3));

        assertEquals(appendFirst(listOf(), 1), listOf(1));
        assertEquals(appendFirst(listOf("B"), "A"), listOf("A", "B"));
        assertEquals(appendFirst(listOf("Y", "Z"), "X"), listOf("X", "Y", "Z"));

        assertEquals(appendLast(listOf(), 1), listOf(1));
        assertEquals(appendLast(listOf("B"), "A"), listOf("B", "A"));
        assertEquals(appendLast(listOf("Y", "Z"), "X"), listOf("Y", "Z", "X"));

        assertEquals(concat(listOf(), listOf()), listOf());
        assertEquals(concat(listOf(1), listOf()), listOf(1));
        assertEquals(concat(listOf(), listOf(1)), listOf(1));
        assertEquals(concat(listOf(1), listOf(2)), listOf(1, 2));

        assertEquals(head(listOf()), Optional.empty());
        assertEquals(head(listOf(1)), Optional.of(1));
        assertEquals(head(listOf(1, 2, 3)), Optional.of(1));

        assertEquals(tail(listOf()), Optional.empty());
        assertEquals(tail(listOf(1)), Optional.of(listOf()));
        assertEquals(tail(listOf(1, 2, 3)), Optional.of(listOf(2, 3)));
    }
}