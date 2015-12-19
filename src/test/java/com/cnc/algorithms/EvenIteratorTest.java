package com.cnc.algorithms;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Evan Harris
 */
public class EvenIteratorTest {

    @Test
    public void testHappyWithOddsAndEvens() {
        testIterator(new Integer[]{1,2,3,4,5,6,7,8,9,10}, new Integer[]{2,4,6,8,10});
    }

    @Test
    public void testWithOnlyOdds() {
       assertFalse(new EvenIterator<Integer>(buildIterator(new Integer[]{1,3,5,7,9})).hasNext());
    }

    @Test
    public void testHappyWithEvens() {
        testIterator(new Integer[]{2,4,6,8,10}, new Integer[]{2,4,6,8,10});
    }

    @Test
    public void testNextWithCallingHasNext() {
        Integer[] input = new Integer[]{2,4,6,8,10};
        Integer[] expectedOutput = new Integer[]{2,4,6,8,10};
        EvenIterator<Integer> evenIterator = new EvenIterator<Integer>(buildIterator(input));
        
        for(int i = 0; i < expectedOutput.length; i++){
            assertEquals(expectedOutput[i], evenIterator.next());
        }
        assertFalse(evenIterator.hasNext());
        
    }
    
    private void testIterator(Integer[] input, Integer[] expectedOutput){
        EvenIterator<Integer> evenIterator = new EvenIterator<Integer>(buildIterator(input));
        for(int i = 0; i < expectedOutput.length; i++){
            assertTrue(evenIterator.hasNext());
            assertEquals(expectedOutput[i], evenIterator.next());
        }
        assertFalse(evenIterator.hasNext());
    }
    
    
    private List<Integer> buildIterator(Integer[] ints){
        List<Integer> output = new LinkedList<Integer>();
        for(Integer currentInt : ints){
            output.add(currentInt);
        }
        return output;
    }
    
}