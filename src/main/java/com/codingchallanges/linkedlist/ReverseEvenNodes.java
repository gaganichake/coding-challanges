package com.codingchallanges.linkedlist;

/*
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=623634548182866&c=420501606451133&ppid=454615229006519&practice_plan=0
 * 
 * Reverse Operations
 * 
 * You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by either end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
 * 
 * Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
 * 
 * The goal of this question is: given a resulting list, determine the original order of the elements.
 * 
 * Example
 * Input:
 * N = 6
 * list = [1, 2, 8, 9, 12, 16]
 * Output:
 * [1, 8, 2, 9, 16, 12]
 * 
 */


import java.util.Objects;

public class ReverseEvenNodes {

//	public class ListNode {
//		int data;
//		ListNode next;
//
//		ListNode(int x) {
//			data = x;
//			next = null;
//		}
//	}

	public static ListNode<Integer> reverse(ListNode<Integer> head) {
		// Write your code here

		ListNode<Integer> dummyHead = new ListNode<>(0);
		dummyHead.next = head;
		ListNode<Integer> current = head;
		ListNode<Integer> tailNext;
		ListNode<Integer> subHead = null;
		ListNode<Integer> subTail;

		while (current != null) {

			if (current.value % 2 == 0) {

				subTail = current;
				subTail.next = current;
			}

			current = current.next;

		}

		return dummyHead.next;
	}

	private static void reverseSublist(ListNode<Integer> head, ListNode<Integer> tailNext) {

		ListNode<Integer> current = head;
		ListNode<Integer> temp;
		while (!Objects.equals(current.value, tailNext.value)) {

			temp = head;
			head = current;
			head.next = temp;
			current = current.next;

		}
		printLinkedList(head);
	}

	public static void main(String[] args) {
		Integer[] arr_1 = { 1, 2, 8, 9, 12, 16 };
		Integer[] expected1 = { 1, 8, 2, 9, 16, 12 };
		ListNode<Integer> head_1 = createLinkedList(arr_1);
		ListNode<Integer> expected_1 = createLinkedList(expected1);
		ListNode<Integer> output_1 = reverse(head_1);
		check(expected_1, output_1);

		Integer[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
		Integer[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
		ListNode<Integer> head_2 = createLinkedList(arr_2);
		ListNode<Integer> expected_2 = createLinkedList(expected2);
		ListNode<Integer> output_2 = reverse(head_2);
		check(expected_2, output_2);

	}

	private static int test_case_number = 1;

	private static void printLinkedList(ListNode<Integer> head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.value);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}

	private static void check(ListNode<Integer> expectedHead, ListNode<Integer> outputHead) {
		boolean result = true;
		ListNode<Integer> tempExpectedHead = expectedHead;
		ListNode<Integer> tempOutputHead = outputHead;
		while (expectedHead != null && outputHead != null) {
			result &= (Objects.equals(expectedHead.value, outputHead.value));
			expectedHead = expectedHead.next;
			outputHead = outputHead.next;
		}
		if (!(expectedHead == null && outputHead == null))
			result = false;

		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printLinkedList(tempExpectedHead);
			System.out.print(" Your output: ");
			printLinkedList(tempOutputHead);
			System.out.println();
		}
		test_case_number++;
	}

	private static ListNode<Integer> createLinkedList(Integer[] arr) {
		ListNode<Integer> head = null;
		ListNode<Integer> tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new ListNode<>(v);
				tempHead = head;
			} else {
				head.next = new ListNode<>(v);
				head = head.next;
			}
		}
		return tempHead;
	}

}
