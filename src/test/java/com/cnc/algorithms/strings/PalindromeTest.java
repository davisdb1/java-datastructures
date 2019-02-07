package com.cnc.algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void testHappy() {
        assertTrue(Palindrome.isPermutationAPalindrome("foo"));
        assertFalse(Palindrome.isPermutationAPalindrome("faoo"));
        assertTrue(Palindrome.isPermutationAPalindrome("f"));
        assertTrue(Palindrome.isPermutationAPalindrome(""));
        assertTrue(Palindrome.isPermutationAPalindrome(null));
    }

}