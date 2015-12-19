package com.cnc.algorithms;

import java.util.Arrays;

/**
 * Gets the common elements between two arrays. No duplicates are returned in the output
 * Runtime: O(n)
 * @author Evan Harris
 */
public class CommonElementsInArray<T extends Comparable<? super T>> {
    
    public  Comparable[] getCommonElements(T[] a, T[] b){
        Comparable[] output = new Comparable[Math.min(a.length,b.length)];
        int outputIndex=0;
        if(a.length > 0 && b.length > 0){
            Arrays.sort(a);
            Arrays.sort(b);
            int i=0, j=0;
            while ( i < a.length && j < b.length ) {
                if (a[i].compareTo(b[j]) < 0) {
                    i++;
                } else if (a[i].compareTo(b[j]) > 0) {
                    j++;
                } else {
                    Comparable added = output[outputIndex++] = a[i];
                    while(i < a.length
                            && j < b.length
                            && a[i] == b[j] 
                            && a[i] == added
                          ) {
                        j++;
                        i++;
                    }
                }
            }
        }
        return Arrays.copyOf(output, outputIndex);
    }
}
