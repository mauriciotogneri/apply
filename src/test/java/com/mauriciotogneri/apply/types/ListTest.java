package com.mauriciotogneri.apply.types;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.appendFirst;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.appendLast;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.concat;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.element;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.empty;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.head;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.init;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.last;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.length;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.listOf;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.map;
import static com.mauriciotogneri.apply.experiment.Runtime.ListOperations.tail;
import static org.junit.Assert.assertEquals;

public class ListTest
{
    // ======================================== EMPTY =========================================== \\

    @Test
    public void emptyOfOne()
    {
        List input = listOf("X");
        assertEquals(empty(input), false);
    }

    @Test
    public void emptyOfThree()
    {
        List input = listOf(1, 2, 3);
        assertEquals(empty(input), false);
    }

    @Test
    public void emptyOfZero()
    {
        List input = listOf();
        assertEquals(empty(input), true);
    }

    // ======================================= LENGTH =========================================== \\

    @Test
    public void lengthOfOne()
    {
        List input = listOf("X");
        assertEquals(length(input), 1);
    }

    @Test
    public void lengthOfThree()
    {
        List input = listOf(1, 2, 3);
        assertEquals(length(input), 3);
    }

    @Test
    public void lengthOfZero()
    {
        List input = listOf();
        assertEquals(length(input), 0);
    }

    // ==================================== APPEND FIRST ======================================== \\

    @Test
    public void appendFirstOfOne()
    {
        List<Integer> inputA = listOf(2);
        Integer inputB = 1;
        List<Integer> output = listOf(1, 2);

        assertEquals(appendFirst(inputA, inputB), output);
    }

    @Test
    public void appendFirstOfThree()
    {
        List<Integer> inputA = listOf(2, 3, 4);
        Integer inputB = 1;
        List<Integer> output = listOf(1, 2, 3, 4);

        assertEquals(appendFirst(inputA, inputB), output);
    }

    @Test
    public void appendFirstOfZero()
    {
        List<Integer> inputA = listOf();
        Integer inputB = 1;
        List<Integer> output = listOf(1);

        assertEquals(appendFirst(inputA, inputB), output);
    }

    // ===================================== APPEND LAST ======================================== \\

    @Test
    public void appendLastOfOne()
    {
        List<Integer> inputA = listOf(1);
        Integer inputB = 2;
        List<Integer> output = listOf(1, 2);

        assertEquals(appendLast(inputA, inputB), output);
    }

    @Test
    public void appendLastOfThree()
    {
        List<Integer> inputA = listOf(1, 2, 3);
        Integer inputB = 4;
        List<Integer> output = listOf(1, 2, 3, 4);

        assertEquals(appendLast(inputA, inputB), output);
    }

    @Test
    public void appendLastOfZero()
    {
        List<Integer> inputA = listOf();
        Integer inputB = 1;
        List<Integer> output = listOf(1);

        assertEquals(appendLast(inputA, inputB), output);
    }

    // ======================================== HEAD ============================================ \\

    @Test
    public void headOfOne()
    {
        List input = listOf("X");
        assertEquals(head(input), Optional.of("X"));
    }

    @Test
    public void headOfThree()
    {
        List input = listOf(1, 2, 3);
        assertEquals(head(input), Optional.of(1));
    }

    @Test
    public void headOfZero()
    {
        List input = listOf();
        assertEquals(head(input), Optional.empty());
    }

    // ======================================== TAIL ============================================ \\

    @Test
    public void tailOfOne()
    {
        List input = listOf("X");
        assertEquals(tail(input), Optional.empty());
    }

    @Test
    public void tailOfThree()
    {
        List input = listOf(1, 2, 3);
        assertEquals(tail(input), Optional.of(listOf(2, 3)));
    }

    @Test
    public void tailOfZero()
    {
        List input = listOf();
        assertEquals(tail(input), Optional.empty());
    }

    // ======================================== INIT ============================================ \\

    @Test
    public void initOfOne()
    {
        List input = listOf("X");
        assertEquals(init(input), Optional.empty());
    }

    @Test
    public void initOfThree()
    {
        List input = listOf(1, 2, 3);
        assertEquals(init(input), Optional.of(listOf(1, 2)));
    }

    @Test
    public void initOfZero()
    {
        List input = listOf();
        assertEquals(init(input), Optional.empty());
    }

    // ======================================== LAST ============================================ \\

    @Test
    public void lastOfOne()
    {
        List input = listOf("X");
        assertEquals(last(input), Optional.of("X"));
    }

    @Test
    public void lastOfThree()
    {
        List input = listOf(1, 2, 3);
        assertEquals(last(input), Optional.of(3));
    }

    @Test
    public void lastOfZero()
    {
        List input = listOf();
        assertEquals(last(input), Optional.empty());
    }

    // ========================================= element ============================================ \\

    @Test
    public void elementOfOneCorrect()
    {
        List input = listOf("X");
        assertEquals(element(input, 0), Optional.of("X"));
    }

    @Test
    public void elementOfOneUnder()
    {
        List input = listOf("X");
        assertEquals(element(input, -1), Optional.empty());
    }

    @Test
    public void elementOfOneOver()
    {
        List input = listOf("X");
        assertEquals(element(input, 1), Optional.empty());
    }

    @Test
    public void elementOfThreeCorrect()
    {
        List input = listOf(1, 2, 3);
        assertEquals(element(input, 0), Optional.of(1));
    }

    @Test
    public void elementOfThreeUnder()
    {
        List input = listOf(1, 2, 3);
        assertEquals(element(input, -1), Optional.empty());
    }

    @Test
    public void elementOfThreeOver()
    {
        List input = listOf(1, 2, 3);
        assertEquals(element(input, 3), Optional.empty());
    }

    @Test
    public void elementOfZero()
    {
        List input = listOf();
        assertEquals(element(input, 0), Optional.empty());
    }

    // ======================================= CONCAT =========================================== \\

    @Test
    public void concatEmptyEmpty()
    {
        List inputA = listOf();
        List inputB = listOf();
        List output = listOf();

        assertEquals(concat(inputA, inputB), output);
    }

    @Test
    public void concatEmptyNotEmpty()
    {
        List inputA = listOf();
        List inputB = listOf(6, 7, 8);
        List output = listOf(6, 7, 8);

        assertEquals(concat(inputA, inputB), output);
    }

    @Test
    public void concatNotEmptyEmpty()
    {
        List inputA = listOf(1, 2, 3);
        List inputB = listOf();
        List output = listOf(1, 2, 3);

        assertEquals(concat(inputA, inputB), output);
    }

    @Test
    public void concatNotEmptyNotEmpty()
    {
        List inputA = listOf(1, 2, 3);
        List inputB = listOf(4, 5, 6);
        List output = listOf(1, 2, 3, 4, 5, 6);

        assertEquals(concat(inputA, inputB), output);
    }

    // ========================================= MAP ============================================ \\

    @Test
    public void mapOfOne()
    {
        List<Integer> input = listOf(1);
        List<Integer> output = listOf(2);
        assertEquals(map(n -> n * 2, input), output);
    }

    @Test
    public void mapOfThree()
    {
        List<Integer> input = listOf(1, 2, -3);
        List<Integer> output = listOf(2, 4, -6);
        assertEquals(map(n -> n * 2, input), output);
    }

    @Test
    public void mapOfZero()
    {
        List<Integer> input = listOf();
        List<Integer> output = listOf();
        assertEquals(map(n -> n * 2, input), output);
    }
}