package com.mauriciotogneri.apply;

import org.junit.Test;

import static com.mauriciotogneri.apply.test.Custom.apply;
import static com.mauriciotogneri.apply.test.Custom.duplicate;
import static com.mauriciotogneri.apply.test.Custom.factorial;
import static com.mauriciotogneri.apply.test.Custom.map;
import static com.mauriciotogneri.apply.test.Custom.pi;
import static com.mauriciotogneri.apply.test.Custom.triplicate;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CustomTest
{
    @Test
    public void tests()
    {
        assertEquals(pi.apply(), 3.14d);
        assertEquals(factorial.apply(5d), 120d);
        assertEquals(duplicate.apply(3d), 6d);
        assertEquals(triplicate.apply(3d), 9d);
        assertEquals(apply.apply(duplicate, 3d, 4d), 14d);

        Double[] input = new Double[] {1d, 2d, -3d};
        Double[] output = new Double[] {2d, 4d, -6d};
        assertArrayEquals((Object[]) map.apply(duplicate, input), output);
    }
}