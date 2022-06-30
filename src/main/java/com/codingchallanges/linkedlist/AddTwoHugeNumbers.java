package com.codingchallanges.linkedlist;

/*
 * addTwoHugeNumbers
 *
 * https://app.codesignal.com/interview-practice/task/RvDFbsNC3Xn7pnQfH/description
 *
 * You're given 2 huge integers represented by linked lists. Each linked list element
 * is a number from 0 to 9999 that represents a number with exactly 4 digits.
 * The represented number might have leading zeros. Your task is to add up these huge
 * integers and return the result in the same format.
 *
 * Example:
 *
 * For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
 * addTwoHugeNumbers(a, b) = [9876, 5434, 0].
 * Explanation: 987654321999 + 18001 = 987654340000.
 *
 * For a = [123, 4, 5] and b = [100, 100, 100], the output should be
 * addTwoHugeNumbers(a, b) = [223, 104, 105].
 * Explanation: 12300040005 + 10001000100 = 22301040105.
 */
public class AddTwoHugeNumbers {

	// Singly-linked lists are already defined with this interface:
	static class ListNode<T> {
		T value;
		ListNode<T> next;
		ListNode(T x) {
			value = x;
		}
	}


	static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {

		ListNode<Integer> aRev = reverseLinkedList(a);
		ListNode<Integer> bRev = reverseLinkedList(b);
		ListNode<Integer> head = new ListNode<>(0);
		ListNode<Integer> res = head;

		int sum = 0, carry = 0;
		int base = 10000;

		while(aRev != null || bRev != null){

			sum += aRev != null ? aRev.value : 0;
			sum += bRev != null ? bRev.value : 0;
			sum += carry;

			res.next = new ListNode<>(sum % base);
			res = res.next;

			carry = sum / base;

			aRev  = aRev != null ? aRev.next : null;
			bRev  = bRev != null ? bRev.next : null;

			sum = 0;
		}

		if(carry > 0){
			res.next = new ListNode<>(carry);
		}

		return reverseLinkedList(head.next);
	}

	private static ListNode<Integer> reverseLinkedList(ListNode<Integer> list) {

		ListNode<Integer> temp;
		ListNode<Integer> revList = null;

		while(list != null){
			temp = revList;
			revList = new ListNode<>(list.value);
			revList.next = temp;
			list = list.next;
		}
		return revList;
	}

	public static void main(String[] args) {

		ListNode<Integer> a = new ListNode<>(9876);
		a.next = new ListNode<>(5432);
		a.next.next = new ListNode<>(1999);

		ListNode<Integer> b = new ListNode<>(1);
		b.next = new ListNode<>(8001);

		System.out.println(addTwoHugeNumbers(a, b));

	}

}
