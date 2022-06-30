package com.codingchallanges.tree.binarytree;

import java.util.Objects;

public class IsSymmetricTree {

    /*
     * isTreeSymmetric
     *
     * https://app.codesignal.com/interview-practice/task/tXN6wQsTknDT6bNrf/description
     *
     * Given a binary tree t, determine whether it is symmetric around its center,
     * i.e. each side mirrors the other
     *
     * Also see boolean identicalTrees(TreeNode a, TreeNode b)
     */
    public boolean isTreeSymmetric(TreeNode<Integer> t) {

        return isTreeSymmetric(t, t);
    }

    private boolean isTreeSymmetric(TreeNode<Integer>  a, TreeNode<Integer>  b) {

        if(a == null && b == null) return true;

        if(a != null && b != null && Objects.equals(a.value, b.value)) {

            return (isTreeSymmetric(a.left, b.right) && isTreeSymmetric(a.right, b.left));

        } else {
            return false;
        }
    }

}
