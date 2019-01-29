package com.cnc.algorithms.dynamicprogramming;

/**
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
 *
 */
public class MaxSumArray {

    /**
     *
     * Recursive approach
     *
     * Runs the same calculations over and over again
     */
    static int maxSubsetSumRecursive(int[] arr) {
        return maxSubsetSumRecursiveHelper(0, arr.length - 1, arr);
    }

    private static int maxSubsetSumRecursiveHelper(int start, int end, int[] arr) {
        if(start == end) {
            return arr[start];
        }
        if(end - start == 1) {
            return Math.max(arr[start], arr[end]);
        }

        //option 1, choose yourself, and skip
        int option1 = arr[start] + maxSubsetSumRecursiveHelper(start + 2, end, arr);
        //option 2, ignore your own value, keep going
        int option2 = maxSubsetSumRecursiveHelper(start + 1, end, arr);
        //option 3, just this number might be larger than any sum
        int option3 = arr[start];
        return Math.max(Math.max(option1, option2), option3);
    }


    /**
     *
     * Bottom up approach
     *
     * Same idea as Memoization, except we remove the need to do recursion.
     *
     * In the recursive approach we are starting at the beginning of the array and making it smaller for each
     * call in the call stack.
     *
     * Now, lets start at the smallest array length and work our way up
     *
     */
    static int maxSubsetSumBottomUp(int[] arr) {

        //matrix storing previous searches
        //use the index memo[start] to store the results of a previous run
        Integer[] memo = new Integer[arr.length];
        memo[0] = arr[0];
        //Trick here. When the array is only of length 2, the max is either of the values
        // because they can never be added
        memo[1] = Math.max(arr[1], memo[0]);
        for(int start = 2; start < arr.length; start++) {
            //option 1, choose yourself, and skip
            int option1 = arr[start] + memo[start - 2];
            //option 2, ignore your own value, use previus
            int option2 = memo[start - 1];
            //option 3, just this number might be larger than any sum
            int option3 = arr[start];
            memo[start] = Math.max(Math.max(option1, option2), option3);
        }
        return memo[arr.length - 1];
    }

}
