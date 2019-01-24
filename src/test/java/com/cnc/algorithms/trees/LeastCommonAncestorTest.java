package com.cnc.algorithms.trees;

import com.cnc.datastructures.BSTree;
import com.cnc.datastructures.Node;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeastCommonAncestorTest {

    private LeastCommonAncestor leastCommonAncestor = new LeastCommonAncestor();

    @Test
    public void testNullRoot() {
        buildTreeAndAssert(null, 1, 2, null);
    }

    @Test
    public void testNeitherValuesInTree() {
        buildTreeAndAssert(new int[]{1, 2, 3}, 4, 5,null);
    }

    @Test
    public void testSkipLevelFind() {
        buildTreeAndAssert(new int[]{5, 3, 4, 8, 7, 9}, 4, 8,5);
    }

    @Test
    public void testRootIsLeastCommon() {
        buildTreeAndAssert(new int[]{2, 1, 3}, 1, 3, 2);
    }

    @Test
    public void testSecondLevelOnLeftIsCommon() {
        buildTreeAndAssert(new int[]{5, 3, 7, 1, 4, 0, 2} , 1, 4, 3);
    }

    @Test
    public void testSecondLevelOnRightIsCommon() {
        buildTreeAndAssert(new int[]{5, 3, 7, 1, 4, 0, 2, 6, 8} , 6, 8, 7);
    }

    @Test
    public void testThirdLevel() {
        buildTreeAndAssert(new int[]{5, 3, 7, 1, 4, 0, 2} , 0, 2, 1);
    }

    @Test
    public void testSplitLevelOnLeft() {
        buildTreeAndAssert(new int[]{5, 3, 7, 1, 4, 0, 2} , 1, 3, 3);
    }


    @Test
    public void testSplitLevelOnRight() {
        buildTreeAndAssert(new int[]{5, 3, 7, 1, 4, 0, 2} , 5, 7, 5);
    }


    private void buildTreeAndAssert(int[] treeData, int value1, int value2, Integer expectedCommon) {
        BSTree<Integer> tree = new BSTree<>();
        if(treeData != null) {
            for(int element: treeData) {
                tree.add(element);
            }
        }

        tree.prettyPrint();
        Node<Integer> result = leastCommonAncestor.findLeastCommonAncestor(tree.getRoot(), value1, value2);

        if(expectedCommon == null) {
            assertNull(result);
        }
        else {
            assertEquals(expectedCommon, result.getData());
        }
    }
}