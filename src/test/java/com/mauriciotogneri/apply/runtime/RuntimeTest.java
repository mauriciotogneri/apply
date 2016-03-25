package com.mauriciotogneri.apply.runtime;

import org.junit.Test;

import static com.mauriciotogneri.apply.test.Runtime.$add;
import static com.mauriciotogneri.apply.test.Runtime.$and;
import static com.mauriciotogneri.apply.test.Runtime.$append;
import static com.mauriciotogneri.apply.test.Runtime.$div;
import static com.mauriciotogneri.apply.test.Runtime.$equal;
import static com.mauriciotogneri.apply.test.Runtime.$greater;
import static com.mauriciotogneri.apply.test.Runtime.$greaterEqual;
import static com.mauriciotogneri.apply.test.Runtime.$head;
import static com.mauriciotogneri.apply.test.Runtime.$less;
import static com.mauriciotogneri.apply.test.Runtime.$lessEqual;
import static com.mauriciotogneri.apply.test.Runtime.$mod;
import static com.mauriciotogneri.apply.test.Runtime.$mul;
import static com.mauriciotogneri.apply.test.Runtime.$negate;
import static com.mauriciotogneri.apply.test.Runtime.$notEqual;
import static com.mauriciotogneri.apply.test.Runtime.$or;
import static com.mauriciotogneri.apply.test.Runtime.$pow;
import static com.mauriciotogneri.apply.test.Runtime.$sub;
import static com.mauriciotogneri.apply.test.Runtime.$tail;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RuntimeTest
{
    @Test
    public void testArithmetic()
    {
        assertEquals($add.apply(3d, -3d), 0d);
        assertEquals($add.apply(3d, 4d), 7d);
        assertEquals($add.apply(3d, -4d), -1d);

        assertEquals($sub.apply(3d, 4d), -1d);
        assertEquals($sub.apply(4d, 3d), 1d);
        assertEquals($sub.apply(3d, 3d), 0d);

        assertEquals($mul.apply(3d, 4d), 12d);
        assertEquals($mul.apply(0d, 4d), 0d);
        assertEquals($mul.apply(3d, 0d), 0d);

        assertEquals($div.apply(3d, 4d), 0.75d);
        assertEquals($div.apply(3d, 3d), 1d);
        assertEquals($div.apply(0d, 4d), 0d);

        assertEquals($pow.apply(3d, 4d), 81d);
        assertEquals($pow.apply(3d, 0d), 1d);
        assertEquals($pow.apply(0d, 4d), 0d);
        assertEquals($pow.apply(9d, 0.5d), 3d);

        assertEquals($mod.apply(3d, 4d), 3d);
        assertEquals($mod.apply(4d, 4d), 0d);
        assertEquals($mod.apply(0d, 4d), 0d);
    }

    @Test
    public void testComparison()
    {
        assertEquals($less.apply(3d, 4d), true);
        assertEquals($less.apply(4d, 3d), false);
        assertEquals($less.apply(3d, 3d), false);

        assertEquals($lessEqual.apply(3d, 4d), true);
        assertEquals($lessEqual.apply(4d, 3d), false);
        assertEquals($lessEqual.apply(3d, 3d), true);

        assertEquals($greater.apply(3d, 4d), false);
        assertEquals($greater.apply(4d, 3d), true);
        assertEquals($greater.apply(3d, 3d), false);

        assertEquals($greaterEqual.apply(3d, 4d), false);
        assertEquals($greaterEqual.apply(4d, 3d), true);
        assertEquals($greaterEqual.apply(3d, 3d), true);

        assertEquals($equal.apply(3d, 3d), true);
        assertEquals($equal.apply(3d, 4d), false);

        assertEquals($equal.apply(true, true), true);
        assertEquals($equal.apply(true, false), false);
        assertEquals($equal.apply(false, true), false);
        assertEquals($equal.apply(false, false), true);

        assertEquals($equal.apply('X', 'X'), true);
        assertEquals($equal.apply('X', 'Y'), false);

        assertEquals($equal.apply(new Double[] {}, new Double[] {}), true);
        assertEquals($equal.apply(new Double[] {}, new Double[] {1d, 2d, 3d}), false);
        assertEquals($equal.apply(new Double[] {1d, 2d, 3d}, new Double[] {}), false);
        assertEquals($equal.apply(new Double[] {1d, 2d, 3d}, new Double[] {1d, 2d, 3d}), true);
        assertEquals($equal.apply(new Double[] {1d, 2d, 3d}, new Double[] {1d, 2d, 3d, 4d}), false);

        assertEquals($notEqual.apply(3d, 4d), true);
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
        assertArrayEquals((Object[]) $append.apply(1d, new Double[] {}), new Double[] {1d});
        assertArrayEquals((Object[]) $append.apply(1d, new Double[] {2d}), new Double[] {1d, 2d});
        assertArrayEquals((Object[]) $append.apply(1d, new Double[] {2d, 3d, 4d}), new Double[] {1d, 2d, 3d, 4d});

        assertEquals($head.apply(new Double[] {}), null);
        assertEquals($head.apply(new Double[] {1d}), 1d);
        assertEquals($head.apply(new Double[] {1d, 2d, 3d}), 1d);

        assertArrayEquals((Object[]) $tail.apply(new Double[] {}), null);
        assertArrayEquals((Object[]) $tail.apply(new Double[] {1d}), new Double[] {});
        assertArrayEquals((Object[]) $tail.apply(new Double[] {1d, 2d, 3d}), new Double[] {2d, 3d});
    }
}