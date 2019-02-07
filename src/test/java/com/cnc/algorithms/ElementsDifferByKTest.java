package com.cnc.algorithms;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ElementsDifferByKTest {

    ElementsDifferByK elementsDifferByK = new ElementsDifferByK();

    @Test
    public void testBasicHappy() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        assertEquals(expected, elementsDifferByK.getElementsThatDifferBy(new Integer[]{1, 2}, 1));
    }

    @Test
    public void testBasicNoMatches() {
        Map<Integer, Integer> expected = new HashMap<>();
        assertEquals(expected, elementsDifferByK.getElementsThatDifferBy(new Integer[]{1, 100}, 1));
        assertEquals(expected, elementsDifferByK.getElementsThatDifferBy(new Integer[]{1, 100, 105, 115, 200}, 1));
    }

    @Test
    public void testBasicHappyMultiValue() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        expected.put(2, 3);
        expected.put(3, 4);
        assertEquals(expected, elementsDifferByK.getElementsThatDifferBy(new Integer[]{1, 2, 3, 4}, 1));
    }

    @Test
    public void testOneResultBeginningAndEnd() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 10);
        assertEquals(expected,
                     elementsDifferByK.getElementsThatDifferBy(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        elementsDifferByK.getElementsThatDifferBy(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidK() {
        elementsDifferByK.getElementsThatDifferBy(new Integer[]{1, 2}, 0);
    }

}