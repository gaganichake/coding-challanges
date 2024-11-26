package com.codingchallanges.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class QuickestWayUpSnakesAndLadders {

	/*
	 * Snakes and Ladders problem.
	 * https://www.hackerrank.com/challenges/the-quickest-way-up/problem
	 *
	 * Use Breadth First Search
	 *
	 * Least number of Cubic rolls to reach the destination = Shorted distance
	 *
	 * Important point: Ladders and Snakes can NOT be added as edges in the graph because
	 * a ladder or snake does not count as a step of Cubic Die. if you mistakenly add
	 * ladders or snakes as edges it with result in shorted distance one edge extra than expected
	 */
	public static int quickestWayUp(Graph graph, int[][] ladders, int[][] snakes, int destination) {

		int start = 1;

		Map<Integer, Integer> ladderMap = covertToMap(ladders);
		Map<Integer, Integer> snakeMap = covertToMap(snakes);

		// You also use a HashMap
		int[] distances = new int[graph.getAllNodes().size() + 1];// Where Index id is equals to Node id. 0 is ignored.
		Arrays.fill(distances, -1);

		Queue<Integer> queue = new LinkedList<>();

		distances[start] = 0;// Distance from self is 0
		queue.add(start);

		while (!queue.isEmpty()) {

			GraphNode parent = graph.getNode(queue.remove());

			if (parent.getId() == destination) {
				return distances[destination];
			}

			for (GraphNode child : parent.getAdjacent()) {

				if (ladderMap.containsKey(child.getId())) {
					child = graph.getNode(ladderMap.get(child.getId()));
				}

				if (snakeMap.containsKey(child.getId())) {
					child = graph.getNode(snakeMap.get(child.getId()));
				}

				if (distances[child.getId()] == -1) {
					distances[child.getId()] = distances[parent.getId()] + 1;
					queue.add(child.getId());
				}
			}
		}
		return -1;
	}

	private static Map<Integer, Integer> covertToMap(int[][] array) {

		return Arrays.stream(array).collect(Collectors.toMap(a -> a[0], a -> a[1]));

//		Map<Integer, Integer> map = new HashMap<>();
//
//		for (int[] pair : array) {
//
//			int source = pair[0];
//			int destination = pair[1];
//			map.put(source, destination);
//		}
//		return map;
	}

	public static void main(String[] args) {
		int[][] ladders = { { 32, 62 }, { 42, 68 }, { 12, 98 } };
		int[][] snakers = { { 95, 13 }, { 97, 25 }, { 93, 37 }, { 79, 27 }, { 75, 19 }, { 49, 47 }, { 67, 17 } };
//		Correct Output: 3

//		int[][] ladders = { { 8, 52 }, { 6, 80 }, { 26, 42 }, { 2, 72 } };
//		int[][] snakers = { { 51, 19 }, { 39, 11 }, { 37, 29 }, { 81, 3 }, { 59, 5 }, { 79, 23 }, { 53, 7 }, { 43, 33 }, { 77, 21 } };
//		Correct Output: 5

		Graph graph = new Graph();

		int id = 1;//Node id: 1 to 100

		for (int i = 0; i < 10; i++) {

			for (int j = 0; j < 10; j++) {
				graph.addNode(id++);
			}
		}

		int cube = 1;// Cube die face values: 1, 2, 3, 4, 5, 6

		while (cube < 7) {

			id = 1;

			for (int i = 0; i < 10; i++) {

				for (int j = 0; j < 10; j++) {

					if (id + cube > 100) {
						break;
					}

					graph.addEdge(id, id + cube);

					id++;
				}
			}
			cube++;
		}

		System.out.println(graph);

		int destination = 100;
		System.out.println("Shortest distance from node 1 to node 100 is " + quickestWayUp(graph, ladders, snakers, destination));
	}
}
