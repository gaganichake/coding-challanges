package com.codingchallanges.array.matrix;

/*
 * matrixElementsSum
 *
 * https://app.codesignal.com/arcade/intro/level-2/xskq4ZxLyqQMCLshr/solutions
 *
 * After becoming famous, the CodeBots decided to move into a new building together.
 * Each of the rooms has a different cost, and some of them are free, but there's a
 * rumour that all the free rooms are haunted! Since the CodeBots are quite superstitious,
 * they refuse to stay in any of the free rooms, or any of the rooms below any of the free
 * rooms.
 *
 * Given matrix, a rectangular matrix of integers, where each value represents the cost
 * of the room, your task is to return the total sum of all rooms that are suitable for
 * the CodeBots (ie: add up all the values that don't appear below a 0).
 */
public class MatrixElementsSum {

	//It is very easy if I just traverse column wise instead of row wise.
	int matrixElementsSum(int[][] matrix) {

	    int sum = 0;
	    int row = matrix.length;
	    int col = matrix[0].length;

	    for(int i = 0; i < col; i++){

			for (int[] ints : matrix) {

				if (ints[i] != 0)
					sum += ints[i];
				else
					break;
			}
	    }

	    return sum;
	}

	public static void main(String[] args) {
//		matrix = [[0, 1, 1, 2],
//		          [0, 5, 0, 0],
//		          [2, 0, 3, 3]]
		        		  //Output: 1 + 5 + 1 + 2 = 9

//		        		  matrix = [[1, 1, 1, 0],
//		        		            [0, 5, 0, 1],
//		        		            [2, 1, 3, 10]]
		        		            		//Output: 1 + 1 + 1 + 5 + 1 = 9
	}

}
