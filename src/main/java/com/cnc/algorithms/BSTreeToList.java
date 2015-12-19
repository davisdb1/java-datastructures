package com.cnc.algorithms;

import com.cnc.datastructures.Node;

public class BSTreeToList {


    /**
     * Write a method can convert a BS Tree to a list. The output list should be ordered and doubly linked.
     *
     * @param node root node of the tree to convers
     * @param <T> data type we are dealing with
     * @return the smallest element in the resultant linked list
     */
    public <T extends Comparable<T>> Node<T> changeToList(Node<T> node) {
        if(node == null) {
            return null;
        }
        TwoNodes<T> list = changeToListHelper(node);
        list.getSmallest().setPrev(list.getGreatest());
        list.getGreatest().setNext(list.getSmallest());
        return list.getSmallest();
    }
    static class TwoNodes <T extends Comparable<T>> {
        Node<T> smallest;
        Node<T> greatest;
        public TwoNodes() {}
        public Node<T> getSmallest() {
            return smallest;
        }
        public void setSmallest(Node<T> smallest) {
            this.smallest = smallest;
        }
        public Node<T> getGreatest() {
            return greatest;
        }
        public void setGreatest(Node<T> greatest) {
            this.greatest = greatest;
        }
    }
    
    private <T extends Comparable<T>> TwoNodes<T> changeToListHelper(Node<T> node) {

        TwoNodes<T> left = null, right = null, result = new TwoNodes<T>();
        if (node.getLeft() != null) {
            left = changeToListHelper(node.getLeft());
            left.getGreatest().setNext(node);
            node.setPrev(left.getGreatest());
        }
        if (node.getRight() != null) {
            right = changeToListHelper(node.getRight());
            right.getSmallest().setPrev(node);
            node.setNext(right.getSmallest());
        }

        if (right == null){
            result.setGreatest(node);
        }else{
            result.setGreatest(right.getGreatest());
        }

        if (left == null){
            result.setSmallest(node);
        }else{
            result.setSmallest(left.getSmallest());
        }
        return result;
    }


    /**
     * Solution 2 - only keeping track of the end of the list. No extra two nodes element needed.
     * @param root
     * @return
     */
    public <T extends Comparable<T>> Node<T> convertBSTtoList(Node<T> root){
        if(root == null){
            return null;
        }
        Node<T> starter = new Node<T>();
        inOrderTraverse(root, starter);
        Node<T> beginning = starter.getRight();
        Node<T> end = beginning;
        while(end.getNext() != null){
            end = end.getNext();
        }
        end.setNext(beginning);
        beginning.setPrev(end);
        
        return beginning;
    }

    private <T extends Comparable<T>> Node<T> inOrderTraverse(Node<T> n, Node<T> listEnd){
        if(n == null) return listEnd;
        listEnd = inOrderTraverse(n.getLeft(), listEnd);
        listEnd.setRight(n);
        n.setLeft(listEnd);
        listEnd = n;
        listEnd = inOrderTraverse(n.getRight(), listEnd);
        return listEnd;
    }
}
