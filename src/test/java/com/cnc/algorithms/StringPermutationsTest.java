package com.cnc.algorithms;

import com.cnc.algorithms.strings.StringPermutations;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringPermutationsTest {


    @Test
    public void SingleChar() {
        StringPermutations perms = new StringPermutations();
        List<String> actual = perms.getPermutations("a");
        assertEquals(actual.size(), 1);
    }


    @Test
    public void TwoChar() {
        StringPermutations perms = new StringPermutations();
        List<String> actual = perms.getPermutations("ab");
        assertEquals(actual.size(), 2);
    }


    @Test
    public void ThreeChar() {
        StringPermutations perms = new StringPermutations();
        List<String> actual = perms.getPermutations("abc");
        assertEquals(actual.size(), 6);
    }

}
