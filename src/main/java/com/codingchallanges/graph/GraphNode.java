package com.codingchallanges.graph;

import java.util.LinkedList;

public class GraphNode {

	private int id;
	private LinkedList<GraphNode> adjacent = new LinkedList<>();

	public GraphNode(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public LinkedList<GraphNode> getAdjacent() {
		return adjacent;
	}
}
