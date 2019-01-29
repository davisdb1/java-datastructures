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
        return Math.max(option1, option2);
    }

    /**
     * Memoize Approach
     *
     * Stores past searches so that we don't have to run the same search over and over again
     */
    static int maxSubsetSumMemoization(int[] arr) {

        //matrix storing previous searches
        //use the index memo[start][end] to store the results of a helper call with the corresponding arguments
        Integer[][] memo = new Integer[arr.length][];
        for(int i = 0; i < memo.length; i++)
            memo[i] = new Integer[arr.length];

        return maxSubsetSumMemoizationHelper(0, arr.length - 1, arr, memo);
    }

    private static int maxSubsetSumMemoizationHelper(int start, int end, int[] arr, Integer[][] memo) {

        //already searched it, just return the pre-computed result
        if(memo[start][end] != null) {
            return memo[start][end];
        }

        if(start == end) {
            return arr[start];
        }
        //Big lesson learned, 2 base cases
        //when the array is only 2 in length, return one or the other
        if(end - start == 1) {
            return Math.max(arr[start], arr[end]);
        }

        //option 1, choose yourself, and skip
        int option1 = arr[start] + maxSubsetSumMemoizationHelper(start + 2, end, arr, memo);
        //option 2, ignore your own value, keep going
        int option2 = maxSubsetSumMemoizationHelper(start + 1, end, arr, memo);
        return memo[start][end] = Math.max(option1, option2);
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
     * Now, lets start at the base case and work our way up
     *
     */
    static int maxSubsetSumBottomUp(int[] arr) {

        //matrix storing previous searches
        //use the index memo[start][end] to store the results of a helper call with the corresponding arguments
        Integer[][] memo = new Integer[arr.length][];
        for(int i = 0; i < memo.length; i++)
            memo[i] = new Integer[arr.length];

        for(int end = arr.length - 1; end >= 0; end--) {
            for (int start = end; start >= 0; start--) {
                if(start == end) {
                    memo[start][end] = arr[start];
                }
                //Big lesson learned, 2 base cases
                //when the array is only 2 in length, return one or the other
                else if(end - start == 1) {
                    memo[start][end] = Math.max(arr[start], arr[end]);
                }
                else {
                    //option 1, choose yourself, and skip
                    int option1 = arr[start] + memo[start + 2][end];
                    //option 2, ignore your own value, keep going
                    int option2 = memo[start + 1][end];
                    memo[start][end] = Math.max(option1, option2);
                }
            }
        }
        return memo[0][arr.length - 1];
    }

}
