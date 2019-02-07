package com.cnc.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of positive, unique, sorted integers, output all pairs that differ by exactly K.
 *
 * @author Evan Harris
 */
public class ElementsDifferByK {

    public Map<Integer, Integer> getElementsThatDifferBy(Integer[] integers, Integer k) {

        if (integers == null || integers.length < 2) {
            throw new IllegalArgumentException("Invalid input array");
        }

        if (k <= 0) {
            throw new IllegalArgumentException("K must be greater than 0");
        }

        Map<Integer, Integer> response = new HashMap<>();
        for (int smallerIndex = 0, largerIndex = 1; largerIndex < integers.length; ) {
            int difference = integers[largerIndex] - integers[smallerIndex];
            if (difference < k) {
                largerIndex++;
            }
            else if (difference > k) {
                smallerIndex++;
            }
            else {
                response.put(integers[smallerIndex], integers[largerIndex]);
                largerIndex++;
                smallerIndex++;
            }
        }
        return response;
    }
}
