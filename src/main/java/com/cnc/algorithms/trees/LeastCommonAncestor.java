package com.cnc.algorithms.trees;


import com.cnc.datastructures.Node;

public class LeastCommonAncestor {


    /**
     * You are given pointer to the root of the binary search tree. You are also given two values.
     *
     * Return the least common ancestor of the two values in the tree.
     *
     * Assumptions: val 1 != val 2
     *
     * Examples
     *
     *               5
     *             /  \
     *            3   7
     *
     *  Input : 3, 7
     *  Result : 5
     *
     *
     *              10
     *            /    \
     *           5     15
     *         /  \   /  \
     *       3    6  11  17
     *
     *  Input: 5, 6
     *  Result: 5
     *
     *  Input 11, 6
     *  Result: 10
     *
     */
    public <T extends Comparable> Node<T> findLeastCommonAncestor(Node<T> root, T value1, T value2) {
      if(root == null) {
          return null;
      }

      T smallerVal = (value1.compareTo(value2) < 0 ? value1 : value2);
      T largerVal = (value1.compareTo(value2) >= 0 ? value1 : value2);

      if(smallerVal.compareTo(root.getData()) > 0 && largerVal.compareTo(root.getData()) > 0) {
          return findLeastCommonAncestor(root.getRight(), value1, value2);
      }
      else if(smallerVal.compareTo(root.getData()) < 0 && largerVal.compareTo(root.getData()) < 0) {
          return findLeastCommonAncestor(root.getLeft(), value1, value2);
      }
      else if( (smallerVal.compareTo(root.getData()) == 0 && containsValueInTree(root.getRight(), largerVal)) ||
              (largerVal.compareTo(root.getData()) == 0 && containsValueInTree(root.getLeft(), smallerVal)) ||
              (containsValueInTree(root.getLeft(), smallerVal) && containsValueInTree(root.getRight(), largerVal))) {
          return root;
      }
      else {
          return null;
      }
    }

    private <T extends Comparable> boolean containsValueInTree(Node<T> root, T value) {
       if(root == null) {
           return false;
       }
       else if(value.compareTo(root.getData()) > 0) {
           return containsValueInTree(root.getRight(), value);
       }
       else if(value.compareTo(root.getData()) < 0) {
           return containsValueInTree(root.getLeft(), value);
       }
       else {
           return true;
       }
    }
}
