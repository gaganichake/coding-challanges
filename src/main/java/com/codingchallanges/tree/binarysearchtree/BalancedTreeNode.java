package com.codingchallanges.tree.binarysearchtree;

import com.codingchallanges.tree.binarytree.TreeNode;

import java.util.*;

public class BalancedTreeNode extends TreeNode<Integer> {

    public int balanceFactor;

    public BalancedTreeNode(Integer value) {
        super(value);
        this.balanceFactor = 0;
    }

    public static TreeNode<Integer> delete(TreeNode<Integer> node, Integer value) {

        if (node == null)
            return null;

        if (Objects.equals(node.value, value)) {
            if (node.left == null && node.right == null)
                return null;
            else if (node.right == null)
                return node.left;
            else if (node.left == null)
                return node.right;
            else {
                //In-order successor is the next greater element than root
                node.value = inorderSuccessor(node).value;//In-order successor is always right side, leftmost
                node.right = delete(node.right, node.value);
            }
        } else if (value < node.value)
            node.left = delete(node.left, value);
        else node.right = delete(node.right, value);
        return node;
    }

    public static TreeNode<Integer> inorderSuccessor(TreeNode<Integer> node) {

        if (node == null) return null;

        //Found right children -> return leftmost node of right subtree
        if (node.right != null) {
            return leftMostChild(node.right);
//        } else {
            //TODO CTCI 4.6
        }
        return null;
    }

    private static TreeNode<Integer> leftMostChild(TreeNode<Integer> node) {

        if (node == null) return null;

        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // The left most leaf of a BST is the smallest element of the tree.
    public Integer min(TreeNode<Integer> node) {

        while (node.left != null) {
            node = node.left;
        }

        return node.value;
    }

    private int height(BalancedTreeNode tree) {

        if (tree == null)
            return -1;// Note: Return 0 if the question assumes the Height of binary tree with single node is taken as 1.

        return Math.max(height((BalancedTreeNode) tree.left), height((BalancedTreeNode) tree.right)) + 1;

    }

    public int caclulateBalanceFactor(BalancedTreeNode tree) {

        if (tree == null) return 0;

        return height((BalancedTreeNode) tree.right) - height((BalancedTreeNode) tree.left);
    }

    public static void main(String[] arg) {

        /*
         * Binary Search Tree
         *
         *           9
         *         /   \
         *        /     \
         *       5       40
         *      / \     /  \
         *     1   8   39   41
         */

        // Sorted Array
        int[] sortedArray = {1, 5, 8, 9, 39, 40, 41};

        BalancedTreeNode binarySearchTree = SortedArrayToTree.sortedArrayToBST(sortedArray);

        System.out.println("Print in Level Order");
        System.out.println(binarySearchTree);

        System.out.println("Insert 99");
        binarySearchTree.insert(99);
        System.out.println(binarySearchTree);


        System.out.println("Delete 9");
        binarySearchTree.delete(9);
        System.out.println(binarySearchTree);

        System.out.println("Inorder traversal of BST always produces sorted output");
        System.out.println("Inorder: " + binarySearchTree.inorderTraversal());


        System.out.println("Min: " + binarySearchTree.min());
        System.out.println("Mix: " + binarySearchTree.max());

//		System.out.println("Serialize: " + binarySearchTree.serialize());
//		System.out.println("Deserialize: " + binarySearchTree.deserialize(binarySearchTree.serialize()));

    }

    public int getBalanceFactor() {
        return this.balanceFactor;
    }

    public void setBalanceFactor() {
        this.balanceFactor = caclulateBalanceFactor(this);
    }

    public boolean find(Integer val) {
        return find(this, val);
    }

    // Search is faster using pre-order traversal
    private boolean find(TreeNode<Integer> node, Integer val) {

        if (node == null) {
            return false;
        }

        if (Objects.equals(node.value, val)) {
            return true;
        } else if (val < node.value) {
            return find(node.left, val);
        } else {
            return find(node.right, val);
        }

    }

    /*
     * https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
     *
     * A new key is always inserted at leaf. We start searching a key from root until
     * we hit a leaf node. Once a leaf node is found, the new node is added as a
     * child of the leaf node.
     */
    public TreeNode<Integer> insert(Integer val) {

        return insert(this, val);
    }

    private TreeNode<Integer> insert(TreeNode<Integer> node, Integer value) {

        if (node == null) {
            return new BalancedTreeNode(value);
        }

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);

//		node.setBalanceFactor();

        return node;
    }

    /*
     * Search the value to be deleted by pre-order traversal. Search is faster using pre-order traversal.
     * When found replace it with it's Inorder Successor. Delete that Inoder Successor using same
     * algorithm.
     */
    public void delete(Integer value) {

        delete(this, value);

    }

    public Integer min() {

        return min(this);
    }

    public Integer max() {

        return max(this);
    }

    // The right most leaf of a BST is the greatest element of the tree.
    public Integer max(TreeNode<Integer> node) {

        while (node.right != null) {
            node = node.right;
        }

        return node.value;
    }

    public int height() {
        return height(this);
    }

    public boolean isBalanced() {
        return isBalanced(this);
    }

    /*
     * Is AVL Tree? - Yes
     *
     * Balancing factor = Height(Left Sub Tree) - Height(Left Sub Tree) = {-1, 0, 1}
     *
     * When Balancing factor < 0, left-heavy
     * When Balancing factor > 0, right-heavy
     *
     * Implement a function to check if a binary tree is balanced. A balanced tree is
     * defined to be a tree such that the height of the two subtrees of any node never
     * differ by more than one. Such balances tree is called an AVL tree.
     *
     * An AVL tree is not necessarily to be Binary Search tree.
     */
    public boolean isBalanced(TreeNode<Integer> tree) {

        if (tree == null) return true;

        if (Math.abs(height(tree.left) - height(tree.right)) > 1)
            return false;
        else
            return isBalanced(tree.left) && isBalanced(tree.right);// each node must be balanced

    }

    public List<Integer> inorderTraversal() {
        List<Integer> output = new ArrayList<>();
        inorderTraversal(this, output);
        return output;
    }

    /*
     * Depth First Search
     *
     * In-order Traversal (Left-Root-Right)
     */
    private void inorderTraversal(TreeNode<Integer> node, List<Integer> output) {

        if (node == null)
            return;
        inorderTraversal(node.left, output);
        output.add(node.value);
        inorderTraversal(node.right, output);

    }

    // Encodes a tree to a single string.
    // DFS - Preorder
    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    public String serialize() {
        return rserialize(this, "");
    }

    private String rserialize(TreeNode<Integer> root, String s) {

        if (root == null) {
            s += "null,";
            return s;
        }

        s += root.value + ",";
        s = rserialize(root.left, s);
        s = rserialize(root.right, s);

        return s;
    }

    // Decodes your encoded data to tree.
    // DFS - Preorder
    // https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    public BalancedTreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(arr));
        return rdeserialize(q);
    }

    private BalancedTreeNode rdeserialize(Queue<String> q) {

        if (q == null) return null;

        if (Objects.equals(q.peek(), "null")) {
            q.remove();
            return null;
        }

        BalancedTreeNode root = new BalancedTreeNode(Integer.valueOf(q.remove()));
        root.left = rdeserialize(q);
        root.right = rdeserialize(q);

        return root;
    }

    /*
     * Print tree
     * Level-order Traversal (Root-Left-Right)
     */
    public String toString() {

        StringBuilder output = new StringBuilder(" Level 0 -");
        TreeNode<Integer> node = this;

        int previousLevel = 0;
        Map<Object, Integer> distances = new HashMap<>();
        distances.put(node.value, 0);

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            node = queue.poll();

            if (distances.get(node.value) > previousLevel) {
                previousLevel = distances.get(node.value);
                output.append("\n Level ").append(previousLevel).append(" -");
            }

            output.append(" ").append(node.value).append(" (").append(balanceFactor).append(")");

            if (node.left != null) {
                queue.add(node.left);
                distances.put(node.left.value, distances.get(node.value) + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                distances.put(node.right.value, distances.get(node.value) + 1);
            }

        }
        return output.toString();
    }
}
