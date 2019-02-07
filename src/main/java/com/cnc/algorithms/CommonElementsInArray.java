package com.cnc.algorithms;

import java.util.Arrays;

/**
 * Gets the common elements between two arrays. No duplicates are returned in the output
 * <p>
 * There are two primary approaches to complete this task, each one has its own benefits and drawbacks
 * <p>
 * 1. Sort arrays up front then iterate through. Assuming Avg case quickstort O(n log n) for sorting then O(n) for
 * iterating through the arrays. Data remains in place and does not need to be copied so this approach is easy
 * on memory
 * 2. Place elements from smallest array in a hashmap. Then iterate over the larger array and see if elements exist
 * in the map
 * <p>
 * This is the first approach which is easy on memory but a little more difficult for runtime
 * <p>
 * <p>
 * Runtime: O(n log n )
 *
 * @author Evan Harris
 */
public class CommonElementsInArray<T extends Comparable<? super T>> {

    public Comparable[] getCommonElements(T[] a, T[] b) {
        Comparable[] output = new Comparable[Math.min(a.length, b.length)];
        int outputIndex = 0;
        if (a.length > 0 && b.length > 0) {
            Arrays.sort(a);
            Arrays.sort(b);
            int i = 0, j = 0;
            while (i < a.length && j < b.length) {
                if (a[i].compareTo(b[j]) < 0) {
                    i++;
                }
                else if (a[i].compareTo(b[j]) > 0) {
                    j++;
                }
                else {
                    Comparable added = output[outputIndex++] = a[i];

                    //handles not printing duplicates by skipping over them
                    while (i < a.length && j < b.length && a[i] == b[j] && a[i] == added) {
                        j++;
                        i++;
                    }
                }
            }
        }
        return Arrays.copyOf(output, outputIndex);
    }
}
