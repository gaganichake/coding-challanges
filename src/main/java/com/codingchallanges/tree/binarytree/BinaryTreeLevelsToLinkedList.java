package com.codingchallanges.tree.binarytree;

import java.util.*;

/*
 * CTCI 4.4
 *
 * Given a binary tree, design an algorithm which created a linked list of all the nodes
 * at each depth. e.g., if you have a tree with depth D, you will have D linked lists.
 *
 * (All three methods below can also be used to print a tree in level order.)
 */
public class BinaryTreeLevelsToLinkedList {

	// My approach: BFS using Queue
	public static List<List<TreeNode<Integer>>> convertLevelsToLinkedList(TreeNode<Integer> root){

		List<List<TreeNode<Integer>>> listOfList = new ArrayList<>();
		Map<Integer, Integer> depth = new HashMap<>();
		Queue<TreeNode<Integer>> q = new LinkedList<>();

		if(root != null) {
			q.add(root);
		}

		int previous = 0;
		if (root != null) {
			depth.put(root.value, previous);
		}

		List<TreeNode<Integer>> list = null;

		while(!q.isEmpty()) {

			TreeNode<Integer> treeNode = q.remove();


			if(previous < depth.get(treeNode.value)) {

				previous = depth.get(treeNode.value);
				list = new LinkedList<>();
				list.add(treeNode);
				listOfList.add(list);

			} else {

				if(list == null) { // for root node
					list = new LinkedList<>();
					listOfList.add(list);
				}

				list.add(treeNode);
			}

			if(treeNode.left != null) {
				q.add(treeNode.left);
				depth.put(treeNode.left.value, depth.get(treeNode.value) + 1);
			}

			if(treeNode.right != null) {
				q.add(treeNode.right);
				depth.put(treeNode.right.value, depth.get(treeNode.value) + 1);
			}

		}

		return listOfList;
	}

	/*
	 * Alternative BFS approach by CTCI
	 *
	 * This solution does not use additional data structure to memorize the depth.
	 * Also, this solution will work even if any two nodes in the tree has same value
	 */
	public static List<List<TreeNode<Integer>>> convertLevelsToLinkedList2(TreeNode<Integer> root){

		List<List<TreeNode<Integer>>> listOfList = new ArrayList<>();

		//This list will serve the purpose of Queue
		List<TreeNode<Integer>> list = new ArrayList<>();//prepare first level

		if(root != null) {
			list.add(root);
		}

		while(list.size() > 0) {

			listOfList.add(list);//add previous (completed) level

			List<TreeNode<Integer>> parentList = list;

			list = new ArrayList<>();//prepare next level

			for(TreeNode<Integer> treeNode : parentList) {

				if(treeNode.left != null) {
					list.add(treeNode.left);
				}

				if(treeNode.right != null) {
					list.add(treeNode.right);
				}
			}
		}

		return listOfList;
	}


	/*
	 * Alternative DFS approach by CTCI
	 *
	 * DFS with pre-over traversal (Root-Left-Right)
	 *
	 */
	public static List<List<TreeNode<Integer>>> convertLevelsToLinkedListDFS(TreeNode<Integer> root){

		List<List<TreeNode<Integer>>> listOfList = new ArrayList<>();

		convertLevelsToLinkedListDFS(root, listOfList, 0);

		return listOfList;
	}

	// pre-over traversal (Root-Left-Right)
	private static void convertLevelsToLinkedListDFS(TreeNode<Integer> node, List<List<TreeNode<Integer>>> listOfList,
			int level) {

		if(node == null) return;


		List<TreeNode<Integer>> list;

		if(listOfList.size() == level) {//This level need to added to the list. First level is 0.
			list = new ArrayList<>();
			listOfList.add(list);
		} else {
			list = listOfList.get(level);
		}

		//root
		list.add(node);

		//left
		convertLevelsToLinkedListDFS(node.left, listOfList, level+1);

		//right
		convertLevelsToLinkedListDFS(node.right, listOfList, level+1);
	}

	public static void main(String[] args) {

		TreeNode<Integer> t = new TreeNode<>(0);
		t.left = new TreeNode<>(1);
		t.right = new TreeNode<>(2);
		t.right.right = new TreeNode<>(3);
		t.right.right.right = new TreeNode<>(4);
		PrintLevelOrder.printLevelOrder(t);

		List<List<TreeNode<Integer>>> listOfLinkedList = convertLevelsToLinkedList(t);
		System.out.println();

		for(List<TreeNode<Integer>> list : listOfLinkedList) {

			for(TreeNode<Integer> treeNode : list) {
				System.out.print(treeNode.value + " -> ");
			}
			System.out.println();
		}

	}

}
