package com.mauriciotogneri.apply.runtime;

import org.junit.Test;

import static com.mauriciotogneri.apply.test.Custom.duplicate;
import static com.mauriciotogneri.apply.test.stdlib.List.concat;
import static com.mauriciotogneri.apply.test.stdlib.List.empty;
import static com.mauriciotogneri.apply.test.stdlib.List.head;
import static com.mauriciotogneri.apply.test.stdlib.List.init;
import static com.mauriciotogneri.apply.test.stdlib.List.last;
import static com.mauriciotogneri.apply.test.stdlib.List.length;
import static com.mauriciotogneri.apply.test.stdlib.List.map;
import static com.mauriciotogneri.apply.test.stdlib.List.notEmpty;
import static com.mauriciotogneri.apply.test.stdlib.List.nth;
import static com.mauriciotogneri.apply.test.stdlib.List.tail;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class ListTest
{
    // ======================================== EMPTY =========================================== \\

    @Test
    public void emptyOfOne()
    {
        Character[] input = {'X'};
        assertEquals(empty.apply(input), false);
    }

    @Test
    public void emptyOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        assertEquals(empty.apply(input), false);
    }

    @Test
    public void emptyOfZero()
    {
        Boolean[] input = {};
        assertEquals(empty.apply(input), true);
    }

    // ====================================== NOT EMPTY ========================================= \\

    @Test
    public void notEmptyOfOne()
    {
        Character[] input = {'X'};
        assertEquals(notEmpty.apply(input), true);
    }

    @Test
    public void notEmptyOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        assertEquals(notEmpty.apply(input), true);
    }

    @Test
    public void notEmptyOfZero()
    {
        Boolean[] input = {};
        assertEquals(notEmpty.apply(input), false);
    }

    // ======================================= LENGTH =========================================== \\

    @Test
    public void lengthOfOne()
    {
        Character[] input = {'X'};
        Double output = 1d;
        assertEquals(length.apply(input), output);
    }

    @Test
    public void lengthOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        Double output = 3d;
        assertEquals(length.apply(input), output);
    }

    @Test
    public void lengthOfZero()
    {
        Boolean[] input = {};
        Double output = 0d;
        assertEquals(length.apply(input), output);
    }

    // ======================================== HEAD ============================================ \\

    @Test
    public void headOfOne()
    {
        Character[] input = {'X'};
        Character output = 'X';
        assertEquals(head.apply(input), output);
    }

    @Test
    public void headOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        Double output = 1d;
        assertEquals(head.apply(input), output);
    }

    @Test
    public void headOfZero()
    {
        Boolean[] input = {};
        Object output = null;
        assertEquals(head.apply(input), output);
    }

    // ======================================== TAIL ============================================ \\

    @Test
    public void tailOfOne()
    {
        Character[] input = {'X'};
        Character[] output = {};
        assertArrayEquals((Object[]) tail.apply(input), output);
    }

    @Test
    public void tailOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        Double[] output = {2d, -3d};
        assertArrayEquals((Object[]) tail.apply(input), output);
    }

    @Test
    public void tailOfZero()
    {
        Boolean[] input = {};
        Object output = null;
        assertEquals(tail.apply(input), output);
    }

    // ======================================== INIT ============================================ \\

    @Test
    public void initOfOne()
    {
        Character[] input = {'X'};
        Character[] output = {};
        assertArrayEquals((Object[]) init.apply(input), output);
    }

    @Test
    public void initOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        Double[] output = {1d, 2d};
        assertArrayEquals((Object[]) init.apply(input), output);
    }

    @Test
    public void initOfZero()
    {
        Boolean[] input = {};
        Object output = null;
        assertEquals(init.apply(input), output);
    }

    // ======================================== LAST ============================================ \\

    @Test
    public void lastOfOne()
    {
        Character[] input = {'X'};
        Character output = 'X';
        assertEquals(last.apply(input), output);
    }

    @Test
    public void lastOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        Double output = -3d;
        assertEquals(last.apply(input), output);
    }

    @Test
    public void lastOfZero()
    {
        Boolean[] input = {};
        Object output = null;
        assertEquals(last.apply(input), output);
    }

    // ========================================= NTH ============================================ \\

    @Test
    public void nthOfOneCorrect()
    {
        Double index = 0d;
        Character[] input = {'X'};
        Character output = 'X';
        assertEquals(nth.apply(index, input), output);
    }

    @Test
    public void nthOfOneUnder()
    {
        Double index = -1d;
        Character[] input = {'X'};
        Object output = null;
        assertEquals(nth.apply(index, input), output);
    }

    @Test
    public void nthOfOneOver()
    {
        Double index = 1d;
        Character[] input = {'X'};
        Object output = null;
        assertEquals(nth.apply(index, input), output);
    }

    @Test
    public void nthOfThreeCorrect()
    {
        Double index = 0d;
        Double[] input = {1d, 2d, -3d};
        Double output = 1d;
        assertEquals(nth.apply(index, input), output);
    }

    @Test
    public void nthOfThreeUnder()
    {
        Double index = -1d;
        Double[] input = {1d, 2d, -3d};
        Object output = null;
        assertEquals(nth.apply(index, input), output);
    }

    @Test
    public void nthOfThreeOver()
    {
        Double index = 3d;
        Double[] input = {1d, 2d, -3d};
        Object output = null;
        assertEquals(nth.apply(index, input), output);
    }

    @Test
    public void nthOfZero()
    {
        Double index = 0d;
        Boolean[] input = {};
        Object output = null;
        assertEquals(nth.apply(index, input), output);
    }

    // ======================================= CONCAT =========================================== \\

    @Test
    public void concatEmptyEmpty()
    {
        Double[] inputA = {};
        Double[] inputB = {};
        Double[] output = {};

        assertArrayEquals((Object[]) concat.apply(inputA, inputB), output);
    }

    @Test
    public void concatEmptyNotEmpty()
    {
        Double[] inputA = {};
        Double[] inputB = {6d, 7d, 8d};
        Double[] output = {6d, 7d, 8d};

        assertArrayEquals((Object[]) concat.apply(inputA, inputB), output);
    }

    @Test
    public void concatNotEmptyEmpty()
    {
        Double[] inputA = {1d, 2d, 3d};
        Double[] inputB = {};
        Double[] output = {1d, 2d, 3d};

        assertArrayEquals((Object[]) concat.apply(inputA, inputB), output);
    }

    @Test
    public void concatNotEmptyNotEmpty()
    {
        Double[] inputA = {1d, 2d, 3d};
        Double[] inputB = {4d, 5d, 6d};
        Double[] output = {1d, 2d, 3d, 4d, 5d, 6d};

        assertArrayEquals((Object[]) concat.apply(inputA, inputB), output);
    }

    // ========================================= MAP ============================================ \\

    @Test
    public void mapOfOne()
    {
        Double[] input = {1d};
        Double[] output = {2d};
        assertArrayEquals((Object[]) map.apply(duplicate, input), output);
    }

    @Test
    public void mapOfThree()
    {
        Double[] input = {1d, 2d, -3d};
        Double[] output = {2d, 4d, -6d};
        assertArrayEquals((Object[]) map.apply(duplicate, input), output);
    }

    @Test
    public void mapOfZero()
    {
        Double[] input = {};
        Double[] output = {};
        assertArrayEquals((Object[]) map.apply(duplicate, input), output);
    }
}