package com.codingchallanges.array.math;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/a-very-big-sum/problem">a-very-big-sum</a>
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n is the length of input array
 */
public class AVeryBigSum {

	//Using long type when number are bigger that integer
	static long aVeryBigSum(long[] ar) {

		return Arrays.stream(ar).sum();
	}

	public static void main(String[] args) {

		String[] arItems = "1000000001 1000000002 1000000003 1000000004 1000000005".split(" ");

		long[] ar  = Arrays.stream(arItems)
				.map(str -> Long.parseLong(str))
				.collect(Collectors.toList())
				.stream().mapToLong(l -> l).toArray();

		long result = aVeryBigSum(ar);

		System.out.println(result);
	}
}
