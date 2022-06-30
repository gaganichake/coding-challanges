package com.codingchallanges.tree.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class DeleteTreeNode {

    /*
     * 1. Use Level Order Traversal (Breadth First Search)
     *  to find a Node with key deleteValue and store it in
     *  a temp node - deleteNode.
     *
     * 2. Continue the traversal until the last node and
     *  store it in a temp node - deepestNode.
     *
     * 3. Replace the deleteNode with deepestNode.
     *
     * 4. Delete the deepestNode from the tree.
     */
    public static boolean delete(TreeNode<Integer> root, int value) {

//		if (root == null)
//			return false;

        if (root.left == null && root.right == null) {
            return root.value == value;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(root);

        TreeNode<Integer> deleteNode = null;
        TreeNode<Integer> deepestNode = null;

        while (!queue.isEmpty()) {

            deepestNode = queue.poll();

            if (deepestNode.value == value) {
                deleteNode = deepestNode;
            }
            if (deepestNode.left != null)
                queue.add(deepestNode.left);
            if (deepestNode.right != null)
                queue.add(deepestNode.right);
        }

        if (deleteNode != null) {
            deleteDeepestNode(root, deepestNode);
            deleteNode.value = deepestNode.value;
            return true;
        } else
            return false;

    }

    /*
     * Use Level Order Traversal (Breadth First Search) to find the deepest Node in
     * Tree then delete it from the Tree and return true/false. Preorder Traversal
     * (DFS )can also be used to find the deepest Node.
     */
    private static void deleteDeepestNode(TreeNode<Integer> tree, TreeNode<Integer> deepestNode) {

        if (tree == null)
            return;

        if (Objects.equals(tree.value, deepestNode.value)) {
            return;
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();

        queue.add(tree);

        while (!queue.isEmpty()) {

            TreeNode<Integer> node = queue.poll();

            if (node.left != null) {
                if (Objects.equals(node.left.value, deepestNode.value)) {
                    node.left = null;
                    return;
                }
                queue.add(node.left);
            }

            if (node.right != null) {
                if (Objects.equals(node.right.value, deepestNode.value)) {
                    node.right = null;
                    return;
                }
                queue.add(node.right);
            }
        }
    }

}
