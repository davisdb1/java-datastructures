package com.cnc.algorithms;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Evan Harris
 */
public class ParenSyntaxCheckerTest extends TestCase {


    @Test
    public void testNullandEmpty() {
        assertTrue(ParenSyntaxChecker.isCorrectSyntax(null));
        assertTrue(ParenSyntaxChecker.isCorrectSyntax(""));
    }

    @Test
    public void testSingleChar() {
        assertTrue(ParenSyntaxChecker.isCorrectSyntax("."));
        assertFalse(ParenSyntaxChecker.isCorrectSyntax("}"));
    }

    @Test
    public void testTwoMatching() {
        assertTrue(ParenSyntaxChecker.isCorrectSyntax("{}"));
        assertTrue(ParenSyntaxChecker.isCorrectSyntax("<knojubvi>"));

    }

    @Test
    public void testTwoUnmatching() {
        assertFalse(ParenSyntaxChecker.isCorrectSyntax("foofoo{foofoo>ag"));
        assertTrue(ParenSyntaxChecker.isCorrectSyntax("gwrgwrhwrhr."));
    }

    @Test
    public void testNested() {
        assertTrue(ParenSyntaxChecker.isCorrectSyntax("foo{{<>}()}foobar"));
    }

}