package com.cnc.algorithms;

import junit.framework.TestCase;

/**
 * Created by evanharris on 2/21/16.
 */
public class DecentNumberFinderTest extends TestCase {

    private DecentNumberFinder decentNumberFinder = new DecentNumberFinder();

    public void testFindLargestDecentNumber() throws Exception {
        assertEquals("-1", decentNumberFinder.findLargestDecentNumber(2));
        assertEquals("555", decentNumberFinder.findLargestDecentNumber(3));
        assertEquals("33333", decentNumberFinder.findLargestDecentNumber(5));
        assertEquals("555555", decentNumberFinder.findLargestDecentNumber(6));
        assertEquals("55533333", decentNumberFinder.findLargestDecentNumber(8));
    }
}