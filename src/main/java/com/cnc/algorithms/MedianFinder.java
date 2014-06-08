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

		Node<Integer> current = root;
		Node<Integer> prev = null;
		while(current != null && current.getData() < value){
			prev = current;
			current = current.getNext();
		}
		if(prev == null){
			root = node;
		}else{
			if(current == null){
				prev.setNext(node);
			}else{
				node.setNext(current);
				prev.setNext(node);
			}
		}

		numberOfInserts++;
	}

	public int getMedian(){
		Node<Integer> current = root;
		for(int i = 1; i  < numberOfInserts / 2 ; i++){
			current = current.getNext();
		}
		if(current != null){
			return current.getData();
		}else{
			return -1;
		}
		
	}
}
