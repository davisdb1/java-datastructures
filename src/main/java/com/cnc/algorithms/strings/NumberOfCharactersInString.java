package com.cnc.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Things to think about:
 *
 * Do we have a supported character set? UTF-8 vs 26
 *  What order do we have to print them in?
 *
 * @author Evan Harris
 */
public class NumberOfCharactersInString {

    public void printCharactersInString(String input){
        if(input != null && !input.isEmpty()){
            Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
            for(char inputChar : input.toCharArray()){
                if(characterCount.containsKey(inputChar)){
                    characterCount.put(inputChar, characterCount.get(inputChar) + 1);
                }
                else {
                    characterCount.put(inputChar, 1);
                }
            }
            for(Character uniqueChar : characterCount.keySet()) {
                System.out.println(uniqueChar + ": " + characterCount.get(uniqueChar));
            }
        }
    }
}
