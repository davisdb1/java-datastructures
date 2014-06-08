package com.cnc.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cnc.algorithms.MedianFinder;

public class MedianFinderTest {

	
	@Test
	public void getMedianOfEmpty(){
		MedianFinder med = new MedianFinder();
		int result = med.getMedian();
		assertEquals(result, -1);
	}
	
	@Test
	public void medainOfOne(){
		MedianFinder med = new MedianFinder();
		med.addNumber(5);
		int result = med.getMedian();
		assertEquals(result, 5);
	}
	
	@Test
	public void medainOfOdd(){
		MedianFinder med = new MedianFinder();
		med.addNumber(5);
		int result = med.getMedian();
		assertEquals(result, 5);
	}
	
	@Test
	public void  multipleOfSameValue(){
		MedianFinder med = new MedianFinder();
		med.addNumber(6);
		med.addNumber(5);
		med.addNumber(5);
		med.addNumber(1);
		med.addNumber(2);
		med.addNumber(5);
		int result = med.getMedian();
		assertEquals(result, 5);
		
	}
}
