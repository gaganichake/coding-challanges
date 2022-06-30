package com.codingchallanges.array.search;

public class LinearSearch {

	public static int linearSearch(int[] array, int k) {

		for (int i = 0; i < array.length; i++) {

			if (k == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] arg) {

		int[] array = { 4, 7, 2, 56, 45, 10, 8, 9 };

		int lookup = 10;

		int index = linearSearch(array, lookup);

		if (index > 0)
			System.out.println("The number " + lookup + " found at possition " + index);
		else
			System.out.println("The number " + lookup + " not found at any possition");
	}
}
