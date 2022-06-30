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
 * Given a singly linked list of integers, determine whether or not it's a palindrome.
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
	boolean isListPalindrome(ListNode<Integer> l) {

		   if(l == null || l.next == null) return true;

		   ListNode<Integer> list = l;
		   ListNode<Integer> reverseList = null;

		   ListNode<Integer> temp;

		   while(list != null){
		       // add before the head
		        temp = reverseList;
		       reverseList = new ListNode<>(list.value);
		       reverseList.next = temp;
		       list = list.next;

		   }

		   list = l;

		   while(list != null && reverseList != null){

		    //    if(Math.abs(list.value) != Math.abs(reverseList.value)) return false;
		        if(!Objects.equals(list.value, reverseList.value)) return false;

		       list = list.next;
		       reverseList = reverseList.next;
		   }
		   return true;
		}

	/*
	 * Approach 2: Fast Runner and Low Runner technique.
	 *
	 * You usually do not know the length of a LinkedList hence can’t find the middle
	 * element or half length. Use Fast Runner and Slow Runner technique.
	 * When the fast runner reached to the end, slow runner will be a the middle position.
	 */
	public static boolean isListPalindrome2(ListNode<Integer> l) {

		if(l == null || l.next == null) return true;

		ListNode<Integer> slow = l;
		ListNode<Integer> fast = l;
		Stack<Integer> s = new Stack<>();

		while(slow != null && fast != null && fast.next != null) {
			s.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}

		//If the linkedList has an odd length, skip the middle one.
		if(fast != null) {
			slow = slow != null ? slow.next : null;
		}

		while(slow != null) {

			if(!Objects.equals(slow.value, s.pop())) return false;

			slow = slow.next;
		}

		return true;
	}


	public static void main(String[] args) {

		ListNode<Integer> node = new ListNode<>(0);
		node.next = new ListNode<>(1);
		node.next.next = new ListNode<>(0);

		System.out.println(isListPalindrome2(node));

		ListNode<Integer> node1 = new ListNode<>(0);
		node1.next = new ListNode<>(1);
		node1.next.next = new ListNode<>(2);
		node1.next.next.next = new ListNode<>(2);
		node1.next.next.next.next = new ListNode<>(1);
		node1.next.next.next.next.next = new ListNode<>(0);

		System.out.println(isListPalindrome2(node1));

		ListNode<Integer> node2 = new ListNode<>(10);
		node2.next = new ListNode<>(11);
		node2.next.next = new ListNode<>(12);
		node2.next.next.next = new ListNode<>(11);
		node2.next.next.next.next = new ListNode<>(10);

		System.out.println(isListPalindrome2(node2));

	}

}
