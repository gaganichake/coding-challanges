package com.codingchallanges.recursion.dynamicprog;

/*
 * https://www.youtube.com/watch?v=P8Xa2BitN3I&feature=youtu.be
 */
public class CountThePath {
	
	public static void main(String[] arg) {
		
		boolean[][] grid = {
				{true, true, true, true, true, true, true, true}, 
				{true, true, false, true, true, true, false, true},
				{true, true, true, true, false, true, true, true},
				{false, true, false, true, true, false, true, true},
				{true, true, false, true, true, true, true, true},
				{true, true, true, false, false, true, false, true},
				{true, false, true, true, true, false, true, true},
				{true, true, true, true, true, true, true, true}};
		
		System.out.println("Count="+countPaths(grid, 0, 0));
		
		System.out.println("Memorized Count="+countPaths(grid, 0, 0));
		
	}

	public static int countPaths(boolean[][] grid, int row, int col) {

		if (isValidSquare(grid, row, col)) {
			if (isAtEnd(grid, row, col)) {
				return 1;
			}

			return countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
		} else {
			return 0;
		}

	}
	
	public static int countPathsMemorize(boolean[][] grid, int row, int col) {
		
		int[][] memory = new int[8][8];
		
		return countPathsMemorize(grid, row, col, memory);
	}
	
	// Using memorization
	private static int countPathsMemorize(boolean[][] grid, int row, int col, int[][] memory) {

		if (isValidSquare(grid, row, col)) {
			if (isAtEnd(grid, row, col)) {
				return 1;
			}

			if (memory[row][col] == 0) {
				memory[row][col] = countPaths(grid, row + 1, col) + countPaths(grid, row, col + 1);
			}

			return memory[row][col];
		} else {
			return 0;
		}

	}

	private static boolean isValidSquare(boolean[][] grid, int row, int col) {
		
		if(row >= grid.length || col >= grid[0].length) {
			return false;
		}
		
		return grid[row][col];
	}
	
	private static boolean isAtEnd(boolean[][] grid, int row, int col) {
		return (row >= grid.length-1 && col >= grid[0].length-1);
		
	}
}
