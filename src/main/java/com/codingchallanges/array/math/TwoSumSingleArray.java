package com.codingchallanges.array.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/
 *
 * Compare with https://www.hackerrank.com/challenges/icecream-parlor/problem
 *
 * Asked in Amazon interview - 08/23/2021
 * Given an array of integers and a integer number. Find indices of numbers in the array
 * whose sum is equal to the integer number in input.
 *
 * Questions on Time complexity, improvements, revised Time complexity after improvement.
 */
public class TwoSumSingleArray {

	// Approach 1: Brute Force : O(n x n)
    public static int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){

            for(int j = 0; j < nums.length; j++){
                if(nums[i] + nums[j] == target && i != j){//you may not use the same element twice.
                    return new int[]{i ,j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    // Approach 2: Two-pass Hash Table : O(n + n) = O(n)
    public int[] twoSum(int target, int[] nums) {

    	// Map will also remove duplicate numbers
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {//you may not use the same element twice.
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // Approach 3: One-pass Hash Table : O(n)
    public static int[] twoSumUsingMap(int[] nums, int target) {


        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

        	int complement = target - nums[i];

        	if(map.containsKey(complement)) {

                return new int[]{map.get(complement), i};
        	}
        	map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }


	public static void main(String[] args) {

		//Ask the interviewer if all the numbers are unique?
		//If the array included duplicate numbers, can we only return index of any occurrence.?
		//Should I need to find indices of all possible combinations?

//		int[] arr = { 6, 1, 7, 4, 2 };
		int[] arr = { 1, 5, 4, 5, 2 };


		System.out.println(Arrays.toString(twoSum(arr, 10)));
		System.out.println(Arrays.toString(twoSumUsingMap(arr, 10)));
//		System.out.println(Arrays.toString(twoSumUsingMap(arr, 10)));
	}

}
