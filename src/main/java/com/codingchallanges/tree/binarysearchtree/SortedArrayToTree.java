package com.codingchallanges.tree.binarysearchtree;

/* 
 * Sorted array to Binary Search Tree
 * 
 * CTCI 4.3
 * 
 * Give a sorted array (increasing order) with unique integer elements, write
 * an algorithm to create a binary search tree with minimal height.
 */
public class SortedArrayToTree {

	public static BalancedTreeNode sortedArrayToBST(int[] nums) {
		
		return SortedArrayToTree.sortedArrayToBST(nums, 0, nums.length-1);
	}
	
	// Considering left middle as root
	public static BalancedTreeNode sortedArrayToBST(int[] nums, int left, int right) {
		
		if(left > right) {
			return null;
		}
		
		int mid =  (left+right)/2;
		
		//pre-order (Root > Left > Right)
		BalancedTreeNode root = new BalancedTreeNode(nums[mid]);
		
		root.left = sortedArrayToBST(nums, left, mid-1);
		root.right = sortedArrayToBST(nums, mid+1, right);
		
		return root;
	}
	
	public static void main(String[] arg) {

		/*
		 * Binary Search Tree
		 * 
		 *           9
		 *         /   \
		 *        /     \
		 *       5       40
		 *      / \     /  \
		 *     1   8   39   41
		 */

		// Sorted Array
		int[] sortedArray = {1, 5, 8, 9, 39, 40, 41};
		
		BalancedTreeNode binarySearchTree = sortedArrayToBST(sortedArray);

		System.out.println("Print in Level Order");
		System.out.println(binarySearchTree);
	}
	
}
