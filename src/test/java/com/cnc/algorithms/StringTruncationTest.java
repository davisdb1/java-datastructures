package com.cnc.algorithms;

import com.cnc.algorithms.strings.StringTruncation;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringTruncationTest {

    @Test
    public void emptyResult() {
        assertEquals("", StringTruncation.getGoogleSeachTitle("", 100));
    }

    @Test
    public void truncateInString() {
        assertEquals("abs abc", StringTruncation.getGoogleSeachTitle("abs abc abc", 8));
        assertEquals("abs abc", StringTruncation.getGoogleSeachTitle("abs abc abc", 7));

    }


    @Test
    public void nullResult() {
        assertEquals(null, StringTruncation.getGoogleSeachTitle(null, 100));
    }

    @Test
    public void singleLengthTest() {
        assertEquals("G", StringTruncation.getGoogleSeachTitle("G", 100));
    }


    @Test
    public void truncateNoSpaces() {
        assertEquals("GOOOOOLLLG", StringTruncation.getGoogleSeachTitle("GOOOOOLLLGGE", 10));
    }


    @Test
    public void truncateWithSpaces() {
        assertEquals("GOOO", StringTruncation.getGoogleSeachTitle("GOOO OOLLLGGE", 10));
    }

    @Test
    public void truncateWithTrailingSpaces() {
        assertEquals("GOOO OOLLLGGE", StringTruncation.getGoogleSeachTitle("GOOO OOLLLGGE ", 13));
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeLengthValueTest() {
        StringTruncation.getGoogleSeachTitle("GOOO OOLLLGGE ", -1);
    }
}
