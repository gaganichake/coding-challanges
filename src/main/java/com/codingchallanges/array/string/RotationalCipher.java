package com.codingchallanges.array.string;

/*
 * Rotational Cipher
 *
 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=238827593802550&c=420501606451133&ppid=454615229006519&practice_plan=1
 *
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
 * Rotating a character means replacing it with another character that is a certain number of steps away
 * in normal alphabetic or numerical order.
 *
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?".
 * Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A),
 * and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0).
 * Note that the non-alphanumeric characters remain unchanged.
 *
 * Given a string and a rotation factor, return an encrypted string.
 *
 * Signature
 *
 * string rotationalCipher(string input, int rotationFactor)
 *
 * Input
 *
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 *
 * Output
 *
 * Return the result of rotating input a number of times equal to rotationFactor.
 *
 * Example 1
 *
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 *
 * Example 2
 *
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class RotationalCipher {

	public static String rotationalCipher(String input, int rotationFactor) {

		int digitFactor = rotationFactor % 10;
		int alphaFactor = rotationFactor % 26;
		StringBuilder result = new StringBuilder(input);

		for (int i = 0; i < result.length(); i++) {

			if (Character.isLetter(result.charAt(i))) {

				char newChar = (char) (result.charAt(i) + alphaFactor);
				if (Character.isLowerCase(result.charAt(i)) && newChar > 'z' || Character.isUpperCase(result.charAt(i)) && newChar > 'Z')
					newChar -= 26;

				result.replace(i, i + 1, (newChar) + "");
			}

			if (Character.isDigit(result.charAt(i))) {

				char newDig = (char) (result.charAt(i) + digitFactor);
				if (newDig > '9')
					newDig -= 10;

				result.replace(i, i + 1, (newDig) + "");
			}

		}
		return result.toString();
	}

	public static void main(String[] args) {

		System.out.println(rotationalCipher("All-convoYs-9-be:Alert1.", 4)); // expected = "Epp-gsrzsCw-3-fi:Epivx5.";
		System.out.println(rotationalCipher("abcdZXYzxy-999.@", 200)); // expected = "stuvRPQrpq-999.@";
	}

}
