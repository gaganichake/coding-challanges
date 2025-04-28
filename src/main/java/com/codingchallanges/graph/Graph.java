package com.codingchallanges.graph;

import java.util.HashMap;
import java.util.LinkedList;

/*
 * https://www.youtube.com/watch?v=zaBhtODEL0w
 */
public class Graph {

	public static final int EDGE_LENGTH = 6;

	// A HashMap representation of this graph.
	private final HashMap<Integer, Node> nodes = new HashMap<>();

	public HashMap<Integer, Node> getAllNodes() {
		return nodes;
	}

	// Retrieve a Node from Graph
	public Node getNode(int id) {
		return nodes.get(id);
	}

	// Add a Node to the Graph
	public Node addNode(int id) {

		return nodes.getOrDefault(id, new Node(id));
	}

	// Add an Edge between two Nodes
	public void addEdge(int source, int destination) {
		//Connect nodes
		addNode(source).getAdjacent().add(addNode(destination));
	}

	// Converting Array representation of Graph to HashMap representation of Graph
	public void addEdges(int[][] edges) {

		for (int[] edge : edges) {
			int source = edge[0];
			int destination = edge[1];
			addEdge(source, destination);
		}
	}

	// Print the Graph
	public String toString() {

		StringBuilder txt = new StringBuilder();

		for (Integer sourceKey : nodes.keySet()) {

			Node sourceNode = nodes.get(sourceKey);

			txt.append(sourceNode.getId()).append(" -> ");

			LinkedList<Node> list = sourceNode.getAdjacent();

			for (Node node : list) {
				txt.append(node.getId()).append(", ");
			}
			txt.append("\n");
		}
		return txt.toString();
	}

}
