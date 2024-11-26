package com.codingchallanges.tree.binarysearchtree;

import java.util.LinkedList;

/*

Facebook Coding interview
October 23, 2020

2. Find the longest increasing path in Binary Search Tree.
    * The path can begin from leaf node or non-lead node and end at leaf node or non-leaf node.
    * Example: In a Binary Search Tree with all node [1, 2, 3, 4, 5, 6, 7] the longest path would be 1 -> 2 -> 4 -> 6 -> 7

            4
         /     \
        2       6
      /   \   /   \
     1     3 5     7

My thoughts: this problem is slightly different from the regular once where the longest path is calculated from the root node.
 */
public class LongestIncreasingPath<T> {


    public static void main(String[] arg) {

        int[] bst = {1, 2, 3, 4, 5, 6, 7};

       longestIncreasingPath(bst);

    }

    private static void longestIncreasingPath(int[] nodes) {

        LinkedList<Integer> longestPath = new LinkedList<>();
//        longestPath.add(Integer.MAX_VALUE);

        longestIncreasingPath(nodes, 0, nodes.length-1, -1);

//        inorderTraversal(nodes, 0, nodes.length-1, longestPath);
//        postorderTraversal(nodes, 0, nodes.length-1, longestPath, true);

        System.out.println("longestPath = " + longestPath);
    }

    static LinkedList<Integer> longestPath = new LinkedList<>();

    private static LinkedList<Integer> longestIncreasingPath(int[] nodes, int left, int right, int prevalue) {

        if(left > right) return null;

        // process the root
        int mid = left + (right - left)/2;
        int root = nodes[mid];

        if(root < prevalue) return null;

        // Length of left child sequence + current node
        LinkedList<Integer> leftPath = longestIncreasingPath(nodes, left, mid - 1, root);
        if(leftPath != null) leftPath.addLast(root);

        // If the left child's value is not consecutive, reset left sequence length
        if(root < prevalue) {
            leftPath.clear();
            leftPath.add(root);
        }

        // Length of right child sequence + current node
        LinkedList<Integer> rightPath =  longestIncreasingPath(nodes, mid + 1, right, root);
        if(rightPath != null) rightPath.addLast(root);

        // If the right child's value is not consecutive, reset right sequence length
        if(root < prevalue) {
            rightPath.clear();
            rightPath.add(root);
        }

        // The maximum length of the consecutive sequence at the current node
        LinkedList<Integer> currentMax = leftPath.size() > rightPath.size() ? leftPath : rightPath;

        // Update the longest streak if the current max is greater
        longestPath = longestPath.size() > currentMax.size() ? longestPath : currentMax;

        return currentMax;
    }

    static LinkedList<Integer> leafNode = new LinkedList<Integer>();

    // Depth-first-search. Inorder: left > root > right
    private static void inorderTraversal(int[] nodes, int left, int right, LinkedList<Integer> path) {

        int mid = left + (right - left)/2;

        if(left > right) return;

        // Go to left
        inorderTraversal(nodes, left, mid - 1, path);

        // process the root
        int root = nodes[mid];

        path.add(root);

        // Is this a leaf node?
        if(left == right) {

            System.out.println("leafNode = " + leafNode);
            if(!leafNode.isEmpty() &&  root > leafNode.getLast())
                path.remove(leafNode.getLast());
            System.out.println("path = " + path);
            leafNode.add(root);
        }

        // Go to right
        inorderTraversal(nodes, mid + 1, right, path);
    }

    private static int prevalue = Integer.MIN_VALUE;

    // Depth-first-search
    private static void postorderTraversal(int[] nodes, int left, int right, LinkedList<Integer> path, boolean l) {

        int mid = left + (right - left)/2;

        if(left > right) return;

        // process the root
        int root = nodes[mid];

        // Go to left
        postorderTraversal(nodes, left, mid - 1, path, true);
        // Go to right
        postorderTraversal(nodes, mid + 1, right, path, false);

        if(l) {
            if(root < path.getLast()) {
                path.removeLast();
            }
        } else {
            if(root > path.getLast()) {
                path.removeLast();
            }
        }

        path.add(root);
        System.out.println("path = " + path);

    }

    
}
