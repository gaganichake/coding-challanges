package com.codingchallanges.tree.binarytree;

public class IsBinarySearchTree {

    public static boolean isBinarySearchTree(TreeNode<Integer> node) {

        return isBinarySearchTree(node, Integer.MIN_VALUE);
    }

    // Using In-order traversal (Left-Root-Right)
    private static boolean isBinarySearchTree(TreeNode<Integer> node, int preValue) {

        if(node == null) return true;

        if(!isBinarySearchTree(node.left, preValue)) return false;

        if(node.value < preValue) return false;

        preValue = node.value;

        return isBinarySearchTree(node.right, preValue);
    }

}
