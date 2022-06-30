package com.codingchallanges.tree.binarytree;

/*
 * isSubtree
 * 
 * https://app.codesignal.com/interview-practice/task/mDpAJnDQkJqaYYsCg/description
 * 
 * (Compare with IdenticalTrees.java)
 * 
 * Given two binary trees t1 and t2, determine whether the second tree is a subtree of the first tree. 
 * A subtree for vertex v in a binary tree t is a tree consisting of v and all its descendants in t. 
 * Determine whether or not there is a vertex v (possibly none) in tree t1 such that a subtree for 
 * vertex v (possibly empty) in t1 equals t2.
 * 
 * Example 1:
       t1:             t2:
       5              10
      / \            /  \
    10   7          4    6
   /  \            / \    \
  4    6          1   2   -1
 / \    \
1   2   -1
 *
 * As you can see, t2 is a subtree of t1 (the vertex in t1 with value 10).
 * 
 * Example 2:
         t1:            t2:
         5             10
       /   \          /  \
     10     7        4    6
   /    \           / \    \
  4     6          1   2   -1
 / \   / 
1   2 -1
 *
 * As you can see, there is no vertex v such that the subtree of t1 for vertex v equals t2.
 */
public class IsSubtree {

	// This is more clean code with the exact same logic as Version 1
	boolean solution(TreeNode<Integer> t1, TreeNode<Integer> t2) {

		return isEquals(t1, t2) || t1 != null && (solution(t1.left, t2) || solution(t1.right, t2));

	}

	// Simply check if two trees are equal
	boolean isEquals(TreeNode<Integer> t1, TreeNode<Integer> t2){

		if(t1 == null && t2 == null) return true;

		return t1 != null && t2 != null
				&& t1.value.intValue() == t2.value.intValue()
				&& isEquals(t1.left, t2.left)
				&& isEquals(t1.right, t2.right);
	}

	// Version 1
	boolean solutionV1(TreeNode<Integer> t1, TreeNode<Integer> t2) {
	    
	    if(t1 == null && t2 == null) return true;
	    
	    if(t1 != null & t2 != null && t1.value.intValue() == t2.value.intValue()) 
	        return isEqualsV1(t1, t2);
	    else return t1 != null && (solution(t1.left, t2) || solution(t1.right, t2));
	}

	// Simply check if two trees are equal
	boolean isEqualsV1(TreeNode<Integer> subT1, TreeNode<Integer> t2){
	    
	    if(subT1 == null && t2 == null) return true;
	    
	    if(subT1 != null && t2 != null && subT1.value.intValue() == t2.value.intValue()) {
	        
	        if(isEqualsV1(subT1.left, t2.left))
	            return isEqualsV1(subT1.right, t2.right);
	        else 
	            return false; 
	        
	    } else {
	        return false;
	    }
	  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
