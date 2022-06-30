package com.codingchallanges.array.math;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
 *
 * A sparse vector is a vector that has mostly zero values, you should
 * store the sparse vector efficiently and compute the dot product
 * between two SparseVector.
 *
 * nums1.length == nums2.length
 */
public class SparseVector {

    Map<Integer, Integer> index_map = new HashMap<>();

    SparseVector(int[] nums) {
        for(int i = 0; i < nums.length; i++)
            index_map.put(i, nums[i]);
    }

	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {

        int product_sum = 0;

        for(Integer key : index_map.keySet())
            product_sum += index_map.get(key) * vec.index_map.get(key);

        return product_sum;
    }

	public static void main(String[] args) {

		int[] nums1 = {1,0,0,2,3};
		int[] nums2 = {0,3,0,4,0};
		SparseVector v1 = new SparseVector(nums1);
		SparseVector v2 = new SparseVector(nums2);

		System.out.println(v1.dotProduct(v2));

		int[] nums3 = {0,1,0,0,0};
		int[] nums4 = {0,0,0,0,2};
		SparseVector v3 = new SparseVector(nums3);
		SparseVector v4 = new SparseVector(nums4);

		System.out.println(v3.dotProduct(v4));

	}
}
