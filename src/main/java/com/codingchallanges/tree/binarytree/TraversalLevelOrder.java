package com.codingchallanges.tree.binarytree;

import java.util.*;

public class TraversalLevelOrder<T>{

    /*
     * Breadth First Search
     *
     * Level Order Traversal using Queue
     *
     * https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
     *
     * traverseTree
     * https://app.codesignal.com/interview-practice/task/PhNPP45hZGNwpPchi/description
     *
     * Note: Try to solve this task without using recursion, since this is what you'll
     * be asked to do during an interview.
     *
     * Given a binary tree of integers t, return its node values in the following format:
     * The first element should be the value of the tree root;
     * The next elements should be the values of the nodes at height 1 (i.e. the root children), ordered from the leftmost to the rightmost one;
     * The elements after that should be the values of the nodes at height 2 (i.e. the children of the nodes at height 1) ordered in the same way;
     */
    public static List<Integer> traverseLevelOrder(TreeNode<Integer> t) {

        List<Integer> list = new ArrayList<>();

        if(t == null) return list;
        //if(t == null) return new int[0];//For codesignal problem

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(t);

        while (!queue.isEmpty()) {

            TreeNode<Integer> node = queue.poll();
            list.add(node.value);
//			System.out.print(node.value + " "); // Print for hackerrank problem

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

//        return list.stream().mapToInt(i -> i).toArray();//Covert to int[] For codesignal problem

        return list;
    }

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
    public void printLevelOrder(TreeNode<T> root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);

        int currentLevel = 1;
        Map<T, Integer> level = new HashMap<>();
        updateLevel(level, root, root);

        while (!queue.isEmpty()) {

            TreeNode<T> node = queue.poll();

            if (level.get(node.value) > currentLevel) {
                System.out.println();// Line break
                currentLevel = level.get(node.value);
            }
            System.out.print(" " + node.value);// A node should be processed only from the Queue

            if (node.left != null) {
                queue.add(node.left);
                updateLevel(level, node, node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
                updateLevel(level, node, node.right);
            }
        }
    }

    private void updateLevel(Map<T, Integer> level, TreeNode<T> parentNode, TreeNode<T> childNode){
        level.put(childNode.value, level.getOrDefault(parentNode.value, 0) + 1);
    }

    public static void main(String[] arg) {
        TreeNode<Character> node = new TreeNode<>('A');

        node.left = new TreeNode<>('B');
        node.right = new TreeNode<>('C');

        node.left.left = new TreeNode<>('D');
        node.left.right = new TreeNode<>('E');

        node.right.right = new TreeNode<>('F');

        TraversalLevelOrder<Character> printLevelOrder =  new TraversalLevelOrder<>();
        printLevelOrder.printLevelOrder(node);

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
