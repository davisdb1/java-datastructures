package com.cnc.datastructures;

public class Node<T> {
    private T data;
    private Node<T> next;  // or right
    private Node<T> prev;  // or left


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRight() {
        return next;
    }

    public void setRight(Node<T> right) {
        this.next = right;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getLeft() {
        return prev;
    }

    public void setLeft(Node<T> left) {
        this.prev = left;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

}
