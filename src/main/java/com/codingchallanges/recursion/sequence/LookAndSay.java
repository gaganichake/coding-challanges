package com.codingchallanges.recursion.sequence;

/*
 * Look and Say
 * 
 * https://www.facebook.com/careers/life/sample_interview_questions
 * 
 * Implement a function that outputs the Look and Say sequence:
 * 1 
 * 11
 * 21
 * 1211
 * 111221
 * 312211
 * 13112221
 * 1113213211
 * 31131211131221
 * 13211311123113112211
 * 
 * 
 * Solution:
 * This problem is fairly straightforward and should not take a long time to solve. However, 
 * be sure you do proper error checking of the input first! (Empty and invalid inputs should 
 * be taken into account). Additionally, you can ask yourself:
 * - How does the output length scale?
 * - What is the max single digit that can exist in the output?
 * - What is the only starting sequence that never grows in length?
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * where n is the length of input String
 */
public class LookAndSay {

	//Simply keep count of the previously visited numbers
	public static String printLookAndSaySeq(String number) {

		StringBuilder output = new StringBuilder();

		char previous = number.charAt(0);

		int count = 1;

		for (int i = 1; i < number.length(); i++) {

			if (previous == number.charAt(i)) {
				count++;//Simply keep count of the previously visited numbers
			} else {
				output.append(count + previous);
				previous = number.charAt(i);
				count = 1;
			}
		}

		output.append(count + previous);

		return output.toString();
	}

	public static void printLevel(int level) {

		String result = "1";

		System.out.println(result);

		for (int i = 2; i <= level; i++) {

			result = printLookAndSaySeq(result);
			System.out.println(result);
		}

	}

	public static void main(String[] args) {

		// Print by input sequence directly
		System.out.println(printLookAndSaySeq("21"));

		// Print by level
		printLevel(9);

	}
}
