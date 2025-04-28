package com.codingchallanges.array.string;

// April 2025
// Write a function that coverts string "DDDTTYYDD" to string "3D2T2Y2D"
public class StringCompressor {

    public static void main(String[] args) {

        System.out.println(stringCompressor("DDDTTYYDD"));
    }

    public static String stringCompressor(String input) {

        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressedString = new StringBuilder();
        char lastChar = input.charAt(0);
        int count = 1;

        // Iterate through the string starting from the second character
        for (int i = 1; i < input.length(); i++) {

            char ch = input.charAt(i);

            //
            if (lastChar == ch) {
                count++;
            } else {
                compressedString.append(count).append(lastChar);
                lastChar = ch;
                count = 1;
            }
        }
        // Append the last character and its count
        compressedString.append(count).append(lastChar);

        return compressedString.toString();
    }

}
