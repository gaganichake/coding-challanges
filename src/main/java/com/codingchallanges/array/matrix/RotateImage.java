package com.codingchallanges.array.matrix;

import com.codingchallanges.array.Utility;

/**
 * rotateImage
 * <p>
 * <a href="https://app.codesignal.com/interview-practice/task/5A8jwLGcEpTPyyjTB/description">rotateImage</a>
 * <p>
 * You are given an n x n 2D matrix that represents an image. Rotate the image by
 * 90 degrees (clockwise).
 * <p>
 * Note: Try to solve this task in-place (with O(1) additional memory), since this
 * is what you'll be asked to do during an interview.
 * <p>
 * Example -
 * <p>
 * Input:
 * <p>
 * a:
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 *
 * Output:
 * [[7,4,1],
 * [8,5,2],
 * [9,6,3]]
 */
public class RotateImage {

	static int[][] rotateImage(int[][] a) {

	    int n = a.length;

	    int[][] b = new int[n][n];

	    for(int i = 0; i < n; i++){

	        for(int j = 0; j < n; j++){

	            b[i][j] = a[n-1-j][i];

	            //System.out.print("[(" + (n-1-j) + ", " + i + ") (" + i + ", " + j + ")]");
	        }
	        // System.out.println();
	    }
	    return b;
	}

	public static void main(String[] args) {

		int[][] a = {{1,2,3},
					{4,5,6},
  					{7,8,9}};
		System.out.println(Utility.printArray(rotateImage(a)));

	}

}
