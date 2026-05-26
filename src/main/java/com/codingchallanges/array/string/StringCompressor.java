package com.codingchallanges.array.string;

// April 2025 interview
// Write a function that coverts string "DDDTTYYDD" to string "3D2T2Y2D"
// Single occurrences should represent without the number, so "Z" should be "Z", not "1Z"

public class StringCompressor {

    public static void main(String[] args) {

        System.out.println(stringCompressor("DDDTTYYDD"));
        System.out.println(stringCompressor("Z"));
        System.out.println(stringCompressor("ZDDDTTZYYDDZ"));
        System.out.println(stringCompressor(""));
    }

    private static String stringCompressor(String s) {

        StringBuilder compressed = new StringBuilder();
        char prev = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (prev != s.charAt(i)) {
                if (count != 0) compressed.append(count == 1 ? "" : count).append(prev);
                prev = s.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }

        if (count != 0) compressed.append(count == 1 ? "" : count).append(prev);

        return compressed.toString();
    }

}
