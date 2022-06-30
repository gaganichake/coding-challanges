package com.codingchallanges.recursion.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://algorithms.tutorialhorizon.com/colorful-numbers/
 * http://www.careercup.com/question?id=4863869499473920
 *
 * Objective: Given a number, find out whether its colorful or not.
 * Colorful Number: When in a given number, product of every digit of a sub-sequence are
 * different. That number is called Colorful Number. See Example
 *
 * Given Number : 3245
 * Output : Colorful
 * Number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * this number is a colorful number, since product of every digit of a sub-sequence are
 * different.
 * That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20, (3*2*4)= 24 (2*4*5)= 40
 *
 * Given Number : 326
 * Output : Not Colorful.
 * 3, 2, 6, 32, 26,
 * 3, 2, 6,  6, 12
 * 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12

 * Possible combinations:

 * abcde

 * a, b, c, d, e
 * ab, bc, cd, de
 * abc, bcd, cde
 * abcd, bcde

 * 3 -> 3 + 2 = 5
 * 4 -> 4 + 3 + 2 = 9
 * 5 -> 5 + 4 + 3 + 2 = 14
 */

public class ColorfulNumbers {

	public static boolean isColorfulNumber(int n) {

		Integer[] array = getDigits(n);

		List<List<Integer>> subsets = subSets(array);

		return product(subsets);
	}

	private static boolean product(List<List<Integer>> subsets) {

		Set<Integer> set = new HashSet<>();

		for(List<Integer> subset : subsets) {

			int p = 1;
			for(Integer n : subset) {
				p = n * p;
			}
			if(!set.contains(p)) {
				set.add(p);
			} else {
				return false;
			}
		}
		return true;
	}

	private static Integer[] getDigits(int number) {

		int length = String.valueOf(number).length();
		Integer[] array = new Integer[length];
		int index = length - 1; // start filling from the end

		while (number > 0) {
			int x = number % 10;
			number = number / 10;
			array[index] = x;
			index--;
		}
		return array;
	}

	public static List<List<Integer>> subSets(Integer[] nums) {

		List<List<Integer>> output = new ArrayList<>();

		backtrack(output, new ArrayList<>(), nums, 0);

		return output;
	}

	private static void backtrack(List<List<Integer>> output, List<Integer> tempList, Integer[] nums, int start) {

		// Add a copy of tempList to the output list.
		// At the very first call tempList would be just []
		output.add(new ArrayList<>(tempList));

		for (int i = start; i < nums.length; i++) {

			tempList.add(nums[i]);

			backtrack(output, tempList, nums, i + 1);

			// Backtrack: Remove the already completed combinations from the tempList
			tempList.remove(tempList.size() - 1);
		}
	}

	public static boolean isColorfulNumber2(int number){

		if(number < 10) return true;

		String colorString = String.valueOf(number);
		int length = colorString.length();

		List<Integer> colorMap = new ArrayList<>();

		for(int i =  1; i < length; i++){

			for (int j = 0;  j+i <= length; j++){

				int product = getProduct(Integer.parseInt(colorString.substring(j, j+i)));

				if(colorMap.contains(product))
					return false;
				else{
					colorMap.add(product);
				}
			}
		}
		return true;
	}

	private static int getProduct(int digits) {

		if(digits < 10) return digits;

		int num = digits;
		int product = 1;

		while(num > 0){
			product = product * (num % 10);
			num = num / 10;
		}
		return product;
	}

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>();
//		numbers.add(326);
		numbers.add(3245);
//		numbers.add(777509);
//		numbers.add(9);
//		numbers.add(98);
//		numbers.add(99);
//		numbers.add(9999);

		for (Integer number : numbers) {
			System.out.println("Input = " + number);
			System.out.println(number + " is a Colorful Number? " + isColorfulNumber(number) + "\n");
		}
	}
}
