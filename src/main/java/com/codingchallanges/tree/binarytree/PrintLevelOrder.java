package com.codingchallanges.tree.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PrintLevelOrder {

    /*
     * Facebook interview question:
     *
     * Print out a binary tree level-by-level, each level on a separate line. Choose
     * an appropriate representation for the tree. Use the language of your choice.
     * Each value has a space between
     * Example:
     * Input Tree:
     *	    A
     *    /   \
     *   B     C
     *  / \     \
     * D   E     F
     *
     *
     *
     * Output:
     * A
     * B C
     * D E F
     *
     * Correct implementation:
     */
    public static void printLevelOrder(TreeNode<Integer> root) {

        Map<Integer, Integer> distances = new HashMap<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();

        if (root == null) {
            return;
        }

        q.add(root);
        distances.put(root.value, 0);// Root at level 0
        int previousLevel = 0;

        while (!q.isEmpty()) {

            TreeNode<Integer> node = q.poll();

            if (distances.get(node.value) > previousLevel) {
                System.out.println();// Line break
                previousLevel = distances.get(node.value);
            }
            System.out.print(" " + node.value);// A node should be processed only from Queue

            if (node.left != null) {
                q.add(node.left);
                distances.put(node.left.value, distances.get(node.value) + 1);
            }

            if (node.right != null) {
                q.add(node.right);
                distances.put(node.right.value, distances.get(node.value) + 1);
            }
        }
    }

    // This is what I coded during the interview.
//	public void printLevelOrder(Node root) {
//
//		Queue<Node> q = new LinkedList<>();
//
//		if (root == null) {
//			return;
//		}
//
//		System.out.print(root.val);
//
//		q.add(root);
//
//		while (!q.isEmpty()) {
//
//			Node node = q.poll();
//
//			if (node != null) {
//
//				System.out.println("");
//
//				if (node.left != null) {
//
//					System.out.print(node.left.val);
//					q.add(node.left);
//				}
//
//				if (node.right != null) {
//
//					System.out.print(" " + node.right.val);
//					q.add(node.right);
//				}
//			}
//		}
//	}
}
