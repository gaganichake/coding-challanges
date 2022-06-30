package com.codingchallanges.tree.tries;

/*
 * https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 * http://anthonybarranco.com/blog/programming-boggle-algorithm/
 * https://blog.niallconnaughton.com/2015/12/10/solving-boggle-boards-at-scale/
 */
public class BoggleBoards {

	// Let the given dictionary be following
    static final String[] dictionary = { "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
    static final int n = dictionary.length;
    static final int M = 3, N = 3;

	static void findWords(char[][] boggle) {


	}

	public static void main(String[] args) {

		char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };

		System.out.println("Following words of dictionary are present");
		findWords(boggle);
	}

}
