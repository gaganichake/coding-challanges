package com.codingchallanges.array.search;

public class BinarySearchOnStrings {

    static int findBook(String[] books, int start, int end, String target) {
        // Base case condition to stop recursion
        if(start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (books[mid].equals(target)) return mid; // Book found

        // Compare mid-book to target book using String.compareTo() method
        if(target.compareTo(books[mid]) < 0) {
            // Recursive call for searching halves of the array
            return findBook(books, start, mid - 1, target);
        } else {
            return findBook(books, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        // Book tiles (Strings) are sorted in lexicographically (Natural) order
        String[] library = {"Alice in Wonderland", "Moby Dick", "The Great Gatsby", "War and Peace"};
        String bookToFind = "The Great Gatsby"; // Book we want to find
        int result = findBook(library, 0, library.length - 1, bookToFind);
        System.out.println("The book '" + bookToFind + "' is at index: " + result);
    }
}
