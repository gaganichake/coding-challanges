package com.codingchallanges.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

/*
 * CTCI 11.8 (compare with CTCI 4.3)
 * This tree help in storing a sorted array as binary tree with properties of an array.
 * 
 * getRankOfNode() method returns the index of a node in the array
 *
 */
public class RankTreeNode {
	
	public int value;
	public RankTreeNode left;
	public RankTreeNode right;
	public int leftRank = 0;// Rank is equals the index in an array

	public RankTreeNode(int val) {
		this.value = val;
	}
	
	public void insertRankNode(int value) {

		insertRankNode(this, value);
	}
	
	private RankTreeNode insertRankNode(RankTreeNode root, int value) {
		
		RankTreeNode node = new RankTreeNode(value);
		
		if(root == null) return node;
		
		if(root.value >= value) {
			root.left = insertRankNode(root.left, value);
			root.leftRank++;
		} else {
			root.right = insertRankNode(root.right, value);
		}
		
		return root;
	}

	public int getRankOfNode(int value) {
		
		if(this.value == value) {
			return this.leftRank;
		} else if(value < this.value) {
			return this.left == null ? -1 : this.left.getRankOfNode(value);
		} else {
			int rightRank = this.right == null ? -1 : this.right.getRankOfNode(value);
			return rightRank == -1 ? -1 : this.leftRank + 1 + rightRank;
		}
	}
	
	public String getLevelOrder() {
		
		StringBuilder str = new StringBuilder();
		
		List<RankTreeNode> parent = new ArrayList<>();
		parent.add(this);
		
		while(!parent.isEmpty()) {
			
			List<RankTreeNode> list = new ArrayList<>();

			for(RankTreeNode node : parent) {
				
				str.append(node.value);
				str.append(" (");
				str.append(node.leftRank);
				str.append(") ");
				
				if(node.left != null) list.add(node.left);
				if(node.right != null) list.add(node.right);
			}
			str.append("\n");
			
			parent = list;
		}
		
		return str.toString();
	}

	public static void main(String[] arg) {

		RankTreeNode tree = new RankTreeNode(20);
		
		tree.insertRankNode(15);
		tree.insertRankNode(10);
		tree.insertRankNode(5);
		tree.insertRankNode(13);
		tree.insertRankNode(25);
		tree.insertRankNode(23);
		tree.insertRankNode(24);

		System.out.println("Print in Level Order");
		System.out.println(tree.getLevelOrder());
		System.out.println("Rank of 24: " + tree.getRankOfNode(24));
	}
}
