package com.cnc.algorithms;


import com.cnc.datastructures.Node;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MiddleElementInLinkedListTest {


    @Test
    public void testOddElements() {
        assertEquals(2, MiddleElementInLinkedList.findMiddle(getListOfSize(3))
                                                 .getData());
        assertEquals(2, MiddleElementInLinkedList.findMiddlePoorPerforming(getListOfSize(3))
                                                 .getData());
        assertEquals(11, MiddleElementInLinkedList.findMiddle(getListOfSize(21))
                                                  .getData());
        assertEquals(11, MiddleElementInLinkedList.findMiddlePoorPerforming(getListOfSize(21))
                                                  .getData());

    }

    @Test
    public void testSingleElement() {
        assertEquals(1, MiddleElementInLinkedList.findMiddle(getListOfSize(1))
                                                 .getData());
        assertEquals(1, MiddleElementInLinkedList.findMiddlePoorPerforming(getListOfSize(1))
                                                 .getData());
    }

    @Test
    public void testEvenElements() {
        assertEquals(5, MiddleElementInLinkedList.findMiddle(getListOfSize(10))
                                                 .getData());
        assertEquals(10, MiddleElementInLinkedList.findMiddle(getListOfSize(20))
                                                  .getData());

        assertEquals(5, MiddleElementInLinkedList.findMiddlePoorPerforming(getListOfSize(10))
                                                 .getData());
        assertEquals(10, MiddleElementInLinkedList.findMiddlePoorPerforming(getListOfSize(20))
                                                  .getData());

        assertEquals(11, MiddleElementInLinkedList.findMiddle(getListOfSize(22))
                                                  .getData());
        assertEquals(11, MiddleElementInLinkedList.findMiddlePoorPerforming(getListOfSize(22))
                                                  .getData());

    }

    @Test
    public void testNullList() {
        assertNull(MiddleElementInLinkedList.findMiddle(null));
        assertNull(MiddleElementInLinkedList.findMiddlePoorPerforming(null));
    }


    private Node getListOfSize(int size) {
        Node<Integer> head = new Node<>();
        head.setData(1);
        Node<Integer> current = head;
        for (int i = 2; i <= size; i++) {
            Node<Integer> next = new Node<>();
            next.setData(i);
            current.setNext(next);
            current = next;
        }
        return head;
    }

}