package com.codingchallanges.recursion.dynamicprog;

import java.util.HashMap;
import java.util.Map;

/*
 * climbingStairs
 *
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 or 3
 * In how many distinct ways can you climb to the top?
 *
 * Example
 * For n = 1, the output should be solution(n) = 1;
 *
 * For n = 2, the output should be solution(n) = 2.
 * You can either climb 2 steps at once or climb 1 step two times.
 *
 * CTCI 9.1
 */
public class ClimbingStairs {

	private static final Map<Integer, Integer> map = new HashMap<>();

	public static int climbingStairs(int n) {

		if(n < 0) return 0;

		// n == 0 means you have reached to the top.
		if(n == 0) return 1; // Reaching to top counts for one distinct way

		// You can choose a combination on 1, 2 and/or 3 steps while climbing
		map.put(n, climbingStairs(n - 1)
					+ climbingStairs(n - 2)
					+ climbingStairs(n - 3));

		return map.get(n);
	}

	public static void main(String[] args) {

		int n = 5;

		System.out.println(climbingStairs(n));
		System.out.println(map);

	}

}
