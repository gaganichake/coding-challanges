package com.codingchallanges.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
 * containsCloseNums
 *
 * https://app.codesignal.com/interview-practice/task/njfXsvjRthFKmMwLC/solutions
 *
 * Given an array of integers nums and an integer k, determine whether there are two distinct indices i and j in the array where nums[i] = nums[j] and the absolute difference between i and j is less than or equal to k.
 *
 * Example
 * For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be solution(nums, k) = true.
 * There are two 2s in nums, and the absolute difference between their positions is exactly 3.
 *
 * For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be solution(nums, k) = false.
 * The absolute difference between the positions of the two 2s is 3, which is more than k.
 */
public class ContainsCloseNums {

	/*
	 * Tests passed: 23/24. Execution time limit exceeded: Program exceeded the
	 * execution time * limit. Make sure that it completes execution in a few
	 * seconds for any possible input.
	 **/
// Brute force code solution. This is not using HashTable and exceeding execution time limit.
//	 boolean containsCloseNums(int[] nums, int k) {
//
//	     if(nums.length == 0) return false;
//
//	     for(int i = 0; i < nums.length; i++){
//	         for(int j = 0; j < nums.length; j++){
//
//	             if(i != j && nums[i] == nums[j] && Math.abs(i-j) <= k) return true;
//	         }
//	     }
//	     return false;
//	 }

	// All tests passed
	boolean containsCloseNums(int[] nums, int k) {

		if (nums.length == 0)
			return false;

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (map.containsKey(nums[i])) {

				if (Math.abs(map.get(nums[i]) - i) <= k)
					return true;// if least once pair exists then return the result. See Test 8
			}
			map.put(nums[i], i);// Do everytime, do not put in else condition. See Test 8
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
