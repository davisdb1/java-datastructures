package com.cnc.algorithms.strings;


import org.junit.Test;

public class NumberOfCharactersInStringTest {

    private NumberOfCharactersInString numberOfCharactersInString = new NumberOfCharactersInString();
    
    @Test
    public void testNumberOfCharactersHappy(){
        numberOfCharactersInString.printCharactersInString("FOO");
        numberOfCharactersInString.printCharactersInString("");
        numberOfCharactersInString.printCharactersInString(null);
        numberOfCharactersInString.printCharactersInString("12lk12");
        numberOfCharactersInString.printCharactersInString("12l\u2342k12");
    }
}