package com.eh.algorithms.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.eh.algorithms.StringPermutations;

public class StringPermutationsTest {

	
	@Test
	public void SingleChar(){
		StringPermutations perms = new StringPermutations();
		List<String> actual = perms.GetPermutations("a");
		assertEquals(actual.size(), 1);
	}
	
	
	@Test
	public void TwoChar(){
		StringPermutations perms = new StringPermutations();
		List<String> actual = perms.GetPermutations("ab");
		assertEquals(actual.size(), 2);
	}
	
	
	@Test
	public void ThreeChar(){
		StringPermutations perms = new StringPermutations();
		List<String> actual = perms.GetPermutations("abc");
		assertEquals(actual.size(), 6);
	}
	
}
