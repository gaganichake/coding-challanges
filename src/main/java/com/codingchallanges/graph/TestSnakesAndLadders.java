package com.codingchallanges.graph;

public class TestSnakesAndLadders {

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
		System.out.println("Shortest distance from node 1 to node 100 is " + graph.quickestWayUp(ladders, snakers, destination));
	}
}
