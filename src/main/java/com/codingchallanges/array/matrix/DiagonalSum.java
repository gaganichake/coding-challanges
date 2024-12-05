package com.codingchallanges.array.matrix;

/*
US Bank
Problem Statement:

Write a Java function that accepts a square integer array as input and returns `true` if the sum of the numbers on
both diagonals is the same, and `false` otherwise.

Example:
----------------
Input1:
4  2  3
4  2  8
10 6  9

(0,0) + (1,1) + (2, 2)
(0,2) + (1, 1) + (2, 0)
Output1:
true

----------------
Input2:
----------------
1  2  3
4  5  6
7  8  9

Output2:
true

----------------
Input3:
2  3  4  5
6  7  8  9
10 11 12 13
14 15 16 17

(0,0) + (1,1) + (2, 2) + (3, 3)
(0,3) + (1, 2) + (2, 1) + (3, 0)
Output3:
true
----------------
 */
public class DiagonalSum {

   public static void main(String[] arg) {

       int[][] input1 = {{4,  2, 3}, {4,  2,  8}, {10, 6,  9}};
       int[][] input2 = {{4,  2, 5}, {4,  2,  8}, {10, 6,  9}};

       System.out.println("input1 = " + isDiagonalsSumEqual(input1));
       System.out.println("input2 = " + isDiagonalsSumEqual(input2));

   }

    private static boolean isDiagonalsSumEqual(int[][] input) {

        int n = input.length;

        int leftSum = 0;
        int rightSum = 0;

        for(int i = 0; i < n; i++){
            leftSum +=  input[i][i];
            rightSum +=  input[i][n-1-i];
        }

        return leftSum == rightSum;
    }
}

/*
public class StringComparison {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Ja").append("va");
        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true
        System.out.println(sb1.toString() == s1); // false
        System.out.println(sb1.toString().equals(s1)); // true
    }
}
 */


