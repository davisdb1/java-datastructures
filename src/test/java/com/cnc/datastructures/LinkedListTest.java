package com.cnc.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cnc.datastructures.LinkedList;

public class LinkedListTest {

   @Test
   public void addMany(){
      LinkedList<Integer> ll =  new LinkedList<Integer>();
      ll.add(1);
      ll.add(2);
      ll.add(3);
      ll.add(4);
      assertEquals(ll.getAtIndex(2), (Integer)3);
   }

   @Test
   public void removeAtIndex() {
      LinkedList<Integer> ll = new LinkedList<Integer>();
      ll.add(1);
      ll.add(2);
      ll.add(3);
      ll.add(4);
      ll.add(5);  // index at 4
      ll.add(6);
      
      // remove a middle
      if(ll.remove(4)){
         assertEquals((int)ll.getAtIndex(4),6);

         // remove the last
         if(ll.remove(4)){
            assertEquals(ll.getAtIndex(4),null);
         }
         // remove from front
         if(ll.remove(0)) {
            assertEquals((int)ll.getAtIndex(0),2);
         }
      }
      else
         fail();
   }

   @Test
   public void getAtBadIndexEmpty(){
      LinkedList<Integer> ll =  new LinkedList<Integer>();
      Integer result = ll.getAtIndex(5);
      assertEquals(result, null);
   }

   @Test
   public void getAtBadIndex(){
      LinkedList<Integer> ll =  new LinkedList<Integer>();
      ll.add(1);
      Integer result = ll.getAtIndex(5);
      assertEquals(result, null);
   }

   @Test
   public void getAtIndex(){
      LinkedList<Integer> ll =  new LinkedList<Integer>();
      ll.add(1);
      ll.add(2);
      ll.add(3);
      ll.add(4);
      ll.add(5);  // index at 4
      ll.add(6);
      Integer result = ll.getAtIndex(4);
      assertEquals((int) result, 5);
   }

   @Test
   public void reverseEmpty(){
      LinkedList<Integer> ll =  new LinkedList<Integer>();
      ll.reverse();
      assertEquals(ll.getAtIndex(0), null);
   }

   @Test
   public void reverseSingle(){
      LinkedList<Integer> ll =  new LinkedList<Integer>();
      ll.add(3);
      ll.reverse();
      Integer result = ll.getAtIndex(0);
      assertEquals(result, (Integer)3);
   }

   @Test
   public void reverseMultiple(){
      LinkedList<Integer> ll =  new LinkedList<Integer>();
      ll.add(1);
      ll.add(2);
      ll.add(3);
      ll.add(4);
      ll.add(5);
      ll.reverse();
      assertEquals(ll.getAtIndex(0), (Integer)5);
      assertEquals(ll.getAtIndex(1), (Integer)4);
      assertEquals(ll.getAtIndex(2), (Integer)3);
      assertEquals(ll.getAtIndex(3), (Integer)2);
      assertEquals(ll.getAtIndex(4), (Integer)1);
   }

}
