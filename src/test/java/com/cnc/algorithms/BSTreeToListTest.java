package com.cnc.algorithms;

import org.junit.Test;

import com.cnc.datastructures.BSTree;
import com.cnc.datastructures.Node;

public class BSTreeToListTest {

   @Test
   public void test_BSTreeToList() {
      BSTreeToList bsTreeToList = new BSTreeToList();
      BSTree<Integer> bstree = new BSTree<Integer>();
      bstree.add(3);
      bstree.add(1);
      bstree.add(2);
      bstree.add(4);
      bstree.add(5);
      Node<Integer> root = bstree.getRoot();

      Node<Integer> listNode = bsTreeToList.changeToList(root);
      while (listNode != null) {
         System.out.println(listNode.getData());
         listNode = listNode.getNext();
      }
   }
}
