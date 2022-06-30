package com.codingchallanges.stack;

public class StackUsingArray {

	private final int[] array = new int[5];
	
	private int topIndex; // remove things from here
	
	public StackUsingArray() {
		topIndex = array.length;
	}

	public boolean isEmpty() {

		return topIndex == array.length;
	}

	public int peek() {

		if (isEmpty())
			throw new IllegalStateException("This stack is empty!");

		return array[topIndex];
	}

	public void push(int val) {
		
		if(topIndex > 0) {
			topIndex--;
			array[topIndex] = val;
		} else {
			throw new IllegalStateException("Stack overflow!");
		}
		
	}

	public int pop() {
		
		if (isEmpty())
			throw new IllegalStateException("This stack is empty!");
		
		int val = array[topIndex];
		topIndex++;

		return val;

	}
	
	public static void main(String[] args) {
		
		StackUsingArray stack = new StackUsingArray();
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());

		System.out.println(stack.peek());
		
		stack.push(1);
		
		System.out.println(stack.peek());
		
		stack.push(2);
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
		
		stack.push(2);
		
		System.out.println(stack.peek());
		
		stack.push(3);
		
		System.out.println(stack.peek());

		stack.push(4);
		
		System.out.println(stack.peek());
		
		stack.push(5);
		
		System.out.println(stack.peek());
		
		stack.push(6);
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());
		
		System.out.println(stack.peek());

		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
		
	}

}
