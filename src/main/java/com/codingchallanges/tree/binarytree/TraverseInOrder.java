package com.codingchallanges.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TraverseInOrder {

    public static List<Integer> inorderTraversal(TreeNode<Integer> node) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(node, inorderList);
        return inorderList;
    }

    /*
     * Depth First Search
     *
     * In-order Traversal (Left-Root-Right)
     */
    public static void inorderTraversal(TreeNode<Integer> node, List<Integer> list) {

        if (node == null)
            return;
        inorderTraversal(node.left, list);
        list.add(node.value);
        inorderTraversal(node.right, list);

    }

}
