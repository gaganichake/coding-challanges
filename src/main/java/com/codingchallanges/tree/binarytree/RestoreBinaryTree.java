package com.codingchallanges.tree.binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * restoreBinaryTree
 * 
 * https://app.codesignal.com/interview-practice/task/AaWaYxi8gjtbqgp2M/solutions
 * 
 * Note: Your solution should have O(inorder.length) time complexity, since this is what you will be asked to accomplish in an interview.
 * 
 * Let's define inorder and preorder traversals of a binary tree as follows:
 * 
 * Inorder traversal first visits the left subtree, then the root, then its right subtree;
 * 
 * Preorder traversal first visits the root, then its left subtree, then its right subtree.
 * 
 * For example, if tree looks like this:
 * 
 *     1
 *   / \
 *  2   3
 * /   / \
 *4   5   6
 *
 * then the traversals will be as follows:
 * Inorder traversal: [4, 2, 1, 5, 3, 6]
 * Preorder traversal: [1, 2, 4, 3, 5, 6]
 *
 * Given the inorder and preorder traversals of a binary tree t, but not t itself, restore t and return it
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */

//Solution credit: https://medium.com/@harycane/construct-binary-tree-from-preorder-and-inorder-traversal-2b6797cd209d
public class RestoreBinaryTree {

	TreeNode<Integer> solution(int[] inorder, int[] preorder) {

		// Using list will improve time complexity of searching the index on a node
		List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());

		// printInorder(t);

		return buildTree(0, 0, inList.size() - 1, inList, preorder);
	}

	private TreeNode<Integer> buildTree(int preStart, int inStart, int inEnd, List<Integer> inList, int[] preorder) {

		if (inStart > inEnd || preStart >= preorder.length)
			return null;

		TreeNode<Integer> t = new TreeNode<>(preorder[preStart]);

		if (inStart == inEnd)
			return t;// t has no children

		int inIndex = inList.indexOf(t.value);

		t.left = buildTree(preStart + 1, inStart, inIndex - 1, inList, preorder);
		t.right = buildTree(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, inList, preorder);

		return t;
	}

	void printInorder(TreeNode<Integer> node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.value + " ");
		printInorder(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
