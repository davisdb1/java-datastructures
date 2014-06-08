package com.cnc.datastructures;

public class LinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public void add(T value){
		Node<T> node = new Node<T>();
		node.setData(value);
		if(tail != null){
			tail.setNext(node);
		}else{
			head = node;
		}
		tail = node;
	}
	
	public T getAtIndex(int index){
		Node<T> current = head;
		int currentIndex = 0;
		while(current != null){
			if(currentIndex == index){
				return current.getData();
			}else{
				current = current.getNext();
				currentIndex++;
			}
		}
		return null;
	}
	
	public void reverse(){
		if(head != null){
			Node<T> current = head;
			Node<T> prev = null;
			Node<T> tmp = tail;
			tail = head;
			head = tmp;
			while(current != null){
				tmp = current.getNext();
				current.setNext(prev);
				prev = current;
				current = tmp;
			}
		}
	}
}
