package com.codingchallanges.array.search;

import java.util.Arrays;

/*
 * Is ZigZag
 *
 * https://app.codesignal.com/
 *
 * Find all ZigZag patterns in the array. Set 1 if three consecutive elements are ZigZag,
 * otherwise set 0
 */
public class IsZigZag {

	public static int[] isZigZag(int[] numbers) {

		int[] output = new int[numbers.length - 2];

		for(int i = 0; i < numbers.length - 2; i++) {

			if((numbers[i] < numbers[i+1] && numbers[i+1] > numbers[i+2])
					|| (numbers[i] > numbers[i+1] && numbers[i+1] < numbers[i+2])) {
				output[i] = 1;
			} else {
				output[i] = 0;
			}
		}

		return output;
	}



	public static void main(String[] args) {

		int[] a = {1, 2, 1, 3, 4};

		System.out.println(Arrays.toString(isZigZag(a)));

	}

}
