package com.eh.datastructures.tests;

import static org.junit.Assert.*;


import org.junit.Test;

import com.eh.datastructures.*;
public class StackTest {

	@Test
	public void PopEmpty() {
		Stack<Integer> stack = new Stack<Integer>();
		Integer result = stack.pop();
		assertEquals(null, result);
		
	}
	
	@Test
	public void PushOne(){
		Stack<Integer> stack = new Stack<Integer>();
		Integer node = 2;
		stack.push(node);
		Integer result = stack.pop();
		assertEquals(node, result);
	}
	
	@Test
	public void PushMultiple(){
		Stack<Integer> stack = new Stack<Integer>();
		Integer node1 = 1;
		Integer node2 = 2;
		stack.push(node1);
		stack.push(node2);
		
		Integer result = stack.pop();
		
		assertEquals(node2, result);
		result = stack.pop();
		assertEquals(node1, result);
		
	}

}
