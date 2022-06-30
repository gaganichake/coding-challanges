package com.codingchallanges.linkedlist;

public class ReverseALinkedList {

	public static ListNode<Integer> reverseALinkedList(ListNode<Integer> list) {

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
		// TODO Auto-generated method stub

	}

}
