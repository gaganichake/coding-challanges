package com.codingchallanges.graph.dfs;

import com.codingchallanges.graph.Node;

import java.util.HashSet;
import java.util.Set;

public class HasPathDFS {
    /*
     * Check if there is a path exist from one Node to another Node.
     * Depth First Search - This is the easiest but NOT THE BEST WAY.
     * It is implemented via recursion.
     * It requires checking if the node was already visited in order to prevent infinite loop.
     */
    public boolean hasPathDFS(Node source, Node destination) {

        // You must use Set
        Set<Node> visited = new HashSet<>();

        return hasPathDFS(source, destination, visited);
    }

    // Time O(n)
    private boolean hasPathDFS(Node source, Node destination, Set<Node> visited) {

        // Reached at the destination
        if(source.getId() == destination.getId()) return true;

        if(!visited.contains(source)) {

            visited.add(source);

            for(Node child : source.getAdjacent()) {
                // Here we are processing the child recursively, hence it is a depth first search.
                if(hasPathDFS(child, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
