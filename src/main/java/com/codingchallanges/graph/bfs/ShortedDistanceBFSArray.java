package com.codingchallanges.graph.bfs;

import com.codingchallanges.graph.Graph;
import com.codingchallanges.graph.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static com.codingchallanges.graph.Graph.EDGE_LENGTH;

public class ShortedDistanceBFSArray {

    /*
     * This implementation is more suitable when you have implemented your Graph using Arrays.
     * Always use BFS for finding shorted path.
     * https://www.youtube.com/watch?v=0XgVhsMOcQM
     * https://www.hackerrank.com/challenges/bfsshortreach/problem
     */
    public static int[] shortedDistanceBFSArray(HashMap<Integer, Node> nodes, Node start) {

        int[] distances = new int[nodes.size() + 1];// Where Index id is equals to Node id. Ignoring Zero '0'.

        // Set the default distances to -1. This will ensure that unreachable nodes are also counted.
        Arrays.fill(distances, -1);

        Queue<Node> q = new LinkedList<>();

        distances[start.getId()] = 0;// Distance from self is 0
        q.add(start);

        while (!q.isEmpty()) {

            Node parent = q.poll();

            for (Node child : parent.getAdjacent()) {

                if (distances[child.getId()] == -1) {
                    distances[child.getId()] = distances[parent.getId()] + EDGE_LENGTH;
                    q.add(child);
                }
            }
        }
        return distances;
    }

    /*
     * [1, 2]
     * [1, 3]
     * [3, 4]
     */
    public static void main(String[] args) {

        Node startNode = new Node(1);
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

        System.out.println("Distance from Node " + startNode + ": " + Arrays.toString(shortedDistanceBFSArray(graph.getAllNodes(), startNode)));

    }
}
