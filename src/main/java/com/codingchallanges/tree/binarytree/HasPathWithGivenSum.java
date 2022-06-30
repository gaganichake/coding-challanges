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
    public boolean hasPathWithGivenSum(TreeNode<Integer> t, int s) {

        if(t == null){
            return false;
        }

        return hasPathWithGivenSum(t, s, 0);
    }

    private boolean hasPathWithGivenSum(TreeNode<Integer> t, int s, int sum){
        //System.out.println("sums = " + sum);

        // if(t == null){
        //     return s == sum;
        // }

        if(t.left == null && t.right == null){ //left & right are null for a leaf node
            sum+=t.value;
            return sum == s; // Compare only at leaf node.
        }

        sum+=t.value;

//        boolean hasPathWithGivenSum = false;
//
//        if(t.left != null){
//            hasPathWithGivenSum = hasPathWithGivenSum(t.left, s, sum);
//        }
//        if(hasPathWithGivenSum == false && t.right != null){
//            return hasPathWithGivenSum(t.right, s, sum);
//        }
//        return hasPathWithGivenSum;

        // This is a clean code, compared to if-else
        return (t.left != null && hasPathWithGivenSum(t.left, s, sum)) || (t.right != null && hasPathWithGivenSum(t.right, s, sum));
    }
}
