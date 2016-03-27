package com.mauriciotogneri.apply.types;

import com.mauriciotogneri.apply.test.types.Bool;
import com.mauriciotogneri.apply.test.types.Char;
import com.mauriciotogneri.apply.test.types.List;
import com.mauriciotogneri.apply.test.types.Num;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListTest
{
    // ======================================== EMPTY =========================================== \\

    @Test
    public void emptyOfOne()
    {
        List input = new List(new Char('X'));
        Bool output = new Bool(false);
        assertEquals(input.empty(), output);
    }

    @Test
    public void emptyOfThree()
    {
        List input = new List(new Num(1), new Num(2), new Num(3));
        Bool output = new Bool(false);
        assertEquals(input.empty(), output);
    }

    @Test
    public void emptyOfZero()
    {
        List input = new List();
        Bool output = new Bool(true);
        assertEquals(input.empty(), output);
    }

    // ======================================= LENGTH =========================================== \\

    @Test
    public void lengthOfOne()
    {
        List input = new List(new Char('X'));
        Num output = new Num(1);
        assertEquals(input.length(), output);
    }

    @Test
    public void lengthOfThree()
    {
        List input = new List(new Num(1), new Num(2), new Num(3));
        Num output = new Num(3);
        assertEquals(input.length(), output);
    }

    @Test
    public void lengthOfZero()
    {
        List input = new List();
        Num output = new Num(0);
        assertEquals(input.length(), output);
    }

    // ======================================== HEAD ============================================ \\

    @Test
    public void headOfOne()
    {
        List input = new List(new Char('X'));
        Char output = new Char('X');
        assertEquals(input.head(), output);
    }

    @Test
    public void headOfThree()
    {
        List input = new List(new Num(1), new Num(2), new Num(3));
        Num output = new Num(1);
        assertEquals(input.head(), output);
    }

    @Test(expected = RuntimeException.class)
    public void headOfZero()
    {
        List input = new List();
        input.head();
    }

    // ======================================== TAIL ============================================ \\

    @Test
    public void tailOfOne()
    {
        List input = new List(new Char('X'));
        List output = new List();
        assertEquals(input.tail(), output);
    }

    @Test
    public void tailOfThree()
    {
        List input = new List(new Num(1), new Num(2), new Num(3));
        List output = new List(new Num(2), new Num(3));
        assertEquals(input.tail(), output);
    }

    @Test(expected = RuntimeException.class)
    public void tailOfZero()
    {
        List input = new List();
        input.tail();
    }

    // ======================================== INIT ============================================ \\

    @Test
    public void initOfOne()
    {
        List input = new List(new Char('X'));
        List output = new List();
        assertEquals(input.init(), output);
    }

    @Test
    public void initOfThree()
    {
        List input = new List(new Num(1), new Num(2), new Num(3));
        List output = new List(new Num(1), new Num(2));
        assertEquals(input.init(), output);
    }

    @Test(expected = RuntimeException.class)
    public void initOfZero()
    {
        List input = new List();
        input.init();
    }

    // ======================================== LAST ============================================ \\

    @Test
    public void lastOfOne()
    {
        List input = new List(new Char('X'));
        Char output = new Char('X');
        assertEquals(input.last(), output);
    }

    @Test
    public void lastOfThree()
    {
        List input = new List(new Num(1), new Num(2), new Num(3));
        Num output = new Num(3);
        assertEquals(input.last(), output);
    }

    @Test(expected = RuntimeException.class)
    public void lastOfZero()
    {
        List input = new List();
        input.last();
    }

    // ========================================= element ============================================ \\

    @Test
    public void elementOfOneCorrect()
    {
        Num index = new Num(0);
        List input = new List(new Char('X'));
        Char output = new Char('X');
        assertEquals(input.element(index), output);
    }

    @Test(expected = RuntimeException.class)
    public void elementOfOneUnder()
    {
        Num index = new Num(-1);
        List input = new List(new Char('X'));
        input.element(index);
    }

    @Test(expected = RuntimeException.class)
    public void elementOfOneOver()
    {
        Num index = new Num(1);
        List input = new List(new Char('X'));
        input.element(index);
    }

    @Test
    public void elementOfThreeCorrect()
    {
        Num index = new Num(0);
        List input = new List(new Num(1), new Num(2), new Num(3));
        Num output = new Num(1);
        assertEquals(input.element(index), output);
    }

    @Test(expected = RuntimeException.class)
    public void elementOfThreeUnder()
    {
        Num index = new Num(-1);
        List input = new List(new Num(1), new Num(2), new Num(3));
        input.element(index);
    }

    @Test(expected = RuntimeException.class)
    public void elementOfThreeOver()
    {
        Num index = new Num(3);
        List input = new List(new Num(1), new Num(2), new Num(3));
        input.element(index);
    }

    @Test(expected = RuntimeException.class)
    public void elementOfZero()
    {
        Num index = new Num(0);
        List input = new List();
        input.element(index);
    }

    // ======================================= CONCAT =========================================== \\

    @Test
    public void concatEmptyEmpty()
    {
        List inputA = new List();
        List inputB = new List();
        List output = new List();

        assertEquals(inputA.concat(inputB), output);
    }

    @Test
    public void concatEmptyNotEmpty()
    {
        List inputA = new List();
        List inputB = new List(new Num(6), new Num(7), new Num(8));
        List output = new List(new Num(6), new Num(7), new Num(8));

        assertEquals(inputA.concat(inputB), output);
    }

    @Test
    public void concatNotEmptyEmpty()
    {
        List inputA = new List(new Num(1), new Num(2), new Num(3));
        List inputB = new List();
        List output = new List(new Num(1), new Num(2), new Num(3));

        assertEquals(inputA.concat(inputB), output);
    }

    @Test
    public void concatNotEmptyNotEmpty()
    {
        List inputA = new List(new Num(1), new Num(2), new Num(3));
        List inputB = new List(new Num(4), new Num(5), new Num(6));
        List output = new List(new Num(1), new Num(2), new Num(3), new Num(4), new Num(5), new Num(6));

        assertEquals(inputA.concat(inputB), output);
    }

    // ========================================= MAP ============================================ \\

    @Test
    public void mapOfOne()
    {
        //Double[] input = {1d};
        //Double[] output = {2d};
        //assertEquals(map.apply(duplicate, input), output);
    }

    @Test
    public void mapOfThree()
    {
        //Double[] input = {1d, 2d, -3d};
        //Double[] output = {2d, 4d, -6d};
        //assertEquals(map.apply(duplicate, input), output);
    }

    @Test
    public void mapOfZero()
    {
        //Double[] input = {};
        //Double[] output = {};
        //assertEquals(map.apply(duplicate, input), output);
    }
}