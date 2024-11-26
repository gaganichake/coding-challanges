package com.codingchallanges.linkedlist;

import java.util.Objects;
import java.util.Stack;

/*
 * CTCI 2.7
 *
 * isListPalindrome
 *
 * https://app.codesignal.com/interview-practice/task/HmNvEkfFShPhREMn4/description
 *
 * Given a singly linked list of integers, determine whether it's a palindrome.
 *
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is
 * the number of elements in l, since this is what you'll be asked to do during an
 * interview
 *
 * Example
 * For l = [0, 1, 0], the output should be solution(l) = true;
 *
 * For l = [1, 2, 2, 3], the output should be solution(l) = false.
 */
public class IsListPalindrome {


	/*
	 * Approach 1: Reverse and Compare
	 */
	static boolean isListPalindrome(ListNode<Integer> list) {

	   if(list == null || list.next == null) return true;

	   ListNode<Integer> reverseList = getReverseList(list);

	   while(list != null && reverseList != null){

		   if(!Objects.equals(list.value, reverseList.value))
			   return false;
		   list = list.next;
		   reverseList = reverseList.next;
	   }
	   return true;
	}

	private static ListNode<Integer> getReverseList(ListNode<Integer> listPointer) {

		ListNode<Integer> reverseList = null;
		ListNode<Integer> temp;

		while(listPointer != null){
			// add before the head
			temp = reverseList;
			reverseList = new ListNode<>(listPointer.value);
			reverseList.next = temp;
			listPointer = listPointer.next;

		}
		return reverseList;
	}

	/*
	 * Approach 2: Fast Runner and Low Runner technique.
	 *
	 * You usually do not know the length of a LinkedList hence can’t find the middle
	 * element or half-length. Use Fast Runner and Slow Runner technique.
	 * When the fast runner reached to the end, slow runner will be at middle position.
	 */
	public static boolean isListPalindrome2(ListNode<Integer> list) {

		if(list == null || list.next == null) return true;

		ListNode<Integer> slow = list;
		ListNode<Integer> fast = list;

		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		//If the linkedList has an odd length, skip the middle one.
		if(fast != null) {
			slow = slow != null ? slow.next : null;
		}

		while(slow != null) {

			if(!Objects.equals(slow.value, list.value))
				return false;
			slow = slow.next;
			list = list.next;
		}

		return true;
	}


	public static void main(String[] args) {

		ListNode<Integer> node = new ListNode<>(0);
		node.next = new ListNode<>(1);
		node.next.next = new ListNode<>(0);
		System.out.println(isListPalindrome(node));

		ListNode<Integer> node1 = new ListNode<>(0);
		node1.next = new ListNode<>(1);
		node1.next.next = new ListNode<>(2);
		node1.next.next.next = new ListNode<>(2);
		node1.next.next.next.next = new ListNode<>(1);
		node1.next.next.next.next.next = new ListNode<>(0);
		System.out.println(isListPalindrome(node1));

		ListNode<Integer> node2 = new ListNode<>(10);
		node2.next = new ListNode<>(11);
		node2.next.next = new ListNode<>(12);
		node2.next.next.next = new ListNode<>(11);
		node2.next.next.next.next = new ListNode<>(10);
		System.out.println(isListPalindrome(node2));

		ListNode<Integer> node3 = new ListNode<>(11);
		node3.next = new ListNode<>(22);
		node3.next.next = new ListNode<>(44);
		node3.next.next.next = new ListNode<>(33);
		node3.next.next.next.next = new ListNode<>(11);

		System.out.println(isListPalindrome(node3));

	}

}
