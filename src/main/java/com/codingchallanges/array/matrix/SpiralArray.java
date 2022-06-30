package com.codingchallanges.array.matrix;

import com.codingchallanges.array.Utility;

/*
 * 2D Spiral Array
 *
 * https://www.facebook.com/careers/life/sample_interview_questions
 *
 * Find the pattern and complete the function: int[][] spiral(int n); where n is
 * the size of the 2D array.
 *
 * Sample Result input = 3
 * Output =
 * 123
 * 894
 * 765
 *
 * input = 4
 * Output =
 * 01 02 03 04
 * 12 13 14 05
 * 11 16 15 06
 * 10 09 08 07
 *
 * input = 8
 *
 * 01 02 03 04 05 06 07 08
 * 28 29 30 31 32 33 34 09
 * 27 48 49 50 51 52 35 10
 * 26 47 60 61 62 53 36 11
 * 25 46 59 64 63 54 37 12
 * 24 45 58 57 56 55 38 13
 * 23 44 43 42 41 40 39 14
 * 22 21 20 19 18 17 16 15
 *
 * Solution -
 *
 * Brute-force:
 * There are two general ways most people try to solve this problem.
 * The most common is to find a pattern of how often you move each four
 * directions. For example, on the 4x4 case it is 4,3,3,2,2,1. This kind of code
 * usually has four "for" loops, each going one of the four directions. These
 * kinds of solutions can very easily have bugs if you don't get the pattern
 * exactly right or if you go too far. For example, the 1x1 case.
 *
 * Backtracking:
 * Another way to solve this problem is to greedily traverse in each direction
 * until you must stop, then turn around and head in the other direction. The
 * sample code below follows this approach and is generally the best way to
 * solve this problem.
 *
 * Recursion:
 * Note, however, you can also solve this problem using recursion - walk around
 * the boarder and fill out the numbers with each iteration. Then, reduce the
 * problem to a smaller square (reduced n by 2). Continue until you arrive at
 * the base case of 1 or 0.
 *
 * Explanation (of Backtracking) for 4x4 matrix:
 * input = 4
 * Output =
 * 01(0,0) 02(0,1) 03(0,2) 04(0,3)
 * 12(1,0) 13(1,1) 14(1,2) 05(1,3)
 * 11(2,0) 16(2,1) 15(2,3) 06(2,3)
 * 10(3,0) 09(3,1) 08(3,2) 07(3,3)
 *
 * r, c, dir, val
 * 0  ,   0, 0, 1
 * 0+0, 0+1, 0, 2
 * 0+0, 1+1, 0, 3
 * 0+0, 2+1, 0, 4
 * 0+0, 3+1, 0,   - Invalid step
 * 0+1, 3+0, 1, 5
 * 1+1, 3+0, 1, 6
 * 2+1, 3+0, 1, 7
 * 3+1, 3+0, 1,   - Invalid step
 * 3+0, 3-1, 2, 8
 * 3+0, 2-1, 2, 9
 * 3+0, 1-1, 2, 10
 * 3+0, 0-1, 2,    - Invalid step
 * 3-1, 0+0, 3, 11
 * 2-1, 0+0, 3, 12
 * 1-1, 0+0, 3,    - Already visited
 * 1+0, 0+1, 0, 13
 * 1+0, 1+1, 0, 14
 * 1+0, 2+1, 0,    - Already visited
 * 1+1, 2+0, 1, 15
 * 2+1, 2+0, 1,    - Already visited
 * 2+0, 2-1, 2, 16 - All cells are filled now but we have to continue
 * 2+0, 1-1, 2     - Already visited
 * 2-1, 1+0, 3, 17 - Limit reached. 17 > 16 (4x4)
 */
public class SpiralArray {


	public static int[][] genSpiral(int n) {

		if (n <= 0) {
			throw new IllegalArgumentException("N must be >0");
		}

		int[] rowDir = new int[] { 0, 1, 0, -1 };//Directions for row (right, bottom, left, up)
		int[] colDir = new int[] { 1, 0, -1, 0 };//Directions for column (right, bottom, left, up)

		int direction = 0, val = 0, row = 0, col = 0, limit = n * n;

		int[][] matrix = new int[n][n];

		while (val++ < limit) {

			matrix[row][col] = val;

			row += rowDir[direction];//Moving forward
			col += colDir[direction];//Moving forward

			if (isInvalid(matrix, row, col)) {//Checking if previous step was valid

				row -= rowDir[direction];//Backtracking
				col -= colDir[direction];//Backtracking

				direction = (direction + 1) % 4;//Now change the direction. There are 4 possible directions.

				row += rowDir[direction];//Moving forward again
				col += colDir[direction];//Moving forward again
			}
		}

		return matrix;
	}

	private static boolean isInvalid(int[][] m, int r, int c) {
		return r < 0 || c < 0 || r >= m.length || c >= m.length || m[r][c] != 0;//Row-column index should be valid and cell should be non-zero.
	}

	public static void main(String[] args) {

		int[][] twoDArray = genSpiral(3);

		System.out.println(Utility.printTwoDArray(twoDArray));

	}
}
