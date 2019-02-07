package com.cnc.datastructures;

public class Stack<T extends Comparable> {

    private Node<T> head;
    private int length = 0;

    public void push(T value) {
        Node<T> node = new Node<T>();
        node.setData(value);
        node.setNext(head);
        length++;
        head = node;
    }

    public T pop() {
        Node<T> result = head;
        if (result != null) {
            length--;
            head = result.getNext();
            result.setNext(null);
            return result.getData();
        }
        else {
            return null;
        }

    }

    public int getLength() {
        return length;
    }
}
