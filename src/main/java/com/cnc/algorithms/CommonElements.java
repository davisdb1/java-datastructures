/**
 * Copyright 2015 Expedia, Inc. All rights reserved. EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cnc.algorithms;

import java.util.Arrays;

/**
 * @author Evan Harris
 */
public class CommonElements {
    
    public static int[] getCommonElements(int[] a, int[] b){
        int[] output = new int[Math.min(a.length,b.length)];
        int outputIndex=0;
        if(a.length > 0 && b.length > 0){
            Arrays.sort(a);
            Arrays.sort(b);
            int i=0, j=0;
            while ( i < a.length && j < b.length ) {
                if (a[i] < b[j]) {
                    i++;
                } else if (a[i] > b[j]) {
                    j++;
                } else {
                    output[outputIndex++] = a[i];
                    j++;
                    i++;
                }
            }
        }
        return Arrays.copyOf(output, outputIndex);
    }
}
