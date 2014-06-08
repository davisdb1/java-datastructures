package com.cnc.datastructures;

public class Queue<T> {
	private Node<T> tail;
	private Node<T> head;
	
	public void push(Node<T> node){
		if(head == null){
			head = tail = node;
		}else{
			head.setPrev(node);
			node.setNext(head);
			head = node;
		}
	}
	
	public Node<T> pop(){
		if(tail == null){
			return null;
		}else{
			Node<T> result = tail;
			tail = result.getPrev();
			if(tail != null){
				tail.setPrev(null);
			}
			return result;
		}
	}

}
