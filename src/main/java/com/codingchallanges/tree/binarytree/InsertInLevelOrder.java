package com.codingchallanges.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertInLevelOrder {

    /*
     * Breadth First Search
     *
     * https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
     */
    public static void insertInLevelOrder(TreeNode<Integer> node, int n) {

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {

            node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            } else {
                node.left = new TreeNode<>(n);
                break;
            }

            if (node.right != null) {
                queue.add(node.right);
            } else {
                node.right = new TreeNode<>(n);
                break;
            }
        }
    }

}
