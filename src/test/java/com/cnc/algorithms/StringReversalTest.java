package com.cnc.algorithms;

import com.cnc.algorithms.strings.StringReversal;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringReversalTest {

    @Test
    public void reverseStringHappy() {

        String actual = "ABCD";
        String expected = "DCBA";

        String result = StringReversal.reverse(actual);
        assertEquals(expected, result);

    }

    @Test
    public void reverseStringOdd() {
        assertEquals("EDCBA", StringReversal.reverse("ABCDE"));
    }

}
