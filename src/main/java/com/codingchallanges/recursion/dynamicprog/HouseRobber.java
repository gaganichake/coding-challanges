package com.codingchallanges.recursion.dynamicprog;

import java.util.Arrays;

/*
 * houseRobber
 * 
 * https://app.codesignal.com/interview-practice/task/XBWN6DYRqPrKdMZs8/description
 * 
 * You are planning to rob houses on a specific street, and you know that every house on the 
 * street has a certain amount of money hidden. The only thing stopping you from robbing all 
 * of them in one night is that adjacent houses on the street have a connected security system. 
 * The system will automatically trigger an alarm if two adjacent houses are broken into on the 
 * same night.
 * 
 * Given a list of non-negative integers nums representing the amount of money hidden in each 
 * house, determine the maximum amount of money you can rob in one night without triggering an 
 * alarm. 
 * 
 * Example:
 * For nums = [1, 1, 1], the output should be houseRobber(nums) = 2.
 * The optimal way to get the most money in one night is to rob the first and the third houses for a total of 2.
 */
public class HouseRobber {

	// Credit:
	// https://github.com/edyluisrey/Codefights-Algorithms/blob/master/src/dynamicProgramming/HouseRobber.java
	// Time complexity: O(n)
	public static int houseRobber(int[] nums) {

		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];

		int[] maxPrefixSum = new int[nums.length];//prefixSum technique with comparison

		maxPrefixSum[0] = nums[0];
		maxPrefixSum[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			
			maxPrefixSum[i] = Math.max(maxPrefixSum[i - 2] + nums[i], maxPrefixSum[i - 1]);
		}
		
		return maxPrefixSum[nums.length - 1];
	}
	
	// Recursive working solution with Execution time limit exceeded error on CodeSignal.
	// Time complexity: O(2^n)
	public static int houseRobber2(int[] nums) {

		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		return Math.max(houseRobber2(Arrays.copyOfRange(nums, 0, nums.length-2)) + nums[nums.length-1],
				houseRobber2(Arrays.copyOfRange(nums, 0, nums.length-1)));
		// Either the last house has alert system or second from the last house has alert system.
	}


	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		System.out.println(houseRobber2(nums));

	}

}
