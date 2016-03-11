package com.cnc.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Evan Harris
 */
public class ReversePositiveIntegersTest {
    
    @Test
    public void testBasicReverse(){
        runTestCase(new int[]{1,2,3}, new int[]{3,2,1});
        runTestCase(new int[]{1,2,-3}, new int[]{2,1,-3});

        runTestCase(new int[]{-3,2,1}, new int[]{-3,1,2});
    }

    
    @Test
    public void testReverseWithPositiveAtEnd(){
        runTestCase(new int[]{1,2,-3, 4, 1, 2}, new int[]{2,1,-3, 2,1,4});
    }
    
    private ReversePositiveIntegers reversePositiveIntegers = new ReversePositiveIntegers();
    private void runTestCase(int[] input, int[] expectedOutput){
        reversePositiveIntegers.reversePositiveIntegers(input);

        System.out.println("Expected: " + Arrays.toString(expectedOutput));
        System.out.println("Actual:   " + Arrays.toString(input));
        Assert.assertArrayEquals(expectedOutput, input);
        
    }
}
