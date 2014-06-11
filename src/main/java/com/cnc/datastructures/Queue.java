package com.cnc.datastructures;

import com.cnc.datastructures.Node;

public class Queue<T> {
	private Node<T> tail;
	private Node<T> head;
	
	public void push(T data){
		Node<T> newNode = new Node<T>();
		newNode.setData(data);
		if(head == null){
			head = tail = newNode;
		}else{
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		}
	}
	
	public T pop(){
		if(tail == null){
			return null;
		}else{
			Node<T> result = tail;
			tail = result.getPrev();
			if(tail != null){
				tail.setPrev(null);
			}
			return result.getData();
		}
	}

}
