package com.cnc.sorts;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class QuickSortTest {

    @Test
    public void quickTestHappy() {
        Integer[] unsorted = new Integer[]{10, 9, 3, 4};
        QuickSort.sort(0, unsorted.length - 1, unsorted);
        assertEquals(unsorted[0], (Integer) 3);
    }
}
