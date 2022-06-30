package com.codingchallanges.tree.binarytree;

public class SearchPreOrder {

    /*
     * Root, Left, Right
     */
    private void preorderSearch(TreeNode<Integer> node, int value) {

        if (node == null) return;

        if (node.value == value) return;

        preorderSearch(node.left, value);

        preorderSearch(node.right, value);

    }

}
