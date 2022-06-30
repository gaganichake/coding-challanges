package com.codingchallanges.tree.binarytree;

import java.util.Objects;

public class TreeToDoublyLinkedList {

	// Definition of a Doubly LinkedList
	private static TreeNode<Integer> head = null;
	private static TreeNode<Integer> tail = null;
	
	/*
	 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
	 * Note: This algorithm works for normal Binary Tree as well as Binary Search Tree 
	 * 
	 * Right Node as Next Node
	 * Left Node as Previous Node
	 */
	public static void treeToDoublyLinkedList(TreeNode<Integer> binarySearchTree) {
		
		if(binarySearchTree == null) {
			head = null;
			tail = null;
		}
		
		// Start a depth first search by assigning the smallest node of the tree to 
        // head node of the list and largest node of the tree to tail node of list.
		traversInorder(binarySearchTree);
		
        // At this position head and tail must not be null. If there is only one
        // Node in the tree, it should be assigned as both head and tail node of the list.
		head.left = tail;//left pointer is treaded as predecessor for LinkedList
		tail.right = head;//right pointer is treaded as successor for LinkedList
	}
	
	// Left -> parent -> Right
	private static void traversInorder(TreeNode<Integer> node) {
		
		if(node != null) {
			
			traversInorder(node.left);

			if(head == null) {//This condition will be true only once. Head should be updated only once.
				head = node;//This assignment will never change.
			} else {
				tail.right = node;//Link forward the tail node to the new node
				node.left = tail;//Link backward the new node to tail node
			}
			
			tail = node;//Make the new node as last one. Tail should be updated all time.
			
			traversInorder(node.right);
		}
		
	}
	public static void main(String[] args) {
		
		TreeNode<Integer> t = new TreeNode<>(0);
		t.left = new TreeNode<>(1);
		t.right = new TreeNode<>(2);
		t.right.right = new TreeNode<>(3);
		t.right.right.right = new TreeNode<>(4);
		PrintLevelOrder.printLevelOrder(t);
		System.out.println();
		
		treeToDoublyLinkedList(t);
		
		System.out.println("Print LinkedList");
		while(!Objects.equals(head.value, tail.value)) {
			
			System.out.print(head.value + " -> ");
			head = head.right;
		}
		System.out.print(tail.value);
	}

}
