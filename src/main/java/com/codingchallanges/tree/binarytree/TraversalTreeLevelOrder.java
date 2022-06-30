package com.codingchallanges.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class TraversalTreeLevelOrder {

    public static List<Integer> traverseLevelOrder(TreeNode<Integer> t) {

        List<Integer> list = new ArrayList<>();

        if(t == null) return list;
        //if(t == null) return new int[0];//For codesignal problem

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(t);

        while (!queue.isEmpty()) {

            TreeNode<Integer> node = queue.poll();
            list.add(node.value);
//			System.out.print(node.value + " "); // For hackerrank problem

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }

//        return list.stream().mapToInt(i -> i).toArray();//For codesignal problem

        return list;
    }
}
