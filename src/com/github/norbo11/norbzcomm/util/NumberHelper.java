package com.github.norbo11.norbzcomm.util;

public class NumberHelper {
    public static int toInt(String s) throws NumberFormatException
    {
        int i = 0;
        i = Integer.valueOf(s);
        return i;
    }
}