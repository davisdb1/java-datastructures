package com.cnc.algorithms.strings;

public class StringReversal {

    public static String reverse(String string) {
        if (string == null || string.equals("")) {
            return string;
        }
        char[] inCharArray = string.toCharArray();
        int start = 0;
        int end = string.length() - 1;
        while ( start < end) {
            char c = inCharArray[start];
            inCharArray[start] = inCharArray[end];
            inCharArray[end] = c;
            start++;
            end--;
        }
        return new String(inCharArray);

    }
}
