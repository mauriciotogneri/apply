package com.mauriciotogneri.apply.tmp;

import static com.mauriciotogneri.apply.experiment.Runtime.AnyOperations.*;
import static com.mauriciotogneri.apply.experiment.Runtime.NumberOperations.*;

public class Test
{
public static Number factorial(Number n)
{
if (equal(n, 0))
{
return 1;
}
else
{
return mul(n, factorial(sub(n, 1)));
}
}
}