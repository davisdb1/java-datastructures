package com.cnc.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Evan Harris
 */
public class CommonElementsTest  {

    @Test
    public void testCommonHappy(){
        assertArrayContentsEqual(new int[]{1}, CommonElements.getCommonElements(new int[]{1,2,3}, new int[]{4,1,5}));
    }

    @Test
    public void testNoMatches(){
        assertArrayContentsEqual(new int[]{}, CommonElements.getCommonElements(new int[]{1, 2, 3}, new int[]{4, 6, 5}));
    }

    @Test
    public void testNoLength(){
        assertArrayContentsEqual(new int[]{}, CommonElements.getCommonElements(new int[]{}, new int[]{}));
    }
    @Test
    public void testAllMatch(){
        assertArrayContentsEqual(new int[]{3,4,5,6}, CommonElements.getCommonElements(new int[]{6,5,4,3}, new int[]{3,4,5,6}));
    }

    @Test
    public void testDifferentLengths(){
        assertArrayContentsEqual(new int[]{3,4,5,6}, CommonElements.getCommonElements(new int[]{6,5,4,3,50}, new int[]{3,4,5,6,20,21,22,23}));
    }
    
    private void assertArrayContentsEqual(int[] lh, int[] rh){
        assertEquals(lh.length, rh.length);
        for(int i = 0; i < lh.length; i++){
            assertEquals(lh[i], rh[i]);
        }
    }
}