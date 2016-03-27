package com.mauriciotogneri.apply.runtime;

import com.mauriciotogneri.apply.test.types.Bool;
import com.mauriciotogneri.apply.test.types.Char;
import com.mauriciotogneri.apply.test.types.List;
import com.mauriciotogneri.apply.test.types.Num;

import org.junit.Test;

import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$add;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$and;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$append;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$concat;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$div;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$element;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$empty;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$equal;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$greater;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$greaterEqual;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$head;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$length;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$less;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$lessEqual;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$mod;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$mul;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$negate;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$notEqual;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$or;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$pow;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$sub;
import static com.mauriciotogneri.apply.test.RuntimeTypedSpecial.$tail;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class RuntimeTest
{
    @Test
    public void testArithmetic()
    {
        assertEquals($add.apply(new Num(3), new Num(-3)), new Num(0));
        assertEquals($add.apply(new Num(3), new Num(4)), new Num(7));
        assertEquals($add.apply(new Num(3), new Num(-4)), new Num(-1));

        assertEquals($sub.apply(new Num(3), new Num(4)), new Num(-1));
        assertEquals($sub.apply(new Num(4), new Num(3)), new Num(1));
        assertEquals($sub.apply(new Num(3), new Num(3)), new Num(0));

        assertEquals($mul.apply(new Num(3), new Num(4)), new Num(12));
        assertEquals($mul.apply(new Num(0), new Num(4)), new Num(0));
        assertEquals($mul.apply(new Num(3), new Num(0)), new Num(0));

        assertEquals($div.apply(new Num(3), new Num(4)), new Num(0.75));
        assertEquals($div.apply(new Num(3), new Num(3)), new Num(1));
        assertEquals($div.apply(new Num(0), new Num(4)), new Num(0));

        assertEquals($pow.apply(new Num(3), new Num(4)), new Num(81));
        assertEquals($pow.apply(new Num(3), new Num(0)), new Num(1));
        assertEquals($pow.apply(new Num(0), new Num(4)), new Num(0));
        assertEquals($pow.apply(new Num(9), new Num(0.5)), new Num(3));

        assertEquals($mod.apply(new Num(3), new Num(4)), new Num(3));
        assertEquals($mod.apply(new Num(4), new Num(4)), new Num(0));
        assertEquals($mod.apply(new Num(0), new Num(4)), new Num(0));
    }

    @Test
    public void testComparison()
    {
        assertEquals($less.apply(new Num(3), new Num(4)), new Bool(true));
        assertEquals($less.apply(new Num(4), new Num(3)), new Bool(false));
        assertEquals($less.apply(new Num(3), new Num(3)), new Bool(false));

        assertEquals($lessEqual.apply(new Num(3), new Num(4)), new Bool(true));
        assertEquals($lessEqual.apply(new Num(4), new Num(3)), new Bool(false));
        assertEquals($lessEqual.apply(new Num(3), new Num(3)), new Bool(true));

        assertEquals($greater.apply(new Num(3), new Num(4)), new Bool(false));
        assertEquals($greater.apply(new Num(4), new Num(3)), new Bool(true));
        assertEquals($greater.apply(new Num(3), new Num(3)), new Bool(false));

        assertEquals($greaterEqual.apply(new Num(3), new Num(4)), new Bool(false));
        assertEquals($greaterEqual.apply(new Num(4), new Num(3)), new Bool(true));
        assertEquals($greaterEqual.apply(new Num(3), new Num(3)), new Bool(true));

        assertEquals($equal.apply(new Num(3), new Num(3)), new Bool(true));
        assertEquals($equal.apply(new Num(3), new Num(4)), new Bool(false));

        assertEquals($equal.apply(new Bool(true), new Bool(true)), new Bool(true));
        assertEquals($equal.apply(new Bool(true), new Bool(false)), new Bool(false));
        assertEquals($equal.apply(new Bool(false), new Bool(true)), new Bool(false));
        assertEquals($equal.apply(new Bool(false), new Bool(false)), new Bool(true));

        assertEquals($equal.apply(new Char('X'), new Char('X')), new Bool(true));
        assertEquals($equal.apply(new Char('X'), new Char('Y')), new Bool(false));

        assertEquals($equal.apply(new List(), new List()), new Bool(true));
        assertEquals($equal.apply(new List(), new List(new Num(1), new Num(2), new Num(3))), new Bool(false));
        assertEquals($equal.apply(new List(new Num(1), new Num(2), new Num(3)), new List()), new Bool(false));
        assertEquals($equal.apply(new List(new Num(1), new Num(2), new Num(3)), new List(new Num(1), new Num(2), new Num(3))), new Bool(true));
        assertEquals($equal.apply(new List(new Num(1), new Num(2), new Num(3)), new List(new Num(1), new Num(2), new Num(3), new Num(4))), new Bool(false));

        assertEquals($notEqual.apply(new Num(3), new Num(4)), new Bool(true));
    }

    @Test
    public void testLogic()
    {
        assertEquals($and.apply(new Bool(true), new Bool(true)), new Bool(true));
        assertEquals($and.apply(new Bool(true), new Bool(false)), new Bool(false));
        assertEquals($and.apply(new Bool(false), new Bool(true)), new Bool(false));
        assertEquals($and.apply(new Bool(false), new Bool(false)), new Bool(false));

        assertEquals($or.apply(new Bool(true), new Bool(true)), new Bool(true));
        assertEquals($or.apply(new Bool(true), new Bool(false)), new Bool(true));
        assertEquals($or.apply(new Bool(false), new Bool(true)), new Bool(true));
        assertEquals($or.apply(new Bool(false), new Bool(false)), new Bool(false));

        assertEquals($negate.apply(new Bool(true)), new Bool(false));
        assertEquals($negate.apply(new Bool(false)), new Bool(true));
    }

    @Test
    public void testList()
    {
        assertEquals($empty.apply(new List()), new Bool(true));
        assertEquals($empty.apply(new List(new Num(1), new Num(2))), new Bool(false));

        assertEquals($length.apply(new List()), new Num(0));
        assertEquals($length.apply(new List(new Num(1))), new Num(1));
        assertEquals($length.apply(new List(new Num(1), new Num(2), new Num(3))), new Num(3));

        // TODO assertEquals($element.apply(new List(), new Num(0)), null);
        assertEquals($element.apply(new List(new Num(1)), new Num(0)), new Num(1));
        assertEquals($element.apply(new List(new Num(1), new Num(2), new Num(3)), new Num(2)), new Num(3));

        assertEquals($append.apply(new List(), new Num(1)), new List(new Num(1)));
        assertEquals($append.apply(new List(new Char('B')), new Char('A')), new List(new Char('A'), new Char('B')));
        assertEquals($append.apply(new List(new Char('Y'), new Char('Z')), new Char('X')), new List(new Char('X'), new Char('Y'), new Char('Z')));

        assertEquals($concat.apply(new List(), new List()), new List());
        assertEquals($concat.apply(new List(new Num(1)), new List()), new List(new Num(1)));
        assertEquals($concat.apply(new List(), new List(new Num(1))), new List(new Num(1)));
        assertEquals($concat.apply(new List(new Num(1)), new List(new Num(2))), new List(new Num(1), new Num(2)));

        // TODO assertEquals($head.apply(new List()), null);
        assertEquals($head.apply(new List(new Num(1))), new Num(1));
        assertEquals($head.apply(new List(new Num(1), new Num(2), new Num(3))), new Num(1));

        // TODO assertEquals($tail.apply(new List()), null);
        assertEquals($tail.apply(new List(new Num(1))), new List());
        assertEquals($tail.apply(new List(new Num(1), new Num(2), new Num(3))), new List(new Num(2), new Num(3)));
    }
}