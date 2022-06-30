package com.codingchallanges.recursion.sequence;

import java.util.HashMap;
import java.util.Map;

/*
 * The Fibonacci sequence begins with 0 and 1. These are the first and second terms, respectively.
 * After this, every element is the sum of the preceding elements.
 *
 * https://www.youtube.com/watch?v=KEEKn7Me-ms
 *
 * https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---fibonacci-numbers/problem
 */
public class Fibonacci {

	public static int fibonacci(int n) {

		if(n <= 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}

	public static Map<Integer, Integer> memo = new HashMap<>();

	// This is better implementation. Improves Time and Space complexity.
	public static int fibonacciMemorize(int n) {

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

		if(n <= 0) return 0;
		if(n == 1) return 1;
		int nextNumber = fibonacci(n-1) + fibonacci(n-2);
		memo.put(n, nextNumber);
		return nextNumber;
	}

	public static void main(String[] args) {

		System.out.println(fibonacciMemorize(10));
	}
}
