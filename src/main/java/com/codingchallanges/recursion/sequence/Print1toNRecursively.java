package com.codingchallanges.recursion.sequence;

import java.util.Scanner;

public class Print1toNRecursively {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 0 to exit.");
        while(true) {
            int n = in.nextInt();
            if (n == 0) break;
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
