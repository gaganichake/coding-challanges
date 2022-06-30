package com.codingchallanges.tree.fb;
/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

public class PostorderTraversal {
	
	static class Node {
	    int data;
	    Node left;
	    Node right;
	}
	
	void postOrder(Node root) {
	    if (root != null) {
	        postOrder(root.left);
	        postOrder(root.right);
	        System.out.print(root.data + " ");
	    }
	}
}

