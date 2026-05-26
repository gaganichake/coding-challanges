package com.codingchallanges.array.string;

/**
 * Rotational Cipher
 * <p>
 * <a href="https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=238827593802550&c=420501606451133&ppid=454615229006519&practice_plan=1">Rotational Cipher</a>
 * <p>
 * One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount.
 * Rotating a character means replacing it with another character that is a certain number of steps away
 * in normal alphabetic or numerical order.
 * <p>
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?".
 * Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A),
 * and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0).
 * Note that the non-alphanumeric characters remain unchanged.
 * <p>
 * Given a string and a rotation factor, return an encrypted string.
 * <p>
 * Signature
 * <p>
 * string rotationalCipher(string input, int rotationFactor)
 * <p>
 * Input
 * <p>
 * 1 <= |input| <= 1,000,000
 * 0 <= rotationFactor <= 1,000,000
 * <p>
 * Output
 * <p>
 * Return the result of rotating input a number of times equal to rotationFactor.
 * <p>
 * Example 1
 * <p>
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 * <p>
 * Example 2
 * <p>
 * input = abcdefghijklmNOPQRSTUVWXYZ0123456789
 * rotationFactor = 39
 * output = nopqrstuvwxyzABCDEFGHIJKLM9012345678
 */
public class RotationalCipher {

	private static String rotationalCipher(String s, int rotation) {

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (Character.isAlphabetic(ch)) {
				ch = nextAlphabet(ch, rotation);
			}

			if (Character.isDigit(ch)) {
				ch = nextDigit(ch, rotation);
			}

			sb.replace(i, i + 1, Character.toString(ch));
		}
		return sb.toString();
	}


	private static char nextAlphabet(int ch, int rotation) {

		rotation = rotation % 26;

		if (Character.isLowerCase(ch)) {
			ch += rotation;
			if (ch > 'z') ch -= 26;
		} else {
			ch +=rotation;
			if (ch > 'Z') ch -= 26;
		}

		return (char)ch;
	}

	private static char nextDigit(int ch, int rotation) {

		rotation = rotation % 10;

		int digit = Character.getNumericValue(ch);
		digit += rotation;
		if (digit > 9) digit -= 10;

		return String.valueOf(digit).charAt(0);
	}

	public static void main(String[] args) {

		System.out.println(rotationalCipher("Zebra-493?", 3)); // expected = "Cheud-726?";
		System.out.println(rotationalCipher("All-convoYs-9-be:Alert1.", 4)); // expected = "Epp-gsrzsCw-3-fi:Epivx5.";
		System.out.println(rotationalCipher("abcdZXYzxy-999.@", 200)); // expected = "stuvRPQrpq-999.@";
	}

}
