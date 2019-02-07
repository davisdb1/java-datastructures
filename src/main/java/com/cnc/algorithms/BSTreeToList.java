package com.cnc.algorithms;

import com.cnc.datastructures.Node;

public class BSTreeToList {


    /**
     * Write a method can convert a BS Tree to a list. The output list should be ordered and doubly linked.
     *
     * Technique only keeping track of the end of the list. No extra two nodes element needed.
     * @param root root node of the tree to convert
     * @param <T>  data type we are dealing with
     * @return the smallest element in the resultant linked list
     */
    public <T extends Comparable<T>> Node<T> convertBSTtoList(Node<T> root) {
        if (root == null) {
            return null;
        }
        Node<T> starter = new Node<T>();
        inOrderTraverse(root, starter);
        Node<T> beginning = starter.getRight();
        Node<T> end = beginning;
        while (end.getNext() != null) {
            end = end.getNext();
        }
        end.setNext(beginning);
        beginning.setPrev(end);

        return beginning;
    }

    private <T extends Comparable<T>> Node<T> inOrderTraverse(Node<T> n, Node<T> listEnd) {
        if (n == null) return listEnd;
        listEnd = inOrderTraverse(n.getLeft(), listEnd);
        listEnd.setRight(n);
        n.setLeft(listEnd);
        listEnd = n;
        listEnd = inOrderTraverse(n.getRight(), listEnd);
        return listEnd;
    }
}
