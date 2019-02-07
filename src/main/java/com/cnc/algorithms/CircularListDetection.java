package com.cnc.algorithms;

import com.cnc.datastructures.Node;

/**
 * http://powerfield-software.com/?p=203
 * <p>
 * Given a linked list, detect if the list is circular
 * If it is, find where the list becomes circualr
 *
 * @author Evan Harris
 */
public class CircularListDetection {


    public static boolean detectCircular(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head.getNext();
        Node slow = head;

        while (fast != slow && fast != null && slow != null) {
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast != null) {
                fast = fast.getNext();
            }
        }
        return fast == slow;
    }

    public static Node detectCircularAndGetInterception(Node head) {
        if (head == null) {
            return null;
        }

        Node fast = head.getNext();
        Node slow = head;

        Node meetingNode = null;
        while (fast != null && fast.getNext() != null) {
            if (fast == slow) {
                meetingNode = fast;
            }
            else {
                slow = slow.getNext();
                fast = fast.getNext();
                if (fast == null) {
                    return null;
                }
                else {
                    fast = fast.getNext();
                }
            }
        }
        if (meetingNode == null) {
            return null;
        }

        int circleLength = 1;
        fast = fast.getNext();
        while (fast != slow) {
            fast = fast.getNext();
            circleLength++;
        }

        //now that we have the circlelength, reset the pointers
        //and then find the interception
        fast = slow = head;
        for (int i = 0; i < circleLength; i++) {
            fast = fast.getNext();
        }
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return slow;
    }
}
