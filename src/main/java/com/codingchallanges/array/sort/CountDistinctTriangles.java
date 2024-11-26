package com.codingchallanges.array.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Counting Triangles
 *
 * Given a list of N triangles with integer side lengths, determine how many triangles there are. Two triangles are considered to be the same if they can both be placed on the plane such that their vertices occupy exactly the same three points.
 *
 * Signature
 * int countDistinctTriangles(ArrayList<Sides> arr)
 * or
 * int countDistinctTrianges(int[][] arr)
 *
 * Input
 * In some languages, arr is an Nx3 array where arr[i] is a length-3 array that contains the side lengths of the ith triangle. In other languages, arr is a list of structs/objects that each represent a single triangle with side lengths a, b, and c.
 *
 * It's guaranteed that all triplets of side lengths represent real triangles.
 *
 * All side lengths are in the range [1, 1,000,000,000]
 * 1 <= N <= 1,000,000
 *
 * Output
 * Return the number of distinct triangles in the list.
 *
 * Example 1
 * arr = [[2, 2, 3], [3, 2, 2], [2, 5, 6]]
 * output = 2
 * The first two triangles are the same, so there are only 2 distinct triangles.
 *
 * Example 2
 * arr = [[8, 4, 6], [100, 101, 102], [84, 93, 173]]
 * output = 3
 * All of these triangles are distinct.
 *
 * Example 3
 * arr = [[5, 8, 9], [5, 9, 8], [9, 5, 8], [9, 8, 5], [8, 9, 5], [8, 5, 9]]
 * output = 1
 * All of these triangles are the same.
 *
 */

public class CountDistinctTriangles {


	static class Sides {
		int a;
		int b;
		int c;

		Sides(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public boolean equals(Object o) {

			Sides s = o instanceof Sides ? (Sides)o : null;

			return this.a == (s != null ? s.a : 0) && this.b == (s != null ? s.b : 0) && this.c == (s != null ? s.c : 0);
		}

		@Override
		public int hashCode() {
			return (this.a+ "" + this.b + "" + this.c).hashCode();
		}

		@Override
		public String toString() {
			return "[" + this.a + ", " + this.b + ", " + this.c +"]";

		}

	}
	// Add any helper functions you may need here

	static int countDistinctTriangles(ArrayList<Sides> arr) {
		// Write your code here

		Set<Sides> triangles = new HashSet<>();

		for (Sides triangle : arr) {

			int[] temp = {triangle.a, triangle.b, triangle.c };

			Arrays.sort(temp);

			triangle.a = temp[0];
			triangle.b = temp[1];
			triangle.c = temp[2];

			triangles.add(triangle);

		}
		//System.out.println(triangles);

		return triangles.size();
	}

	static int countDistinctTriangles2(ArrayList<Sides> arr) {
		// Write your code here

		Set<String> triangles = new HashSet<>();

		for (Sides triangle : arr) {

			int[] temp = {triangle.a, triangle.b, triangle.c };

			Arrays.sort(temp);

			triangles.add(temp[0] + "" + temp[1] + "" + temp[0]);

		}
		//System.out.println(triangles);

		return triangles.size();
	}


	public static void main(String[] args) {
		ArrayList<Sides> arr_1 = new ArrayList<>();
		arr_1.add(new Sides(7, 6, 5));
		arr_1.add(new Sides(5, 7, 6));
		arr_1.add(new Sides(8, 2, 9));
		arr_1.add(new Sides(2, 3, 4));
		arr_1.add(new Sides(2, 4, 3));
		int expected_1 = 3;
		int output_1 = countDistinctTriangles(arr_1);
//	    check(expected_1, output_1);
		System.out.println(output_1);

		ArrayList<Sides> arr_2 = new ArrayList<>();
		arr_2.add(new Sides(3, 4, 5));
		arr_2.add(new Sides(8, 8, 9));
		arr_2.add(new Sides(7, 7, 7));
		int expected_2 = 3;
		int output_2 = countDistinctTriangles(arr_2);
//	    check(expected_2, output_2);
		System.out.println(output_2);

		// Add your own test cases here

	}

}
