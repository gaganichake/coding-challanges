package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * Given an array of distinct integers candidates and a target integer target, return a
 * list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two
 * combinations are unique if the frequency of at least one of the chosen numbers is different.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than
 * 150 combinations for the given input.
 *
 * https://leetcode.com/problems/combination-sum/
 * https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 *
 * Compare with https://leetcode.com/problems/subsets/
 */
public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] nums, int target) {

	    List<List<Integer>> output = new ArrayList<>();

//	    Arrays.sort(nums);// Not necessary

	    combinationSum(nums, new ArrayList<>(), output, target, 0);

	    return output;
	}

	private static void combinationSum(int [] nums, List<Integer> newCombination, List<List<Integer>> output, int target, int start){

		if(target == 0) {
	    		output.add(new ArrayList<>(newCombination)); // Target met
//	    		System.out.println("newCombination: " + newCombination);

	    	} else {

	    		for(int i = start; i < nums.length; i++){

	            newCombination.add(nums[i]);
//	            System.out.println("add (" + nums[i] + "): " + newCombination);

	            // not i + 1 because we can reuse same elements
	            combinationSum(nums, newCombination, output, target - nums[i], i);
//	            System.out.println("return: " + newCombination);
//	            int remove = newCombination.get(newCombination.size() - 1);

	            newCombination.remove(newCombination.size() - 1);
//	            System.out.println("remove (" + remove + "): " + newCombination);
	        }
	    }
	}

	public static void main(String[] args) {

		int[] nums = {1,2};

		System.out.println(combinationSum(nums, 4));

	}

}
