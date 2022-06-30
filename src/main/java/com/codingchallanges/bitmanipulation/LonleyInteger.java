package com.codingchallanges.bitmanipulation;

/*
 * https://www.youtube.com/watch?v=eXWjCgbL01U
 * 
 * https://en.wikipedia.org/wiki/Bitwise_operation
 * 
 * Bit Manipulation reduces Space complexity
 */
public class LonleyInteger {

	public static int lonleyInteger(int[] array) {
		
		int result = 0;
		for(int value :  array) {
			result = result ^ value;
			System.out.println(result);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] array = {9, 1, 2, 3, 2, 9, 1, 7, 7};
		
		System.out.println("A Lonley Integer nubmer is "+ lonleyInteger(array));

	}
}
