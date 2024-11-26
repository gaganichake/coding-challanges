package com.codingchallanges.array.math;

import java.util.Arrays;

/*
 * boundedRatio
 *
 * CodeSignal
 *
 * You are given an array of integers a and two integer l and r.
 * Your task is to calculate a boolean array b, where b[i] = true
 * if there exist an integer x, such that a[i] = (i + 1) * x and
 * l <= x <= r. Otherwise, b[i] should be set to false
 */
public class BoundedRatio {

	static boolean[] boundedRatio(int[] a, int l, int r) {

		boolean[] b = new boolean[a.length]; //default value is false
		int x;

		for(int i = 0; i < a.length; i++){
			x = a[i] / (i + 1);
			//Only whole number would qualify
			b[i] = a[i] % (i + 1) == 0 && l <= x && x <= r;
		}
		return b;
	}

	public static void main(String[] args) {

		int[] a = {8, 5, 6, 16, 5};
		int i = 1, r = 3;

		//Expected result: [false, false, true, false, true]
		System.out.println(Arrays.toString(boundedRatio(a, i, r)));
	}

}
