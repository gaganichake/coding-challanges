package com.codingchallanges.linkedlist;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 * CTCI 2.1
 *
 * Write code to remove duplicates from an unsorted linked list
 *
 * FOLLOW UP
 *
 * How would you solve this problem if a temporary buffer is not allowed?
 */


public class RemoveDuplicates {

	//Time: O(1), Space: O(1). Best solution
	public static void removeDuplicatesUsingBuffer(ListNode<Integer> head) {

		if(head == null) return;

		Set<Integer> set = new HashSet<>();

		ListNode<Integer> previous = null;

		while(head != null) {

			if(set.contains(head.value)) {
				previous.next = head.next;
			} else {
				set.add(head.value);
				previous = head;
			}
			head = head.next;
		}
	}

	// Time: O(N*N), Space: O(n). This approach is slightly different from the book
	public static void removeDuplicatesNoBuffer(ListNode<Integer> head) {

		if(head == null || head.next == null) return;

		Integer val = head.value;

		ListNode<Integer> current = head;

		while(current.next != null) {

			if(Objects.equals(val, current.next.value)) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		// N elements, N recursive calls
		removeDuplicatesNoBuffer(head.next);
	}

	// Time: O(N*N), Space: O(1). The above solution converted to iterative code reduces space complexity.
	public static void removeDuplicatesNoBuffer2(ListNode<Integer> head) {

		if(head == null) return;

		ListNode<Integer> current = head;

		while(current != null) {

			//remove all future nodes that have the same value
			ListNode<Integer> runner = current;

			while(runner.next != null) {

				if(Objects.equals(runner.next.value, current.value)) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public static void main(String[] args) {

		ListNode<Integer> linkedList = new ListNode<>(2);

//		System.out.println(linkedList);

//		System.out.println("Append 4");
		linkedList.append(4);
//		System.out.println("Append 6");
		linkedList.append(6);
//		System.out.println("Append 8");
		linkedList.append(8);
//		System.out.println("Append 8");
		linkedList.append(8);
//		System.out.println("Append 10");
		linkedList.append(10);
//		System.out.println("Append 4");
		linkedList.append(4);
//		System.out.println("Append 15");
		linkedList.append(15);
//		System.out.println("Append 4");
		linkedList.append(4);
//		System.out.println("Append 10");
		linkedList.append(10);
//		System.out.println("Append 10");
		linkedList.append(10);

		System.out.println(linkedList);

		removeDuplicatesUsingBuffer(linkedList);
//		removeDuplicatesNoBuffer(linkedList);
//		removeDuplicatesNoBuffer2(linkedList);

		System.out.println(linkedList);


	}

}
