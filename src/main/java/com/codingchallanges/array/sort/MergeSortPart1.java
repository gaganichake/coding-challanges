package com.codingchallanges.array.sort;

import java.util.Arrays;

/**
 * Merge Sort Part 1
 */
public class MergeSortPart1 {

	// Time complexity O(n)
	public static int[] mergeTwoSortedArrays(int[] a, int[] b) {

		int[] c = new int[a.length + b.length];

		for(int i = 0, j = 0, k = 0; i < c.length; i++) {

			if(a[j] < b[k]) {
				c[i] = a[j];
				j++;
			} else {
				c[i] = b[k];
				k++;
			}

			if(j == a.length) {
				System.arraycopy(b, k, c, i+1, b.length - k);
				break;
			}

			if(k == b.length) {
				System.arraycopy(a, j, c, i+1, a.length - j);
				break;
			}
		}

		return c;
	}

	public static void main(String[] args) {

		int[] a = {1, 2, 6, 9, 10};
		int[] b = {2, 3, 5, 7, 8, 10, 11};

		System.out.println(Arrays.toString(mergeTwoSortedArrays(a, b)));

	}

}
