package com.codingchallanges.graph;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://www.youtube.com/watch?v=zaBhtODEL0w
 */
public class Graph {

	private static final int EDGE_LENGTH = 6;

	// A HashMap representation of this graph.
	private final HashMap<Integer, GraphNode> nodes = new HashMap<>();

	public HashMap<Integer, GraphNode> getAllNodes() {
		return nodes;
	}

	// Retrieve a Node from Graph
	public GraphNode getNode(int id) {
		return nodes.get(id);
	}

	// Add a Node to the Graph
	public GraphNode addNode(int id) {

		return nodes.getOrDefault(id, new GraphNode(id));
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

	/*
	 * Check if there is a path exist from one Node to another Node.
	 * Depth First Search - This is the easiest but not the best way.
	 * It is implemented via recursion.
	 * It requires checking if the node was already visited in order to prevent infinite loop.
	 */
	public boolean hasPathDFS(int source, int destination) {

		// You must use Set
		Set<Integer> visited = new HashSet<>();

		return hasPathDFS(source, destination, visited);
	}

	// Time O(n)
	private boolean hasPathDFS(int source, int destination, Set<Integer> visited) {

		// Reached at the destination
		if(source == destination) return true;

		if(!visited.contains(source)) {

			visited.add(source);
			GraphNode node = getNode(source);

			for(GraphNode child : node.getAdjacent()) {
				// Here we are processing the child recursively, hence it is a depth first search.
				 if(hasPathDFS(child.getId(), destination)) {
					 return true;
				 }
			}
		}
		return false;
	}

	/*
	 * Check if there is a path exist from one Node to another Node.
	 * Breadth First Search is the better way to find the shorted path.
	 * It can be implemented using iterative method or a queue.
	 * Put all children of current node in a queue then
	 * pick them one by one until the queue is empty.
	 *
	 * CTCI 4.2
	 */
	public boolean hasPathBFS(int source, int destination) {

		if(source == destination) return true;// Optional check for early exit

		Set<Integer> visited = new HashSet<>(); //Must track visited nodes to prevent infinite loop

		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(getNode(source));

		// Here we are visiting all children stored in a queue one by one, hence it is a breadth
		// first search.
		while(!queue.isEmpty()) {

			GraphNode node = queue.poll();

			if(node.getId() == destination) return true;//process the node

			// Add all adjacent Node to queue
			for(GraphNode child : node.getAdjacent()) {
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
	 * Find shorted distance to all other node from the give node.
	 * Always use Breadth First Search for finding shorted path.
	 */
	public Map<Integer, Integer> shortedDistanceBFS(int start) {

		// Memorization technique
		// This map will also be used to keep track of visited node
		Map<Integer, Integer> distances = new HashMap<>();

		// Set the default distances to -1.
		// This will ensure that unreachable nodes (islands) are also counted.
		for (Integer node : nodes.keySet()) {
			distances.put(node, -1);
		}

		GraphNode startNode = getNode(start);
		Queue<GraphNode> q = new LinkedList<>();

		distances.put(startNode.getId(), 0);// Distance from self is 0
		q.add(startNode);

		while (!q.isEmpty()) {

			GraphNode parent = q.poll();

			for (GraphNode child : parent.getAdjacent()) {

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
	 * This implementation is more suitable when you have implemented your Graph using Arrays.
	 * Always use BFS for finding shorted path.
	 * https://www.youtube.com/watch?v=0XgVhsMOcQM
	 * https://www.hackerrank.com/challenges/bfsshortreach/problem
	 */
	public int[] shortedDistanceBFSArray(int start) {

		int[] distances = new int[nodes.size() + 1];// Where Index id is equals to Node id. Ignoring Zero '0'.

		// Set the default distances to -1. This will ensure that unreachable nodes are also counted.
		Arrays.fill(distances, -1);

		Queue<Integer> q = new LinkedList<>();

		distances[start] = 0;// Distance from self is 0
		q.add(start);

		while (!q.isEmpty()) {

			GraphNode parent = getNode(q.poll());

			for (GraphNode child : parent.getAdjacent()) {

				if (distances[child.getId()] == -1) {
					distances[child.getId()] = distances[parent.getId()] + EDGE_LENGTH;
					q.add(child.getId());
				}
			}
		}
		return distances;
	}

	public boolean hasPath(GraphNode n1, GraphNode n2) {

		List<GraphNode> visited = new ArrayList<>();

		Queue<GraphNode> q = new LinkedList<>();
		q.add(n1);
		visited.add(n1);

		while(!q.isEmpty()) {

			GraphNode n = q.poll();

			for(GraphNode adj : n.getAdjacent()) {

				visited.add(adj);

				if(n2.equals(adj)) return true;

				if(!visited.contains(adj)) q.add(adj);
			}
		}

		return false;
	}

	// Print the Graph
	public String toString() {

		StringBuilder txt = new StringBuilder();

		for (Integer sourceKey : nodes.keySet()) {

			GraphNode sourceNode = nodes.get(sourceKey);

			txt.append(sourceNode.getId()).append(" -> ");

			LinkedList<GraphNode> list = sourceNode.getAdjacent();

			for (GraphNode node : list) {
				txt.append(node.getId()).append(", ");
			}
			txt.append("\n");
		}
		return txt.toString();
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

		System.out.println("Distance from Node " + startNode + ": " + graph.shortedDistanceBFS(startNode));

		System.out.println("Distance from Node " + startNode + ": " + Arrays.toString(graph.shortedDistanceBFSArray(startNode)));

		System.out.println("Has path from 1 to 4? : " + graph.hasPath(new GraphNode(1), new GraphNode(4)));
	}
}
