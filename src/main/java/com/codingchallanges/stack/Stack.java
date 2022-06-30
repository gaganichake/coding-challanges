package com.codingchallanges.stack;

/*
 * Stacks and Linked List are essentially the same thing, except that 
 * a stack usually prevents the user from "peeking" at items below the top node.
 * You can implement a stack using a Linked List or an Array.
 */
public class Stack {

	private static class Node {

		private final int val;
		private Node next;

		private Node(int val) {
			this.val = val;
			next = null;
		}
	}

	private Node top; // remove things from here

	public boolean isEmpty() {

		return top == null;
	}

	public int peek() {

		if (isEmpty())
			throw new IllegalStateException("This stack is empty!");

		return top.val;
	}

	public void push(int val) {

		Node newNode = new Node(val);

		if (isEmpty()) {
			top = newNode;
			return;
		}

		newNode.next = top;
		top = newNode;
	}

	public int pop() {

		if (isEmpty())
			throw new IllegalStateException("This stack is empty!");

		int val = top.val;

		top = top.next;

		return val;
	}

	@Override
	public String toString() {
		
		StringBuilder str  = new StringBuilder("Stack [");
		Stack temp = new Stack();
		int val;
		
		while(!this.isEmpty()) {
			
			val = this.pop();
			str.append(val).append(", ");
			temp.push(val);
		}
		
		while(!temp.isEmpty()) {
			this.push(temp.pop());
		}
		
		str.append("]");
		return str.toString();
	}
	
	
	
}
