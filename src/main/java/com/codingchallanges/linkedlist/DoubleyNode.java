package com.codingchallanges.linkedlist;

public class DoubleyNode {

	public int val;
	public DoubleyNode next;
	public DoubleyNode prev;
	public DoubleyNode head;

	public DoubleyNode(int val) {
		this.val = val;
		this.next = null;
		this.prev = null;
		this.head = this;
	}

}
