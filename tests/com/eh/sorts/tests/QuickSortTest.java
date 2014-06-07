package com.eh.sorts.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.eh.sorts.QuickSort;


public class QuickSortTest {

	
	@Test
	public void QuickTest(){
		Integer[] unsorted= new Integer[]{10,9,3,4};
		//QuickSort<Integer> sort = new QuickSort<Integer>();
		
		QuickSort.sort(0, unsorted.length - 1,unsorted); //Sort(0, unsorted.length - 1, unsorted);
		
		assertEquals(unsorted[0], (Integer)3);
		
	}
}
