package com.cnc.algorithms.dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaxSumArrayTest {

    @Test
    public void testOneValue(){
        run(new int[]{1}, 1);
        run(new int[]{10}, 10);
        run(new int[]{-10}, -10);
    }


    @Test
    public void testTwoValues(){
        run(new int[]{10, 20}, 20);
        run(new int[]{-1, 2}, 2);
    }

    @Test
    public void testMany() {
        run(new int[]{3, 7, 4, 6, 5}, 13);

        run(new int[]{1, 2, 3}, 4);
        run(new int[]{1, 2, 3, 4, 5}, 9);
        run(new int[]{1, 2, -30, 4, 5}, 7);



        run(new int[]{1, 2, -30, 4, 5, 5, 32, 1, 2, 3, 4, 5, 6, 7, 4, 3, 2}, 57);
    }


    private void run(int[] array, int expectedMax) {
        System.out.println("Testing array " + Arrays.toString(array));
        long startTime = System.nanoTime();
        int recursiveMax = MaxSumArray.maxSubsetSumRecursive(array);
        System.out.println("Time for recursive " + (System.nanoTime() - startTime) );
        assertEquals(expectedMax, recursiveMax);

        startTime = System.nanoTime();
        int memoizationMax = MaxSumArray.maxSubsetSumMemoization(array);
        System.out.println("Time for memoize " + (System.nanoTime() - startTime) );

        assertEquals(expectedMax, memoizationMax);

        startTime = System.nanoTime();
        int bottomUpMax = MaxSumArray.maxSubsetSumBottomUp(array);
        System.out.println("Time for bottom up " + (System.nanoTime() - startTime) );

        assertEquals(expectedMax, bottomUpMax);
    }
}