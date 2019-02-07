package com.cnc.algorithms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Evan Harris
 */
public class CommonElementsTest {

    CommonElementsInArray commonElementsInArray;

    @Before
    public void setup() {
        commonElementsInArray = new CommonElementsInArray();
    }


    @Test
    public void testCommonHappy() {
        assertArrayContentsEqual(createList(new int[]{1}),
                                 commonElementsInArray.getCommonElements(createList(new int[]{1, 2, 3}),
                                                                         createList(new int[]{4, 1, 5})));
    }

    @Test
    public void testNoMatches() {
        assertArrayContentsEqual(createList(new int[]{}),
                                 commonElementsInArray.getCommonElements(createList(new int[]{1, 2, 3}),
                                                                         createList(new int[]{4, 6, 5})));
    }

    @Test
    public void testNoLength() {
        assertArrayContentsEqual(createList(new int[]{}),
                                 commonElementsInArray.getCommonElements(createList(new int[]{}),
                                                                         createList(new int[]{})));
    }

    @Test
    public void testAllMatch() {
        assertArrayContentsEqual(createList(new int[]{3, 4, 5, 6}),
                                 commonElementsInArray.getCommonElements(createList(new int[]{6, 5, 4, 3}),
                                                                         createList(new int[]{3, 4, 5, 6})));
    }

    @Test
    public void testDifferentLengths() {
        assertArrayContentsEqual(createList(new int[]{3, 4, 5, 6}),
                                 commonElementsInArray.getCommonElements(createList(new int[]{6, 5, 4, 3, 50}),
                                                                         createList(
                                                                                 new int[]{3, 4, 5, 6, 20, 21, 22, 23})));
    }

    @Test
    public void testNoDuplicatesInOutput() {
        assertArrayContentsEqual(createList(new int[]{3, 4, 5, 6}),
                                 commonElementsInArray.getCommonElements(createList(new int[]{6, 5, 6, 6, 4, 3, 3, 50}),
                                                                         createList(
                                                                                 new int[]{3, 4, 5, 6, 20, 4, 21, 22, 23})));
    }

    private void assertArrayContentsEqual(Comparable[] lh, Comparable[] rh) {
        assertEquals(lh.length, rh.length);
        for (int i = 0; i < lh.length; i++) {
            assertEquals(lh[i], rh[i]);
        }
    }

    private Integer[] createList(int[] ints) {
        Integer[] result = new Integer[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = ints[i];
        }
        return result;

    }
}