package com.cnc.algorithms;

import org.junit.Test;

import com.cnc.datastructures.BSTree;
import com.cnc.datastructures.Node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BSTreeToListTest {

   @Test
   public void testBSTreeToListHappy() {
      BSTreeToList bsTreeToList = new BSTreeToList();
      BSTree<Integer> bstree = new BSTree<Integer>();
      bstree.add(3);
      bstree.add(1);
      bstree.add(2);
      bstree.add(4);
      bstree.add(5);
      Node<Integer> root = bstree.getRoot();

      Integer[] expected = new Integer[]{1,2,3,4,5};
      Node<Integer> headNode = bsTreeToList.changeToList(root);
      assertNotNull(headNode);
      Node<Integer> previous = null;
      Node<Integer> current = headNode;
      
      for(int i = 0; i <= expected.length; i++){
         if(previous != null && i > 0){
            assertEquals(expected[i - 1], previous.getData());
         }
         
         if(i < expected.length){
            assertNotNull(current);
            assertEquals(expected[i], current.getData());
            assertEquals(current.getNext().getPrev(), current);
            assertEquals(current.getPrev().getNext(), current);
           
         }
         
         if(i + 1 == expected.length){
            assertEquals(headNode, current.getNext());
            assertEquals(headNode.getPrev(), current);
         }

         previous = current;
         current = current.getNext();
      }
   }




   @Test
   public void testBSTreeToListHappyOtherSolution() {
      BSTreeToList bsTreeToList = new BSTreeToList();
      BSTree<Integer> bstree = new BSTree<Integer>();
      bstree.add(3);
      bstree.add(1);
      bstree.add(2);
      bstree.add(4);
      bstree.add(5);
      Node<Integer> root = bstree.getRoot();

      Integer[] expected = new Integer[]{1,2,3,4,5};
      Node<Integer> headNode = bsTreeToList.convertBSTtoList(root);
      assertNotNull(headNode);
      Node<Integer> previous = null;
      Node<Integer> current = headNode;

      for(int i = 0; i <= expected.length; i++){
         if(previous != null && i > 0){
            assertEquals(expected[i - 1], previous.getData());
         }

         if(i < expected.length){
            assertNotNull(current);
            assertEquals(expected[i], current.getData());
            assertEquals(current.getNext().getPrev(), current);
            assertEquals(current.getPrev().getNext(), current);

         }

         if(i + 1 == expected.length){
            assertEquals(headNode, current.getNext());
            assertEquals(headNode.getPrev(), current);
         }

         previous = current;
         current = current.getNext();
      }
   }
}
