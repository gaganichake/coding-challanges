package com.codingchallanges.array.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k/">subarray-sum-equals-k</a>
 * <p>
 * Given an array of integers and an integer k, you need to
 * find the total number of continuous sub-arrays whose sum
 * equals to k.
 * <p>
 * Also see TwoSumSingleArray
 */
public class SubarraySum {

	/*
	 * Brute force approach
	 * Time complexity: O(n * n)
	 * Space complexity: O(1)
	 */
    public static int subarraySum(int[] nums, int k) {

        int total = 0;
        int sum;

        for(int i = 0; i < nums.length; i++){

            sum = 0;

            for(int j = i; j < nums.length; j++){

                sum+=nums[j];

             	//Do not break here as negative value can also produce same result
                // Like[1, -1, 0] for k = 0
                if(sum == k){
                    total++;
                }
            }
        }
        return total;
    }

//    public int subarraySum(int[] nums, int k) {
//
//        int count = 0;
//
//        for(int i = 0; i < nums.length; i++){
//
//               count+=subarraySum(nums, i, k);
//
//           }
//
//           return count;
//       }
//
//       private int subarraySum(int[] nums, int start, int k){
//
//           int sum = 0;
//           int count = 0;
//
//           for(int i = start; i < nums.length; i++){
//
//               sum+=nums[i];
//
//               if(sum == k) count++;
//           }
//           return count;
//       }

	/*
	 * Best performance
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
    public static int subarraySum2(int[] nums, int k) {

        int count = 0, sum = 0;
        HashMap <Integer, Integer > map = new HashMap<>();// sum -> Count

        map.put(0, 1);

        for (int num : nums) {

            sum += num;

            count += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("map = " + map);
        return count;
    }

    //Not working
    public static int subarraySum3(int[] nums, int k) {

        int count = 0;
        int[] prefixSum = new int[nums.length + 1];

	    for(int i = 0; i < nums.length; i++){

	    	prefixSum[i+1] = prefixSum[i] + nums[i];

			if(prefixSum[i] == k) {
				count++;
			}
		}

        for(int i = 1; i < prefixSum.length; i++){

            int lastElement = prefixSum[prefixSum.length - 1];
            if(lastElement - prefixSum[i] == k) {
                count++;
            }
        }
        System.out.println("prefixSum = " + Arrays.toString(prefixSum));
        return count;
    }

	public static void main(String[] args) {

//		int[] nums = {1, 1, 1};
//		int k = 2;

// 		int[] nums = {1, 2, 3};
//		int k = 3;

        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;

//		int[] nums = {28,54,7,-70,22,65,-6};
//		int k = 100;

//		int[] nums = {0,0,0,0,0,0,0,0,0,0};
//		int k = 0;

		System.out.println("count = " + subarraySum(nums, k));
		System.out.println("count = " + subarraySum2(nums, k));
		System.out.println("count = " + subarraySum3(nums, k));
	}

}
