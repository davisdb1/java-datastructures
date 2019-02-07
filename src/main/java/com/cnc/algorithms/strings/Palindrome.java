/**
 * Copyright 2018 EXPEDIA, Inc. All rights reserved.
 * EXPEDIA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cnc.algorithms.strings;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    /**
     * TODO test
     *
     * Given a string, determine if any permutation of the string can be a made into a palindrome. That is,
     * reads the same forwards and backward.
     *
     * @param input the string to check
     * @return true if the string can be made into a palindrome, false if not.
     */
    public static boolean isPermutationAPalindrome(String input) {
        if(input == null || input.length() < 2) {
            return true;
        }

        Set<Character> unmatchedChars = new HashSet<>();

        for (char character : input.toCharArray()) {
            if (unmatchedChars.contains(character)) {
                unmatchedChars.remove(character);
            }
            else {
                unmatchedChars.add(character);
            }
        }

        return unmatchedChars.size() <= 1;
    }
}
