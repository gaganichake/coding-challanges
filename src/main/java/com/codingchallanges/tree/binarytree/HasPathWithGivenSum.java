package com.codingchallanges.tree.binarytree;

public class HasPathWithGivenSum {

    /*
     * hasPathWithGivenSum
     *
     * https://app.codesignal.com/interview-practice/task/TG4tEMPnAc3PnzRCs/description
     *
     * Given a binary tree t and an integer s, determine whether there is a root to leaf
     * path in t such that the sum of vertex values equals s.
     */
    public boolean hasPathWithGivenSum(TreeNode<Integer> node, int s) {

        System.out.println("node = " + (node != null ? node.value : "null"));
        System.out.println("s = " + s);

        return node == null && s == 0
                || s > 0 && node != null && hasPathWithGivenSum(node.left, s-node.value)
                || s > 0 && node != null && hasPathWithGivenSum(node.right, s-node.value);

    }

    // Another approach with additional variable
    private boolean hasPathWithGivenSum(TreeNode<Integer> node, int s, int sum){

        if(node == null) return false;

        sum+=node.value;

        if(node.left == null && node.right == null){ //left & right are null for a leaf node
            return sum == s; // Compare only at leaf node.
        }

        return (node.left != null && hasPathWithGivenSum(node.left, s, sum))
                || (node.right != null && hasPathWithGivenSum(node.right, s, sum));
    }

}
