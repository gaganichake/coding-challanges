package com.codingchallanges.linkedlist;

/*
 * removeKFromList
 *
 * https://app.codesignal.com/interview-practice/task/gX7NXPBrYThXZuanm/description
 *
 * Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in the list, since this is what you'll be asked to do during an interview.
 *
 * Given a singly linked list of integers l and an integer k, remove all elements from list l that have a value equal to k.
 *
 * Example
 * For l = [3, 1, 2, 3, 4, 5] and k = 3, the output should be solution(l, k) = [1, 2, 4, 5];
 *
 * For l = [1, 2, 3, 4, 5, 6, 7] and k = 10, the output should be solution(l, k) = [1, 2, 3, 4, 5, 6, 7].
 */
public class RemoveKFromList {

    ListNode<Integer> solution(ListNode<Integer> l, int k) {

        ListNode<Integer> n = l;
        ListNode<Integer> prev = null;
        while (n != null) {

            if (n.value == k) {

                if (prev == null) {
                    l = l != null ? l.next : null;
                } else {
                    prev.next = n.next;
                }
            } else {
                if (prev == null) {
                    prev = l;
                } else {
                    prev = prev.next;
                }
            }
            n = n.next;
        }
        return l;
    }

    //  Singly-linked lists are already defined with this interface:
    static class ListNode<T> {
        T value;
        ListNode<T> next;
        ListNode(T x) {
            value = x;
        }
    }

}
