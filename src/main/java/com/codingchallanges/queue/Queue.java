package com.codingchallanges.queue;

public class Queue {

	private static class Node {

		private final int val;
		private Node next;

		private Node(int val) {
			this.val = val;
			next = null;
		}
	}

	private Node head; // remove things from here
	private Node tail; // add items here

	public boolean isEmpty() {

		return head == null;
	}

	public int peek() {

		if (isEmpty())
			throw new IllegalStateException("This queue is empty!");

		return head.val;
	}

	public void add(int val) {

		Node newNode = new Node(val);

		if (isEmpty()) {
			head = newNode;
		}

		if (tail != null)
			tail.next = newNode;

		tail = newNode;

	}

	public int remove() {

		if (isEmpty())
			throw new IllegalStateException("This queue is empty!");

		int val = head.val;

		head = head.next;

		if (isEmpty())
			tail = null;

		return val;
	}

}
