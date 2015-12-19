package com.cnc.algorithms;

import com.cnc.datastructures.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CircularListDetectionTest {
    
    @Test
    public void testHappy(){
        Node head = new Node();
        Node current = head;
        for(int i = 0; i < 4; i++){
            current.setNext(new Node());
            current = current.getNext();
        }
        current.setNext(head);
        assertTrue(CircularListDetection.detectCircular(head));
        current.setNext(null);
        assertFalse(CircularListDetection.detectCircular(head));
    }

    @Test
    public void testHappyListNotAllTheWayCircular(){
        Node<Integer> head = new Node<Integer>();
        Node current = head;
        head.setData(1);
        for(int i = 0; i < 14; i++){
            Node<Integer> node = new Node<Integer>();
            node.setData(i + 2);
            current.setNext(node);
            current = current.getNext();
        }
        Node tail = current;
        current = head;
        for(int i = 0; i < 5; i++){
            current = current.getNext();
        }
        tail.setNext(current);
        assertTrue(CircularListDetection.detectCircular(head));
        assertEquals(current, CircularListDetection.detectCircularAndGetInterception(head));
    }

}