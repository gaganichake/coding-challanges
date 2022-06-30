package com.codingchallanges.tree.binarysearchtree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * https://en.wikipedia.org/wiki/Red–black_tree
 * 
 * Red-Black Tree
 * 
 * is a Binary Search tree.
 * is a balanced tree.
 * 
 * There are four properties of a Red-Black Tree:
 * 1. had either Red or Black nodes.
 * 2. The root and leaves (NIL) nodes are always black.
 * 3. If a node is red then its children are black.
 * 4. All paths from a node to its NIL descendants contain
 * the same number of black nodes.
 * 
 * Node requires one storage bit to keep track of color
 * The longest path is more than twice the length of the
 * shortest path (root to the nearest NIL).
 * - Shorted path: all black nodes
 * - Longest path: alternating red and black
 * 
 * Time Complexity: O(log n) - Search, Insert, Remove
 * Space complexity: O(n)
 * 
 * Time Complexity of rotation & coloring operations: O(1) - 
 */
public class RedBlackTree {
	
	public int value;
	public RedBlackTree left;
	public RedBlackTree right;
	public boolean color;//Red = true, Black = false;
	
	public RedBlackTree(int value) {
		this.color = true;//Default Red
		this.value = value;
	}
	
	public void setRed() {
		color = true;
	}
	
	public void setBlack() {
		color = false;
	}
	
	public boolean isRed() {
		return color;
	}
	
	public boolean isBlack() {
		return !color;
	}

	public boolean search(RedBlackTree node) {
		
		return false;
	}
	
	// Insert new node in tree
	public RedBlackTree insert(RedBlackTree node) {
		
		//Color it Red
		node.setRed();
		
		return insert(this, node); 
	}
	
	private RedBlackTree insert(RedBlackTree root, RedBlackTree node) {
		
		if(root ==  null) return node;
		
		if(root.value > node.value) {
			root.left = insert(root.left, node);
		} else if(root.value < node.value) {
			root.right = insert(root.right, node);
		}
		
		return root;
	}
	
	public boolean remove(RedBlackTree node) {
		
		return false;
	}
	
	/*
	 * Print tree
	 * Level-order Traversal (Root-Left-Right)
	 */
	public String toString() {

		StringBuilder output = new StringBuilder();
		RedBlackTree node = this;
		
		int previousLevel = 0;
		Map<Integer, Integer>  distances =  new HashMap<>();
		distances.put(node.value, 0);
		
		Queue<RedBlackTree> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {

			node = queue.poll();
			
			if(distances.get(node.value) > previousLevel) {
				output.append("\n");
				previousLevel = distances.get(node.value);
			}
			
			output.append(" ").append(node.value).append(" (").append(distances.get(node.value)).append(")");

			if (node.left != null) {
				queue.add(node.left);
				distances.put(node.left.value, distances.get(node.value)+1);
			}
				
			if (node.right != null) {
				queue.add(node.right);
				distances.put(node.right.value, distances.get(node.value)+1);
			}
				
		}
		return output.toString();
	}
	
	public static void main(String[] args) {

	}

}
