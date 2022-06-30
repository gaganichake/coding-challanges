package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * climbingStaircase
 *
 * You need to climb a staircase that has n steps, and you decide to get some extra
 * exercise by jumping up the steps. You can cover at most k steps in a single jump.
 * Return all the possible sequences of jumps that you could take to climb the
 * staircase, sorted.
 *
 * https://app.codesignal.com/interview-practice/task/cAXEnPyzknC5zgd7x/description
 *
 * Compare with https://leetcode.com/problems/combination-sum/
 */
public class ClimbingStraicase {

	public static int[][] climbingStaircase(int n, int k) {

	    LinkedList<int[]> list = new LinkedList<>();

	    int[] nums = new int[k];

	    for(int i = 0; i < k; i++) {
	    	nums[i] = i+1;
	    }

	    climbingStaircase(nums, new ArrayList<>(), list, n);

	    return list.toArray(new int[list.size()][n]);
	}

	private static void climbingStaircase(int[] nums, List<Integer> newCombination, List<int[]> output, int target){

	if(target == 0) {

	    		output.add(newCombination.stream().mapToInt(i -> i).toArray()); // Target met
//	    		System.out.println("newCombination: " + newCombination);

	    	} else {

			for (int num : nums) {

				newCombination.add(num);
//	            System.out.println("add (" + nums[i] + "): " + newCombination);

				// not i + 1 because we can reuse same elements
				climbingStaircase(nums, newCombination, output, target - num);
//	            System.out.println("return: " + newCombination);
//	            int remove = newCombination.get(newCombination.size() - 1);

				newCombination.remove(newCombination.size() - 1);
//	            System.out.println("remove (" + remove + "): " + newCombination);
			}
	    }
	}

//	private static boolean passCriteria(int[] sample, int n){
//
//	    int sum = 0;
//	    int i = 0;
//
//	    for(; i < sample.length; i++){
//	        sum+=sample[i];
//	        if(sum == n){
//	            break;
//	        }
//	    }
//
//	    return sum == n && i == sample.length;
//	}


	public static void main(String[] args) {

		int[][] list = climbingStaircase(7,3);

		for(int[] array : list) {
			System.out.println(Arrays.toString(array));
		}
	}

}
