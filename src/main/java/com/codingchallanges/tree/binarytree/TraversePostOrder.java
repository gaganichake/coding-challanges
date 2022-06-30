package com.codingchallanges.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TraversePostOrder {

    public static List<Integer> postorderTraversal(TreeNode<Integer> node) {
        List<Integer> postorderList = new ArrayList<>();
        postorderTraversal(node, postorderList);
        return postorderList;
    }

    /*
     * Depth First Search
     *
     * Post-order Traversal (Left-Right-Root)
     */
    public static void postorderTraversal(TreeNode<Integer> tree, List<Integer> list) {

        if (tree == null)
            return;
        postorderTraversal(tree.left, list);
        postorderTraversal(tree.right, list);
        list.add(tree.value);
    }


}
