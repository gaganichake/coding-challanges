package com.codingchallanges.graph.bfs;

import com.codingchallanges.graph.Graph;
import com.codingchallanges.graph.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static com.codingchallanges.graph.Graph.EDGE_LENGTH;

public class ShortedDistanceBFS {
    /*
     * Find shorted distance to all other node from the give node.
     * Always use Breadth First Search for finding shorted path.
     */
    public static Map<Integer, Integer> shortedDistanceBFS(HashMap<Integer, Node> nodes, Node startNode) {

        // Memorization technique
        // This map will also be used to keep track of visited node
        Map<Integer, Integer> distances = new HashMap<>();

        // Set the default distances to -1.
        // This will ensure that unreachable nodes (islands) are also counted.
        for (Integer node : nodes.keySet()) {
            distances.put(node, -1);
        }

        Queue<Node> q = new LinkedList<>();

        distances.put(startNode.getId(), 0);// Distance from self is 0
        q.add(startNode);

        while (!q.isEmpty()) {

            Node parent = q.poll();

            for (Node child : parent.getAdjacent()) {

                // This check insures that a distance calculated once will never be updated in
                // future and Breadth First Search ensures that a Node visited first time will
                // always have a shorted distance from the source. If the same node is visited again
                // it will have longer distance.
                if (distances.get(child.getId()) == -1) {
                    distances.put(child.getId(), distances.get(parent.getId()) + EDGE_LENGTH);
                    q.add(child);
                }
//				System.out.println(distances);
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

        System.out.println("Distance from Node " + startNode + ": " + shortedDistanceBFS(graph.getAllNodes(), startNode));
    }
}
