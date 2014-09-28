package com.cnc.algorithms;

import com.cnc.datastructures.Node;

public class BSTreeToList {

   static class TwoNodes <T extends Comparable<T>> { 
      Node<T> smallest;
      Node<T> greatest;
      public TwoNodes() {}
      public TwoNodes(Node<T> smallest, Node<T> greatest) {
         this.smallest = smallest;
         this.greatest = greatest;
      }
      public Node<T> getSmallest() {
         return smallest;
      }
      public void setSmallest(Node<T> smallest) {
         this.smallest = smallest;
      }
      public Node<T> getGreatest() {
         return greatest;
      }
      public void setGreatest(Node<T> greatest) {
         this.greatest = greatest;
      }
   }
   public <T extends Comparable<T>> Node<T> changeToList(Node<T> node) {
      return changeToListHelper(node).getSmallest();
   }
   private <T extends Comparable<T>> TwoNodes<T> changeToListHelper(Node<T> node) {
      if(node == null){
         return null;
      }

      TwoNodes<T> left = null, right = null, result = new TwoNodes<T>();
      if (node.getLeft() != null) {
         left = changeToListHelper(node.getLeft());
         left.getGreatest().setNext(node);
      }
      if (node.getRight() != null) {
         right = changeToListHelper(node.getRight());
         node.setNext(right.getSmallest());
      }
      
      if (right == null){
         result.setGreatest(node);
      }else{
         result.setGreatest(right.getGreatest());
      }
      
      if (left == null){
         result.setSmallest(node);
      }else{
         result.setSmallest(left.getSmallest());
      }
      return result;
   }   
}
