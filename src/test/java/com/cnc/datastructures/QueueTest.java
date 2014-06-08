package com.cnc.datastructures;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cnc.datastructures.Node;
import com.cnc.datastructures.Queue;


public class QueueTest {
	@Test
	public void PopEmpty() {
		Queue<Integer> stack = new Queue<Integer>();
		Node<Integer> result = stack.pop();
		assertEquals(null, result);
		
	}
	
	@Test
	public void PushOne(){
		Queue<Integer> stack = new Queue<Integer>();
		Node<Integer> node = new Node<Integer>();
		stack.push(node);
		Node<Integer> result = stack.pop();
		assertEquals(node, result);
	}
	
	@Test
	public void PushMultiple(){
		Queue<Integer> stack = new Queue<Integer>();
		Node<Integer> node1 = new Node<Integer>();
		Node<Integer> node2 = new Node<Integer>();
		stack.push(node1);
		stack.push(node2);
		
		Node<Integer> result = stack.pop();
		
		assertEquals(node1, result);
		result = stack.pop();
		assertEquals(node2, result);
		
	}
}
