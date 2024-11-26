package com.codingchallanges.linkedlist;

/*
 * mergeTwoLinkedLists
 *
 * https://app.codesignal.com/interview-practice/task/6rE3maCQwrZS3Mm2H/description
 *
 * Note: Your solution should have O(l1.length + l2.length) time complexity, since this is what you will be asked to accomplish in an interview.
 *
 * Given two singly linked lists sorted in non-decreasing order, your task is to merge them.
 * In other words, return a singly linked list, also sorted in non-decreasing order, that contains the elements from both original lists.
 *
 * Example
 * For l1 = [1, 2, 3] and l2 = [4, 5, 6], the output should be solution(l1, l2) = [1, 2, 3, 4, 5, 6];
 *
 * For l1 = [1, 1, 2, 4] and l2 = [0, 3, 5], the output should be solution(l1, l2) = [0, 1, 1, 2, 3, 4, 5].
 *
 */

public class MergeTwoLinkedLists {

    // Singly-linked lists are already defined with this interface:
    static class ListNode<T> {
        T value;
        ListNode<T> next;
        ListNode(T x) {
            value = x;
        }
    }

    ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode<Integer> newList = new ListNode<>(0);
        ListNode<Integer> headOfNewList = newList;

        while(l1 != null && l2 != null){

            if(l1.value < l2.value){
                newList.next = new ListNode<>(l1.value);
                l1 = l1.next;
            } else {
                newList.next = new ListNode<>(l2.value);
                l2 = l2.next;
            }
            newList = newList.next;
        }

        if(l1 == null) newList.next = l2;
        if(l2 == null) newList.next = l1;

        return headOfNewList.next;
    }

}
