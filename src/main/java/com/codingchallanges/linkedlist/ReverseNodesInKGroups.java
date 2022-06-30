package com.codingchallanges.linkedlist;

/*
 * reverseNodesInKGroups
 *
 * https://app.codesignal.com/interview-practice/task/XP2Wn9pwZW6hvqH67/description
 *
 * Note: Your solution should have O(n) time complexity, where n is the number of elements in l, and O(1) additional space complexity, since this is what you would be asked to accomplish in an interview
 *
 * Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer that is less than or equal to the length of l. If the number of nodes in the linked list is not a multiple of k, then the nodes that are left out at the end should remain as-is.
 *
 * You may not alter the values in the nodes - only the nodes themselves can be changed.
 *
 * Example:
 *
 * For l = [1, 2, 3, 4, 5] and k = 2, the output should be solution(l, k) = [2, 1, 4, 3, 5];
 *
 * For l = [1, 2, 3, 4, 5] and k = 1, the output should be solution(l, k) = [1, 2, 3, 4, 5];
 *
 * For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be solution(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].
 */
public class ReverseNodesInKGroups {

	// Singly-linked lists are already defined with this interface:
	static class ListNode<T> {
		ListNode(T x) {
			value = x;
		}

		T value;
		ListNode<T> next;
	}

	ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {

		if (k == 1 || l == null || l.next == null)
			return l;

		int i = k;
		ListNode<Integer> tail = l;
		ListNode<Integer> head = null;
		ListNode<Integer> last = null;
		ListNode<Integer> shortTail = null;

		while (i != 0 && tail != null) {
			// System.out.print(tail.value + ", ");
			tail = tail.next;
			i--;

			if (i == 0) {
				if (head == null) {
					head = reverse(l, tail);
				} else {
					last.next = reverse(l, tail);
				}
				last = l;
				l.next = tail;
				l = l.next;
				i = k;
			}
		}

		return head;
	}

	private ListNode<Integer> reverse(ListNode<Integer> startNode, ListNode<Integer> tail) {

		ListNode<Integer> head = null;
		ListNode<Integer> current = startNode;
		ListNode<Integer> temp;
		// System.out.println("\n" + current.value + " | " + tail.value + "\n");
		while (current != tail) {
			// System.out.print(current.value + ", ");
			temp = head;
			head = current;
			current = current.next;
			head.next = temp;
			// System.out.print(head.value + ", ");
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
