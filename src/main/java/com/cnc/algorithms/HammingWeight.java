package com.cnc.algorithms;

/**
 * 8 bits representing the number 7 look like this:
 * 00000111
 * <p>
 * Find the number of "set bits" in an integer
 *
 * @author evharris
 */
public class HammingWeight {

    /**
     * F*cking magic
     * <p>
     * http://en.wikipedia.org/wiki/Hamming_weight
     *
     * @param i
     * @return the number of set bits in an integer
     * <p>
     * TODO: write unit test and figure out how this works!
     */
    int NumberOfSetBits(int i) {
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        return (((i + (i >> 4)) & 0x0F0F0F0F) * 0x01010101) >> 24;
    }


}
