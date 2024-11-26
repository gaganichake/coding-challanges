package com.codingchallanges.array.sort;

import java.util.*;

/*
 * Time complexity: O(w * n) where n is the number of keys, and w is the key length.
 *
 * Space complexity: O(w + n)
 */
public class RadixSort {

	public static void radixSort(int[] array) {

		int factor;
		int maxNumberLength = (Integer.MAX_VALUE+"").length();
		Map<Integer, List<Integer>> bucket = new HashMap<>();

		for(int d = 0; d < 10; d++) {
			bucket.put(d, new ArrayList<>());
		}

		for(int w = 0; w < maxNumberLength; w++) {

			for(int d = 0; d < 10; d++) {
				bucket.get(d).clear();
			}

			factor = (int)Math.pow(10, w);

			for (int j : array) {

				bucket.get((j / factor) % 10).add(j);
//				System.out.println(bucket.get((array[i] / factor) % 10));
			}

			System.arraycopy(bucket.get(0).stream().mapToInt(i -> i).toArray(), 0, array, 0, bucket.get(0).size());
			System.arraycopy(bucket.get(1).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size(), bucket.get(1).size());
			System.arraycopy(bucket.get(2).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size(), bucket.get(2).size());
			System.arraycopy(bucket.get(3).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size() + bucket.get(2).size(), bucket.get(3).size());
			System.arraycopy(bucket.get(4).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size() + bucket.get(2).size() + bucket.get(3).size(), bucket.get(4).size());
			System.arraycopy(bucket.get(5).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size() + bucket.get(2).size() + bucket.get(3).size() + bucket.get(4).size(), bucket.get(5).size());
			System.arraycopy(bucket.get(6).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size() + bucket.get(2).size() + bucket.get(3).size() + bucket.get(4).size() + bucket.get(5).size(), bucket.get(6).size());
			System.arraycopy(bucket.get(7).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size() + bucket.get(2).size() + bucket.get(3).size() + bucket.get(4).size() + bucket.get(5).size() + bucket.get(6).size(), bucket.get(7).size());
			System.arraycopy(bucket.get(8).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size() + bucket.get(2).size() + bucket.get(3).size() + bucket.get(4).size() + bucket.get(5).size() + bucket.get(6).size() + bucket.get(7).size(), bucket.get(8).size());
			System.arraycopy(bucket.get(9).stream().mapToInt(i -> i).toArray(), 0, array, bucket.get(0).size() + bucket.get(1).size() + bucket.get(2).size() + bucket.get(3).size() + bucket.get(4).size() + bucket.get(5).size() + bucket.get(6).size() + bucket.get(7).size() + bucket.get(8).size(), bucket.get(9).size());
		}
	}

	public static void main(String[] args) {

		int[] array = {7, 3, 5, 1, 6, 2, 4, 8, 0, 9, 100, 10, 300, 200, 333, 666666, 4444, 9999999, 55555};

		System.out.println("Before: " + Arrays.toString(array));

		radixSort(array);

		System.out.println("After: " + Arrays.toString(array));
	}

}
