package com.cnc.algorithms;

import java.util.ArrayList;
import java.util.List;


/*
 * given a string, find all the permutations of the string
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
	
}
