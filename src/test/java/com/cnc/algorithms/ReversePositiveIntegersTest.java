package com.cnc.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Evan Harris
 */
public class ReversePositiveIntegersTest {

    private ReversePositiveIntegers reversePositiveIntegers = new ReversePositiveIntegers();

    @Test
    public void testBasicReverseAllPositive() {
        runTestCase(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        runTestCase(new int[]{1, 2, -3}, new int[]{2, 1, -3});

        runTestCase(new int[]{-3, 2, 1}, new int[]{-3, 1, 2});
    }

    @Test
    public void testBasicReverseNegativeAtEnd() {
        runTestCase(new int[]{1, 2, 3}, new int[]{3, 2, 1});

        runTestCase(new int[]{-3, 2, 1}, new int[]{-3, 1, 2});
    }

    @Test
    public void testBasicReverseNegativeAtFront() {
        runTestCase(new int[]{-3, 2, 1}, new int[]{-3, 1, 2});
    }

    @Test
    public void worksWithNull() {
        runTestCase(null, null);
    }

    @Test
    public void sizeofOne() {
        runTestCase(new int[]{-3}, new int[]{-3});
    }

    @Test
    public void testReverseWithPositiveAtEnd() {
        runTestCase(new int[]{1, 2, -3, 4, 1, 2}, new int[]{2, 1, -3, 2, 1, 4});
    }

    private void runTestCase(int[] input, int[] expectedOutput) {
        reversePositiveIntegers.reversePositiveIntegers(input);

        System.out.println("Expected: " + Arrays.toString(expectedOutput));
        System.out.println("Actual:   " + Arrays.toString(input));
        Assert.assertArrayEquals(expectedOutput, input);

    }
}
