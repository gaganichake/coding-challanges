package com.codingchallanges.array.sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 */
public class IntersectionTwoArrays {

	public static int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

		Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

		if (set1.size() < set2.size())
			return intersection(set1, set2);
		else
			return intersection(set2, set1);
	}

	private static int[] intersection(Set<Integer> set1, Set<Integer> set2) {

		Set<Integer> output = new HashSet<>();

		for (Integer s : set1) {
			if (set2.contains(s))
				output.add(s);
		}


		return output.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {

		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};

		System.out.println(Arrays.toString(intersection(nums1, nums2)));

	}

}
