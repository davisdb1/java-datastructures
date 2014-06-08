package com.cnc.datastructures;

public class BSTree<T extends Comparable<T>> {

	private Node<T> root;
	
	public int findDepth(){
		return findDepthHelper(root);
	}
	public int findDepthHelper(Node<T> root){
		if(root == null){
			return 0;
		}else{
			int left = findDepthHelper(root.getPrev());
			int right = findDepthHelper(root.getNext());
			return Math.max(left, right) + 1;
		}
	}
	
	public boolean add(T value){

		Node<T> current = root;
		Node<T> nodeToInsert = new Node<T>();
		nodeToInsert.setData(value);
		
		if(root == null){
			root = nodeToInsert;
			return true;
		}
		
		while(current != null){
			int compared = value.compareTo(current.getData());
			if(compared == 0 ){
				return false;
			}else if(compared < 0){
				if(current.getPrev() == null){
					current.setPrev(nodeToInsert);
					return true;
				}else{
					current = current.getPrev();
				}
			}else{
				if(current.getNext() == null){
					current.setNext(nodeToInsert);
					return true;
				}else{
					current = current.getNext();
				}
			}
		}
		return false;
	}

	public T find(T value){
		Node<T> current = root;
		int comparison;
		while(current != null){
			comparison = value.compareTo(current.getData());
			if(comparison == 0){
				return current.getData();
			}else if(comparison > 0){
				current = current.getNext();
			}else{
				current = current.getPrev();
			}
		}
		return null;
		
	}
}
