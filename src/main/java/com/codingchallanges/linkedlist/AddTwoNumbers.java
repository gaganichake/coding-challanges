package com.codingchallanges.linkedlist;

/*
 * https://leetcode.com/problems/add-two-numbers
 *
 * You are given two non-empty linked lists representing two non-negative
 *  integers. The digits are stored in reverse order, and each of their
 *  nodes contains a single digit. Add the two numbers and return the sum
 *  as a linked list.
 *
 *  You may assume the two numbers do not contain any leading zero, except
 *  the number 0 itself.
 */
public class AddTwoNumbers {

	/**
	 * Definition for singly-linked list.
	 *
	 */
	public static class Node {

		int val;
		Node next;

		Node() {
		}

		Node(int val) {
			this.val = val;
			this.next = null;
		}

		Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}

		public String toString() {

			Node currentNode = this;

			StringBuilder txt = new StringBuilder("[");

			while (currentNode != null) {

				txt.append("[").append(currentNode.val).append("] -> ");

				currentNode = currentNode.next;
			}

			txt.append("null");

			return txt.toString();
		}
	}

	public static Node addTwoNumbers(Node l1, Node l2) {

		int sum = 0;
		int carry = 0;
		Node dummyHead = new Node();
		Node result = dummyHead;

		while (l1 != null || l2 != null) {

			sum+=(l1 != null ? l1.val : 0);
			sum+=(l2 != null ? l2.val : 0);
			sum+=carry;

			result.next = new Node(sum % 10);
			result = result.next;

			carry = sum / 10;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;

			sum = 0;
		}

		if(carry > 0) result.next = new Node(carry);

		return dummyHead.next;
	}

	public static void main(String[] args) {

		Node l1 = new Node(2); l1.next = new Node(4); l1.next.next = new Node(3);
		Node l2 = new Node(5); l2.next = new Node(6); l2.next.next = new Node(6);

		System.out.println(l1);
		System.out.println(l2);
		Node result = addTwoNumbers(l1, l2);
		System.out.println(result);

	}
}
