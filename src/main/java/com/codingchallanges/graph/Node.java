package com.codingchallanges.graph;

import java.util.LinkedList;

public class Node {

	private final int id;
	private final LinkedList<Node> adjacent = new LinkedList<>();

	public Node(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public LinkedList<Node> getAdjacent() {
		return adjacent;
	}
}
