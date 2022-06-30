package com.codingchallanges.graph;

import java.util.Arrays;

public class TestGraph {

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

		System.out.println("Distance from Node " + startNode + ": " + graph.shortedDistanceBFS(startNode));

		System.out.println("Distance from Node " + startNode + ": " + Arrays.toString(graph.shortedDistanceBFSArray(startNode)));

		System.out.println("Has path from 1 to 4? : " + graph.hasPath(new GraphNode(1), new GraphNode(4)));
	}
}
