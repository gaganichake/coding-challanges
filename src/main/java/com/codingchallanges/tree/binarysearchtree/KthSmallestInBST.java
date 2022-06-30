package com.codingchallanges.tree.binarysearchtree;

import com.codingchallanges.tree.binarytree.TreeNode;

import java.util.Stack;

/*
 * kthSmallestInBST
 *
 * https://app.codesignal.com/interview-practice/task/jAKLMWLu8ynBhYsv6/description
 * Note: Your solution should have only one BST traversal and O(1) extra space complexity, since this is what you will be asked to accomplish in an interview.
 *
 * Given a binary search tree t, find the kth smallest element in it.
 * int kthSmallestInBST(Tree<Integer> t, int k)
 *
 * Note that kth smallest element means kth element in increasing order.
 * Guaranteed constraints: 1 ≤ k ≤ tree size.
 */
public class KthSmallestInBST {

    int rank = 0;
    TreeNode<Integer> kth = null;

    // My solution: Due to recursive calls, the Space complexity is O(2^n). Passes 100% test cases.
    // However, the expected Space complexity is O(1). This has to be done without resursion.
    int kthSmallestInBST(TreeNode<Integer> t, int k) {

        inorderTraversal(t, k);

        return kth.value;
    }

    private void inorderTraversal(TreeNode<Integer> t, int k) {

        if (t == null) return;

        inorderTraversal(t.left, k);

        if (++rank == k) {
            kth = t;
            return;
        }

        inorderTraversal(t.right, k);
    }

    // Expected solution provide by other users. Space compexity is O(1)
    int solution(TreeNode<Integer> t, int k) {
        int visited = 0;
        Stack<TreeNode<Integer>> stack = new Stack<>();
        TreeNode<Integer> current = t;
        while (current != null || !stack.empty()) { // An iterative version on InOrder traversal
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (++visited == k) {
                    return current.value;
                }
                current = current.right;
            }
        }
        return Integer.MIN_VALUE;
    }

}
