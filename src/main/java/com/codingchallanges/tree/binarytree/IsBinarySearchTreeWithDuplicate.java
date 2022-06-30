package com.codingchallanges.tree.binarytree;

public class IsBinarySearchTreeWithDuplicate {

    /*
     * The previous isBinarySearchTree() algorithm assumes that the tree cannot have
     * duplicate values. The algorithm works in this case.
     *
     * However, a binary search tree must satisfy property: left <= parent < right
     * The following algorithm can keep track of left and right node
     */
    public static boolean isBinarySearchTreeWithDuplicate(TreeNode<Integer> node) {

        return isBinarySearchTreeWithDuplicate(node, null, null);
    }

    // Using Min/Max and pre-order traversal (Root-Left-Right)
    private static boolean isBinarySearchTreeWithDuplicate(TreeNode<Integer> node, Integer minValue, Integer maxValue) {

        if(node == null) return true;

        //root
        if((minValue != null && node.value <= minValue) || (maxValue != null && node.value > maxValue)) return false;

        //left
        if(!isBinarySearchTreeWithDuplicate(node.left, minValue, node.value)) return false;

        //right
        return isBinarySearchTreeWithDuplicate(node.right, node.value, maxValue);
    }

}
