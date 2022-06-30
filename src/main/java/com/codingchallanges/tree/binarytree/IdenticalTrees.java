package com.codingchallanges.tree.binarytree;

/*
 * https://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 * 
 * Also see boolean isTreeSymmetric(TreeNode t)
 */
public class IdenticalTrees {

	public static boolean isIdenticalTrees(TreeNode<Integer> a, TreeNode<Integer> b) {
		
		if(a == null && b == null) return true;
		
		if(a != null && b != null && a.value.equals(b.value)) {
			
			return isIdenticalTrees(a.left, b.left) && isIdenticalTrees(a.right, b.right);
			
		} else {
			return false;
		}
		
	}
	public static void main(String[] args) {
		
		TreeNode<Integer> root1 = new TreeNode<>(1);
        root1.left = new TreeNode<>(2);
        root1.right = new TreeNode<>(3);
        root1.left.left = new TreeNode<>(4);
        root1.left.right = new TreeNode<>(5);
  
        TreeNode<Integer> root2 = new TreeNode<>(1);
        root2.left = new TreeNode<>(2);
        root2.right = new TreeNode<>(3);
        root2.left.left = new TreeNode<>(4);
        root2.left.right = new TreeNode<>(5);
  
        if (isIdenticalTrees(root1, root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");

	}

}
