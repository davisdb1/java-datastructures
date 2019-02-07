package com.cnc.algorithms;

/**
 * Given an array of integers, reverse the order of positive integers contained in the array
 * <p>
 * <p>
 * if input 4 3 8 9 -2 6 10 13 -1 2 3
 * output   9 8 3 4 -2 13 10 6 -1 3 2
 *
 * @author Evan Harris
 */
public class ReversePositiveIntegers {


    public void reversePositiveIntegers(int[] input) {

        if (input == null || input.length < 2) {
            return;
        }

        int firstPositiveIndex = -1;
        for (int i = 0; i < input.length; i++) {
            //if at positive and index is unset
            if (input[i] > 0 && firstPositiveIndex < 0) {
                firstPositiveIndex = i;
            }

            //if at negative and positive index has been set
            if (input[i] <= 0 && firstPositiveIndex >= 0) {
                reverse(input, firstPositiveIndex, i - 1);
                firstPositiveIndex = -1;
            }

            //edge case for when we are at the end
            if (i == input.length - 1 && firstPositiveIndex >= 0) {
                reverse(input, firstPositiveIndex, i);
                firstPositiveIndex = -1;

            }
        }
    }


    private void reverse(int[] input, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int tmp = input[startIndex];
            input[startIndex] = input[endIndex];
            input[endIndex] = tmp;
            endIndex--;
            startIndex++;
        }
    }
}
