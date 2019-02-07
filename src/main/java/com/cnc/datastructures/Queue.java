package com.cnc.datastructures;

public class Queue<T> {

	// pull on the tail
	private Node tail;

	// push on the head
	private Node head;

	private int size = 0;

	public void push(T data){

		Node<T> newNode = new Node<T>();
		newNode.setData(data);
		if(size == 0){
			head = tail = newNode;
		}else{
			head.setPrev(newNode);
			newNode.setNext(head);
			head = newNode;
		}

		size++;
	}

	public T pop(){
		if(tail == null){
			return null;
		}else{
			Node<T> result = tail;
			tail = result.getPrev();
			if(tail != null){
				tail.setNext(null);
			}
			else {
				head = null;
			}
			size--;
			return result.getData();
		}
	}

	public int size() {
		return size;
	}

}
