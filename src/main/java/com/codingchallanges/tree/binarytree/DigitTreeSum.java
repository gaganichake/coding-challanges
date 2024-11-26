package com.codingchallanges.tree.binarytree;

/*
 * digitTreeSum
 * 
 * https://app.codesignal.com/interview-practice/task/2oxNWXTS8eWBzvnRB/description
 * 
 * We're going to store numbers in a tree. Each node in this tree will store a single digit (from 0 to 9), and each path from root to leaf encodes a non-negative integer.
 * 
 * Given a binary tree t, find the sum of all the numbers encoded in it.
 * (Elbow is not counted. The ending number must a leaf node.)
 *
 * Example 1:
 * 
 *    1
 *   / \
 *   0  4
 *  / \
 * 3   1 
 * Output: 218
 * 
 * There are 3 numbers encoded in this tree:
 * Path 1->0->3 encodes 103
 * Path 1->0->1 encodes 101
 * Path 1->4 encodes 14 and their sum is 103 + 101 + 14 = 218.
 * 
 * Example 2:
 * 
 *    0
 *   / \
 *  9   9
 *     / \
 *    1   3
 * Output: 193
 * 
 * 09 + 091 + 093 = 193
 * 
 */
public class DigitTreeSum {

	static long digitTreeSum(TreeNode<Integer> node) {

//		preorderTraversal(node, new StringBuffer());
//		return total;

		return digitTreeSum(node, "");
	}

	static long total = 0L;

	// Parent -> Left child -> Right child (Depth First Search)
	private static void preorderTraversal(TreeNode<Integer> node, StringBuffer encodedNumber) {

		if (node == null) {
			return;
		}

		// exit condition (leaf node)
		if (node.left == null && node.right == null) {
			encodedNumber.append(node.value);
			total += Long.parseLong(encodedNumber.toString());
			return;
		}

		// process data
		encodedNumber.append(node.value);

		preorderTraversal(node.left, new StringBuffer(encodedNumber));

		preorderTraversal(node.right, new StringBuffer(encodedNumber));

	}

	// Same approach without global variable 'total"
	static long digitTreeSum(TreeNode<Integer> node, String number) {

		if(node.left == null && node.right == null)  {
			System.out.println("number = " + number);
			return Long.valueOf(number + node.value);
		}

		return digitTreeSum(node.left, number + node.value)
				+ digitTreeSum(node.right, number + node.value);

	}

	public static void main(String[] args) {

		TreeNode<Integer> node1 = new TreeNode<>(1);
		node1.left = new TreeNode<>(0);
		node1.right = new TreeNode<>(4);
		node1.left.left = new TreeNode<>(3);
		node1.left.right = new TreeNode<>(1);

		TreeNode<Integer> node2 = new TreeNode<>(0);
		node2.left = new TreeNode<>(9);
		node2.right = new TreeNode<>(9);
		node2.right.left = new TreeNode<>(1);
		node2.right.right = new TreeNode<>(3);

		System.out.println("sum = " + digitTreeSum(node2));
	}

}
