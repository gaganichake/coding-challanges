package com.codingchallanges.linkedlist;

public class ListNode<T> {

	public T value;
	public ListNode<T> next;

	public ListNode(T val) {
		this.value = val;
		next = null;
		this.head = this;
	}

	private ListNode<T> head;

	public boolean isEmpty() {
		return head == null;
	}

	public void push(T val) {

		ListNode<T> newNode = new ListNode<>(val);

		if (this.head == null) {
			this.head = newNode;
			return;
		}

		newNode.next = this.head;
		this.head = newNode;
	}

	public void append(T val) {

		ListNode<T> node = new ListNode<>(val);

		if (this.head == null) {
			head = node;
			return;
		}

		ListNode<T> lastNode = this.head;

		while (lastNode.next != null) {

			lastNode = lastNode.next;
		}

		lastNode.next = node;
	}

	public void insertAfter(T newVal, T val) {

		if(this.isEmpty()) {
			return;
		}

		ListNode<T> node = this.head;

		while(node != null) {

			if(node.value == val) {
				ListNode<T> newNode = new ListNode<>(newVal);
				newNode.next = node.next;
				node.next = newNode;
				return;
			}
			node = node.next;
		}
	}

	public void insertBefore(T newVal, T val) {

		if(this.isEmpty()) {
			return;
		}

		if(this.head.value == val) {
			ListNode<T> newNode = new ListNode<>(newVal);
			newNode.next = this.head;
			this.head = newNode;
		}

		ListNode<T> node = this.head;

		while(node.next != null) {

			if(node.next.value == val) {
				ListNode<T> newNode = new ListNode<>(newVal);
				newNode.next = node.next;
				node.next = newNode;
				return;
			}
			node = node.next;
		}
	}

	// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
	public void insertAtPosition(T val, int position) {

		if(position < 0) return;

		if(position == 0) {
			push(val);
		}

		int index = 0;
		ListNode<T> node = this.head;

		while(node != null) {

			index++;
			if(index == position) {
				ListNode<T> newNode = new ListNode<>(val);
				newNode.next = node.next;
				node.next = newNode;
				return;
			}
			node = node.next;
		}

	}

	public void deleteWithValue(T val) {

		if(this.isEmpty()) {
			return;
		}

		if(this.head.value == val) {
			this.head = this.head.next;
		}

		ListNode<T> node = this.head;

		while(node.next != null) {

			if(node.next.value == val) {
				node.next = node.next.next;
				return;
			}
			node = node.next;
		}
	}

	/*
	 * removeKFromList
	 *
	 * https://app.codesignal.com/interview-practice/task/gX7NXPBrYThXZuanm/description
	 *
	 * Given a singly linked list of integers l and an integer k, remove all elements
	 * from list l that have a value equal to k.
	 *
	 * Note: Try to solve this task in O(n) time using O(1) additional space, where n
	 * is the number of elements in the list, since this is what you'll be asked to
	 * do during an interview.
	 */
	ListNode<T> removeKFromList(ListNode<T> l, T k) {

	    ListNode<T> n = l;
	    ListNode<T> prev = null;
	    while(n != null){

	        if(n.value == k){

	            if(prev == null){
	                l = l != null ? l.next : null;
	            } else {
	                prev.next = n.next;
	            }
	        } else {
	            if(prev == null){
	                prev = l;
	            } else {
	                prev = prev.next;
	            }
	        }
	        n = n.next;
	    }
	    return l;
	}

	public String toString() {

		if (this.head == null)
			return "[]";

		ListNode<T> currentNode = this.head;

		StringBuilder txt = new StringBuilder("[");

		while (currentNode.next != null) {

			txt.append(currentNode.value).append(", ");

			currentNode = currentNode.next;
		}

		txt.append(currentNode.value).append("]");

		return txt.toString();
	}

	public static void main(String[] arg) {

		ListNode<Integer> linkedList = new ListNode<>(2);

		System.out.println(linkedList);

//		System.out.println("Append 2");
//		linkedList.append(2);
		System.out.println("Append 4");
		linkedList.append(4);
		System.out.println("Append 6");
		linkedList.append(6);
		System.out.println("Append 8");
		linkedList.append(8);
		System.out.println("Append 10");
		linkedList.append(10);

		System.out.println(linkedList);

		System.out.println("Push 1");
		linkedList.push(1);
		System.out.println(linkedList);

		System.out.println("Insert 5 after 4");
		linkedList.insertAfter(5, 4);
		System.out.println(linkedList);

		System.out.println("Insert 7 before 8");
		linkedList.insertBefore(7, 8);
		System.out.println(linkedList);

		System.out.println("Insert 0 and position 0");
		linkedList.insertAtPosition(0, 0);
		System.out.println(linkedList);

		System.out.println("Insert 3 at position 3");
		linkedList.insertAtPosition(3, 3);
		System.out.println(linkedList);

		System.out.println("Insert 9 at position 9");
		linkedList.insertAtPosition(9, 9);
		System.out.println(linkedList);

		System.out.println("Insert 11 at poistion 11");
		linkedList.insertAtPosition(11, 11);
		System.out.println(linkedList);

		System.out.println("Insert 13 at poistion 13 (This position does not exist)");
		linkedList.insertAtPosition(13, 13);
		System.out.println(linkedList);

		System.out.println("Delete 0");
		linkedList.deleteWithValue(0);
		System.out.println(linkedList);

		System.out.println("Delete 7");
		linkedList.deleteWithValue(7);
		System.out.println(linkedList);

		System.out.println("Delete 13");
		linkedList.deleteWithValue(13);
		System.out.println(linkedList);
	}
}
