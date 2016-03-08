package com.mauriciotogneri.apply;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests
{
    @Test
    public void testPrintHelloWorld()
    {
        Sum sum = new Sum();
        assertEquals(sum.sum(2, 3), 5);
    }
}