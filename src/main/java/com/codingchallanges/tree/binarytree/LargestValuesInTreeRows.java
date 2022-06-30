package com.codingchallanges.tree.binarytree;

import java.util.*;

/*
 * largestValuesInTreeRows
 * 
 * https://app.codesignal.com/interview-practice/task/m9vC4ALaAeudkwRTF/description
 * 
 * You have a binary tree t. Your task is to find the largest value in each row of this tree. 
 * In a tree, a row is a set of nodes that have equal depth. For example, a row with depth 
 * 0 is a tree root, a row with depth 1 is composed of the root's children, etc.
 * 
 * Return an array in which the first element is the largest value in the row with depth 0, 
 * the second element is the largest value in the row with depth 1, the third element is 
 * the largest element in the row with depth 2, etc.
 *
 * Example
 * For
 * = {
    "value": -1,
    "left": {
        "value": 5,
        "left": null,
        "right": null
    },
    "right": {
        "value": 7,
        "left": null,
        "right": {
            "value": 1,
            "left": null,
            "right": null
        }
    }
}
 * the output should be solution(t) = [-1, 7, 1].
 *
 * The tree in the example looks like this:
 *  -1
   / \
  5   7
       \
        1
 *
 * In the row with depth 0, there is only one vertex - the root with value -1;
 * In the row with depth 1, there are two vertices with values 5 and 7, so the largest value here is 7;
 * In the row with depth 2, there is only one vertex with value 1.
 *
 */
public class LargestValuesInTreeRows {

	//My version: 100% test result after fixing a bug while storing "depth" of node.
	int[] largestValuesInTreeRows(TreeNode<Integer> t) {

		if(t == null) return new int[0];

		List<Integer> list = new ArrayList<>();

		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.add(t);

		Map<TreeNode<Integer>, Integer> depth = new HashMap<>();
		int previousLevel = 0;
		depth.put(t, previousLevel);

		TreeNode<Integer> node;
		int largestValue = Integer.MIN_VALUE;//largest value at root

		while(!q.isEmpty()){

			node = q.poll();

			int thisLevel = depth.get(node);

			if(thisLevel > previousLevel){//Depth will change here
				list.add(largestValue);//Set largest value of previous level
				previousLevel = depth.get(node);//Reset previous level
				largestValue = node.value;//First element of the new row
			}

			largestValue = Math.max(node.value, largestValue);

			if(node.left != null){
				q.add(node.left);
				depth.put(node.left, depth.get(node) + 1);
			}

			if(node.right != null){
				q.add(node.right);
				depth.put(node.right, depth.get(node) + 1);
			}
		}

		list.add(largestValue);//Largest value of previous (the last) level

		return list.stream().mapToInt(i -> i).toArray();
	}
	
	//Version 2: 100% tests results.
	//Credit: https://github.com/edyluisrey/Codefights-Algorithms
	int[] largestValuesInTreeRowsV2(TreeNode<Integer> t) {
	    
	    if(t==null) return new int[0];
	    
	    List<Integer> list = new ArrayList<>();
	    Queue<TreeNode<Integer>> q = new LinkedList<>();
	    q.offer(t);
	    
	    while(!q.isEmpty()){
	    	
	        int max=Integer.MIN_VALUE;
	        
	        int size= q.size();

			// Process all node at the current level. This removed the need for memorizing the level.
	        for(int i = 0; i< size; i++){
	        	
	        	TreeNode<Integer> tempNode= q.poll();

	            max = Math.max(max, tempNode != null ? tempNode.value : max);
	            
	            if((tempNode != null ? tempNode.left : null) != null) q.offer(tempNode.left);
	            if((tempNode != null ? tempNode.right : null) !=null) q.offer(tempNode.right);
	        }
	        list.add(max);
	    }
	   
	    return list.stream().mapToInt(i -> i).toArray();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
