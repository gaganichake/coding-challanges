package com.codingchallanges.array.matrix;

import java.util.Arrays;

/*
 * CTCI 11.6 Give an M x N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 */
public class SearchSortedMatrix {

	/*
	 * A common approach would be to apply binary search on each row. That would take
	 * O(M log(N)) time. Where M are number of rows and log(N) is the time complexity
	 * of individual row.
	 */
	public static int[] searchSortedMatrixBinarySearch(int[][] matrix, int key) {

		int rowIndex = -1;
		int colIndex;

		for(int[] a : matrix) {
			rowIndex++;
			colIndex = Arrays.binarySearch(a, key);
			if(colIndex > -1) {
				return new int[]{rowIndex, colIndex};
			}
		}
		return new int[]{-1, -1};
	}

	/*
	 * Another approach is you create a new one dimensional array of M*N length and
	 * copy all elements to the new array row by row and then apply binary search on
	 * the new array. Now the returned index 'i' should be used to calculate the column
	 * and row index in original matrix.
	 * row index = i / column.length; column index = i % column.length.
	 *
	 */
	public static int[] searchSortedMatrixUsingNewArray(int[][] matrix, int key) {

		int[] newArray = new int[matrix.length * matrix[0].length];
		int offset = 0;

		for(int[] a : matrix) {

			System.arraycopy(a, 0, newArray, offset, a.length);
			offset += matrix[0].length;
		}
//		System.out.println(Arrays.toString(newArray));

		int i = Arrays.binarySearch(newArray, key);

		int[] result = new int[2];
		result[0] = i / matrix[0].length;
		result[1] = i % matrix[0].length;

		return result;
	}

	/*
	 * The above algorithm will not work if the last element of a row in greater than the
	 * first element of it's next row.
	 * {{15, 20, 40, 85}, {20, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}}
	 *
	 * We can compare the start of the column and the end of the row with the search key
	 * and reduce search matrix to a sub-matrix
	 * Further we can compare the end of the column and the start of the row with the search
	 * key and reduce the search matrix to a sub-matrix
	 * These filters will reduce the execution time.
	 *
	 * Apply binary search row wise on the sub-matrix.
	 */
	//TODO


	public static void main(String[] args) {

		int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

		System.out.println(Arrays.toString(searchSortedMatrixBinarySearch(matrix, 7)));
		System.out.println(Arrays.toString(searchSortedMatrixUsingNewArray(matrix, 7)));
	}

}
