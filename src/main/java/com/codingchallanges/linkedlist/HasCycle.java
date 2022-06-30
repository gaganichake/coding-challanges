package com.codingchallanges.linkedlist;

/*
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 *
 * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
 */
public class HasCycle {

	/*
	 * Find duplicate Object (not value) using Single Pointer.
	 *
	 * If the list has less than 100 items. Therefore, we can keep the reference to each
	 * of the nodes - as it will not be memory expensive.
	 * If we see that reference (that node) while we iterate over the list,
	 * it means that there is a cycle.
	 */
	public static boolean hasCycleSinglePointer(ListNode<Integer> head) {

		if (head == null)
			return false;

		ListNode<Integer> node = head.next;

		while (node != null && node != head) {

			if (node.next == null)
				return false;

			node = node.next;
		}

		return node == head;
	}

	/*
	 * Find duplicate Object (not value) by NOT using Two Pointer
	 *
	 * Another option would be to move two pointers. One should be twice faster.
	 * If there are any cycles, this should never end, but it will meet the other
	 * pointer. This idea is much more creative.
	 */
	public static boolean hasCycleTwoPointers(ListNode<Integer> head) {

		if (head == null)
			return false;

		ListNode<Integer> slowPointer = head;
		ListNode<Integer> fastPointer = head.next;

		while (fastPointer != null && fastPointer != slowPointer) {

			if (fastPointer.next == null)
				return false;

			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		return fastPointer == slowPointer;
	}

	public static void main(String[] args) {

		ListNode<Integer> head = new ListNode<>(5);

		head.next = new ListNode<>(1);

		head.next.next = new ListNode<>(6);

		head.next.next = head;

		System.out.println(hasCycleSinglePointer(head));

		System.out.println(hasCycleTwoPointers(head));
	}
}
