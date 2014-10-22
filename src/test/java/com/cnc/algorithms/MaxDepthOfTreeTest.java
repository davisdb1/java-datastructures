package com.cnc.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cnc.datastructures.BSTree;
import com.cnc.datastructures.Node;

public class MaxDepthOfTreeTest {

	@Test
	public void NullTree(){
		assertEquals(0, MaxDepthOfTree.findMaxDepth(null));	
	}
	
	@Test
	public void SingleNode(){
		assertEquals(1, MaxDepthOfTree.findMaxDepth(new Node<Object>()));
	}
	
	
	@Test
	public void UnbalancedTree(){
		BSTree<Integer> tree = new BSTree<Integer>();
		
		tree.add(1);
		tree.add(0);
		tree.add(-1);
		
		assertEquals(3, MaxDepthOfTree.findMaxDepth(tree.getRoot()));
		
	}
	
	@Test
	public void BalancedTree(){
	BSTree<Integer> tree = new BSTree<Integer>();
		
		tree.add(1);
		tree.add(0);
		tree.add(2);
		
		assertEquals(2, MaxDepthOfTree.findMaxDepth(tree.getRoot()));
		
	}
}
