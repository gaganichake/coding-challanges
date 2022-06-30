package com.codingchallanges.graph;

import java.util.LinkedList;

public class GraphNode {

	private int id;
	private LinkedList<GraphNode> adjecent = new LinkedList<>();

	public GraphNode(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LinkedList<GraphNode> getAdjecent() {
		return adjecent;
	}

	public void setAdjecent(LinkedList<GraphNode> adjecent) {
		this.adjecent = adjecent;
	}


}
