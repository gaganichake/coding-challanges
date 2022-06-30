package com.codingchallanges.recursion.dynamicprog;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/decode-ways/
 * 
 * 'A' -> "1"
 * 'B' -> "2"
 * 'C' -> "3"
 * 'D' -> "4"
 * 'E' -> "5"
 * "F" -> "6"
 * "G" -> "7"
 * ...
 * 'Z' -> "26"
 * 
 *  "0" (zero) represents nothing.
 *  "26" represents 'Z' as well as 'BF'
 *  "27" represents 'BG'
 *
 */
public class DecodeWays {

	private static final Map<Integer, Integer> map = new HashMap<>();

	// Recursion with memorization

	private static int numDecodings(int index, String s) {

		if (s == null || s.length() == 0)
			return 0;

		if (index == s.length())
			return 1;

		if (s.charAt(index) == '0')
			return 0;

		if (index == s.length() - 1)
			return 1;

		if (map.containsKey(index)) {
			return map.get(index);
		}

		int count = numDecodings(index + 1, s);

		if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
			count = count + numDecodings(index + 2, s);
		}

		map.put(index, count);

		return count;
	}

	public static int numDecodings(String message) {

		map.clear();

		return numDecodings(0, message);// Start is a position of numbers in the String
	}

//    public static int numDecodings(String s) {
//        
//        int count = 0;
//        
//        if(s == null) return 0;
//        
//        if(s.length() > 0) count++;
//        
//        int doubleDigit = 0;
//        
//        for(int i = 0; i < s.length()-1; i++){
//            
//            doubleDigit = Integer.parseInt(s.charAt(i)+s.charAt(i+1)+"");System.out.println("doubleDigit = " + doubleDigit);
//                
//            if(doubleDigit > 9 && doubleDigit < 27){
//                count++;
//            } 
//        }
//        return count;
//    }

	


	public static void main(String[] args) {

		System.out.println("Input: null, output: " + numDecodings(null));

		System.out.println("Input: \"\", output: " + numDecodings(""));

		System.out.println("Input: 0, output: " + numDecodings("0"));

		System.out.println("Input: 000, output: " + numDecodings("000"));

		System.out.println("Input: 6, output: " + numDecodings("6"));

		System.out.println("Input: 26, output: " + numDecodings("26"));

		System.out.println("Input: 27, output: " + numDecodings("27"));

		System.out.println("Input: 226, output: " + numDecodings("226"));
		// Output: BZ (2, 26), VF (22, 6), BBF (B, B, F)

		System.out.println("Input: 9875, output: " + numDecodings("9875"));

		System.out.println("Input: 98765327, output: " + numDecodings("98765327"));

	}
}
