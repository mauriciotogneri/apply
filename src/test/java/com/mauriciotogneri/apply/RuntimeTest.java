package com.mauriciotogneri.apply;

import org.junit.Test;

import static com.mauriciotogneri.apply.test.Runtime.$add;
import static com.mauriciotogneri.apply.test.Runtime.$and;
import static com.mauriciotogneri.apply.test.Runtime.$appendBeginning;
import static com.mauriciotogneri.apply.test.Runtime.$appendEnd;
import static com.mauriciotogneri.apply.test.Runtime.$concat;
import static com.mauriciotogneri.apply.test.Runtime.$div;
import static com.mauriciotogneri.apply.test.Runtime.$equal;
import static com.mauriciotogneri.apply.test.Runtime.$greater;
import static com.mauriciotogneri.apply.test.Runtime.$greaterEqual;
import static com.mauriciotogneri.apply.test.Runtime.$length;
import static com.mauriciotogneri.apply.test.Runtime.$less;
import static com.mauriciotogneri.apply.test.Runtime.$lessEqual;
import static com.mauriciotogneri.apply.test.Runtime.$mod;
import static com.mauriciotogneri.apply.test.Runtime.$mul;
import static com.mauriciotogneri.apply.test.Runtime.$negate;
import static com.mauriciotogneri.apply.test.Runtime.$noEqual;
import static com.mauriciotogneri.apply.test.Runtime.$nth;
import static com.mauriciotogneri.apply.test.Runtime.$or;
import static com.mauriciotogneri.apply.test.Runtime.$pow;
import static com.mauriciotogneri.apply.test.Runtime.$remove;
import static com.mauriciotogneri.apply.test.Runtime.$sub;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RuntimeTest
{
    @Test
    public void testArithmetic()
    {
        assertEquals($add.apply(3d, 4d), 7d);
        assertEquals($sub.apply(3d, 4d), -1d);
        assertEquals($mul.apply(3d, 4d), 12d);
        assertEquals($div.apply(3d, 4d), 0.75d);
        assertEquals($pow.apply(3d, 4d), 81d);
        assertEquals($mod.apply(3d, 4d), 3d);
    }

    @Test
    public void testComparison()
    {
        assertEquals($less.apply(3d, 4d), true);
        assertEquals($lessEqual.apply(3d, 4d), true);
        assertEquals($greater.apply(3d, 4d), false);
        assertEquals($greaterEqual.apply(3d, 4d), false);
        assertEquals($equal.apply(3d, 4d), false);
        assertEquals($noEqual.apply(3d, 4d), true);
    }

    @Test
    public void testLogic()
    {
        assertEquals($and.apply(true, true), true);
        assertEquals($and.apply(true, false), false);
        assertEquals($and.apply(false, true), false);
        assertEquals($and.apply(false, false), false);
        assertEquals($or.apply(true, true), true);
        assertEquals($or.apply(true, false), true);
        assertEquals($or.apply(false, true), true);
        assertEquals($or.apply(false, false), false);
        assertEquals($negate.apply(true), false);
        assertEquals($negate.apply(false), true);
    }

    @Test
    public void testList()
    {
        Double[] inputA = new Double[] {1d, 2d, 3d, 4d, 5d};
        Double[] inputB = new Double[] {6d, 7d, 8d};

        assertEquals($nth.apply(2d, inputA), 3d);
        assertEquals($length.apply(inputA), 5d);
        assertArrayEquals((Object[]) $concat.apply(inputA, inputB), new Double[] {1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d});
        assertArrayEquals((Object[]) $appendBeginning.apply(0d, inputA), new Double[] {0d, 1d, 2d, 3d, 4d, 5d});
        assertArrayEquals((Object[]) $appendEnd.apply(inputA, 6d), new Double[] {1d, 2d, 3d, 4d, 5d, 6d});
        assertArrayEquals((Object[]) $remove.apply(2d, inputA), new Double[] {1d, 2d, 4d, 5d});
    }
}