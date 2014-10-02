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
    public void medainSequential(){
        MedianFinder med = new MedianFinder();
        med.addNumber(1);
        med.addNumber(2);
        med.addNumber(3);
        med.addNumber(4);
        med.addNumber(5);
        int result = med.getMedian();
        assertEquals(result, 3);
    }
	
	   @Test
	    public void medainNonSequential(){
	        MedianFinder med = new MedianFinder();
	        med.addNumber(1);
	        med.addNumber(5);
	        med.addNumber(3);
	        med.addNumber(4);
	        med.addNumber(2);
	        int result = med.getMedian();
	        assertEquals(result, 3);
	    }
	    
	   
	   @Test
       public void medainLargeNumberDifference(){
           MedianFinder med = new MedianFinder();
           med.addNumber(100);
           med.addNumber(-100);
           med.addNumber(0);
           med.addNumber(30);
          
           int result = med.getMedian();
           assertEquals(result, 15);
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
