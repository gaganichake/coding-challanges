package com.codingchallanges.graph.bfs;

import com.codingchallanges.graph.Graph;
import com.codingchallanges.graph.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class HasPathBFS {

    /*
     * Check if there is a path exist from one Node to another Node.
     * Breadth First Search is the better way to find the shorted path.O
     * It can be implemented using iterative method or a queue.
     * Put all children of current node in a queue then
     * pick them one by one until the queue is empty.
     *
     * CTCI 4.2
     */
    public static boolean hasPathBFS(Node source, Node destination) {

        if(source.getId() == destination.getId()) return true;// Optional check for early exit

        Set<Integer> visited = new HashSet<>(); //Must track visited nodes to prevent infinite loop

        Queue<Node> queue = new LinkedList<>();
        queue.add(source);

        // Here we are visiting all children stored in a queue one by one, hence it is a breadth
        // first search.
        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if(node.getId() == destination.getId()) return true;//process the node

            // Add all adjacent Node to queue
            for(Node child : node.getAdjacent()) {
                // add only unvisited nodes
                if(!visited.contains(node.getId())) {
                    queue.add(child);// This appends new children at the end of the queue.
                }
            }

            visited.add(node.getId());

        }
        return false;
    }

    /*
     * [1, 2]
     * [1, 3]
     * [3, 4]
     */
    public static void main(String[] args) {

        int startNode = 1;
        int nodes = 5;
        int NumberOfEdges = 4;

        // A Matrix representation of graph
        int[][] edges = new int[NumberOfEdges][2];

        edges[0][0] = 1;
        edges[0][1] = 2;

        edges[1][0] = 1;
        edges[1][1] = 3;

        edges[2][0] = 3;
        edges[2][1] = 4;

        edges[3][0] = 1;
        edges[3][1] = 3;

        Graph graph = new Graph();

        // Add all give nodes to the graph
        for (int n = 1; n <= nodes; n++) {
            graph.addNode(n);
        }

        graph.addEdges(edges);

        System.out.println(graph);

        System.out.println("Has path from 1 to 4? : " + hasPathBFS(new Node(1), new Node(4)));
    }
}
