package com.codingchallanges.recursion.sequence;

import java.util.Scanner;

public class Print1toNRecursively {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            printRecursively(n);
            System.out.println();
        }
    }

    private static void printRecursively(int n) {
        if (n > 0) {
            printRecursively(n - 1);
            System.out.print(n + " ");
        }
    }
}
