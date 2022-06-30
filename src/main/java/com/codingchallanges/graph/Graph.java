package com.codingchallanges.graph;

import java.util.*;

/*
 * https://www.youtube.com/watch?v=zaBhtODEL0w
 */
public class Graph {

	private static final int EDGE_LENGTH = 6;

	// A HashMap representation of this graph
	private final HashMap<Integer, GraphNode> nodes = new HashMap<>();

	// Retrieve a Node from Graph
	private GraphNode getNode(int id) {
		return nodes.get(id);
	}

	// Add a Node to the Graph
	public void addNode(int id) {

		if (!nodes.containsKey(id)) {
			nodes.put(id, new GraphNode(id));
		}
	}

	// Add an Edge between two Nodes
	public void addEdge(int source, int destination) {

		// Add nodes if not already exist
		addNode(source);
		addNode(destination);

		//Connect nodes
		getNode(source).getAdjecent().add(getNode(destination));
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
	 * Check if there a path exist from one Node to another Node.
	 * Depth First Search - This is the easiest but not the best way.
	 * It is implemented via recursion.
	 * It requires to check if the node was already visited in order to prevent infinite loop.
	 */
	public boolean hasPathDFS(int source, int destination) {

		// You must use Set
		Set<Integer> visited = new HashSet<>();

		return hasPathDFS(source, destination, visited);
	}

	private boolean hasPathDFS(int source, int destination, Set<Integer> visited) {

		// Reached at the destination
		if(source == destination) return true;

		if(!visited.contains(source)) {

			visited.add(source);

			GraphNode node = getNode(source);

			for(GraphNode child : node.getAdjecent()) {

				// Here we are processing the child recursively, hence it is a depth first search.
				 if(hasPathDFS(child.getId(), destination)) {
					 return true;
				 }
			}
		}

		return false;
	}

	/*
	 * Check if there a path exist from one Node to another Node.
	 * Breadth First Search is the better way to find the shorted path.
	 * It can be implemented using iterative method or a queue.
	 * Put all children of current node in a queue then
	 * pick them one by one until the queue is empty.
	 *
	 * CTCI 4.2
	 */
	public boolean hasPathBFS(int source, int destination) {

		if(source == destination) return true;// Optional check for early exit

		Set<Integer> visited = new HashSet<>();

		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(getNode(source));

		// Here we are visiting all children stored in a queue one by one, hence it is a breadth
		// first search.
		while(!queue.isEmpty()) {

			GraphNode node = queue.poll();

			if(node.getId() == destination) return true;//process the node

			// Add all adjacent Node to queue
			for(GraphNode child : node.getAdjecent()) {
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

		Map<Integer, Integer> distances = new HashMap<>(); // Memorization technique

		// Set the default distances to -1.
		// This will insure that unreachable nodes (islands) are also counted.
		for (Integer node : nodes.keySet()) {
			distances.put(node, -1);
		}

		GraphNode startNode = getNode(start);
		Queue<GraphNode> q = new LinkedList<>();

		distances.put(startNode.getId(), 0);// Distance from self is 0
		q.add(startNode);

		while (!q.isEmpty()) {

			GraphNode parent = q.poll();

			for (GraphNode child : parent.getAdjecent()) {

				// This check insures that a distance calculated once will never be updated in
				// future
				// and Breadth First Search ensures that a Node visited first time will always
				// have a
				// shorted distance from the source. If the same node is visited again it will
				// have
				// longer distance.
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

		// Set the default distances to -1. This will insure that unreachable nodes are also counted.
		Arrays.fill(distances, -1);

		Queue<Integer> q = new LinkedList<>();

		distances[start] = 0;// Distance from self is 0
		q.add(start);

		while (!q.isEmpty()) {

			GraphNode parent = getNode(q.poll());

			for (GraphNode child : parent.getAdjecent()) {

				if (distances[child.getId()] == -1) {
					distances[child.getId()] = distances[parent.getId()] + EDGE_LENGTH;
					q.add(child.getId());
				}
			}
		}
		return distances;
	}

	/*
	 * Snakes and Ladders problem.
	 * https://www.hackerrank.com/challenges/the-quickest-way-up/problem
	 *
	 * Use Breadth First Search
	 *
	 * Least number of Cubic rolls to reach the destination = Shorted distance
	 *
	 * Important point: Ladders and Snakes can NOT be added as edges in the graph because
	 * a ladder or snake does not count as a step of Cubic Die. if you mystically add
	 * ladders
	 * or snakes as edges it with result in shorted distance one edge extra than
	 * expected
	 */
	public int quickestWayUp(int[][] ladders, int[][] snakes, int destination) {

		int start = 1;

		Map<Integer, Integer> ladderMap = covertToMap(ladders);
		Map<Integer, Integer> snakeMap = covertToMap(snakes);

		// You also use a HashMap
		int[] distances = new int[nodes.size() + 1];// Where Index id is equals to Node id. 0 is ignored.
		Arrays.fill(distances, -1);

		Queue<Integer> queue = new LinkedList<>();

		distances[start] = 0;// Distance from self is 0
		queue.add(start);

		while (!queue.isEmpty()) {

			GraphNode parent = getNode(queue.remove());

			if (parent.getId() == destination) {
				return distances[destination];
			}

			for (GraphNode child : parent.getAdjecent()) {

				if (ladderMap.containsKey(child.getId())) {
					child = getNode(ladderMap.get(child.getId()));
				}

				if (snakeMap.containsKey(child.getId())) {
					child = getNode(snakeMap.get(child.getId()));
				}

				if (distances[child.getId()] == -1) {
					distances[child.getId()] = distances[parent.getId()] + EDGE_LENGTH;
					queue.add(child.getId());
				}
			}
		}
		return -1;
	}

	private Map<Integer, Integer> covertToMap(int[][] array) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int[] pair : array) {

			int node = pair[0];
			int replacement = pair[1];
			map.put(node, replacement);
		}
		return map;
	}

	public boolean hasPath(GraphNode n1, GraphNode n2) {

		List<GraphNode> visited = new ArrayList<>();

		Queue<GraphNode> q = new LinkedList<>();
		q.add(n1);
		visited.add(n1);

		while(!q.isEmpty()) {

			GraphNode n = q.poll();

			for(GraphNode adj : n.getAdjecent()) {

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

			LinkedList<GraphNode> list = sourceNode.getAdjecent();

			for (GraphNode node : list) {
				txt.append(node.getId()).append(", ");
			}
			txt.append("\n");
		}
		return txt.toString();
	}
}
