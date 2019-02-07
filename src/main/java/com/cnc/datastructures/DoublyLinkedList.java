package com.cnc.datastructures;

public class DoublyLinkedList<T extends Comparable> {

    public void swap(int leftIndex, int rightIndex) {
        Node<T> left = this.getNodeAtIndex(leftIndex);
        Node<T> right = this.getNodeAtIndex(rightIndex);

        Node<T> rightPrev = left.getPrev();
        Node<T> rightNext = left.getNext();
        Node<T> leftPrev = right.getPrev();
        Node<T> leftNext = right.getNext();

        if(left.getNext() == right) { //adjacent
            rightNext = left;
            leftPrev = right;
        }

        setPointers(rightPrev, right, rightNext);
        setPointers(leftPrev, left, leftNext);

        if(head == left) {
            head = right;
        }

        if(tail == right) {
            tail = left;
        }

    }

    private void setPointers(Node<T> prev, Node<T> current, Node<T> next) {
        current.setPrev(prev);
        current.setNext(next);
        if(prev != null){
            prev.setNext(current);
        }
        if(next != null) {
            next.setPrev(current);
        }
    }

    private Node<T> getNodeAtIndex(int index) {
        Node<T> curr = head;
        int currIndex = 0;
        while (curr != null) {
            if(currIndex == index) {
                return curr;
            }
            else {
                curr = curr.getNext();
                currIndex++;
            }
        }
        return null;
    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        Node<T> node = new Node<T>();
        node.setData(value);
        if (tail != null) {
            tail.setNext(node);
            node.setPrev(tail);
        }
        else {
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
                Node<T> nextNode = curr.getNext();
                prev.setNext(nextNode);
                nextNode.setPrev(prev);
                if (curr.getNext() == null) tail = prev;
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

    public T getAtIndex(int index) {
        Node<T> curr = head;
        int currIndex = 0;
        while (curr != null) {
            if (currIndex == index) {
                return curr.getData();
            }
            else {
                curr = curr.getNext();
                currIndex++;
            }
        }
        return null;
    }

    public void reverse() {
        if (head != null) {
            Node<T> curr = head;
            Node<T> prev = null;
            Node<T> tmp = tail;
            tail = head;
            head = tmp;
            while (curr != null) {
                tmp = curr.getNext();
                curr.setNext(prev);
                if (prev != null) prev.setPrev(curr);

                prev = curr;
                curr = tmp;
            }
            head.setPrev(null);
        }

    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
