package com.codingchallanges.linkedlist;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    public static Node sortedMerge(Node l1, Node l2) {

        Node dummyHead = new Node();
        Node result = dummyHead;

        if (l1 == null) return l2;

        if (l2 == null) return l1;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                result.next = new Node(l1.val);
                l1 = l1.next;
            } else {
                result.next = new Node(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }

        result.next = sortedMerge(l1, l2);

        return dummyHead.next;
    }

    public static void main(String[] args) {

        Node l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(4);
        Node l2 = new Node(1);
        l2.next = new Node(3);
        l2.next.next = new Node(4);

        System.out.println(l1);
        System.out.println(l2);
        Node result = sortedMerge(l1, l2);
        System.out.println(result);
    }

    /**
	 *
	 *   Merge two linked lists
	 *   head pointer input could be NULL as well for empty list
	 *   Node is defined as
	 *   class Node {
	 *      int data;
	 *      Node next;
	 *   }
	 *
     * There are two ways of coding this:
     * 1) Involves iterating over the lists inserting the nodes of the other lista
     * when these are smaller.
     * 2) Keep a reference to the tail of the new list and a pointer for each list.
     * We would always insert the node of the pointer that is pointing to the smaller
     * value.
     * Let's solve it as approach n.2 as both solutions have the same big-Oh in time
     * and memory, but n.2 is simpler to implement.
     */
    Node mergeLists2(Node headA, Node headB) {
        Node newHead = null;
        Node newTail = null;
        // We will use headA and headB as tracking nodes.
        while (headA != null || headB != null) {
            if (headA == null || headB != null && headA.val > headB.val) {
				Node n = appendNodeInNewList(newHead, newTail, headB.val);
                if (newHead == null) {
                    newHead = n;
                }
                newTail = n;
                headB = headB.next;
            } else {
                Node n = appendNodeInNewList(newHead, newTail, headA.val);
                if (newHead == null) {
                    newHead = n;
                }
                newTail = n;
                headA = headA.next;
            }
        }

        return newHead;
    }

    private Node appendNodeInNewList(Node head, Node tail, int data) {
        Node nodeToInsert = new Node();
        nodeToInsert.val = data;
        // handle first case
        if (head != null) {
            tail.next = nodeToInsert;
        }
        return nodeToInsert;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class Node {

        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {

            Node currentNode = this;

            StringBuilder txt = new StringBuilder();

            while (currentNode != null) {

                txt.append("[").append(currentNode.val).append("] -> ");

                currentNode = currentNode.next;
            }

            txt.append("null");

            return txt.toString();
        }
    }

}
