package com.codingchallanges.array.string;

/**
 * <a href="https://www.hackerrank.com/challenges/designer-pdf-viewer/problem">designer-pdf-viewer</a>
 * <p>
 * When a contiguous block of text is selected in a PDF viewer, the selection is highlighted with a
 * blue rectangle. In this PDF viewer, each word is highlighted independently.
 * For example:
 * abc, def, ghi
 * <p>
 * Input: There is a list of 26 character heights aligned by index to their letters.
 * For example, 'a' is at index 0 and 'z' is at index 25 . There will also be a string. Using the
 * letter heights given, determine the area of the rectangle highlight in mm^2 assuming all letters
 * are 1mm wide.
 */
public class DesignerPDFViewer {

	/*
	 * Time complexity: O(n) Space complexity: O(n) where n is the length of input
	 * String
	 */
	private static int getHighlightedAreaSize(int[] h, String word) {

		int maxH = 0;

		// Option: 1
//		Map<Character, Integer> charHeightMap = new HashMap<>();
//
//		charHeightMap.put('a', h[0]);
//		charHeightMap.put('b', h[1]);
//		charHeightMap.put('c', h[2]);
//		charHeightMap.put('d', h[3]);
//		charHeightMap.put('e', h[4]);
//		charHeightMap.put('f', h[5]);
//		charHeightMap.put('g', h[6]);
//		charHeightMap.put('h', h[7]);
//		charHeightMap.put('i', h[8]);
//		charHeightMap.put('j', h[9]);
//		charHeightMap.put('k', h[10]);
//		charHeightMap.put('l', h[11]);
//		charHeightMap.put('m', h[12]);
//		charHeightMap.put('n', h[13]);
//		charHeightMap.put('o', h[14]);
//		charHeightMap.put('p', h[15]);
//		charHeightMap.put('q', h[16]);
//		charHeightMap.put('r', h[17]);
//		charHeightMap.put('s', h[18]);
//		charHeightMap.put('t', h[19]);
//		charHeightMap.put('u', h[20]);
//		charHeightMap.put('v', h[21]);
//		charHeightMap.put('w', h[22]);
//		charHeightMap.put('x', h[23]);
//		charHeightMap.put('y', h[24]);
//		charHeightMap.put('z', h[25]);

		// Option: 2
		// note that characters can be treated as numbers. 'b' -'a' = 1.
		// To find height of 'g', use this smart way. Example: int height_of_g = h['g' - 'a']; = h[6]
		for (int i = 0; i < word.length(); i++) {

			maxH = Math.max(maxH, h[word.charAt(i) - 'a']);// Find height of the tallest letter
		}
		return maxH * word.length();
	}

	public static void main(String[] args) {

		//Where index 0 is the position of 'a' and index 25 is the pos'tion of 'z'
//		int h[] =  {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

//		String word = "abc";

		int[] h = { 1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7 };

		String word = "zaba";

		int size = getHighlightedAreaSize(h, word);

		System.out.println("Size = " + size);
	}
}
