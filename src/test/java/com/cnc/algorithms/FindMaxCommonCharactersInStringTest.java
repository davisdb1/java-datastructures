package com.cnc.algorithms;


import com.cnc.algorithms.dynamicprogramming.FindMaxCommonCharactersInString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindMaxCommonCharactersInStringTest {

    @Test
    public void happy() {
        runTest("adf3q9tuh429ub11111111111ojdngojengq", "kgmwrpgkm111111", "111111");
    }


    private void runTest(String a, String b, String expectedOutput) {
        assertEquals(expectedOutput, new FindMaxCommonCharactersInString().findMaxCommonCharactersInString(a, b));
    }

}