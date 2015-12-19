package com.cnc.algorithms.strings;

import java.util.ArrayList;
import java.util.List;


/*
 * given a string, find all the permutations of the string
 * Example:
 * 
 * ABC
 * ACB
 * BAC
 * BCA
 * CAB
 * CBA
 * 
 * O(N!) 
 */
public class StringPermutations {
	public List<String> GetPermutations(String word){
		if(word.length() <= 1){
			List<String> res = new ArrayList<String>();
			res.add(word);
			return res;
		}
		
		// recursively call GetPermutations to start at the last char.
		// unwinding this method will introduce the chars one at a time
		List<String> permutations = GetPermutations(word.substring(1));
		
		// rotate the location of the perm char in all positions over the 
		// permutation string. do this for all permutations in the list
		int permLength = permutations.get(0).length();
      char permChar = word.charAt(0);
      List<String> result = new ArrayList<String>();
      
		for(String permutation : permutations){
			for(int i = 0; i <= permLength; i++){
					result.add(permutation.substring(0,i) + permChar + permutation.substring(i));
			}	
			
		}
		return result;
	}
	
	/**
	 * This is another way to do it that prints the strings instead of storing them
	 * Is way more memory efficient because it doesnt have to store anything
	 * @param str
	 */
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	
}
