package com.codingchallanges.tree.binarysearchtree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/*
 *
 * AVL tree
 * - An AVL tree is a self-balancing binary search tree
 * - In an AVL tree, the heights of the two child subtrees of any node differ by at most one.
 * - If at any time they differ by more than one, rebalancing is done to restore this property.
 * - Lookup, insertion, and deletion all take O(log n) time in both the average and worst cases.
 * - Insertions and deletions may require the tree to be rebalanced by one or more tree rotations.
 *
 * https://en.wikipedia.org/wiki/AVL_tree
 * https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
 */
public class AVLTree {

	private BalancedTreeNode root;

	public AVLTree() {
		this.root = null;
	}

	public AVLTree(Integer rootValue) {
		this.root = new BalancedTreeNode(rootValue);
	}

	public boolean search(Integer value) {

		return this.root.find(value);
	}

	// Insert new node in tree
	public void insert(Integer value) {

		if(this.root == null) {
			this.root = new BalancedTreeNode(value);
		} else {
			this.root.insert(value);
		}

		rebalance(this.root);
	}

	private void rebalance(BalancedTreeNode node) {

		//Traverse level order, set balance factor and rebalance, again set balance factor
		//> +1 = rotate left
		//< -1 = rotate right

		if(node == null) return;

		Queue<BalancedTreeNode> q = new LinkedList<>();
		q.add(node);

		while(!q.isEmpty()) {

			node = q.poll();

			node.setBalanceFactor();

			if(node.balanceFactor < -1) {
				rotateRight(node.value);
				node.setBalanceFactor();
			}

			if(node.balanceFactor > 1) {
				rotateLeft(node.value);
				node.setBalanceFactor();
			}

			if(node.left != null) q.add((BalancedTreeNode) node.left);

			if(node.right != null) q.add((BalancedTreeNode) node.right);
		}

	}

	public void delete(Integer value) {

		if(this.root != null) {

			if(Objects.equals(this.root.value, value)) {
				BalancedTreeNode.delete(this.root, value);
			} else {
				this.root.delete(value);
			}
		}

		rebalance(this.root);
	}

	private void rotateRight(Integer value) {

		BalancedTreeNode parent = findParent(this.root, value);

		if(parent == null) {

			if(Objects.equals(this.root.value, value)) {
				this.root = rotateRight(this.root);
			}
			return;
		}

		if(parent.left != null && Objects.equals(parent.left.value, value)) {

			parent.left = rotateRight((BalancedTreeNode) parent.left);
			return;
		}

		if(parent.right != null && Objects.equals(parent.right.value, value)) {

			parent.right = rotateRight((BalancedTreeNode) parent.right);
		}
	}

	private void rotateLeft(Integer value) {

		BalancedTreeNode parent = findParent(this.root, value);

		if(parent == null) {

			if(Objects.equals(this.root.value, value)) {
				this.root = rotateLeft(this.root);
			}
			return;
		}

		if(parent.left != null && Objects.equals(parent.left.value, value)) {

			parent.left = rotateLeft((BalancedTreeNode) parent.left);
			return;
		}

		if(parent.right != null && Objects.equals(parent.right.value, value)) {

			parent.right = rotateLeft((BalancedTreeNode) parent.right);
		}
	}

	private BalancedTreeNode rotateRight(BalancedTreeNode node) {

		BalancedTreeNode parent = (BalancedTreeNode) node.left;

		node.left = parent.right;
		parent.right = node;

		return parent;
	}

	private BalancedTreeNode rotateLeft(BalancedTreeNode node) {

		BalancedTreeNode parent = (BalancedTreeNode) node.right;

		node.right = parent.left;
		parent.left = node;

		return parent;
	}

	private BalancedTreeNode findParent(BalancedTreeNode node, Integer value) {

		if(node == null || Objects.equals(node.value, value)) return null;

		//Find parent of value
		if(node.left != null && Objects.equals(node.left.value, value)) return node;

		if(node.right != null & Objects.equals(node.right != null ? node.right.value : null, value)) return node;

		if(node.left != null && node.right != null) {
			if(node.left.value > node.right.value) {
				return findParent((BalancedTreeNode) node.left, value);
			} else if(node.left.value < node.right.value) {
				return findParent((BalancedTreeNode) node.right, value);
			}
		}
		return null;
	}

	public static void main(String[] args) {

		AVLTree tree = new AVLTree();

		tree.insert(1);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(2);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(3);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(4);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(5);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(6);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(7);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(8);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(9);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(10);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(11);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(12);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(13);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(14);System.out.println(tree.root);System.out.println("______________________");
		tree.insert(15);System.out.println(tree.root);System.out.println("______________________");

//		System.out.println("Height of the tree: " + tree.root.height());

//		System.out.println(tree.root);

//		System.out.println("Rotated Right:");
//
//		tree.rotateRight(18);
//
//		System.out.println(tree.root);
//
//		System.out.println("Rotated Left:");
//
//		tree.rotateLeft(7);
//
//		System.out.println(tree.root);

//		System.out.println("Delete:");
//
//		tree.delete(10);
//
//		System.out.println(tree.root);

	}

}
