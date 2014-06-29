package com.cnc.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoublyLinkedListTest {

   @Test
   public void add() {
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
      dll.add(1);
      dll.add(2);
      dll.add(3);
      
      assertEquals(1, (int)dll.getHead().getData());
      assertEquals(2, (int)dll.getHead().getNext().getData());
      assertEquals(3, (int)dll.getHead().getNext().getNext().getData());
      assertEquals(null, dll.getHead().getNext().getNext().getNext());
      assertEquals(3, (int)dll.getTail().getData());
      assertEquals(2, (int)dll.getTail().getPrev().getData());
      assertEquals(1, (int)dll.getTail().getPrev().getPrev().getData());
      assertEquals(null, dll.getTail().getPrev().getPrev().getPrev());
   }
   
   @Test
   public void reverse() {
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
      dll.add(1);
      dll.add(2);
      dll.add(3);
      
      dll.reverse();
      
      assertEquals(3, (int)dll.getHead().getData());
      assertEquals(2, (int)dll.getHead().getNext().getData());
      assertEquals(1, (int)dll.getHead().getNext().getNext().getData());
      assertEquals(null, dll.getHead().getNext().getNext().getNext());
      assertEquals(1, (int)dll.getTail().getData());
      assertEquals(2, (int)dll.getTail().getPrev().getData());
      assertEquals(3, (int)dll.getTail().getPrev().getPrev().getData());
      assertEquals(null, dll.getTail().getPrev().getPrev().getPrev());
   }
   
   @Test
   public void getIndex() {
      DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
      dll.add(1); 
      dll.add(2);
      dll.add(3);
      dll.add(4);
      dll.add(5);
      
      assertEquals(1, (int)dll.getAtIndex(0));
      assertEquals(2, (int)dll.getAtIndex(1));
      assertEquals(3, (int)dll.getAtIndex(2));
      assertEquals(4, (int)dll.getAtIndex(3));
      assertEquals(5, (int)dll.getAtIndex(4));
      assertEquals(null, dll.getAtIndex(-1));
      assertEquals(null, dll.getAtIndex(5));
   }
}
