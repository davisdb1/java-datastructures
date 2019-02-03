package com.cnc.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetCountTest {

    @Test
    public void testSingle(){
        run(new int[]{1}, 1, 1);
        run(new int[]{1}, 0, 40);
        run(new int[]{50}, 1, 50);
    }

    @Test
    public void testTwo(){
        run(new int[]{1, 2}, 1, 2);
        run(new int[]{1, 2}, 1, 3);
        run(new int[]{1, 2}, 1, 1);
        run(new int[]{2, 2}, 1, 4);
    }



    private void run(int[] array, int expected, int sumToLookFor) {
        assertEquals(expected, SetCount.numberOfSetsThatSumRecursive(sumToLookFor, array));
    }

}