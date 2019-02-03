package com.cnc.algorithms.dynamicprogramming;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Count the number of subsets that add up to 16
 *
 *
 * Example
 *
 *  [ 2, 4, 6, 10 ]
 *
 *  Questions to ask
 *
 *  Is the list sorted?
 *  Negative numbers?
 *
 *
 *  Answer
 *
 *  [ 10, 6]
 *  [ 10,4 ,2]
 *
 *  https://www.youtube.com/watch?v=nqlNzOcnCfs
 */
public class SetCount {


    /**
     * Recursive approach
     */
    static int numberOfSetsThatSumRecursive(int desiredSum, int[] array) {
        return numberOfSetsThatSumRecursiveHelper(desiredSum, array, 0, array.length - 1);

        List<Set<Integer>> connectedCities = new List<Set<Integer>>();
    }

    private static int numberOfSetsThatSumRecursiveHelper(int desiredSum, int[] array, int start, int end) {
        int subsetsFound = 0;
        if(array[start] == desiredSum) {
            subsetsFound++;
        }

        if(start < end) {
            //2 choices at each layer
            //choice 1 - not use current position in a set
            subsetsFound += numberOfSetsThatSumRecursiveHelper(desiredSum, array, start + 1, end);
            //choice 2 - use current position in a set
            int desiredLeftIfUsed = desiredSum - array[start];
            if(desiredLeftIfUsed > 0) {
                subsetsFound += numberOfSetsThatSumRecursiveHelper(desiredLeftIfUsed, array, start + 1, end);
            }
        }
        return subsetsFound;
    }



    static int numberOfSetsThatSumBottomUp(int desiredSum, int[] array) {

        //tracks how many subsets were seen at a previous length
        int[] memo = new int[array.length];
        memo[0] = array[0] == desiredSum;
        for (int start = 0; start < array.length; start++) {

        }

        return memo[array.length - 1];
    }
}
