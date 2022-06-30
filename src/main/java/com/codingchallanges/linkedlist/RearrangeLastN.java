package com.codingchallanges.linkedlist;

/*
 * rearrangeLastN
 *
 * https://app.codesignal.com/interview-practice/task/5vcioHMkhGqkaQQYt/description
 *
 * Note: Try to solve this task in O(list size) time using O(1) additional space, since this is what you'll be asked during an interview.
 *
 * Given a singly linked list of integers l and a non-negative integer n, move the last n list nodes to the beginning of the linked list.
 *
 * Example
 *
 * For l = [1, 2, 3, 4, 5] and n = 3, the output should be solution(l, n) = [3, 4, 5, 1, 2];
 *
 * For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be solution(l, n) = [7, 1, 2, 3, 4, 5, 6].0
 *
 */

public class RearrangeLastN {

    ListNode<Integer> solution(ListNode<Integer> l, int n) {

        if (l == null || l.next == null || n == 0) return l;

        ListNode<Integer> previousPointer = new ListNode<>(0);
        previousPointer.next = l;
        ListNode<Integer> currentPointer = l;
        ListNode<Integer> forwardPointer = new ListNode<>(0);
        forwardPointer.next = l;

        // Set forwardPointer to nth position
        for (int i = 0; i < n && forwardPointer != null; i++) {
            forwardPointer = forwardPointer.next;
        }

        if ((forwardPointer != null ? forwardPointer.next : null) == null) return l; // When list size == n

        while (forwardPointer.next != null) {
            previousPointer = previousPointer.next;
            currentPointer = currentPointer.next;
            forwardPointer = forwardPointer.next;
        }

        forwardPointer.next = l;
        previousPointer.next = null;

        return currentPointer;
    }

    // Singly-linked lists are already defined with this interface:
    static class ListNode<T> {
        T value;
        ListNode<Integer> next;
        ListNode(T x) {
            value = x;
        }
    }
}
