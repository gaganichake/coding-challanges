package com.codingchallanges.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TraversePreOrder {

    public static List<Integer> preorderTraversal(TreeNode<Integer> node) {
        List<Integer> preorderList = new ArrayList<>();
        preorderTraversal(node, preorderList);
        return preorderList;
    }

    /*
     * Depth First Search
     *
     * Pre-order Traversal (Root-Left-Right)
     */
    public static void preorderTraversal(TreeNode<Integer> tree, List<Integer> list) {

        if (tree == null)
            return;
        list.add(tree.value);
        preorderTraversal(tree.left, list);
        preorderTraversal(tree.right, list);
    }

}
