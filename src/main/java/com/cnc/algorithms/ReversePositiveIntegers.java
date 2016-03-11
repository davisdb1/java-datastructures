package com.cnc.algorithms;

/**
 * Given an array of integers, reverse the the order of positive integers contained in the array
 * 
 * 
 * if input 4 3 8 9 -2 6 10 13 -1 2 3
 * output   9 8 3 4 -2 13 10 6 -1 3 2
 * 
 * 
 * 
 * @author Evan Harris
 */
public class ReversePositiveIntegers {
    
    public void reversePositiveIntegers(int[] input){
        
        int firstPositiveIndex = -1;
        for(int i=0; i < input.length; i++) {
            
            //edge case for when we are at the end
            if(i == input.length - 1 && firstPositiveIndex >= 0) {
                reverse(input, firstPositiveIndex, i);
                
            }
            else if(firstPositiveIndex < 0 && input[i] > 0){ //fist positive number seen
                firstPositiveIndex = i;
            }
            else if(firstPositiveIndex > 0 && input[i] <= 0){//negative number seen and first positive number seen
                firstPositiveIndex = -1;
                reverse(input, firstPositiveIndex, i - 1);
            }
        }
    }
    
    
    private void reverse(int[] input, int startIndex, int endIndex){
        while(startIndex < endIndex){
            int tmp = input[startIndex];
            input[startIndex] = input[endIndex];
            input[endIndex] = tmp;
            endIndex--;
            startIndex++;
        }
    }
}
