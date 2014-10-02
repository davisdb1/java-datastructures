package com.cnc.algorithms;

import com.cnc.datastructures.Node;

/*
 * Given a stream on integers, implement a class that can
 * find the median number in the stream
 * 
 */
public class MedianFinder {
	private Node<Integer> root;
	private int numberOfInserts = 0;
	
	public void addNumber(int value){
		Node<Integer> node = new Node<Integer>();
		node.setData(value);
		numberOfInserts++;
		if(root == null) {
		  root = node;
		  return;
		}
		
		Node<Integer> current = root;
		Node<Integer> prev = null;
	
		while(current != null && current.getData() < value){
			prev = current;
			current = current.getNext();
		}
		
		//insert at the beginnning
		if(prev == null) {
		  node.setNext(current);
		  root = node;
		}else {
		  //insert at middle/end
		  node.setNext(current);
		  prev.setNext( node );
		}
		
	}

	public int getMedian(){
		Node<Integer> current = root;
		Node<Integer> prev = root;
		
		for(int i = 1; i  <= numberOfInserts / 2 ; i++){
		    prev = current;
			current = current.getNext();
		}
		if(current != null) {
    		if(numberOfInserts % 2 == 1) {
    		  return current.getData();
    		}else {
    		  return (prev.getData() + current.getData()) / 2;
    		}
		}
		else
		{
          return -1;
		}
		
		
	}
}
