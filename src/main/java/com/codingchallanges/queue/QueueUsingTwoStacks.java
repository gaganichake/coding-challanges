package com.codingchallanges.queue;

import java.util.Stack;

/*
 * https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 */
public class QueueUsingTwoStacks {

	private static class MyQueue {

		Stack<Integer> q = new Stack<>();// This stack will hold the main queue elements.
		Stack<Integer> temp = new Stack<>();

		public boolean isEmpty() {
			return q.isEmpty();
		}

		public int peek() {
			return q.peek();
		}

		public int remove() {
			return q.pop();
		}

		public void push(int val) {

			while (!q.isEmpty()) {

				temp.push(q.pop());

			}

			q.push(val);

			while (!temp.isEmpty()) {

				q.push(temp.pop());

			}
		}

		public void println() {
			System.out.println(q.toString());
		}
	}

	public static void main(String[] args) {

		MyQueue q = new MyQueue();

		System.out.println(q.isEmpty());

		q.push(1);

		q.println();

		q.push(2);

		q.println();

		System.out.println(q.peek());

		System.out.println(q.remove());

		q.println();

		System.out.println(q.peek());

		System.out.println(q.remove());

		q.println();

		System.out.println(q.peek());

	}
}
