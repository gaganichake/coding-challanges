package com.codingchallanges.tree.binarytree;

public class IsBalancedTree {

    /*
     * Is AVL Tree? - No. An AVL tree must be a Binary Search tree
     *
     * Balancing factor = Height(Left Sub Tree) - Height(Left Sub Tree) = {-1, 0, 1}
     *
     * When Balancing factor < 0, left-heavy
     * When Balancing factor > 0, right-heavy
     *
     * Implement a function to check if a binary tree is balanced. A balanced tree is
     * defined to be a tree such that the height of the two subtrees of any node never
     * differ by more than one. Such balances tree is called an AVL tree.
     *
     * An AVL tree is not necessarily to be Binary Search tree.
     *
     * CTCI 4.1
     */
    public static boolean isBalanced(TreeNode<Integer> tree) {

        if(tree == null) return true;

        if(Math.abs(tree.height(tree.left) -  tree.height(tree.right)) > 1)
            return false;
        else
            return isBalanced(tree.left) && isBalanced(tree.right);// each node must be balanced

    }
}
