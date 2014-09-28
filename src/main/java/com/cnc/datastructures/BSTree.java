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
			int left = findDepthHelper(root.getLeft());
			int right = findDepthHelper(root.getRight());
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
				if(current.getLeft() == null){
					current.setLeft(nodeToInsert);
					return true;
				}else{
					current = current.getLeft();
				}
			}else{
				if(current.getRight() == null){
					current.setRight(nodeToInsert);
					return true;
				}else{
					current = current.getRight();
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
				current = current.getRight();
			}else{
				current = current.getLeft();
			}
		}
		return null;
	}
   public Node<T> getRoot() {
      return root;
   }
	
}
