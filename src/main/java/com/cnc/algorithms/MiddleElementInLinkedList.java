package com.cnc.algorithms;

import com.cnc.datastructures.Node;

/**
 * Find the middle element in a linked list
 * <p>
 * Things to consider:
 * <p>
 * not stepping off end of list with fast pointer
 * what happens on an even amount in list? round up or down
 * <p>
 * any error handling for a circular list? could this go on forever?
 *
 * @author Evan Harris
 */
public class MiddleElementInLinkedList {


    public static Node findMiddle(Node node) {

        if (node == null) {
            return null;
        }

        Node slow = node;
        Node fast = node;

        while (fast.getNext() != null && fast.getNext()
                                             .getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext()
                       .getNext();
        }

        return slow;
    }

    public static Node findMiddlePoorPerforming(Node node) {

        if (node == null) {
            return null;
        }

        int numberOfElements = 0;

        Node current = node;
        while (current != null) {
            numberOfElements++;
            current = current.getNext();
        }

        Node middle = node;
        int middleIndex = numberOfElements / 2;
        if (numberOfElements % 2 == 0 && numberOfElements > 0) {
            middleIndex--;
        }
        for (int i = 0; i < middleIndex; i++) {
            middle = middle.getNext();
        }

        return middle;
    }


}
