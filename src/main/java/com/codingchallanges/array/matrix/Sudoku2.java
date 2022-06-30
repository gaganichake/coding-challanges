package com.codingchallanges.array.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * sudoku2
 *
 * https://app.codesignal.com/interview-practice/task/SKZ45AF99NpbnvgTn/description
 *
 * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers
 * in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that
 * compose the grid all contain all of the numbers from 1 to 9 one time.
 *
 * Implement an algorithm that will check whether the given grid of numbers represents a
 * valid Sudoku puzzle according to the layout rules described above. Note that the puzzle
 * represented by grid does not have to be solvable.
 *
 * Example
 * For
 * grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
			['.', '.', '6', '.', '.', '.', '.', '.', '.'],
			['.', '.', '.', '.', '.', '.', '.', '.', '.'],
			['.', '.', '1', '.', '.', '.', '.', '.', '.'],
			['.', '6', '7', '.', '.', '.', '.', '.', '9'],
			['.', '.', '.', '.', '.', '.', '8', '1', '.'],
			['.', '3', '.', '.', '.', '.', '.', '.', '6'],
			['.', '.', '.', '.', '.', '7', '.', '.', '.'],
			['.', '.', '.', '5', '.', '.', '.', '7', '.']]
 *
 * the output should be solution(grid) = true;
 *
 * For
 * grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
			['.', '.', '.', '.', '6', '.', '.', '.', '.'],
			['7', '1', '.', '.', '7', '5', '.', '.', '.'],
			['.', '7', '.', '.', '.', '.', '.', '.', '.'],
			['.', '.', '.', '.', '8', '3', '.', '.', '.'],
			['.', '.', '8', '.', '.', '7', '.', '6', '.'],
			['.', '.', '.', '.', '.', '2', '.', '.', '.'],
			['.', '1', '.', '2', '.', '.', '.', '.', '.'],
			['.', '2', '.', '.', '3', '.', '.', '.', '.']]
 *
 * the output should be solution(grid) = false;
 * The given grid is not correct because there are two 1s in the second column. Each column, each row,
 * and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.
 */
public class Sudoku2 {

	boolean sudoku2(char[][] grid) {

	    Set<Character> numbers = new HashSet<>();

	    // Check rows
	    for(char[] row : grid){

	        for(char c : row){

	            if(c == '.') continue;

	            if(numbers.contains(c)) return false;

	            numbers.add(c);
	        }
	        numbers = new HashSet<>();
	    }

	    // Check columns
	    for(int i = 0; i < grid.length; i++){

			for (char[] chars : grid) {

				if (chars[i] == '.') continue;

				if (numbers.contains(chars[i])) return false;

				numbers.add(chars[i]);
			}
	        numbers = new HashSet<>();
	    }

	    char[][] subgrid = new char[3][];
	    int subIndex;

	    // Check sub-grid
	    for(int i = 0; i < grid.length; i+=3){

	        subIndex = 0;

	        for(int j = 0; j < grid.length; j+=3){

	            for(int k = j; k < j+3; k++){

	                subgrid[subIndex] = Arrays.copyOfRange(grid[k], i, i+3);
	                subIndex++;
	            }

	            subIndex = 0;
	            if(!subgrid(subgrid)) return false;
	        }
	    }

	    return true;
	}

	private boolean subgrid(char[][] subgrid){

	    Set<Character> numbers = new HashSet<>();

	    // Check rows
	    for(char[] row :  subgrid){

	        for(char c : row){

	            if(c == '.') continue;

	            if(numbers.contains(c)) return false;

	            numbers.add(c);
	        }
	    }
	    return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
