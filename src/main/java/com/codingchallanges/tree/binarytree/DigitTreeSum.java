package com.codingchallanges.tree.binarytree;

/*
 * digitTreeSum
 * 
 * https://app.codesignal.com/interview-practice/task/2oxNWXTS8eWBzvnRB/description
 * 
 * We're going to store numbers in a tree. Each node in this tree will store a single digit (from 0 to 9), and each path from root to leaf encodes a non-negative integer.
 * 
 * Given a binary tree t, find the sum of all the numbers encoded in it.
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

	long digitTreeSum(TreeNode<Integer> t) {

		preorderTraversal(t, new StringBuffer());

		return total;
	}

	long total = 0L;

	// Parent -> Left child -> Right child (Depth First Search)
	private void preorderTraversal(TreeNode<Integer> t, StringBuffer encodedNumber) {

		if (t == null) {
			return;
		}

		// exit condition (leaf node)
		if (t.left == null && t.right == null) {
			encodedNumber.append(t.value);
			total += Long.parseLong(encodedNumber.toString());
			return;
		}

		// process data
		encodedNumber.append(t.value);

		// go to left
//		if (t.left == null) {
			// total += Long.valueOf(encodedNumber.toString()).longValue(); // Invalid
			// number. Elbow is not counted. The ending number must a leaf node.
//		} else {
			preorderTraversal(t.left, new StringBuffer(encodedNumber)); // Option 1
			// preorderTraversal(t.left, encodedNumber); // Option 2
			// encodedNumber.deleteCharAt(encodedNumber.length() - 1); // Option 2
//		}

		// go to right
//		if (t.right == null) {
			// total += Long.valueOf(encodedNumber.toString()).longValue(); / Invalid
			// number. Elbow is not counted. The ending number must a leaf node.
//		} else {
			preorderTraversal(t.right, new StringBuffer(encodedNumber)); // Option 1
			// preorderTraversal(t.right, encodedNumber); // Option 2
			// encodedNumber.deleteCharAt(encodedNumber.length() - 1); // Option 2
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
