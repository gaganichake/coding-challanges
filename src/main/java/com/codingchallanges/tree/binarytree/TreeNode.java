package com.codingchallanges.tree.binarytree;

import com.codingchallanges.tree.binarysearchtree.IsBinarySearchTree;

import java.util.List;
import java.util.function.BiFunction;

/*
 * https://www.youtube.com/watch?v=oSWTXtMglKE&t=138sI
 */
public class TreeNode<T> {

	public T value;
	public TreeNode<T> left;
	public TreeNode<T> right;

	public TreeNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	/*
	 * Size of a tree = Size of left subtree + 1 + Size of right subtree.
	 */
	private int size() {
		return size(this);
	}

	public int size(TreeNode<T> tree) {

		if (tree == null)
			return 0;
		else
			return (size(tree.left) + 1 + size(tree.right));
	}

	/*
	 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
	 * 
	 * The height of a binary tree is the number of levels between the tree's root
	 * and its farthest leaf inclusive.
	 * 
	 * The Height of binary tree with single node is 0. 
	 * 
	 * Height of the tree = Max of (Height of the left tree, Height of the
	 * right tree) + 1
	 */
	private Integer height() {
		return height(this);
	}

	public Integer height(TreeNode<T> tree) {

		if (tree == null)
			return -1;// Note: Return 0 if the question assumes the Height of binary tree with single node is taken as 1.

		return Math.max(height(tree.left), height(tree.right)) + 1;

	}

	// Find a Node with maximum value
	private TreeNode<T> findMax(BiFunction<T, T, Boolean> function) {
		return findMax(this, function);
	}

	/*
	 * Compare maximum of left subtree and maximum of right subtree with root node.
	 */
	public TreeNode<T> findMax(TreeNode<T> root, BiFunction<T, T, Boolean> function) {

		if (root == null)
			return null;

		if (root.left == null && root.right == null)
			return root;
		else
			return maxOf(maxOf(findMax(root.left, function), root, function), maxOf(findMax(root.right, function), root, function), function);
	}

	private TreeNode<T> maxOf(TreeNode<T> node1, TreeNode<T> node2, BiFunction<T, T, Boolean> function) {

		if (node1 == null && node2 == null)
			return null;
		else if (node1 == null)
			return node2;
		else if (node2 == null)
			return node1;
		else if (function.apply(node1.value, node2.value))
			return node1;
		else
			return node2;
	}

	// Find a Node with minimum value
	private TreeNode<T> findMin(BiFunction<T, T, Boolean> function) {
		return findMin(this, function);
	}

	/*
	 * Compare minimum of left subtree and minimum of right subtree with root node.
	 */
	private TreeNode<T> findMin(TreeNode<T> root, BiFunction<T, T, Boolean> function) {

		if (root == null)
			return null;

		if (root.left == null && root.right == null)
			return root;
		else
			return minOf(minOf(findMin(root.left, function), root, function), minOf(findMin(root.right, function), root, function), function);
	}

	private TreeNode<T> minOf(TreeNode<T> node1, TreeNode<T> node2, BiFunction<T, T, Boolean> function) {

		if (node1 == null && node2 == null)
			return null;
		else if (node1 == null)
			return node2;
		else if (node2 == null)
			return node1;
		else if (function.apply(node1.value, node2.value))
			return node1;
		else
			return node2;
	}


	public static void main(String[] args) {

		TreeNode<Integer> t = new TreeNode<>(0);
		t.left = new TreeNode<>(1);
		t.right = new TreeNode<>(2);
//		t.right.right = new TreeNode<>(3);
//		t.right.right.right = new TreeNode<>(4);
		TraversalLevelOrder<Integer> printLevelOrder =  new TraversalLevelOrder<>();
		printLevelOrder.printLevelOrder(t);
		System.out.println();
		System.out.println("Is Balanced = " + IsBalancedTree.isBalanced(t));
		
		System.out.println("Is Binary Tree (1) = " + IsBinarySearchTree.isBinarySearchTree(t));
		
		System.out.println("Is Binary Tree (2) = " + IsBinarySearchTreeWithDuplicate.isBinarySearchTreeWithDuplicate(t));
		TreeNode<Integer> binaryTree = new TreeNode<>(0);

		InsertInLevelOrder.insertInLevelOrder(binaryTree, 3);
		InsertInLevelOrder.insertInLevelOrder(binaryTree,9);
		InsertInLevelOrder.insertInLevelOrder(binaryTree,6);
		InsertInLevelOrder.insertInLevelOrder(binaryTree,5);
		InsertInLevelOrder.insertInLevelOrder(binaryTree,7);
		InsertInLevelOrder.insertInLevelOrder(binaryTree,9);
		InsertInLevelOrder.insertInLevelOrder(binaryTree,1);
		InsertInLevelOrder.insertInLevelOrder(binaryTree,10);

		System.out.println("Tree size = " + binaryTree.size());
		
		System.out.println("Tree height = " + binaryTree.height());
		
		TreeNode<Integer> max = binaryTree.findMax((x, y) -> x > y);

		if (max != null)
			System.out.println("Max value = " + max.value);
		else
			System.out.println("Invalid input NULL");

		TreeNode<Integer> min = binaryTree.findMin((x, y) -> x < y);

		if (min != null)
			System.out.println("Min value = " + min.value);
		else
			System.out.println("Invalid input NULL");
		
		List<Integer> output = TraversalLevelOrder.traverseLevelOrder(binaryTree);
		System.out.println("Level order" + output);

		System.out.println("Insert 8 at Level order");
		InsertInLevelOrder.insertInLevelOrder(binaryTree, 8);

		output = TraversalLevelOrder.traverseLevelOrder(binaryTree);
		System.out.println("Level order" + output);
		
		output = TraverseInOrder.inorderTraversal(binaryTree);
		System.out.println("Inorder" + output);
		
		output = TraversePostOrder.postorderTraversal(binaryTree);
		System.out.println("Postorder" + output);
		
		output = TraversePreOrder.preorderTraversal(binaryTree);
		System.out.println("Preorder" + output);
		
		output = TraversalLevelOrder.traverseLevelOrder(binaryTree);
		System.out.println("Level order" + output);
		
		System.out.println("Level order with line break");
		printLevelOrder.printLevelOrder(t);
		
		output = TraversalLevelOrder.traverseLevelOrder(binaryTree);
		System.out.println("\nBefore (Level order) " + output);

		int deleteValue = 3;
		System.out.println("Delete " +  deleteValue);
		boolean deleted = DeleteTreeNode.delete(binaryTree, deleteValue);

		System.out.println("Node " + deleteValue + " deleted ? : " + deleted);

		output = TraversalLevelOrder.traverseLevelOrder(binaryTree);
		System.out.println("After (Level order) " + output);
		
		TreeNode<Integer> t1 = new TreeNode<>(0);
		t1.left = new TreeNode<>(1);
		t1.left.left = new TreeNode<>(2);
		t1.left.right = new TreeNode<>(3);
		System.out.println("In-order " + TraverseInOrder.inorderTraversal(t1));
		
		TreeNode<Integer> t2 = new TreeNode<>(1);
		t2.left = new TreeNode<>(2);
		t2.right = new TreeNode<>(0);
		t2.right.left = new TreeNode<>(3);
		System.out.println("In-order " + TraverseInOrder.inorderTraversal(t2));
		
		System.out.println("Do Tree t1 and t2 has same in-order traversal: " + CompareInOrder.compareInorder(t1, t2));
	}

}
