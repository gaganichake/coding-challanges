package com.codingchallanges.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * isCryptSolution
 *
 * https://app.codesignal.com/interview-practice/task/yM4uWYeQTHzYewW9H/description?solutionId=fiqjPRGDiNHwMM6JP
 *
 * A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence
 * between letters and digits, such that the given arithmetic equation consisting of letters
 * holds true when the letters are converted to digits.
 *
 * You have an array of strings crypt, the cryptarithm, and an array containing the
 * mapping of letters and digits, solution. The array crypt will contain three non-empty
 * strings that follow the structure: [word1, word2, word3], which should be interpreted as
 * the word1 + word2 = word3 cryptarithm.
 *
 * If crypt, when it is decoded by replacing all of the letters in the cryptarithm with
 * digits using the mapping in solution, becomes a valid arithmetic equation containing no
 * numbers with leading zeroes, the answer is true. If it does not become a valid arithmetic
 * solution, the answer is false.
 *
 * Note that number 0 doesn't contain leading zeroes (while for example 00 or 0123 do).
 *
 * Example:
 * crypt = ["SEND", "MORE", "MONEY"]
 * solution = [['O', '0'],
 *            ['M', '1'],
 *            ['Y', '2'],
 *            ['E', '5'],
 *            ['N', '6'],
 *            ['D', '7'],
 *            ['R', '8'],
 *            ['S', '9']]
 *
 * Expect output: true
 * 9567 + 1085 = 10652
 *
 * crypt = ["TEN", "TWO", "ONE"]
 * solution = [['O', '1'],
 * ['T', '0'],
 * ['W', '9'],
 * ['E', '5'],
 * ['N', '4']]
 *
 * Expect output: false
 * 054 + 091 = 145
 */
public class IsCryptSolution {

	boolean isCryptSolution(String[] crypt, char[][] solution) {

		Map<Character, Character> map = new HashMap<>();
		List<Long> list = new ArrayList<>();

		for (char[] c : solution) {

			map.put(c[0], c[1]);
		}

		for (String str : crypt) {

			StringBuffer strBuf = new StringBuffer(str);

			if (!isValid(strBuf, map))
				return false;

			list.add(Long.valueOf(strBuf.toString()));
		}
		return list.get(0) + list.get(1) == list.get(2);//The equation must also be valid
	}

	private boolean isValid(StringBuffer strBuf, Map<Character, Character> map) {

		for (int i = 0; i < strBuf.length(); i++) {
			strBuf.setCharAt(i, map.get(strBuf.charAt(i)));//Covert string to digits
		}
		// System.out.println(strBuf);
		return strBuf.length() <= 1 || strBuf.charAt(0) != '0';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
