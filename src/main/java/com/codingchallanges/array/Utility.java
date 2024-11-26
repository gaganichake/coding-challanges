package com.codingchallanges.array;

public class Utility {

	public static String arrayToString(int[] array, int start, int end) {
		StringBuilder txt = new StringBuilder("[");
		for (int i = start; i <= end; i++) {
			txt.append(array[i]);
			if (i < end)
				txt.append(", ");
		}
		txt.append("]");
		return txt.toString();
	}

	public static void swap(int[] array, int i, int j) {

		int temp = array[i];
		array[i] =  array[j];
		array[j] = temp;
	}

	public static String printArray(int[][] array) {

		StringBuilder str = new StringBuilder();

		for (int[] ints : array) {

			str.append("[");

			for (int anInt : ints) {

				str.append(anInt).append(",");

			}
			str.deleteCharAt(str.lastIndexOf(",")).append("]\n");
		}
		return str.toString();
	}

	public static String printArray(String[][] array) {

		StringBuilder str = new StringBuilder();

		for (String[] ints : array) {

			str.append("[");

			for (String anInt : ints) {

				str.append(anInt).append(",");

			}
			str.deleteCharAt(str.lastIndexOf(",")).append("]\n");
		}
		return str.toString();
	}

	public static String base62Encoding(int deci) {

		String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String hashStr = "";

		while(deci > 0) {
			hashStr = String.format("%s%s", s.charAt(deci % 62), hashStr);
			deci /= 62;
		}
		return hashStr;
	}

}
