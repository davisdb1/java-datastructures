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
	
	public boolean remove(int index) {
	   // no nodes
	   if (head == null) {
	      return false;
	   }
	   // for head node
	   if (index == 0) {
	      Node<T> tmp = head;
	      head = tmp.getNext();
	      tmp = null;
	      return true;
	   }
	   
	   // for the rest of the nodes
	   Node<T> prev = head;
      Node<T> curr = head.getNext(); 
	   int currIndex = 1;
	   while (curr != null) {
	      // remove the index
	      if (currIndex == index) {
	         prev.setNext(curr.getNext());
	         // if at the tail, set tail to previous
	         if (curr.getNext() == null)
	            tail = prev;
	         curr = null;
	         return true;
	      }
	      // not at the index, move forward
	      else {
	         currIndex++;
	         prev = curr;
	         curr = curr.getNext();
	      }
	   }
	   return false;
	}
	
	public T getAtIndex(int index){
		Node<T> curr = head;
		int currIndex = 0;
		while(curr != null){
			if(currIndex == index){
				return curr.getData();
			}else{
			   curr = curr.getNext();
			   currIndex++;
			}
		}
		return null;
	}
	
	public void reverse(){
		if(head != null){
			Node<T> curr = head;
			Node<T> prev = null;
			Node<T> tmp = tail;
			tail = head;
			head = tmp;
			while(curr != null){
				tmp = curr.getNext();
				curr.setNext(prev);
				prev = curr;
				curr = tmp;
			}
		}
	}
	
	/**
	 * Removes elements immediatly adjacent to parameter value.
	 * 
	 * Example list contains
	 * 1 2 3 4 5 6 7
	 * 
	 * when removeNeighbors(4) is called, result list should look like
	 * 1 2 4 6 7
	 * @param value The element whose neighbors to remove
	 */
	public void removeNeighbors(T value) {
		
	}
}
