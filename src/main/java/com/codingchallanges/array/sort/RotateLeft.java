package com.codingchallanges.array.sort;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 *
 * Rotate Left <
 */
public class RotateLeft {

	/*
	 * Time complexity: O(n*d)
	 * Space complexity: O(n)
	 * where n is the length of input
	 * array and d is the rotations
	 */
	public static void rotateLeft(int[] a, int d) {

		if (a.length == 1 || d == 0) return;

		d = d % a.length; // discard any full rotations

		if (d == 0) return; // No rotation required

		int firstItem;

		while (d > 0) {

			firstItem = a[0];

			System.arraycopy(a, 1, a, 0, a.length - 1);

			a[a.length - 1] = firstItem;// Place first time of the array at the last position

			d--;
		}
	}

	/*
	 * Time complexity: O(n) [Only one iteration needed]
	 * Space complexity: O(n*2) [because we are creating a new array]
	 * where n is the length of input
	 * array and d is rotations
	 */
	public static void rotateLeft2(int[] a, int d) {

		if (a.length == 1 || d == 0) return;

		d = d % a.length; // discard the full rotations

		if (d == 0) return; // No rotation required

        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {

        	int indexOfA = i + d;

            b[i] = a[indexOfA >= a.length ? indexOfA - a.length : indexOfA];
        }

        System.arraycopy(b, 0, a, 0,b.length);
	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5 };

//		rotateLeft(a, 12);

		rotateLeft2(a, 2);

		System.out.println(Arrays.toString(a));

	}

}
