package com.mauriciotogneri.apply.base;

import java.io.File;

public class TestSuite
{
    protected File file(String path)
    {
        return new File("/home/max/github/apply/src/test/resources/" + path);
    }
}